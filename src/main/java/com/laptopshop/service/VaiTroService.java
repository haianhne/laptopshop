package com.laptopshop.service;

import java.util.List;

import com.laptopshop.entities.VaiTro;

public interface VaiTroService {

	VaiTro findByTenVaiTro(String tenVaiTro);
	List<VaiTro> findAllVaiTro();
}
