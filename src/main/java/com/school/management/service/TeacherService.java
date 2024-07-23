package com.school.management.service;

import java.util.List; 

import com.school.management.dto.TeacherDto;

public interface TeacherService {

	TeacherDto createTeacher(TeacherDto teacherDto);
	
	TeacherDto updateTeacher(TeacherDto teacherDto, Integer id);
	
	TeacherDto getTeacherById(Integer id);
	
	List<TeacherDto> getAllTeachers();
	
	void deleteTeacher(Integer id);
}
