package com.shoppingcart.app.controller;

import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.app.dto.request.VegetableRequestDto;
import com.shoppingcart.app.enums.UnitEnum;
import com.shoppingcart.app.enums.VegeEnum;
import com.shoppingcart.app.response.VegetableResponseDto;
import com.shoppingcart.app.service.VegetableMgmtService;
import com.shoppingcart.app.validator.ValuesAllowedValidator;

@RestController("vegetableController")
@RequestMapping("/vegetables")
@Validated
public class VegetableController {

	@Autowired
	VegetableMgmtService vegService;

	// admin id is important to this inventory/.
	@PostMapping("/addVegetable")
	public VegetableResponseDto addVegetable(@RequestBody @Valid VegetableRequestDto adminReq,
			@RequestParam(name = "type", required = true) VegeEnum type,
			@RequestParam(name = "unit", required = true) UnitEnum unit,
			@ValuesAllowedValidator(propName = "currency", values = {
					"Rupees" }) @RequestParam(required = false) String currency,
			@RequestParam(name = "adminId", required = true) Integer adminId) {

		return vegService.addVegetable(adminReq, type, unit,adminId);

	}

	@GetMapping("/{id}/getVegetable")
	public VegetableResponseDto getAdmin(@PathVariable("id") Integer vegetableId,
			@RequestParam(name = "adminId", required = true) Integer adminId) {

		return vegService.viewVegetable(vegetableId,adminId);

	}

	@GetMapping("/listVegetables")
	public List<VegetableResponseDto> listVegetables(@RequestParam(name = "type", required = false) VegeEnum type,
			@RequestParam(name = "unit", required = false) UnitEnum unit,
			@RequestParam(name = "adminId", required = true) Integer adminId) {
		return vegService.viewAllVegetable(type, unit,adminId);
	}

	@PutMapping("/{id}/updateVegetable")
	public VegetableResponseDto updateVegetable(@PathVariable("id") Integer vegetableId,
			@RequestBody VegetableRequestDto vegReq, @RequestParam(name = "adminId", required = true) Integer adminId) {
		// delete existing record and add new okne

		return vegService.updateVegetable(vegetableId, vegReq,adminId);
	}

	@DeleteMapping("/{id}/deleteVegetable")
	public void deleteAdmin(@PathVariable("id") Integer vegID,
			@RequestParam(name = "adminId", required = true) Integer adminId) {
		vegService.removeVegetable(vegID,adminId);
	}

	@DeleteMapping("/deleteVegetable")
	public void deleteAllVegetables(@RequestParam(name = "adminId", required = true) Integer adminId) {
		vegService.removeAllVegetable(adminId);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	String handleConstraintViolationException(ConstraintViolationException e) {
		return "Validation error: " + e.getMessage();
	}
}
