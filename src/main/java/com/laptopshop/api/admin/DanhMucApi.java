package com.laptopshop.api.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
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

import com.laptopshop.entities.DanhMuc;
import com.laptopshop.entities.ResponseObject;
import com.laptopshop.service.DanhMucService;

@RestController
@RequestMapping("api/danh-muc")
public class DanhMucApi {

	@Autowired
	private DanhMucService danhMucService;

	@GetMapping("/all")
	public Page<DanhMuc> getAllDanhMuc(@RequestParam(defaultValue = "1") int page) {
		return danhMucService.getAllDanhMucForPageable(page-1,6);
	}
	
	@GetMapping("/allForReal")
	public List<DanhMuc> getRealAllDanhMuc() {
		return danhMucService.getAllDanhMuc();
	}

	@GetMapping("/{id}")
	public DanhMuc getDanhMucById(@PathVariable long id) {
		return danhMucService.getDanhMucById(id);
	}

	@PostMapping(value = "/save")
	public ResponseObject addDanhMuc(@RequestBody @Valid DanhMuc newDanhMuc, BindingResult result, HttpServletRequest request) {
		
		ResponseObject ro = new ResponseObject();
		
		if (result.hasErrors()) {

			Map<String, String> errors = result.getFieldErrors().stream()
					.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
			ro.setErrorMessages(errors);
			
			List<String> keys = new ArrayList<String>(errors.keySet());			
			for (String key: keys) {
			    System.out.println(key + ": " + errors.get(key));
			}
			
			ro.setStatus("fail");
			errors = null;
			;
		} else {
			danhMucService.save(newDanhMuc);
			ro.setData(newDanhMuc);
			ro.setStatus("success");
		}
		return ro;
	}
	
	@PutMapping(value = "/update")
	public ResponseObject updateDanhMuc(@RequestBody @Valid DanhMuc editDanhMuc, BindingResult result, HttpServletRequest request) {
		
		ResponseObject ro = new ResponseObject();		
		if (result.hasErrors()) {

			Map<String, String> errors = result.getFieldErrors().stream()
					.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
			ro.setErrorMessages(errors);
			ro.setStatus("fail");
			errors = null;
			
		} else {
			danhMucService.update(editDanhMuc);
			ro.setData(editDanhMuc);
			ro.setStatus("success");
		}
		
		return ro;
	}

	@DeleteMapping("/delete/{id}")
	public String deleteDanhMuc(@PathVariable long id, HttpServletRequest request) {
		danhMucService.deleteById(id);
		request.getSession().setAttribute("listDanhMuc", danhMucService.getAllDanhMuc());;
		return "OK !";
	}

}
