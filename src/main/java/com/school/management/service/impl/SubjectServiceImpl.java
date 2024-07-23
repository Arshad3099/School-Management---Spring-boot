package com.school.management.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.management.dto.SubjectDto;
import com.school.management.models.Subject;
import com.school.management.repository.SubjectRepo;
import com.school.management.service.SubjectService;
import com.school.management.utility.ResourceNotFoundException;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectRepo subjectRepo;

	@Override
	public SubjectDto createSubject(SubjectDto subjectDto) {
		// TODO Auto-generated method stub

		Subject subject = this.dtoToSubject(subjectDto);

		Subject createdSubject = this.subjectRepo.save(subject);

		return this.subjectToDto(createdSubject);
	}

	@Override
	public List<SubjectDto> getAllSubjects() {
		
		List<Subject> subjects = this.subjectRepo.findAll();
		
		List<SubjectDto> subjectsDtos = subjects.stream().map(Subject -> this.subjectToDto(Subject))
				.collect(Collectors.toList());
		
		return subjectsDtos;
	}

	@Override
	public void deleteSubject(Integer subId) {

		Subject subject = this.subjectRepo.findById(subId)
				.orElseThrow(() -> new ResourceNotFoundException("Subject", "id", subId));
		this.subjectRepo.delete(subject);
	}

	private Subject dtoToSubject(SubjectDto dto) {

		Subject subject = new Subject();

		subject.setSubId(dto.getSubId());
		subject.setSubjectName(dto.getSubjectName());
		subject.setMaxMarks(dto.getMaxMarks());

		return subject;

	}

	private SubjectDto subjectToDto(Subject subject) {

		SubjectDto dto = new SubjectDto();

		dto.setSubId(subject.getSubId());
		dto.setSubjectName(subject.getSubjectName());
		;
		dto.setMaxMarks(subject.getMaxMarks());

		return dto;
	}

}
