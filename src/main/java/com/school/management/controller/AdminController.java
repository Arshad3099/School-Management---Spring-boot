package com.school.management.controller;

import java.util.List; 
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.management.dto.StudentDto;
import com.school.management.dto.SubjectDto;
import com.school.management.dto.TeacherDto;
import com.school.management.service.StudentService;
import com.school.management.service.SubjectService;
import com.school.management.service.TeacherService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/school")
public class AdminController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private TeacherService teacherService;

	@Autowired
	private SubjectService subjectService;

	// Admin login

	// Add student
	@PostMapping(path = "/student")
	public ResponseEntity<StudentDto> createStudent(@Valid @RequestBody StudentDto studentDto) {

		StudentDto createdStudent = this.studentService.createStudent(studentDto);

		return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
	}

	// Add Teacher
	@PostMapping(path = "/teacher")
	public ResponseEntity<TeacherDto> createTeacher(@Valid @RequestBody TeacherDto teacherDto) {

		TeacherDto createdTeacher = this.teacherService.createTeacher(teacherDto);

		return new ResponseEntity<>(createdTeacher, HttpStatus.CREATED);
	}

	// Add subject
	@PostMapping(path = "/subject")
	public ResponseEntity<SubjectDto> createSubject(@Valid @RequestBody SubjectDto subjectDto) {

		SubjectDto createdSubject = this.subjectService.createSubject(subjectDto);

		return new ResponseEntity<>(createdSubject, HttpStatus.CREATED);
	}

	// Update Student
	@PutMapping(path = "/student/{stdId}")
	public ResponseEntity<StudentDto> updateStudent(@Valid @RequestBody StudentDto studentDto, @PathVariable Integer stdId) {

		StudentDto updatedStudent = this.studentService.updateStudent(studentDto, stdId);

		return new ResponseEntity<>(updatedStudent, HttpStatus.OK);

	}

	// Update Teacher
	@PutMapping(path = "/teacher/{tId}")
	public ResponseEntity<TeacherDto> updateTeacher(@Valid @RequestBody TeacherDto teacherDto, @PathVariable Integer tId) {

		TeacherDto updatedTeacher = this.teacherService.updateTeacher(teacherDto, tId);

		return new ResponseEntity<>(updatedTeacher, HttpStatus.OK);

	}

	// view all students
	@GetMapping(path = "/student")
	public ResponseEntity<List<StudentDto>> getAllStudents() {

		return ResponseEntity.ok(this.studentService.getAllStudents());
	}

	// view all teachers
	@GetMapping(path = "/teacher")
	public ResponseEntity<List<TeacherDto>> getAllTeachers() {

		return ResponseEntity.ok(this.teacherService.getAllTeachers());
	}	
	
	// view all subjects
	@GetMapping(path = "/subject")
	public ResponseEntity<List<SubjectDto>> getAllSubjects() {

		return ResponseEntity.ok(this.subjectService.getAllSubjects());
	}
	
	// delete student
	@DeleteMapping(path = "/student/{stdId}")
	public ResponseEntity<?> deleteStudent(@PathVariable("stdId") Integer id) {
		this.studentService.deleteStudent(id);

		return new ResponseEntity<>(Map.of("message", "Student deleted Successfully"), HttpStatus.OK);
	}

	// delete teacher
	@DeleteMapping(path = "/teacher/{tId}")
	public ResponseEntity<?> deleteTeacher(@PathVariable("tId") Integer id) {
		this.teacherService.deleteTeacher(id);

		return new ResponseEntity<>(Map.of("message", "Teacher deleted Successfully"), HttpStatus.OK);
	}

	// delete subject
	@DeleteMapping(path = "/subject/{subId}")
	public ResponseEntity<?> deleteSubject(@PathVariable("subId") Integer id) {
		this.subjectService.deleteSubject(id);

		return new ResponseEntity<>(Map.of("message", "Subject deleted Successfully"), HttpStatus.OK);
	}

}
