package com.azad.practice.school.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.azad.practice.school.exception.StudentServiceException;
import com.azad.practice.school.io.entity.StudentEntity;
import com.azad.practice.school.io.repository.StudentRepository;
import com.azad.practice.school.service.PassportService;
import com.azad.practice.school.service.StudentService;
import com.azad.practice.school.shared.dto.PassportDto;
import com.azad.practice.school.shared.dto.StudentDto;
import com.azad.practice.school.shared.utils.StudentUtils;
import com.azad.practice.school.ui.model.response.ErrorMessages;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	PassportService passportService;
	
	@Autowired
	StudentUtils studentUtils;

	@Override
	public StudentDto createStudent(StudentDto studentDto) {
		
		ModelMapper modelMapper = new ModelMapper();
		StudentEntity studentEntity = modelMapper.map(studentDto, StudentEntity.class);
		
		studentEntity.setStudentId(studentUtils.generateStudentId(10));
		
		passportService.createPassport(new PassportDto(studentDto.getPassportNumber()));
//		PassportEntity savedPassportEntity = modelMapper.map(savedPassportDto, PassportEntity.class);
		
		studentEntity.setPassportEntity(passportService.getPassportByPassportNumber(studentDto.getPassportNumber()));
//		studentEntity.setPassportEntity(savedPassportEntity);
		
//		studentEntity.setPassportEntity(studentDto.getPassportEntity());
		
//		PassportEntity passportEntity = passportService.getPassportByPassportNumber(studentDto.getPassportNumber());
//
//		if (passportEntity != null) {
//			studentEntity.setPassportEntity(passportEntity);
//		} else {
//			throw new RuntimeException("PassportEntity not found");
//		}
		
		/*
		 * use passport service
		 * and change name to passportNumber
		 * */
		
		StudentEntity createdStudent = studentRepository.save(studentEntity);
		
		StudentDto returnValue = modelMapper.map(createdStudent, StudentDto.class);
		
		return returnValue;
	}

	@Override
	public StudentDto getStudentByStudentId(String studentId) {
		
		StudentEntity studentEntity = studentRepository.findByStudentId(studentId);
		
		ModelMapper modelMapper = new ModelMapper();
		StudentDto returnValue = modelMapper.map(studentEntity, StudentDto.class);
		
		return returnValue;
	}

	@Override
	public List<StudentDto> getAll(int page, int limit) {
		
		if (page > 0) {
			page--;
		}
		
		Pageable pageableRequest = PageRequest.of(page, limit);
		
		Page<StudentEntity> studentPage = studentRepository.findAll(pageableRequest);
		List<StudentEntity> studentEntityList = studentPage.getContent();
		
		List<StudentDto> returnValueList = new ArrayList<StudentDto>();
		
		ModelMapper modelMapper = new ModelMapper();
		for (StudentEntity studentEntity : studentEntityList) {
			StudentDto studentDto = modelMapper.map(studentEntity, StudentDto.class);
			returnValueList.add(studentDto);
		}
		
		return returnValueList;
	}

	@Override
	public void deleteStudent(String studentId) {
		
		StudentEntity studentEntity = studentRepository.findByStudentId(studentId);

		if (studentEntity == null) {
			throw new StudentServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		}
		
		studentRepository.delete(studentEntity);
	}

	@Override
	public StudentDto updateStudent(String studentId, StudentDto updatedStudentDto) {
		
		ModelMapper modelMapper = new ModelMapper();
		
		StudentEntity studentEntity = studentRepository.findByStudentId(studentId);
		
		studentEntity.setName(updatedStudentDto.getName());
		studentEntity.setEmail(updatedStudentDto.getEmail());
		studentEntity.setBirthDate(updatedStudentDto.getBirthDate());
		
		passportService.createPassport(new PassportDto(updatedStudentDto.getPassportNumber()));
		studentEntity.setPassportEntity(passportService.getPassportByPassportNumber(updatedStudentDto.getPassportNumber()));
		
		StudentEntity updatedStudent = studentRepository.save(studentEntity);
		
		StudentDto returnValue = modelMapper.map(updatedStudent, StudentDto.class);
		
		return returnValue;
	}

	@Override
	public StudentEntity getStudentByEmail(String studentEmail) {
		
		return studentRepository.findByEmail(studentEmail);
	}

	@Override
	public String getStudentIdByPassportId(Long id) {
		
		StudentEntity studentEntity = studentRepository.findByPassportEntityId(id);
		
		return studentEntity.getStudentId();
	}
	
	
}
