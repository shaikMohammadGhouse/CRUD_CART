package com.shoppingcart.app.service.impl;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.app.dao.Cart;
import com.shoppingcart.app.dao.Customer;
import com.shoppingcart.app.dao.Vegetable;
import com.shoppingcart.app.enums.CalcTypeEnum;
import com.shoppingcart.app.enums.StatusEnum;
import com.shoppingcart.app.exception.ApplicationException;
import com.shoppingcart.app.repository.CartRepository;
import com.shoppingcart.app.repository.CustomerRepository;
import com.shoppingcart.app.repository.VegetableRepository;
import com.shoppingcart.app.response.BaseCartResponseDto;
import com.shoppingcart.app.response.CartResponseDto;
import com.shoppingcart.app.response.VegetableResponseDto;
import com.shoppingcart.app.service.CartService;
import com.shoppingcart.app.util.ApplicationUtil;

@Service
public class CartServiceImpl implements CartService{

	
	@Autowired
	CartRepository cartRepo;
	

	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	VegetableRepository vegRepo;
	
	@Autowired
	CustomerRepository custRepo;
	
	
	@Override
	public CartResponseDto updateQuantity(Integer customerId, Integer cartId, Integer vegId, Integer quantity, CalcTypeEnum type) {
		
		getCustomer(customerId);
		
		Optional<Cart> cartOption=cartRepo.findById(cartId);
		if(cartOption.isEmpty()) {
			throw new ApplicationException("Cart is unavailable, Recreate a Cart");
		}else
		{
			Cart cart=new Cart(); 
			Optional<Vegetable> vegetable=vegRepo.findById(vegId);
			//sum of total price;
			BigDecimal totalPrice=null;
			
			if(type.toString().equals(CalcTypeEnum.ADD_QUANTITY)) {
				
			}else if(type.toString().equals(CalcTypeEnum.DELETE_QUANTITY)) {
				
			}
			
			//change status to open from new then add items
			//cart.setCustomerId(cartId);
			cart.setStatus(StatusEnum.OPEN.toString());
			cart.setTotalPrice(totalPrice);
			//cart.setVegetables(vegetables);
			
			cart=cartRepo.save(cart);
			return convertToDto(cart);
		}
	}

	@Override
	public CartResponseDto removeFromCart(Integer customerId, Integer cartId, List<Integer> vegIds) {
		// TODO Auto-generated method stub
		
		getCustomer(customerId);
		return null;
	}


	@Override
	public CartResponseDto addToCart(Integer customerId, Integer cartId, List<Integer> vegIds) {
		getCustomer(customerId);
		
		//if cart is empty or in status new,
		Optional<Cart> cartOption=cartRepo.findById(cartId);
		if(cartOption.isEmpty()) {
			throw new ApplicationException("Cart is unavailable, Recreate a Cart");
		}else
		{
			Cart cart=new Cart(); 
			Set<Vegetable> vegetables=vegRepo.findByvegIdIn(vegIds);
			//sum of total price;
			BigDecimal totalPrice=null;
			for(Vegetable veg:vegetables) {
				totalPrice=totalPrice.add(veg.getPrice());
			}
			
			//change status to open from new then add items
			//cart.setCustomerId(cartId);
			cart.setStatus(StatusEnum.OPEN.toString());
			cart.setTotalPrice(totalPrice);
			cart.setVegetables(vegetables);
			
			cart=cartRepo.save(cart);
			return convertToDto(cart);
		}
		
	}
	
	////remove items from cart
	//if last item to be removed rom cart then mark it back to NEW status and remove every value

	@Override
	public BaseCartResponseDto createCart(Integer customerId) {
		
		//getCustomer
		Customer customer=getCustomer(customerId);

		// check if any open cart is avaialable for customer
		// for a customerID and open new status shoudl have only one entry of cart.
		Optional<Cart> cartOption = cartRepo.getOpenCart(ApplicationUtil.getOPENStatuses(), customer.getCustomerId());
		if (cartOption.isEmpty()) {
			// create new cart.
			Cart cart = new Cart();
			cart.setStatus(StatusEnum.NEW.toString());
			cart.setCustomer(customer);
			//cart.setCustomerId(hardcodeCustomer);
			cart = cartRepo.save(cart);
			return convertToDto(cart);
		}
		// else
		// map and send back
		return convertToDto(cartOption.get());

	}
	
	private Customer getCustomer(Integer customerId) {
		
		Optional<Customer> customerOpt=custRepo.findById(customerId);
		if(customerOpt.isEmpty()) {
			throw new ApplicationException("Improper CustomerID/ Invalid Customer");
		}
		return customerOpt.get();
		
	}

	

	@Override
	public CartResponseDto getItemsInCart(Integer customerId, Integer cartId) {
		getCustomer(customerId);
		// TODO Auto-generated method stub
		CartResponseDto cartReponse=new CartResponseDto();
		Set<VegetableResponseDto> vegset=new HashSet<VegetableResponseDto>();
		Optional<Cart> cart=cartRepo.findById(cartId);
		cart.get().getVegetables().forEach(a-> vegset.add(convertToVEgDto(a)));
		cartReponse.setVegetables(vegset);
		cartReponse=convertToDto(cart.get());
		return cartReponse;
	}


	private CartResponseDto convertToDto(Cart post) {
		CartResponseDto postDto = modelMapper.map(post, CartResponseDto.class);
	    return postDto;
	}
	
	private VegetableResponseDto convertToVEgDto(Vegetable post) {
		VegetableResponseDto postDto = modelMapper.map(post, VegetableResponseDto.class);
	    return postDto;
	}
}
