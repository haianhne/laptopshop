package com.laptopshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptopshop.entities.ChiMucGioHang;
import com.laptopshop.entities.GioHang;
import com.laptopshop.entities.SanPham;

public interface ChiMucGioHangRepository extends JpaRepository<ChiMucGioHang, Long>{
	
	ChiMucGioHang findBySanPhamAndGioHang(SanPham sp,GioHang g);
	
	List<ChiMucGioHang> findByGioHang(GioHang g);
}
