package com.yash.noBrokerageRentedHouse.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.noBrokerageRentedHouse.repository.HouseOwnerRepository;
import com.yash.noBrokerageRentedHouse.repository.LoginRepo;
import com.yash.noBrokerageRentedHouse.repository.UserRepository;

@Service
public class LoginService {

	@Autowired
	LoginRepo loginRepo;
	
	/*
	 * @Autowired HouseOwnerRepository houseOwnerRepository;
	 * 
	 * @Autowired UserRepository userRepository;
	 * 
	 * String checkLogin(String email, String password) {
	 * 
	 * Optional<String> eml=Optional.of(userRepository.findByUserEmail(email));
	 * if(eml.isPresent()) { return
	 * userRepository.findByUserEmailAndUserPassword(email,password); } else {
	 * Optional<String> oeml=Optional.empty(); return
	 * houseOwnerRepository.findByUserEmailAndUserPassword(email,password); }
	 * 
	 * 
	 * }
	 */

	public String getCredential(String email, String password) {
		
		return loginRepo.findByEmailAndPassword(email,password);
	}
	
	
	
	
}
