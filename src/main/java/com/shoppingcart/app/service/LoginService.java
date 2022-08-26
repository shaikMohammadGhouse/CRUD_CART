package com.shoppingcart.app.service;

import org.springframework.stereotype.Service;

import com.shoppingcart.app.dto.UserDto;

@Service
public interface LoginService {

	UserDto validateLogin(UserDto user);
	UserDto logOut(UserDto user);
}
