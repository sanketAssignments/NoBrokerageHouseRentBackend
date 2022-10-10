package com.yash.noBrokerageRentedHouse.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;
	private String userFirstName;
	private String userLastName;
	private String userCountry;
	private String userPhoneNumber;
	private String userAddress;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId_id")
	private LoginCredential loginCredential;
	
}
