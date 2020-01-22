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

import com.azad.practice.school.service.StudentService;
import com.azad.practice.school.shared.dto.StudentDto;
import com.azad.practice.school.ui.model.request.StudentDetailsRequestModel;
import com.azad.practice.school.ui.model.response.OperationStatusModel;
import com.azad.practice.school.ui.model.response.RequestOperationName;
import com.azad.practice.school.ui.model.response.RequestOperationStatus;
import com.azad.practice.school.ui.model.response.StudentRest;

@RestController
@RequestMapping("students")
public class StudentController {
	
	@Autowired
	StudentService studentService;

	@PostMapping
	public StudentRest createStudent(@RequestBody StudentDetailsRequestModel studentDetails) {
		
		ModelMapper modelMapper = new ModelMapper();
		StudentDto studentDto = modelMapper.map(studentDetails, StudentDto.class);
		
		StudentDto createdStudent = studentService.createStudent(studentDto);
		
		StudentRest returnValue = modelMapper.map(createdStudent, StudentRest.class);
		return returnValue;
	}
	
	@GetMapping(path = "/{studentId}")
	public StudentRest getStudent(@PathVariable String studentId) {
		
		StudentDto studentDto = studentService.getStudentByStudentId(studentId);
		
		ModelMapper modelMapper = new ModelMapper();
		StudentRest returnValue = modelMapper.map(studentDto, StudentRest.class);
		
		return returnValue;
	}
	
	@GetMapping
	public List<StudentRest> getAllStudent(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "25") int limit) {
		
		List<StudentDto> studentDtoList = studentService.getAll(page, limit);
		
		List<StudentRest> returnValueList = new ArrayList<StudentRest>();
		
		ModelMapper modelMapper = new ModelMapper();
		for (StudentDto studentDto : studentDtoList) {
			StudentRest studentRest = modelMapper.map(studentDto, StudentRest.class);
			returnValueList.add(studentRest);
		}
		
		return returnValueList;
	}
	
	@DeleteMapping(path = "/{studentId}")
    public OperationStatusModel deleteUser(@PathVariable String studentId) {
    	
    	OperationStatusModel returnValue = new OperationStatusModel();
    	
    	returnValue.setOperationName(RequestOperationName.DELETE.name());
    	studentService.deleteStudent(studentId);
    	returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());
    	
        return returnValue;
    }
	
	@PutMapping(path = "/{studentId}")
	public StudentRest updateStudent(@PathVariable String studentId, @RequestBody StudentDetailsRequestModel updatedStudentDetails) {
		
		ModelMapper modelMapper = new ModelMapper();
		StudentDto updatedStudentDto = modelMapper.map(updatedStudentDetails, StudentDto.class);
		
		StudentDto updatedStudent = studentService.updateStudent(studentId, updatedStudentDto);
		
		StudentRest returnValue = modelMapper.map(updatedStudent, StudentRest.class);
		return returnValue;
	}
}
