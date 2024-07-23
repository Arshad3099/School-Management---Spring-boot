package com.school.management.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.management.dto.TeacherDto;
import com.school.management.models.Subject;
import com.school.management.models.Teacher;
import com.school.management.repository.SubjectRepo;
import com.school.management.repository.TeacherRepo;
import com.school.management.service.TeacherService;
import com.school.management.utility.ResourceNotFoundException;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherRepo teacherRepo;

	@Autowired
	private SubjectRepo subjectRepo;

	@Override
	public TeacherDto createTeacher(TeacherDto teacherDto) {

		Optional<Subject> optionalSubject = this.subjectRepo.findById(teacherDto.getSubId());

		Subject subject = optionalSubject.get();

		Teacher teacher = this.dtoToTeacher(teacherDto);
		teacher.setSubject(subject);
		Teacher createdTeacher = this.teacherRepo.save(teacher);

		return this.teacherToDto(createdTeacher);
	}

	@Override
	public TeacherDto updateTeacher(TeacherDto teacherDto, Integer id) {
		// TODO Auto-generated method stub

		Optional<Teacher> optionalTeacher = this.teacherRepo.findById(id);

		Teacher teacher = optionalTeacher.get();

		if (optionalTeacher.isPresent()) {
			teacher.setFirstName(teacherDto.getFirstName());
			teacher.setLastName(teacherDto.getLastName());
			teacher.setDoj(teacherDto.getDoj());
			teacher.setPhNo(teacherDto.getPhNo());
			teacher.setEmailID(teacherDto.getEmailId());

			Optional<Subject> optionalSubject = this.subjectRepo.findById(teacherDto.getSubId());

			Subject subject = optionalSubject.get();
			teacher.setSubject(subject);
			Teacher updatedTeacher = this.teacherRepo.save(teacher);

			return this.teacherToDto(updatedTeacher);

		} else {

			return null;

		}

	}

	@Override
	public TeacherDto getTeacherById(Integer id) {
		Teacher teacher = this.teacherRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("teacher", "id", id));
		return this.teacherToDto(teacher);
	}

	@Override
	public List<TeacherDto> getAllTeachers() {
		// TODO Auto-generated method stub

		List<Teacher> teachers = this.teacherRepo.findAll();
		List<TeacherDto> teachersDtos = teachers.stream().map(Teacher -> this.teacherToDto(Teacher))
				.collect(Collectors.toList());

		return teachersDtos;
	}

	@Override
	public void deleteTeacher(Integer id) {
		// TODO Auto-generated method stub

		Teacher teacher = this.teacherRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Teacher", "id", id));
		this.teacherRepo.delete(teacher);

	}

	private Teacher dtoToTeacher(TeacherDto dto) {

		Teacher teacher = new Teacher();

		teacher.setId(dto.getId());
		teacher.setFirstName(dto.getFirstName());
		teacher.setLastName(dto.getLastName());
		teacher.setDoj(dto.getDoj());
		teacher.setPhNo(dto.getPhNo());
		teacher.setEmailID(dto.getEmailId());

		return teacher;
	}

	private TeacherDto teacherToDto(Teacher teacher) {

		TeacherDto dto = new TeacherDto();

		dto.setId(teacher.getId());
		dto.setFirstName(teacher.getFirstName());
		dto.setLastName(teacher.getLastName());
		dto.setDoj(teacher.getDoj());
		dto.setPhNo(teacher.getPhNo());
		dto.setEmailId(teacher.getEmailID());

		Subject subject = teacher.getSubject();
		Integer subId = subject.getSubId();
		dto.setSubId(subId);

		return dto;
	}

}
