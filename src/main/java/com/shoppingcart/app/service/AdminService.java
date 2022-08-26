package com.shoppingcart.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.shoppingcart.app.dto.AdminDto;

@Service
public interface AdminService {

	AdminDto addAdmin(AdminDto admin);
	AdminDto updateAdmin(AdminDto admin);
	void removeAdmin(Integer adminId);
	AdminDto viewAdmin(Integer adminId);
	List<AdminDto> listAdmins();
	Page<AdminDto> listAdmins(Pageable page);
	void removeAllAdmins();
}
