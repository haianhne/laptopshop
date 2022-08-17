package com.laptopshop.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


import com.laptopshop.entities.SanPham;

public interface SanPhamRepository extends JpaRepository<SanPham, Long>, QuerydslPredicateExecutor<SanPham>{

	
	List<SanPham> findFirst12ByDanhMucTenDanhMucContainingIgnoreCaseOrderByIdDesc(String dm);
	List<SanPham> findByIdIn(Set<Long> idList);
}
