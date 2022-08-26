package com.shoppingcart.app.dto.request;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
@Valid
public class VegetableRequestDto {
	//^ start with
	//[A-Z] only captials
	//{0,10} max 10 characters
	
	@Pattern(regexp = "^[A-Z]{0,10}$")
	String name;
	
	BigDecimal price;
	Integer quantity;
	String comment;

}
