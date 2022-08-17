package com.laptopshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.laptopshop.entities.GioHang;
import com.laptopshop.entities.NguoiDung;

public interface GioHangRepository extends JpaRepository<GioHang, Long>{
	
	GioHang findByNguoiDung(NguoiDung n);
	
}
