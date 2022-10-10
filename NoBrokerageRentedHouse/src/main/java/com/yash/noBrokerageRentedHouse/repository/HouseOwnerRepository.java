package com.yash.noBrokerageRentedHouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.noBrokerageRentedHouse.entity.HouseOwner;

@Repository
public interface HouseOwnerRepository extends JpaRepository<HouseOwner, Long>{

//	String findByUserEmailAndUserPassword(String email, String password);
//
//	Object findByOwnerEmail(String email);

	
}
