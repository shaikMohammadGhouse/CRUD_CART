package com.shoppingcart.app.dto;

import java.util.List;

import com.shoppingcart.app.response.VegetableResponseDto;

import lombok.Data;
@Data
public class CartDto {

	int cartId;
	int customerId;	
	List<VegetableResponseDto> vegetables;
}
