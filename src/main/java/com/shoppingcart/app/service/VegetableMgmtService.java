package com.shoppingcart.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shoppingcart.app.dto.request.VegetableRequestDto;
import com.shoppingcart.app.enums.UnitEnum;
import com.shoppingcart.app.enums.VegeEnum;
import com.shoppingcart.app.response.VegetableResponseDto;

@Service
public interface VegetableMgmtService {

	VegetableResponseDto addVegetable(VegetableRequestDto vegetable,VegeEnum type,UnitEnum unit,Integer adminId);
	VegetableResponseDto updateVegetable(Integer vegetableId,VegetableRequestDto vegetable,Integer adminId);
	void removeVegetable(Integer vegetableId,Integer adminId);
	VegetableResponseDto viewVegetable(Integer id,Integer adminId);
	List<VegetableResponseDto> viewAllVegetable(VegeEnum type,UnitEnum unit,Integer adminId);
	void removeAllVegetable(Integer adminId);
	
}
