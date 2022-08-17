package com.laptopshop.api.admin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laptopshop.dto.TaiKhoanDTO;
import com.laptopshop.entities.NguoiDung;
import com.laptopshop.entities.ResponseObject;
import com.laptopshop.entities.VaiTro;
import com.laptopshop.service.NguoiDungService;
import com.laptopshop.service.VaiTroService;
import com.laptopshop.validator.NguoiDungValidator;

@RestController
@RequestMapping("/api/tai-khoan")
public class TaiKhoanApi {

	@Autowired
	private NguoiDungService nguoiDungService;

	@Autowired
	private VaiTroService vaiTroService;

	@GetMapping("/all")
	public Page<NguoiDung> getNguoiDungByVaiTro(@RequestParam("tenVaiTro") String tenVaiTro,
			@RequestParam(defaultValue = "1") int page) {
		Set<VaiTro> vaiTro = new HashSet<>();
		vaiTro.add(vaiTroService.findByTenVaiTro(tenVaiTro));

		return nguoiDungService.getNguoiDungByVaiTro(vaiTro, page);
	}

	@PostMapping("/save")
	public ResponseObject saveTaiKhoan(@RequestBody @Valid TaiKhoanDTO dto, BindingResult result, Model model) {
		
		ResponseObject ro = new ResponseObject();

		if(nguoiDungService.findByEmail(dto.getEmail()) != null) {
			result.rejectValue("email", "error.email","Email đã được đăng ký");
		}
		if(!dto.getConfirmPassword().equals(dto.getPassword())) {
			result.rejectValue("confirmPassword", "error.confirmPassword","Nhắc lại mật khẩu không đúng");
		}

		if (result.hasErrors()) {
			setErrorsForResponseObject(result, ro);
		} else {
			ro.setStatus("success");
			nguoiDungService.saveUserForAdmin(dto);
		}	
		return ro;
	}

	@DeleteMapping("/delete/{id}")
	public void deleteTaiKhoan(@PathVariable long id) {
		nguoiDungService.deleteById(id);
	}
	public void setErrorsForResponseObject(BindingResult result, ResponseObject object) {

		Map<String, String> errors = result.getFieldErrors().stream()
				.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
		object.setErrorMessages(errors);
		object.setStatus("fail");
		
		List<String> keys = new ArrayList<String>(errors.keySet());			
		for (String key: keys) {
		    System.out.println(key + ": " + errors.get(key));
		}
		
		errors = null;
	}
}
