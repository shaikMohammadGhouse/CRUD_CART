package com.shoppingcart.app.service.impl;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.shoppingcart.app.dao.Admin;
import com.shoppingcart.app.dto.AdminDto;
import com.shoppingcart.app.repository.AdminRepository;
import com.shoppingcart.app.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	
	@Autowired
	AdminRepository adminRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	
	@Override
	public AdminDto addAdmin(AdminDto adminDto) {
		Admin admin=new Admin();
		try {
			admin=convertToEntity(adminDto);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return convertToDto(adminRepo.save(admin));
	}

	@Override
	public AdminDto updateAdmin(AdminDto adminDto) {
		//upsert
		Optional<Admin> admin=adminRepo.findById(adminDto.getAdminId());
		Admin adminImp=null;
		if(admin.isPresent()) {
			adminImp=admin.get();
			admin.get().setContactNumber(adminDto.getContactNumber());
			admin.get().setEmailId(adminDto.getEmailId());
			admin.get().setName(adminDto.getName());
			
			adminRepo.save(admin.get());
		}
		return convertToDto(adminImp);
	}

	@Override
	public void removeAdmin(Integer adminId) {
		adminRepo.deleteById(adminId);
	}

	@Override
	public AdminDto viewAdmin(Integer adminId) {
		Optional<Admin> admin=adminRepo.findById(adminId);
		if(admin.isEmpty()) {
			//exceptonal handling for service level 
			//throw new 
		}else {
			return convertToDto(admin.get());
			
		}
		return null;
	}

	@Override
	public List<AdminDto> listAdmins() {
		 List<Admin> posts = adminRepo.findAll();
	        return posts.stream()
	          .map(this::convertToDto)
	          .collect(Collectors.toList());
	}
	
	@Override
	public void removeAllAdmins() {
		adminRepo.deleteAll();
	}
	private AdminDto convertToDto(Admin post) {
		AdminDto postDto = modelMapper.map(post, AdminDto.class);
	    return postDto;
	}
	
	private Admin convertToEntity(AdminDto postDto) throws ParseException {
		Admin post = modelMapper.map(postDto, Admin.class);
	    return post;
	}

	@Override
	public Page<AdminDto> listAdmins(Pageable page) {
		Page<Admin> adminPAges=adminRepo.findAll(page);
		
		
		adminPAges.get().map(this::convertToDto).collect(Collectors.toList());
		
		
		return null;
	}
	
	
}