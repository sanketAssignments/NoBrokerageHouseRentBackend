package com.yash.noBrokerageRentedHouse.service;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.yash.noBrokerageRentedHouse.entity.UserEntity;

public interface UserService {

	UserEntity saveUser(UserEntity user);

	UserEntity editUserDetails(UserEntity user,long userId);

	Optional<UserEntity> getUserDetailsById(long userId);

	ResponseEntity<HttpStatus> deleteUserDetailsById(long userId);

	
}
