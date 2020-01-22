package com.azad.practice.school.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.azad.practice.school.exception.PassportServiceException;
import com.azad.practice.school.exception.StudentServiceException;
import com.azad.practice.school.io.entity.PassportEntity;
import com.azad.practice.school.io.entity.StudentEntity;
import com.azad.practice.school.io.repository.PassportRepository;
import com.azad.practice.school.service.PassportService;
import com.azad.practice.school.service.StudentService;
import com.azad.practice.school.shared.dto.PassportDto;
import com.azad.practice.school.shared.dto.StudentDto;
import com.azad.practice.school.shared.utils.PassportUtils;
import com.azad.practice.school.ui.model.response.ErrorMessages;

@Service
public class PassportServiceImpl implements PassportService {
	
	@Autowired
	PassportRepository passportRepository;
	
	@Autowired
	PassportUtils passportUtils;
	
	@Autowired
	StudentService studentService; 

	@Override
	public PassportDto createPassport(PassportDto passportDto) {
		
		ModelMapper modelMapper = new ModelMapper();
		PassportEntity passportEntity = getPassportByPassportNumber(passportDto.getNumber());
		
		if (passportEntity != null) {
			
			PassportDto returnValue = modelMapper.map(passportEntity, PassportDto.class);
			return returnValue;
		}
		
		passportEntity = modelMapper.map(passportDto, PassportEntity.class);
		
		passportEntity.setPassportId(passportUtils.generatePassportId(10));
		passportEntity.setStudentEntity(studentService.getStudentByEmail(passportDto.getStudentEmail()));
		
		PassportEntity createdPassport = passportRepository.save(passportEntity);
		
		PassportDto returnValue = modelMapper.map(createdPassport, PassportDto.class);
		
		return returnValue;
	}

	@Override
	public PassportEntity getPassportByPassportNumber(String number) {
		
		return passportRepository.findByNumber(number);
	}

	@Override
	public PassportDto getPassportByPassportId(String passportId) {
		
		PassportEntity passportEntity = passportRepository.findByPassportId(passportId);
		
		ModelMapper modelMapper = new ModelMapper();
		PassportDto returnValue = modelMapper.map(passportEntity, PassportDto.class);
		
		return returnValue;
	}

	@Override
	public List<PassportDto> getAll(int page, int limit) {
		
		if (page > 0) {
			page--;
		}
		
		Pageable pageableRequest = PageRequest.of(page, limit);
		
		Page<PassportEntity> passportPage = passportRepository.findAll(pageableRequest);
		List<PassportEntity> passportEntityList = passportPage.getContent();
		
		List<PassportDto> returnValueList = new ArrayList<PassportDto>();
		
		ModelMapper modelMapper = new ModelMapper();
		for (PassportEntity passportEntity : passportEntityList) {
			PassportDto passportDto = modelMapper.map(passportEntity, PassportDto.class);
			returnValueList.add(passportDto);
		}
		
		return returnValueList;
	}

	@Override
	public void deletePassport(String passportId) {
		
		PassportEntity passportEntity = passportRepository.findByPassportId(passportId);

		if (passportEntity == null) {
			throw new PassportServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		}
		
		String studentId = studentService.getStudentIdByPassportId(passportEntity.getId());
		
		if (studentId == null) {
			throw new PassportServiceException(ErrorMessages.COULD_NOT_DELETE_RECORD.getErrorMessage());
		}
		
		passportRepository.delete(passportEntity);
	}

	@Override
	public PassportDto updatePassport(String passportId, PassportDto updatedPassportDto) {
		
		ModelMapper modelMapper = new ModelMapper();
		
		PassportEntity passportEntity = passportRepository.findByPassportId(passportId);
		
		passportEntity.setNumber(updatedPassportDto.getNumber());	
		
		PassportEntity updatedPassport = passportRepository.save(passportEntity);
		
		PassportDto returnValue = modelMapper.map(updatedPassport, PassportDto.class);
		
		return returnValue;
	}
}
