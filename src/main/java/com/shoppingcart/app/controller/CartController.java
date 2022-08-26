package com.shoppingcart.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.app.enums.CalcTypeEnum;
import com.shoppingcart.app.response.BaseCartResponseDto;
import com.shoppingcart.app.response.CartResponseDto;
import com.shoppingcart.app.service.CartService;

@RestController("cartController")
@RequestMapping("/mycart")
public class CartController {

	@Autowired
	CartService cartService;
	
	@PostMapping("/createCart/{customerId}")
	public BaseCartResponseDto createCart(@PathVariable("customerId") Integer customerId){
		//return cartID with status Open
		return cartService.createCart(customerId);
		
	}
	
	@PostMapping("/{customerId}/addToCart/{cartId}")
	public CartResponseDto addtoCart(@PathVariable("customerId") Integer customerId,@PathVariable("cartId") Integer cartId, @RequestParam List<Integer> vegIds){
		
		return cartService.addToCart(customerId, cartId, vegIds);
		
	}
	
	
	
	//list all the available vegetables in cart.
	
	@GetMapping("/{customerId}/listItemsInCart/{cartId}")
	public CartResponseDto listItems(@PathVariable("customerId") Integer customerId,@PathVariable("cartId") Integer cartId){
		
		return cartService.getItemsInCart(customerId,cartId);
		
	}
	
	

	@PatchMapping("/{customerId}/addToCart/{cartId}")
	public CartResponseDto upDateQuantity(@PathVariable("customerId") Integer customerId,@PathVariable("cartId") Integer cartId, @RequestParam("vegId") Integer vegId, @RequestParam("type") CalcTypeEnum  type,
			@RequestParam("qty") Integer  qty){
		
		return cartService.updateQuantity( customerId,  cartId,  vegId,  qty, type);
		
	}
	
	
	
}
