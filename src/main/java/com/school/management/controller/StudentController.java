package com.school.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.management.dto.StudentDto;
import com.school.management.service.StudentService;

@RestController
@RequestMapping(path = "/school")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	// Student login
	
	// View student by ID
	@GetMapping(path = "/student/{stdId}")
	public ResponseEntity<StudentDto> getStudentById(@PathVariable("stdId") Integer id) {

		return ResponseEntity.ok(this.studentService.getStudentById(id));
	}
	
}
