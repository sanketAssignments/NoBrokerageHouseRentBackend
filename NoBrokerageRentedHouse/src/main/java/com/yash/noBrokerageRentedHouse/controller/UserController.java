package com.yash.noBrokerageRentedHouse.controller;

import java.util.Optional;
import java.util.Random;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.noBrokerageRentedHouse.entity.Roll;
import com.yash.noBrokerageRentedHouse.entity.UserEntity;
import com.yash.noBrokerageRentedHouse.service.UserService;
import com.yash.noBrokerageRentedHouse.serviceImpl.EmailService;

@RestController
@RequestMapping("/API/User")
@CrossOrigin("*")
public class UserController {
	
	Random random=new Random(1000);
	
	@Autowired
	UserService userService;
	
	@Autowired
	EmailService emailService;
	

	@PostMapping("/saveUserDetails")
	ResponseEntity<UserEntity> saveUserDetails(@RequestBody UserEntity user) {
		
		if(user!=null) {
			//user.setLoginCredential().getRoll(Roll.user);
		UserEntity obj=userService.saveUser(user);
		return ResponseEntity.ok(obj);
		}
		else {
			throw new NullPointerException("Object is null");
		}
	}
	
	@GetMapping("/getUserDetails/{id}")
	ResponseEntity<Optional<UserEntity>> getUserDetails(@PathVariable("id") long userId) {
			
		Optional<UserEntity> uid= userService.getUserDetailsById(userId);
			
			return ResponseEntity.ok(uid);
			
		}
	@PutMapping("/updateUserDetails/{id}")
	ResponseEntity<UserEntity> updateUserDetails(@RequestBody UserEntity user,@PathVariable("id") long userId) {
		
		UserEntity uid= userService.editUserDetails(user,userId);
		
		return ResponseEntity.ok(uid);
	}
	@DeleteMapping("/deleteUserDetails/{id}")
	ResponseEntity<UserEntity> deleteUserDetails(@PathVariable("id") long userId) {
		
        userService.deleteUserDetailsById(userId);
		
		return new ResponseEntity<UserEntity>(HttpStatus.OK);
	}
	
	@PostMapping("/sendOtp/{email}")
	String emailSendOTPVerify(@PathVariable String email) throws MessagingException {
		
		int otp=random.nextInt(9999);
		//System.out.println(otp);
		emailService.sendOtpMessage(email, "demo", "Hi,/n Your OTP is :-/n"+otp);
		return "";
	}
	
	
	
}
