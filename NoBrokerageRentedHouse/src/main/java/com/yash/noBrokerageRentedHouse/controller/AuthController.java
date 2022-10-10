package com.yash.noBrokerageRentedHouse.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yash.noBrokerageRentedHouse.config.JwtUtil;
import com.yash.noBrokerageRentedHouse.entity.JwtRequest;
import com.yash.noBrokerageRentedHouse.entity.JwtResponse;
import com.yash.noBrokerageRentedHouse.entity.UserEntity;
import com.yash.noBrokerageRentedHouse.serviceImpl.EmailService;
import com.yash.noBrokerageRentedHouse.serviceImpl.UserDetailServiceImpl;


@CrossOrigin("*")

@RestController
public class AuthController 
{
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailServiceImpl userDetailServiceImpl;
	
	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private EmailService emailService;
	
	
	//generate tokens
	
	@PostMapping("/generate-token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception
	{
		try {
			emailService.sendOtpMessage("sanket.kongare@gmail.com", "demo", "hello tushar this is sanket");
			authenticate(jwtRequest.getEmail(), jwtRequest.getPassword());
			
		} catch (UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("employee not found");
		}
	
	
	//authenticate
		
//	UserDetails userDetails= this.userDetailServiceImpl.loadUserByUsername(jwtRequest.getEmail());
//	String token=this.jwtUtil.generateToken(userDetails);
//	System.out.println(token);
//	return ResponseEntity.ok( new JwtResponse(token));
	
	return ResponseEntity.ok(null);
	}
	
	private void authenticate(String username,String password) throws Exception
	{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			
		} catch (DisabledException e) {
			
			throw new Exception("USER DISABLED" +e.getMessage());
		}
		catch (BadCredentialsException e) {
			System.err.println("hello");
			throw new Exception("invalid credentials" +e.getMessage());
		}
	}
	
	 //return the details of current user
//    @GetMapping("/current-User")
//    public UserEntity getCurrentUser(Principal principal) {
//        return ((UserEntity) this.userDetailServiceImpl.loadUserByUsername(principal.getName()));
//
//    }


}
