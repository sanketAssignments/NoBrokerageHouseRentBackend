package com.yash.noBrokerageRentedHouse.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.yash.noBrokerageRentedHouse.entity.HouseOwner;
import com.yash.noBrokerageRentedHouse.repository.HouseOwnerRepository;
import com.yash.noBrokerageRentedHouse.service.HouseOwnerService;

@Service
public class HouseOwnerServiceImpl implements HouseOwnerService {

	@Autowired
	HouseOwnerRepository houseOwnerRepository;
	
	@Override
	public HouseOwner saveUser(HouseOwner houseOwner) {
		
		houseOwnerRepository.save(houseOwner);
		return houseOwner;
	}

	@Override
	public Optional<HouseOwner> getUserDetailsById(long ownerId) {

		Optional<HouseOwner> data= houseOwnerRepository.findById(ownerId);
		if(data.isPresent()) {
			return data;
		}
		else {
			throw new NullPointerException("data is not present");
		}
	}

	@Override
	public HouseOwner editUserDetails(HouseOwner houseOwner, long ownerId) {
		Optional<HouseOwner> data= houseOwnerRepository.findById(ownerId);
		if(data.isPresent()) {
			return houseOwnerRepository.save(houseOwner);
		}
		else {
			throw new NullPointerException("data is not present");
		}
	}

	@Override
	public ResponseEntity<HouseOwner> deleteUserDetailsById(long ownerId) {
		
		houseOwnerRepository.deleteById(ownerId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@Override
	public List<HouseOwner> getAllHouseOwner(long ownerAddress) {

		
		return null;
	}

	@Override
	public void addData(HouseOwner houseOwner2) {
		
		houseOwnerRepository.save(houseOwner2);
		
	}

}
