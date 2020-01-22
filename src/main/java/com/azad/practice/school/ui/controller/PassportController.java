package com.azad.practice.school.ui.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.azad.practice.school.service.PassportService;
import com.azad.practice.school.shared.dto.PassportDto;
import com.azad.practice.school.shared.dto.StudentDto;
import com.azad.practice.school.ui.model.request.PassportDetailsRequestModel;
import com.azad.practice.school.ui.model.request.StudentDetailsRequestModel;
import com.azad.practice.school.ui.model.response.OperationStatusModel;
import com.azad.practice.school.ui.model.response.PassportRest;
import com.azad.practice.school.ui.model.response.RequestOperationName;
import com.azad.practice.school.ui.model.response.RequestOperationStatus;
import com.azad.practice.school.ui.model.response.StudentRest;

@RestController
@RequestMapping("passports")
public class PassportController {
	
	@Autowired
	PassportService passportService;

	@PostMapping
	public PassportRest createPassport(@RequestBody PassportDetailsRequestModel passportDetails) {
		
		ModelMapper modelMapper = new ModelMapper();
		PassportDto passportDto = modelMapper.map(passportDetails, PassportDto.class);
		
		PassportDto createdPassport = passportService.createPassport(passportDto);
		
		PassportRest returnValue = modelMapper.map(createdPassport, PassportRest.class);
		
		return returnValue;
	}
	
	@GetMapping(path = "/{passportId}")
	public PassportRest getPassport(@PathVariable String passportId) {
		
		PassportDto passportDto = passportService.getPassportByPassportId(passportId);
		
		ModelMapper modelMapper = new ModelMapper();
		PassportRest returnValue = modelMapper.map(passportDto, PassportRest.class);
		
		return returnValue;
	}
	
	@GetMapping
	public List<PassportRest> getAllPassport(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "25") int limit) {
		
		List<PassportDto> passportDtoList = passportService.getAll(page, limit);
		
		List<PassportRest> returnValueList = new ArrayList<PassportRest>();
		
		ModelMapper modelMapper = new ModelMapper();
		for (PassportDto passportDto : passportDtoList) {
			PassportRest passportRest = modelMapper.map(passportDto, PassportRest.class);
			returnValueList.add(passportRest);
		}
		
		return returnValueList;
	}
	
	@DeleteMapping(path = "/{passportId}")
    public OperationStatusModel deletePassport(@PathVariable String passportId) {
    	
    	OperationStatusModel returnValue = new OperationStatusModel();
    	
    	returnValue.setOperationName(RequestOperationName.DELETE.name());
    	passportService.deletePassport(passportId);
    	returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());
    	
        return returnValue;
    }
	
	@PutMapping(path = "/{passportId}")
	public PassportRest updatePassport(@PathVariable String passportId, @RequestBody PassportDetailsRequestModel updatedPassportDetails) {
		
		ModelMapper modelMapper = new ModelMapper();
		PassportDto updatedPassportDto = modelMapper.map(updatedPassportDetails, PassportDto.class);
		
		PassportDto updatedPassport = passportService.updatePassport(passportId, updatedPassportDto);
		
		PassportRest returnValue = modelMapper.map(updatedPassport, PassportRest.class);
		return returnValue;
	}
}
