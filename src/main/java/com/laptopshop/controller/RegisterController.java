package com.laptopshop.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.laptopshop.entities.NguoiDung;
import com.laptopshop.service.NguoiDungService;
import com.laptopshop.service.SecurityService;
import com.laptopshop.validator.NguoiDungValidator;

@Controller
public class RegisterController {

    @Autowired
    private NguoiDungService nguoiDungService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private NguoiDungValidator nguoiDungValidator;
	
	
	@GetMapping("/register")
	public String registerPage(Model model) {
		model.addAttribute("newUser", new NguoiDung());
		return "client/register";
	}
	
	@PostMapping("/register")
	public String registerProcess(@ModelAttribute("newUser") @Valid NguoiDung nguoiDung, BindingResult bindingResult, Model model) {
	    
		nguoiDungValidator.validate(nguoiDung, bindingResult);
		
        if (bindingResult.hasErrors()) {
            return "client/register";
        }
        
        nguoiDungService.saveUserForMember(nguoiDung);

        securityService.autologin(nguoiDung.getEmail(), nguoiDung.getConfirmPassword());

        return "redirect:/";
	}
}
