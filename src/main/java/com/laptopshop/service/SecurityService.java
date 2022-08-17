package com.laptopshop.service;

public interface SecurityService {

	String findLoggedInUsername();

	void autologin(String email, String password);

}
