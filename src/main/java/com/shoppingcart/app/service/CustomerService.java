package com.shoppingcart.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shoppingcart.app.dto.request.CustomerRequestDto;
import com.shoppingcart.app.response.CustomerResponseDto;

@Service
public interface CustomerService {

	CustomerResponseDto addCustomer(CustomerRequestDto customer);
	CustomerResponseDto updateCustomer(Integer id, CustomerRequestDto customer);
	void removeCustomer(Integer id);
	CustomerResponseDto viewCustomer(CustomerRequestDto customer);
	List<CustomerResponseDto> getCustomers();
}
