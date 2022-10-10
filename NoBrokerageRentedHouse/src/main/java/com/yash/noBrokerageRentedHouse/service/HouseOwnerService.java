package com.yash.noBrokerageRentedHouse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.yash.noBrokerageRentedHouse.entity.HouseOwner;

public interface HouseOwnerService {

	HouseOwner saveUser(HouseOwner houseOwner);

	Optional<HouseOwner> getUserDetailsById(long ownerId);

	HouseOwner editUserDetails(HouseOwner houseOwner, long ownerId);

	ResponseEntity<HouseOwner> deleteUserDetailsById(long ownerId);

	List<HouseOwner> getAllHouseOwner(long ownerAddress);

	void addData(HouseOwner houseOwner2);

}
