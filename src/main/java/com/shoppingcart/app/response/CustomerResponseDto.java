package com.shoppingcart.app.response;

import com.shoppingcart.app.dto.AddressDto;

import lombok.Data;

@Data
public class CustomerResponseDto {
	
	Integer customerId;

	String name;
	
	String mobileNumber;
	
	AddressDto address;	
	
	String emailId;
	
	String password;
	
	String confirmPassword;
}
