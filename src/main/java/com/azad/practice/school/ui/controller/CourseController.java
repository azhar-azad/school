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

import com.azad.practice.school.service.CourseService;
import com.azad.practice.school.shared.dto.CourseDto;
import com.azad.practice.school.shared.dto.StudentDto;
import com.azad.practice.school.ui.model.request.CourseDetailsRequestModel;
import com.azad.practice.school.ui.model.request.StudentDetailsRequestModel;
import com.azad.practice.school.ui.model.response.CourseRest;
import com.azad.practice.school.ui.model.response.OperationStatusModel;
import com.azad.practice.school.ui.model.response.RequestOperationName;
import com.azad.practice.school.ui.model.response.RequestOperationStatus;
import com.azad.practice.school.ui.model.response.StudentRest;

@RestController
@RequestMapping("courses")
public class CourseController {
	
	@Autowired
	CourseService courseService;

	@PostMapping
	public CourseRest createCourse(@RequestBody CourseDetailsRequestModel courseDetails) {
		
		ModelMapper modelMapper = new ModelMapper();
		CourseDto courseDto = modelMapper.map(courseDetails, CourseDto.class);
		
		CourseDto createdCourse = courseService.createCourse(courseDto);
		
		CourseRest returnValue = modelMapper.map(createdCourse, CourseRest.class);
		return returnValue;
	}
	
	@GetMapping(path = "/{courseId}")
	public CourseRest getCourse(@PathVariable String courseId) {
		
		CourseDto courseDto = courseService.getCourseByCourseId(courseId);
		
		ModelMapper modelMapper = new ModelMapper();
		CourseRest returnValue = modelMapper.map(courseDto, CourseRest.class);
		
		return returnValue;
	}
	
	@GetMapping
	public List<CourseRest> getAllCourse(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "25") int limit) {
		
		List<CourseDto> courseDtoList = courseService.getAll(page, limit);
		
		List<CourseRest> returnValueList = new ArrayList<CourseRest>();
		
		ModelMapper modelMapper = new ModelMapper();
		for (CourseDto courseDto : courseDtoList) {
			CourseRest courseRest = modelMapper.map(courseDto, CourseRest.class);
			returnValueList.add(courseRest);
		}
		
		return returnValueList;
	}
	
	@DeleteMapping(path = "/{courseId}")
    public OperationStatusModel deleteCourse(@PathVariable String courseId) {
    	
    	OperationStatusModel returnValue = new OperationStatusModel();
    	
    	returnValue.setOperationName(RequestOperationName.DELETE.name());
    	courseService.deleteCourse(courseId);
    	returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());
    	
        return returnValue;
    }
	
	@PutMapping(path = "/{courseId}")
	public CourseRest updateCourse(@PathVariable String courseId, @RequestBody CourseDetailsRequestModel updatedCourseDetails) {
		
		ModelMapper modelMapper = new ModelMapper();
		CourseDto updatedCourseDto = modelMapper.map(updatedCourseDetails, CourseDto.class);
		
		CourseDto updatedCourse = courseService.updateCourse(courseId, updatedCourseDto);
		
		CourseRest returnValue = modelMapper.map(updatedCourse, CourseRest.class);
		return returnValue;
	}
}
