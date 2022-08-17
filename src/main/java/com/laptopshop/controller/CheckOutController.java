package com.laptopshop.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.laptopshop.entities.ChiMucGioHang;
import com.laptopshop.entities.ChiTietDonHang;
import com.laptopshop.entities.DonHang;
import com.laptopshop.entities.GioHang;
import com.laptopshop.entities.NguoiDung;
import com.laptopshop.entities.SanPham;
import com.laptopshop.service.ChiMucGioHangService;
import com.laptopshop.service.ChiTietDonHangService;
import com.laptopshop.service.DonHangService;
import com.laptopshop.service.GioHangService;
import com.laptopshop.service.NguoiDungService;
import com.laptopshop.service.SanPhamService;

@Controller
@SessionAttributes("loggedInUser")
public class CheckOutController {
	
	@Autowired
	private SanPhamService sanPhamService;
	@Autowired
	private NguoiDungService nguoiDungService;
	@Autowired
	private GioHangService gioHangService;
	@Autowired
	private ChiMucGioHangService chiMucGioHangService;
	@Autowired
	private DonHangService donHangService;
	@Autowired
	private ChiTietDonHangService chiTietDonHangService;

	@ModelAttribute("loggedInUser")
	public NguoiDung loggedInUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return nguoiDungService.findByEmail(auth.getName());
	}
	
	public NguoiDung getSessionUser(HttpServletRequest request) {
		return (NguoiDung) request.getSession().getAttribute("loggedInUser");
	}
	
	@GetMapping("/checkout")
	public String checkoutPage(HttpServletRequest res,Model model) {
		NguoiDung currentUser = getSessionUser(res);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Map<Long,String> quanity = new HashMap<Long,String>();
		List<SanPham> listsp = new ArrayList<SanPham>();
				
		if(auth == null || auth.getPrincipal() == "anonymousUser")     //Lay tu cookie
		{
			Cookie cl[] = res.getCookies();		
			Set<Long> idList = new HashSet<Long>();
			for(int i=0; i< cl.length; i++)
			{
				if(cl[i].getName().matches("[0-9]+"))
				{
					idList.add(Long.parseLong(cl[i].getName()));
					quanity.put(Long.parseLong(cl[i].getName()), cl[i].getValue());  
				}
				
			}
			listsp = sanPhamService.getAllSanPhamByList(idList);
		}else     //Lay tu database
		{
			GioHang g = gioHangService.getGioHangByNguoiDung(currentUser);
			if(g != null)
			{
				List<ChiMucGioHang> listchimuc = chiMucGioHangService.getChiMucGioHangByGioHang(g);
				
				for(ChiMucGioHang c: listchimuc)
				{
					
					listsp.add(c.getSanPham());
					quanity.put(c.getSanPham().getId(), Integer.toString(c.getSo_luong()));
									
				}
			}
		}
		
		model.addAttribute("cart",listsp);
		model.addAttribute("quanity",quanity);
		model.addAttribute("user", currentUser);
		model.addAttribute("donhang", new DonHang());
		
		return "client/checkout";
	}
	
	@PostMapping(value="/thankyou")
	public String thankyouPage(@ModelAttribute("donhang") DonHang donhang ,HttpServletRequest req,HttpServletResponse response ,Model model){
		donhang.setNgayDatHang(new Date());
		donhang.setTrangThaiDonHang("Đang chờ giao");

		NguoiDung currentUser = getSessionUser(req);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Map<Long,String> quanity = new HashMap<Long,String>();
		List<SanPham> listsp = new ArrayList<SanPham>();
		List<ChiTietDonHang> listDetailDH = new ArrayList<ChiTietDonHang>();
	
		if(auth == null || auth.getPrincipal() == "anonymousUser")     //Lay tu cookie
		{
			DonHang d = donHangService.save(donhang);
			Cookie cl[] = req.getCookies();		
			Set<Long> idList = new HashSet<Long>();
			for(int i=0; i< cl.length; i++)
			{
				if(cl[i].getName().matches("[0-9]+"))
				{
					idList.add(Long.parseLong(cl[i].getName()));					
					quanity.put(Long.parseLong(cl[i].getName()), cl[i].getValue());  
				}	
			}
			listsp = sanPhamService.getAllSanPhamByList(idList);
			for(SanPham sp: listsp)
			{
				ChiTietDonHang detailDH = new ChiTietDonHang();
				detailDH.setSanPham(sp);
				detailDH.setSoLuongDat(Integer.parseInt(quanity.get(sp.getId())));
				detailDH.setDonGia(Integer.parseInt(quanity.get(sp.getId()))*sp.getDonGia());
				detailDH.setDonHang(d);
				listDetailDH.add(detailDH);
			}
		}else     //Lay tu database
		{
			donhang.setNguoiDat(currentUser);
			DonHang d = donHangService.save(donhang);
			GioHang g = gioHangService.getGioHangByNguoiDung(currentUser);
			List<ChiMucGioHang> listchimuc = chiMucGioHangService.getChiMucGioHangByGioHang(g);
			for(ChiMucGioHang c: listchimuc)
			{			
				ChiTietDonHang detailDH = new ChiTietDonHang();
				detailDH.setSanPham(c.getSanPham());
				detailDH.setDonGia(c.getSo_luong()*c.getSanPham().getDonGia());	
				detailDH.setSoLuongDat(c.getSo_luong());
				detailDH.setDonHang(d);
				listDetailDH.add(detailDH);		
				
				listsp.add(c.getSanPham());
				quanity.put(c.getSanPham().getId(), Integer.toString(c.getSo_luong()));
			}
			
		}					
			
		chiTietDonHangService.save(listDetailDH);
		
		cleanUpAfterCheckOut(req,response);
		model.addAttribute("donhang",donhang);
		model.addAttribute("cart",listsp);
		model.addAttribute("quanity",quanity);
		return "client/thankYou";
	}
	
	public void cleanUpAfterCheckOut(HttpServletRequest request, HttpServletResponse response)
	{
		NguoiDung currentUser = getSessionUser(request);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if(auth == null || auth.getPrincipal() == "anonymousUser")    //Su dung cookie de luu
		{
			Cookie clientCookies[] = request.getCookies();
			for(int i=0;i<clientCookies.length;i++)
			{
				if(clientCookies[i].getName().matches("[0-9]+"))
				{						
					clientCookies[i].setMaxAge(0);
					clientCookies[i].setPath("/laptopshop");
					response.addCookie(clientCookies[i]);
				}
			}
		}else //Su dung database de luu
		{
			GioHang g = gioHangService.getGioHangByNguoiDung(currentUser);
			List<ChiMucGioHang> c = chiMucGioHangService.getChiMucGioHangByGioHang(g);
			chiMucGioHangService.deleteAllChiMucGiohang(c);
		}
	}
	
	
	
}
