package com.laptopshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.laptopshop.entities.DanhMuc;
import com.laptopshop.repository.DanhMucRepository;
import com.laptopshop.service.DanhMucService;


@Service
public class DanhMucServiceImpl implements DanhMucService {

	@Autowired
	private DanhMucRepository repo;

	@Override
	public DanhMuc save(DanhMuc d) {
		return repo.save(d);
	}

	@Override
	public DanhMuc update(DanhMuc d) {
		return repo.save(d);
	}

	@Override
	public void deleteById(long id) {
		repo.deleteById(id);
	}

	@Override
	public Page<DanhMuc> getAllDanhMucForPageable(int page, int size) {
		return repo.findAll(PageRequest.of(page, size));
	}

	@Override
	public DanhMuc getDanhMucById(long id) {
		return repo.findById(id).get();
	}

	@Override
	public List<DanhMuc> getAllDanhMuc() {
		return repo.findAll();
	}

}
