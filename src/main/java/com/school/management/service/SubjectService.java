package com.school.management.service;

import java.util.List; 

import com.school.management.dto.SubjectDto;

public interface SubjectService {

	SubjectDto createSubject(SubjectDto subjectDto);
	
	List<SubjectDto> getAllSubjects();
	
	void deleteSubject(Integer subId);
	
	
}
