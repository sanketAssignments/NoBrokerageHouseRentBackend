package com.yash.noBrokerageRentedHouse.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.BeanDefinitionDsl.Role;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yash.noBrokerageRentedHouse.entity.HouseOwner;
import com.yash.noBrokerageRentedHouse.entity.Roll;
import com.yash.noBrokerageRentedHouse.entity.UserEntity;
import com.yash.noBrokerageRentedHouse.service.HouseOwnerService;

@RestController
@CrossOrigin("*")
@RequestMapping("/API/houseOwner")
public class HouseOwnerController {

	@Autowired
	HouseOwnerService houseOwnerService;
	
	
	@PostMapping("/saveHouseOwnerDetailsByName")
	ResponseEntity<HouseOwner> saveHouseOwnerDetails(@RequestBody HouseOwner houseOwner) {
		
		if(houseOwner!=null) {
			HouseOwner obj=houseOwnerService.saveUser(houseOwner);
			return ResponseEntity.ok(obj);
			}
			else {
				throw new NullPointerException("Object is null");
			}
	}
	
	@GetMapping("/getHouseOwnerDetails/{id}")
	ResponseEntity<Optional<HouseOwner>> getHouseOwnerDetails(@PathVariable("id") long ownerId) {
			
		Optional<HouseOwner> uid= houseOwnerService.getUserDetailsById(ownerId);
		
		return ResponseEntity.ok(uid);
		}
	
	@GetMapping("/getAllHouseOwnerDetails/{address}")
	ResponseEntity<List<HouseOwner>> geAlltHouseOwnerDetails(@PathVariable("address") long ownerAddress) {
			
			List<HouseOwner> list=houseOwnerService.getAllHouseOwner(ownerAddress);
			return new ResponseEntity<List<HouseOwner>>(list,HttpStatus.OK);
		}
	
	@PutMapping("/editHouseOwnerDetails/{id}")
	ResponseEntity<HouseOwner> updateHouseOwnerDetails(@RequestBody HouseOwner houseOwner,@PathVariable("id") long ownerId) {
		
		   return new ResponseEntity<HouseOwner>(houseOwnerService.editUserDetails(houseOwner,ownerId), HttpStatus.OK);
	}
	@DeleteMapping("/deleteHouseOwnerDetails/{id}")
	ResponseEntity<HouseOwner> deleteHouseOwnerDetails(@PathVariable("id") long ownerId) {
		
		houseOwnerService.deleteUserDetailsById(ownerId);
		
		return new ResponseEntity<HouseOwner>(HttpStatus.OK);
	}
	
	@PutMapping("/saveData")

	public HouseOwner saveData(@RequestParam(name = "file",required = false) MultipartFile[] files, @RequestParam("houseOwner") String houseOwner ) throws JsonMappingException, JsonProcessingException,IOException { 
		  ObjectMapper Om= new ObjectMapper();
		  Om.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		  HouseOwner houseOwner2 = Om.readValue(houseOwner,HouseOwner.class); 
		  houseOwner2.getLoginCredential().setRoll(Roll.owner);
		  if(files!=null) {
			  System.out.println(files);
			  for(MultipartFile file:files) {
	  byte[] data =file.getBytes();
	  houseOwner2.setImg(data);
	  houseOwner2.setImgName(file.getOriginalFilename());
		  }}
	  houseOwnerService.addData(houseOwner2); 
	  
	  return houseOwner2;
	  }
}
