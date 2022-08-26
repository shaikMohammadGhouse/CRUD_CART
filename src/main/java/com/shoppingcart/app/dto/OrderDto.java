package com.shoppingcart.app.dto;

import java.util.List;

import com.shoppingcart.app.response.VegetableResponseDto;

import lombok.Data;
@Data
public class OrderDto {

	int orderNo;
	int customerId;
	List<VegetableResponseDto> vegetableList;
	double totalAmount;
	String status;
}
