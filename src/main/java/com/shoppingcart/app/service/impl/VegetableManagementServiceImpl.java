package com.shoppingcart.app.service.impl;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.app.dao.Admin;
import com.shoppingcart.app.dao.Vegetable;
import com.shoppingcart.app.dto.request.VegetableRequestDto;
import com.shoppingcart.app.enums.UnitEnum;
import com.shoppingcart.app.enums.VegeEnum;
import com.shoppingcart.app.exception.ApplicationException;
import com.shoppingcart.app.repository.AdminRepository;
import com.shoppingcart.app.repository.VegetableRepository;
import com.shoppingcart.app.response.VegetableResponseDto;
import com.shoppingcart.app.service.VegetableMgmtService;

@Service
public class VegetableManagementServiceImpl implements VegetableMgmtService{

	@Autowired
	VegetableRepository vegRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	AdminRepository adminRepo;
	
	@Override
	public VegetableResponseDto addVegetable(VegetableRequestDto vegetable, VegeEnum type, UnitEnum unit,Integer adminId) {
		
		validateAdmin(adminId);
		//pre check to avoid duplicates.
		Vegetable veg=new Vegetable();
		try {
			veg=convertToEntity(vegetable);
			veg.setType(type.toString());
			veg.setUnit(unit.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return convertToDto(vegRepo.save(veg));
	
	}

	@Override
	public VegetableResponseDto updateVegetable(Integer vegetableId, VegetableRequestDto vegetable,Integer adminId) {
		validateAdmin(adminId);
		
		if(vegetable!=null) {
			Optional<Vegetable> vegOpt= vegRepo.findById(vegetableId);
			Vegetable veg=new Vegetable();
			if(vegOpt.isPresent())
			{
				
				veg=vegOpt.get();
				
				veg.setName(vegetable.getName());
				veg.setPrice(vegetable.getPrice());
				veg.setQuantity(vegetable.getQuantity());
				veg=vegRepo.save(veg);
				
			}else {
				throw new ApplicationException("Vegetable ID not found");
			}
			return convertToDto(veg);
		}else
		{
			throw new ApplicationException("Vegetable Request is null");
		}
		
	}

	@Override
	public void removeVegetable(Integer vegetableId,Integer adminId) {
		validateAdmin(adminId);
		vegRepo.deleteById(vegetableId);
	}

	@Override
	public VegetableResponseDto viewVegetable(Integer id,Integer adminId) {
		validateAdmin(adminId);
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VegetableResponseDto> viewAllVegetable(VegeEnum type,UnitEnum unit,Integer adminId) {
		validateAdmin(adminId);
		List<Vegetable> vegList=vegRepo.findAllByCombination((type==null)?null:type.toString(),(unit==null)?null:unit.toString());
		
		return vegList.stream().map(a->convertToDto(a)).collect(Collectors.toList());
	}

	@Override
	public void removeAllVegetable(Integer adminId) {
		validateAdmin(adminId);
		vegRepo.deleteAll();
	}

	private boolean validateAdmin(Integer adminId) {
		
		Optional<Admin> adminOpt=adminRepo.findById(adminId);
		
		if(adminOpt.isPresent()) {
			return true;
		}else {
			throw new ApplicationException("No Admin Found, can't ingest Vegetables");
		}
		
	}
	private VegetableResponseDto convertToDto(Vegetable post) {
		VegetableResponseDto postDto = modelMapper.map(post, VegetableResponseDto.class);
	    return postDto;
	}
	
	private Vegetable convertToEntity(VegetableRequestDto postDto) throws ParseException {
		Vegetable post = modelMapper.map(postDto, Vegetable.class);
	    return post;
	}
}
