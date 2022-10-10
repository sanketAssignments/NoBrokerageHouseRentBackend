package com.yash.noBrokerageRentedHouse.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class HouseOwner {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ownerId;
	private String ownerFirstName;
	private String ownerLastName;
	private String ownerCountry;
	private String ownerPhoneNumber;
	private String ownerAddress;
	private String houseType;
	private String imgName;
	@Lob
	private byte[] img;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId_id")
	private LoginCredential loginCredential;
}
