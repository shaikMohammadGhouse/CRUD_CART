package com.shoppingcart.app.controller;

import java.util.List;

import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.app.dto.AdminDto;
import com.shoppingcart.app.service.AdminService;

@RestController("adminController")
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@PostMapping("/addAdmin")
	public AdminDto addtoCart(@RequestBody AdminDto adminReq){
		
		return adminService.addAdmin(adminReq);
		
	}
	
	@GetMapping("/{id}/getAdmin")
	public AdminDto getAdmin(@PathVariable("id") Integer adminId ){
		
		return adminService.viewAdmin(adminId);
		
	}
	
	@GetMapping("/listAdmins")
	public List<AdminDto> listAdmins(){
		return adminService.listAdmins();
	}
	
	@GetMapping("/listAdminPage")
	public Page<AdminDto> pageAdmins(@ParameterObject Pageable pageable){
		return adminService.listAdmins(pageable);
	}
	@PutMapping("/upsertAdmin")
	public AdminDto upsertAdmin(AdminDto admin) {
		//delete existing record and add  new okne
		return adminService.updateAdmin(admin);
	}
	
	
	@PatchMapping("/updateAdmin")
	public AdminDto updateAdmin(AdminDto admin) {
		return adminService.updateAdmin(admin);
	}
	
	//updating a single column in a row of patch
	
	
	@DeleteMapping("/{id}/deleteAdmin")
	public void deleteAdmin(@PathVariable("id") Integer adminId ) {
		adminService.removeAdmin(adminId);
	}
	
	@DeleteMapping("/deleteAdmins")
	public void deleteAllAdmin() {
		adminService.removeAllAdmins();
	}
}
