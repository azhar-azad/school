package com.azad.practice.school.io.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.azad.practice.school.io.entity.StudentEntity;

@Repository
public interface StudentRepository extends PagingAndSortingRepository<StudentEntity, Long> {

	StudentEntity findByStudentId(String studentId);

	StudentEntity findByEmail(String studentEmail);

	StudentEntity findByPassportEntityId(Long id);

}
