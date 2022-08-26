package com.shoppingcart.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shoppingcart.app.enums.CalcTypeEnum;
import com.shoppingcart.app.response.BaseCartResponseDto;
import com.shoppingcart.app.response.CartResponseDto;

@Service
public interface CartService {

		
	CartResponseDto updateQuantity(Integer customerId, Integer cartId, Integer vegId, Integer quantity, CalcTypeEnum type);
	
	CartResponseDto removeFromCart(Integer customerId, Integer cartId, List<Integer> vegIds);
	
	CartResponseDto addToCart(Integer customerId, Integer cartId, List<Integer> vegIds);

	BaseCartResponseDto createCart(Integer customerId);

	CartResponseDto getItemsInCart(Integer customerId, Integer cartId);
	
}
