package com.yash.noBrokerageRentedHouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.noBrokerageRentedHouse.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

//	String findByUserEmail(String userEmail);
//
//	String findByUserEmailAndUserPassword(String email, String password);
}
