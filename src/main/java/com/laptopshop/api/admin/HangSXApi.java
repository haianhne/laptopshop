package com.laptopshop.api.admin;

import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laptopshop.entities.HangSanXuat;
import com.laptopshop.entities.ResponseObject;
import com.laptopshop.service.HangSanXuatService;

@RestController
@RequestMapping("/api/nhan-hieu")
public class HangSXApi {

	@Autowired
	private HangSanXuatService service;

	@GetMapping("/all")
	public Page<HangSanXuat> getAllHangSanXuat(@RequestParam(defaultValue = "1") int page) {
		return service.getALlHangSX(page-1,6);
	}

	@GetMapping("/{id}")
	public HangSanXuat getHangSanXuatById(@PathVariable long id) {
		return service.getHSXById(id);
	}

	@PostMapping(value = "/save")
	public ResponseObject addHangSanXuat(@RequestBody @Valid HangSanXuat newHangSanXuat, BindingResult result) {

		ResponseObject ro = new ResponseObject();

		if (result.hasErrors()) {
			Map<String, String> errors = result.getFieldErrors().stream()
					.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
			ro.setErrorMessages(errors);
			ro.setStatus("fail");
		} else {
			service.save(newHangSanXuat);
			ro.setData(newHangSanXuat);
			ro.setStatus("success");
		}
		return ro;
	}

	@PutMapping(value = "/update")
	public ResponseObject updateHangSanXuat(@RequestBody @Valid HangSanXuat editHangSanXuat, BindingResult result) {

		ResponseObject ro = new ResponseObject();
		if (result.hasErrors()) {
			Map<String, String> errors = result.getFieldErrors().stream()
					.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
			ro.setErrorMessages(errors);
			ro.setStatus("fail");
			errors = null;
		} else {
			service.update(editHangSanXuat);
			ro.setData(editHangSanXuat);
			ro.setStatus("success");
		}

		return ro;
	}

	@DeleteMapping("/delete/{id}")
	public String deleteHangSanXuat(@PathVariable long id) {
		service.deleteById(id);
		return "OK !";
	}
}
