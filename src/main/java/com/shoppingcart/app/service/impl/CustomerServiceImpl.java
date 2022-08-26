package com.shoppingcart.app.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.app.dao.Address;
import com.shoppingcart.app.dao.Customer;
import com.shoppingcart.app.dto.AddressDto;
import com.shoppingcart.app.dto.request.CustomerRequestDto;
import com.shoppingcart.app.exception.ApplicationException;
import com.shoppingcart.app.repository.AddressRepository;
import com.shoppingcart.app.repository.CustomerRepository;
import com.shoppingcart.app.response.CustomerResponseDto;
import com.shoppingcart.app.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	

	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	CustomerRepository customerRepo;
	
	@Autowired
	AddressRepository addressRepo;

	@Override
	@Transactional
	public CustomerResponseDto addCustomer(CustomerRequestDto customer) {

		CustomerResponseDto customerResponse;
		Customer customerdao=convertToEntity(customer);
		//push address to address table first
		Address address=addressRepo.save(convertToAddressEntity(customer.getAddress()));
		customerdao.setAddress(address);
		
		customerdao=customerRepo.save(customerdao);
		
		customerResponse=convertToDto(customerdao);
		customerResponse.setAddress(convertToAddressDto(customerdao.getAddress()));
		
		return customerResponse;
	}
   
	@Override
	public CustomerResponseDto updateCustomer(Integer id,CustomerRequestDto customer) {
		Optional<Customer> customeropt;
		
		customeropt=customerRepo.findById(id);
		if(customeropt.isEmpty()) {
			throw new ApplicationException("no customer found");
		}else {
			Customer customerdao=customeropt.get();
			CustomerResponseDto customerResponse;
			//updating all input values
			if(customer.getConfirmPassword()!=null) {
				customerdao.setConfirmPassword(customer.getConfirmPassword());
			}
			if(customer.getEmailId()!=null) {
				customerdao.setEmailId(customer.getEmailId());
			}
			if(customer.getMobileNumber()!=null) {
				customerdao.setMobileNumber(customer.getMobileNumber());
			}
			if(customer.getName()!=null) {
				customerdao.setName(customer.getName());
			}
			if(customer.getPassword()!=null) {
				customerdao.setPassword(customer.getPassword());
			}
			
			customerdao.setAddress(convertToAddressEntity(customer.getAddress()));
			customerdao=customerRepo.save(customerdao);
			customerResponse=convertToDto(customerdao);
			customerResponse.setAddress(convertToAddressDto(customerdao.getAddress()));
			return customerResponse;
		}
		
	}

	@Override
	public void removeCustomer(Integer id) {
		customerRepo.deleteById(id);
	}

	@Override
	public CustomerResponseDto viewCustomer(CustomerRequestDto customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerResponseDto> getCustomers() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private CustomerResponseDto convertToDto(Customer post) {
		CustomerResponseDto postDto = modelMapper.map(post, CustomerResponseDto.class);
		postDto.setAddress(convertToAddressDto(post.getAddress()));
	    return postDto;
	}
	
	private Customer convertToEntity(CustomerRequestDto postDto) {
		Customer post = modelMapper.map(postDto, Customer.class);
	    return post;
	}
	
	private AddressDto convertToAddressDto(Address post) {
		AddressDto postDto = modelMapper.map(post, AddressDto.class);
	    return postDto;
	}
	
	private Address convertToAddressEntity(AddressDto postDto) {
		Address post = modelMapper.map(postDto, Address.class);
	    return post;
	}
}


