package com.laptopshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.laptopshop.entities.LienHe;

public interface LienHeRepository extends JpaRepository<LienHe, Long>, QuerydslPredicateExecutor<LienHe>{

	int countByTrangThai(String trangThai);
	
}
