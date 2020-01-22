package com.azad.practice.school.io.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.azad.practice.school.io.entity.CourseEntity;

@Repository
public interface CourseRepository extends PagingAndSortingRepository<CourseEntity, Long> {

	CourseEntity findByCourseId(String courseId);

	CourseEntity findByCode(String code);

}
