package com.shoppingcart.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.app.dto.request.CustomerRequestDto;
import com.shoppingcart.app.response.CustomerResponseDto;
import com.shoppingcart.app.service.CustomerService;

@RestController("customerController")
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@PostMapping("/addCustomer")
	public CustomerResponseDto addCustomer(@RequestBody CustomerRequestDto customerReq){
		return customerService.addCustomer(customerReq);
	}
	
	@DeleteMapping("/deleteCustomer")
	public CustomerResponseDto deleteCustomer(@RequestParam(name = "customerId") Integer id){
		customerService.removeCustomer(id);
		return null;
	}
	
	@PatchMapping("/{id}/updateCustomer")
	public CustomerResponseDto updateCustomer(@PathVariable(name = "id") Integer id,@RequestBody CustomerRequestDto customerReq){
		customerService.updateCustomer(id,customerReq);
		return null;
	}
	
	@GetMapping("/getCustomers")
	public List<CustomerResponseDto> getCustomers(){
		customerService.getCustomers();
		return null;
	}
	
	
}
