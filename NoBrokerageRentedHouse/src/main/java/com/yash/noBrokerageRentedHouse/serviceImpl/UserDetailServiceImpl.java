package com.yash.noBrokerageRentedHouse.serviceImpl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.yash.noBrokerageRentedHouse.entity.UserEntity;
import com.yash.noBrokerageRentedHouse.repository.UserRepository;
import com.yash.noBrokerageRentedHouse.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserDetailServiceImpl implements UserService {
	//UserDetailsService
	@Autowired
	UserRepository userRepository;
	
//	@Override
//	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//		log.info("we are in load by userName");
//		//UserEntity user=userRepository.findByUserName(username);
//		System.out.println(email);
//		if(email==null) {
//			log.error("User is not found");
//			throw new UsernameNotFoundException("User not found");
//		}
//		else {
//			log.info("user found in database : {}",email);
//		     return  new User("akshay","$2a$04$vRPiQxFX1zfXke8fI838KuXODddTv5.l4VuTjbVu/cb5uTDcxSSim", new ArrayList<>());
//	}
//	}

	@Override
	public UserEntity saveUser(UserEntity user) {
		
		userRepository.save(user);
		return user;
	}

	@Override
	public UserEntity editUserDetails(UserEntity user, long userId) {
	
		Optional<UserEntity> uid= userRepository.findById(userId);
		if(uid.isPresent()) {
			userRepository.save(user);
			return user;
		}
		else {
			throw new UsernameNotFoundException("User not present in database");
		}
		
	}

	@Override
	public Optional<UserEntity> getUserDetailsById(long userId) {
		
	return	 userRepository.findById(userId);

	}

	@Override
	public ResponseEntity<HttpStatus> deleteUserDetailsById(long userId) {
		
		 Optional<UserEntity> uid= userRepository.findById(userId);
			if(uid.isPresent()) {
				 userRepository.deleteById(userId);
				 return new ResponseEntity<HttpStatus>(HttpStatus.OK);
			}
			else {
				throw new UsernameNotFoundException("User not present in database");
			}
	}

}
