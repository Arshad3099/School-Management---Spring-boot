package com.school.management.service;

import java.util.List; 

import com.school.management.dto.StudentDto;

public interface StudentService {
	
	StudentDto createStudent(StudentDto studentDto);

	StudentDto updateStudent(StudentDto studentDto, Integer stdID);
	
	StudentDto getStudentById(Integer stdID);
	
	List<StudentDto> getAllStudents();
	
	void deleteStudent(Integer stdID);
	
	

}
