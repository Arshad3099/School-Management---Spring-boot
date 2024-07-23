package com.school.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.management.dto.TeacherDto;
import com.school.management.service.TeacherService;

@RestController
@RequestMapping(path = "/school")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	// Teacher login
	
	// View teacher by ID
	@GetMapping(path = "/teacher/{tId}")
	public ResponseEntity<TeacherDto> getTeacherById(@PathVariable("tId") Integer id) {

		TeacherDto teacher = this.teacherService.getTeacherById(id);
		
		return new ResponseEntity<>(teacher, HttpStatus.OK);
	}
	
}
