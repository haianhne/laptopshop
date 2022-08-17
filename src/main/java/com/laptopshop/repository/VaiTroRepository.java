package com.laptopshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptopshop.entities.VaiTro;

public interface VaiTroRepository extends JpaRepository<VaiTro, Long> {

	VaiTro findByTenVaiTro(String tenVaiTro);
}
