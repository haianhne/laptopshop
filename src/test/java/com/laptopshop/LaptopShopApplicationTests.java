package com.laptopshop;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.laptopshop.entities.DanhMuc;
import com.laptopshop.entities.DonHang;
import com.laptopshop.entities.NguoiDung;
import com.laptopshop.entities.VaiTro;
import com.laptopshop.repository.DonHangRepository;
import com.laptopshop.repository.NguoiDungRepository;
import com.laptopshop.service.DanhMucService;
import com.laptopshop.service.NguoiDungService;
import com.laptopshop.service.SanPhamService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LaptopShopApplicationTests {

	@Autowired
	private DanhMucService dmService;

	@Autowired
	private NguoiDungService nguoiDungService;

	@Autowired
	private NguoiDungRepository ndRepo;

	@Autowired
	private DonHangRepository dhRepo;
	
	@Autowired
	private SanPhamService spService;


//	@Test
//	public void getALlDanhMucTest() {
//		System.out.println(dhRepo.test().size());
//	}

	@Test
	public void getALlDanhMucTest() {
		System.out.println(spService.getSanPhamByTenSanPhamForAdmin("asus",0,10).getContent().size());
	}

}
