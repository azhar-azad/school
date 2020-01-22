package com.azad.practice.school.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.azad.practice.school.exception.CourseServiceException;
import com.azad.practice.school.exception.StudentServiceException;
import com.azad.practice.school.io.entity.CourseEntity;
import com.azad.practice.school.io.entity.StudentEntity;
import com.azad.practice.school.io.repository.CourseRepository;
import com.azad.practice.school.service.CourseService;
import com.azad.practice.school.shared.dto.CourseDto;
import com.azad.practice.school.shared.dto.PassportDto;
import com.azad.practice.school.shared.dto.StudentDto;
import com.azad.practice.school.shared.utils.CourseUtils;
import com.azad.practice.school.ui.model.response.ErrorMessages;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	CourseUtils courseUtils;
	
	// this method will only be called by ReviewService
	public CourseDto saveCourse(CourseDto courseDto) {
		
		ModelMapper modelMapper = new ModelMapper();
		
		CourseEntity courseEntity = courseRepository.findByCode(courseDto.getCode());
		
		if (courseEntity == null) {
			throw new CourseServiceException("No such course existed");	
		} 
		
		CourseDto returnValue = modelMapper.map(courseEntity, CourseDto.class);
		return returnValue;
	}

	@Override
	public CourseDto createCourse(CourseDto courseDto) {
		
		ModelMapper modelMapper = new ModelMapper();
		CourseEntity courseEntity = modelMapper.map(courseDto, CourseEntity.class);
		
		courseEntity.setCourseId(courseUtils.generateCourseId(10));
		
		CourseEntity createdCourse = courseRepository.save(courseEntity);
		
		CourseDto returnValue = modelMapper.map(createdCourse, CourseDto.class);
		
		return returnValue;
	}

	@Override
	public CourseDto getCourseByCourseId(String courseId) {

		CourseEntity courseEntity = courseRepository.findByCourseId(courseId);
		
		ModelMapper modelMapper = new ModelMapper();
		CourseDto returnValue = modelMapper.map(courseEntity, CourseDto.class);
		
		return returnValue;
	}

	@Override
	public List<CourseDto> getAll(int page, int limit) {

		if (page > 0) {
			page--;
		}
		
		Pageable pageableRequest = PageRequest.of(page, limit);
		
		Page<CourseEntity> coursePage = courseRepository.findAll(pageableRequest);
		List<CourseEntity> courseEntityList = coursePage.getContent();
		
		List<CourseDto> returnValueList = new ArrayList<CourseDto>();
		
		ModelMapper modelMapper = new ModelMapper();
		for (CourseEntity courseEntity : courseEntityList) {
			CourseDto courseDto = modelMapper.map(courseEntity, CourseDto.class);
			returnValueList.add(courseDto);
		}
		
		return returnValueList;
	}

	@Override
	public void deleteCourse(String courseId) {

		CourseEntity courseEntity = courseRepository.findByCourseId(courseId);

		if (courseEntity == null) {
			throw new CourseServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		}
		
		courseRepository.delete(courseEntity);
	}

	@Override
	public CourseDto updateCourse(String courseId, CourseDto updatedCourseDto) {
		
		ModelMapper modelMapper = new ModelMapper();
		
		CourseEntity courseEntity = courseRepository.findByCourseId(courseId);
		
		courseEntity.setCode(updatedCourseDto.getCode());
		courseEntity.setName(updatedCourseDto.getName());
		courseEntity.setFullName(updatedCourseDto.getFullName());
		courseEntity.setCredit(updatedCourseDto.getCredit());
		courseEntity.setCreditHour(updatedCourseDto.getCreditHour());
		
//		passportService.createPassport(new PassportDto(updatedStudentDto.getPassportNumber()));
//		courseEntity.setPassportEntity(passportService.getPassportByPassportNumber(updatedStudentDto.getPassportNumber()));
		
		CourseEntity updatedCourse = courseRepository.save(courseEntity);
		
		CourseDto returnValue = modelMapper.map(updatedCourse, CourseDto.class);
		
		return returnValue;
	}

	@Override
	public CourseEntity getCourseByCourseCode(String courseCode) {
		
		return courseRepository.findByCode(courseCode);
	}

}
