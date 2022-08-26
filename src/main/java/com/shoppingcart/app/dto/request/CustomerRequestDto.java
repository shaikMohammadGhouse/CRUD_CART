package com.shoppingcart.app.dto.request;

import com.shoppingcart.app.dto.AddressDto;

import lombok.Data;

@Data
public class CustomerRequestDto {

	String name;
	
	String mobileNumber;
	
	AddressDto address;	
	
	String emailId;
	
	String password;
	
	String confirmPassword;
}
