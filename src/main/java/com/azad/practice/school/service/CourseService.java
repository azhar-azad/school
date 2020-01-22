package com.azad.practice.school.service;

import java.util.List;

import com.azad.practice.school.io.entity.CourseEntity;
import com.azad.practice.school.shared.dto.CourseDto;

public interface CourseService {

	CourseDto createCourse(CourseDto courseDto);

	CourseDto getCourseByCourseId(String courseId);

	List<CourseDto> getAll(int page, int limit);

	void deleteCourse(String courseId);

	CourseDto updateCourse(String courseId, CourseDto updatedCourseDto);

	CourseEntity getCourseByCourseCode(String courseCode);

	CourseDto saveCourse(CourseDto courseDto);

}
