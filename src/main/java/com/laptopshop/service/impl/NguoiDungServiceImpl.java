package com.laptopshop.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.laptopshop.dto.TaiKhoanDTO;
import com.laptopshop.entities.NguoiDung;
import com.laptopshop.entities.VaiTro;
import com.laptopshop.repository.NguoiDungRepository;
import com.laptopshop.repository.VaiTroRepository;
import com.laptopshop.service.NguoiDungService;

@Service
@Transactional
public class NguoiDungServiceImpl implements NguoiDungService {

	@Autowired
	private NguoiDungRepository nguoiDungRepo;

	@Autowired
	private VaiTroRepository vaiTroRepo;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public NguoiDung findByEmail(String email) {
		return nguoiDungRepo.findByEmail(email);
	}

	@Override
	public NguoiDung findByConfirmationToken(String confirmationToken) {
		return null;
	}

	@Override
	public NguoiDung saveUserForMember(NguoiDung nd) {
		nd.setPassword(bCryptPasswordEncoder.encode(nd.getPassword()));
		Set<VaiTro> setVaiTro = new HashSet<>();
		setVaiTro.add(vaiTroRepo.findByTenVaiTro("ROLE_MEMBER"));
		nd.setVaiTro(setVaiTro);
		return nguoiDungRepo.save(nd);
	}

	@Override
	public NguoiDung findById(long id) {
		NguoiDung nd = nguoiDungRepo.findById(id).get();
		return nd;
	}

	@Override
	public NguoiDung updateUser(NguoiDung nd) {
		return nguoiDungRepo.save(nd);
	}

	@Override
	public void changePass(NguoiDung nd, String newPass) {
		nd.setPassword(bCryptPasswordEncoder.encode(newPass));
		nguoiDungRepo.save(nd);
	}

	@Override
	public Page<NguoiDung> getNguoiDungByVaiTro(Set<VaiTro> vaiTro,  int page) {
		return nguoiDungRepo.findByVaiTro(vaiTro, PageRequest.of(page - 1, 6));
	}

	@Override
	public List<NguoiDung> getNguoiDungByVaiTro(Set<VaiTro> vaiTro) {
		return nguoiDungRepo.findByVaiTro(vaiTro);
	}

	@Override
	public NguoiDung saveUserForAdmin(TaiKhoanDTO dto) {
		NguoiDung nd = new NguoiDung();
		nd.setHoTen(dto.getHoTen());
		nd.setDiaChi(dto.getDiaChi());
		nd.setEmail(dto.getEmail());
		nd.setSoDienThoai(dto.getSdt());
		nd.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
		
		Set<VaiTro> vaiTro  = new HashSet<>();
		vaiTro.add(vaiTroRepo.findByTenVaiTro(dto.getTenVaiTro()));
		nd.setVaiTro(vaiTro);
		
		return nguoiDungRepo.save(nd);
	}

	@Override
	public void deleteById(long id) {
		nguoiDungRepo.deleteById(id);
	}

}
