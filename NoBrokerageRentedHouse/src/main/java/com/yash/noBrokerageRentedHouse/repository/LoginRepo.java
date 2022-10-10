package com.yash.noBrokerageRentedHouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.noBrokerageRentedHouse.entity.LoginCredential;

public interface LoginRepo extends JpaRepository<LoginCredential, Integer> {

	String findByEmailAndPassword(String email, String password);

	
	
}
