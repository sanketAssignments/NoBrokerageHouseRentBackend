package com.yash.noBrokerageRentedHouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.noBrokerageRentedHouse.serviceImpl.LoginService;

@CrossOrigin("*")
@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@GetMapping("/getData")
	String login(@PathVariable String email, @PathVariable String password) {
	
		return loginService.getCredential(email, password);
	}
} 
