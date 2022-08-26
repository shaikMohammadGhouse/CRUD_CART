package com.shoppingcart.app.response;

import java.math.BigDecimal;
import java.util.Set;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class CartResponseDto extends BaseCartResponseDto{
	Integer customerId;	
	BigDecimal totalPrice;
	Set<VegetableResponseDto> vegetables;
}
