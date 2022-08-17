package com.laptopshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptopshop.entities.VaiTro;
import com.laptopshop.repository.VaiTroRepository;
import com.laptopshop.service.VaiTroService;

@Service
public class VaiTroServiceImpl implements VaiTroService{
	

	@Autowired
	private VaiTroRepository repo;

	@Override
	public VaiTro findByTenVaiTro(String tenVaiTro) {
		return repo.findByTenVaiTro(tenVaiTro);
	}

	@Override
	public List<VaiTro> findAllVaiTro() {
		return repo.findAll();
	}


}
