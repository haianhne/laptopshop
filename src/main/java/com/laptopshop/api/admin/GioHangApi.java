package com.laptopshop.api.admin;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.laptopshop.entities.ChiMucGioHang;
import com.laptopshop.entities.GioHang;
import com.laptopshop.entities.NguoiDung;
import com.laptopshop.entities.ResponseObject;
import com.laptopshop.entities.SanPham;
import com.laptopshop.service.ChiMucGioHangService;
import com.laptopshop.service.GioHangService;
import com.laptopshop.service.NguoiDungService;
import com.laptopshop.service.SanPhamService;

@RestController
@RequestMapping("api/gio-hang")
@SessionAttributes("loggedInUser")
public class GioHangApi  {
	
	@Autowired
	private NguoiDungService nguoiDungService;
	@Autowired
	private GioHangService gioHangService;
	@Autowired
	private SanPhamService sanPhamService;
	@Autowired
	private ChiMucGioHangService chiMucGioHangService;
	
	@ModelAttribute("loggedInUser")
	public NguoiDung loggedInUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return nguoiDungService.findByEmail(auth.getName());
	}
	
	public NguoiDung getSessionUser(HttpServletRequest request) {
		return (NguoiDung) request.getSession().getAttribute("loggedInUser");
	}
	
	@GetMapping("/addSanPham")
	public ResponseObject addToCart(@RequestParam String id,HttpServletRequest request,HttpServletResponse response) {
		ResponseObject ro = new ResponseObject();
		SanPham sp = sanPhamService.getSanPhamById(Long.parseLong(id));
		if(sp.getDonViKho() == 0)
		{
			ro.setStatus("false");
			return ro;
		}
		NguoiDung currentUser = getSessionUser(request);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();	
		if(auth == null || auth.getPrincipal() == "anonymousUser" )    //Su dung cookie de luu
		{
			Cookie clientCookies[] = request.getCookies();
			boolean found = false;
			for(int i=0;i<clientCookies.length;i++)
			{
				if(clientCookies[i].getName().equals(id))     //Neu san pham da co trong cookie tang so luong them 1
				{				
					clientCookies[i].setValue(Integer.toString(Integer.parseInt(clientCookies[i].getValue())+1));
					clientCookies[i].setPath("/laptopshop");
					clientCookies[i].setMaxAge(60*60*24*7);
					response.addCookie(clientCookies[i]);
					found = true;
					break;
				}
			}
			if(!found)   //Neu san pham ko co trong cookie,them vao cookie
			{
				Cookie c = new Cookie(id,"1");
				c.setPath("/laptopshop");
				c.setMaxAge(60*60*24*7);
				response.addCookie(c);
			}
		}else {     //Su dung database de luu
			GioHang g = gioHangService.getGioHangByNguoiDung(currentUser);
			if(g==null)
			{
				g = new GioHang();
				g.setNguoiDung(currentUser);
				g = gioHangService.save(g);			
			}
			
			ChiMucGioHang c = chiMucGioHangService.getChiMucGioHangBySanPhamAndGioHang(sp,g);
			if(c== null)     //Neu khong tim chi muc gio hang, tao moi
			{
				System.out.println(g.getNguoiDung().getEmail());
				System.out.println(g.getId());
				c = new ChiMucGioHang();
				c.setGioHang(g);
				c.setSanPham(sp);
				c.setSo_luong(1);
			}else       //Neu san pham da co trong database tang so luong them 1
			{
				c.setSo_luong(c.getSo_luong()+1);
			}
			c = chiMucGioHangService.saveChiMucGiohang(c);
		}
		ro.setStatus("success");
		return ro;
	}
	
	@GetMapping("/changSanPhamQuanity")
	public ResponseObject changeQuanity(@RequestParam String id,@RequestParam String value,HttpServletRequest request,HttpServletResponse response) {
		NguoiDung currentUser = getSessionUser(request);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		ResponseObject ro = new ResponseObject();
		if(auth == null || auth.getPrincipal() == "anonymousUser" )    //Su dung cookie de luu
		{
			Cookie clientCookies[] = request.getCookies();
			for(int i=0;i<clientCookies.length;i++)
			{
				if(clientCookies[i].getName().equals(id))
				{						
					clientCookies[i].setValue(value);
					clientCookies[i].setPath("/laptopshop");
					clientCookies[i].setMaxAge(60*60*24*7);
					response.addCookie(clientCookies[i]);
					break;
				}
			}
		}else //Su dung database de luu
		{
			GioHang g = gioHangService.getGioHangByNguoiDung(currentUser);
			SanPham sp = sanPhamService.getSanPhamById(Long.parseLong(id));
			ChiMucGioHang c = chiMucGioHangService.getChiMucGioHangBySanPhamAndGioHang(sp,g);
			c.setSo_luong(Integer.parseInt(value));
			c = chiMucGioHangService.saveChiMucGiohang(c);
		}
		ro.setStatus("success");
		return ro;
	}
	
	@GetMapping("/deleteFromCart")
	public ResponseObject deleteSanPham(@RequestParam String id,HttpServletRequest request,HttpServletResponse response) {
		NguoiDung currentUser = getSessionUser(request);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();	
		ResponseObject ro = new ResponseObject();
		if(auth == null || auth.getPrincipal() == "anonymousUser")    //Su dung cookie de luu
		{
			Cookie clientCookies[] = request.getCookies();
			for(int i=0;i<clientCookies.length;i++)
			{
				if(clientCookies[i].getName().equals(id))
				{						
					clientCookies[i].setMaxAge(0);
					clientCookies[i].setPath("/laptopshop");
					System.out.println(clientCookies[i].getMaxAge());
					response.addCookie(clientCookies[i]);
					break;
				}
			}
		}else //Su dung database de luu
		{
			GioHang g = gioHangService.getGioHangByNguoiDung(currentUser);
			SanPham sp = sanPhamService.getSanPhamById(Long.parseLong(id));
			ChiMucGioHang c = chiMucGioHangService.getChiMucGioHangBySanPhamAndGioHang(sp,g);
			chiMucGioHangService.deleteChiMucGiohang(c);
		}
		
		ro.setStatus("success");
		return ro;
	}
}
