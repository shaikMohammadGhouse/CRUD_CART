package com.shoppingcart.app.response;

import java.util.Date;

import lombok.Data;

@Data
public class VegetableResponseDto {
	int vegId;
	
	String name;
	
	String type;
	
	double price;
	
	int quantity;
	
	private Date createDate;

	private Date modifyDate;

}
