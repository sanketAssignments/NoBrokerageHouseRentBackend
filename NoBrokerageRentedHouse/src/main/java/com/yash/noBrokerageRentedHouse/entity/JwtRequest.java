package com.yash.noBrokerageRentedHouse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtRequest {

	private String email;
	private String password;
}
