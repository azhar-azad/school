package com.azad.practice.school.service;

import java.util.List;

import com.azad.practice.school.io.entity.StudentEntity;
import com.azad.practice.school.shared.dto.StudentDto;

public interface StudentService {

	StudentDto createStudent(StudentDto studentDto);

	StudentDto getStudentByStudentId(String studentId);

	List<StudentDto> getAll(int page, int limit);

	void deleteStudent(String studentId);

	StudentDto updateStudent(String studentId, StudentDto updatedStudentDto);

	StudentEntity getStudentByEmail(String studentEmail);

	String getStudentIdByPassportId(Long id); // input: passport entity id. output: student_id

}
