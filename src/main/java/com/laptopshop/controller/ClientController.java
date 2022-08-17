package com.laptopshop.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.laptopshop.dto.SearchSanPhamObject;
import com.laptopshop.entities.DanhMuc;
import com.laptopshop.entities.LienHe;
import com.laptopshop.entities.NguoiDung;
import com.laptopshop.entities.ResponseObject;
import com.laptopshop.entities.SanPham;
import com.laptopshop.service.DanhMucService;
import com.laptopshop.service.LienHeService;
import com.laptopshop.service.NguoiDungService;
import com.laptopshop.service.SanPhamService;

@Controller
@SessionAttributes("loggedInUser")
@RequestMapping("/")
public class ClientController {

	@Autowired
	private SanPhamService sanPhamService;

	@Autowired
	private NguoiDungService nguoiDungService;
	
	@Autowired
	private DanhMucService danhMucService;
	
	@Autowired
	private LienHeService lienHeService;

	@ModelAttribute("loggedInUser")
	public NguoiDung loggedInUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return nguoiDungService.findByEmail(auth.getName());
	}
	
	@ModelAttribute("listDanhMuc")
	public List<DanhMuc> listDanhMuc(){
		return danhMucService.getAllDanhMuc();
	}

	public NguoiDung getSessionUser(HttpServletRequest request) {
		return (NguoiDung) request.getSession().getAttribute("loggedInUser");
	}

	@GetMapping
	public String clientPage(Model model) {
		return "client/home";
	}

	@GetMapping("/login")
	public String loginPage() {
		return "client/login";
	}
	
	@GetMapping("/contact")
	public String contactPage() {
		return "client/contact";
	}
	
	@PostMapping("/createContact")
	@ResponseBody
	public ResponseObject createContact(@RequestBody LienHe lh)
	{
		lh.setNgayLienHe(new Date());
		lienHeService.save(lh);
		return new ResponseObject();
	}

	@GetMapping("/store")
	public String storePage(@RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "") String range,@RequestParam(defaultValue = "") String brand,@RequestParam(defaultValue = "") String manufactor,@RequestParam(defaultValue = "") String os,@RequestParam(defaultValue = "") String ram,@RequestParam(defaultValue = "") String pin,Model model) {		
		SearchSanPhamObject obj = new SearchSanPhamObject();
		obj.setBrand(brand);
		obj.setDonGia(range);
		obj.setManufactor(manufactor);
		obj.setOs(os);
		obj.setRam(ram);
		obj.setPin(pin);
		Page<SanPham> list = sanPhamService.getSanPhamByBrand(obj,page,12);
		int totalPage = list.getTotalPages();
		model.addAttribute("totalPage",totalPage);
		model.addAttribute("list",list.getContent());
		model.addAttribute("currentPage",page);
		model.addAttribute("range",range);
		model.addAttribute("brand",brand);
		model.addAttribute("manufactor",manufactor);
		model.addAttribute("os",os);
		model.addAttribute("ram",ram);
		model.addAttribute("pin",pin);
		List<Integer> pagelist = new ArrayList<Integer>();
		
		//Lap ra danh sach cac trang
		if(page==1 || page ==2 || page == 3 || page == 4)
		{
			for(int i = 2; i <=5 && i<=totalPage; i++)
			{
				pagelist.add(i);
			}
		}else if(page == totalPage)
		{
			for(int i = totalPage; i >= totalPage - 3 && i> 1; i--)
			{
				pagelist.add(i);
			}
			Collections.sort(pagelist);
		}else
		{
			for(int i = page; i <= page + 2 && i<= totalPage; i++)
			{
				pagelist.add(i);
			}
			for(int i = page-1; i >= page - 2 && i> 1; i--)
			{
				pagelist.add(i);
			}
			Collections.sort(pagelist);
		}
		model.addAttribute("pageList",pagelist);
			
		//Lay cac danh muc va hang san xuat tim thay
		Set<String> hangsx = new HashSet<String>();
		Set<String> pinSet = new HashSet<String>();
		Iterable<SanPham> dum = sanPhamService.getSanPhamByTenDanhMuc(brand);
		for(SanPham sp: dum)
		{
			hangsx.add(sp.getHangSanXuat().getTenHangSanXuat());
			if(brand.equals("Laptop"))
			{
				pinSet.add(sp.getDungLuongPin());
			}
		}
		model.addAttribute("hangsx",hangsx);
		model.addAttribute("pinSet",pinSet);
		return "client/store";
	}

	@GetMapping("/sp")
	public String detailspPage(@RequestParam int id, Model model) {
		SanPham sp = sanPhamService.getSanPhamById(id);
		model.addAttribute("sp", sp);
		return "client/detailsp";
	}

	@GetMapping(value = "/logout")
	public String logoutPage(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}

	@GetMapping("/shipping")
	public String shippingPage(Model model) {

		return "client/shipping";
	}

	@GetMapping("/guarantee")
	public String guaranteePage(Model model) {

		return "client/guarantee";
	}

}
