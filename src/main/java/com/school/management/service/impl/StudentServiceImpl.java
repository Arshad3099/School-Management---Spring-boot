package com.school.management.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.management.dto.StudentDto;
import com.school.management.models.Student;
import com.school.management.repository.StudentRepo;
import com.school.management.service.StudentService;
import com.school.management.utility.ResourceNotFoundException;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo studentRepo;

	@Override
	public StudentDto createStudent(StudentDto studentDto) {
		// TODO Auto-generated method stub

		Student student = this.dtoToStudent(studentDto);

		Student createdStudent = this.studentRepo.save(student);

		return this.studentToDto(createdStudent);
	}

	@Override
	public StudentDto updateStudent(StudentDto studentDto, Integer stdID) {
		// TODO Auto-generated method stub

		Optional<Student> optionalStudent = this.studentRepo.findById(stdID);

		Student student = optionalStudent.get();

		if (optionalStudent.isPresent()) {
			student.setFirstName(studentDto.getFirstName());
			student.setLastName(studentDto.getLastName());
			student.setDob(studentDto.getDob());
			student.setStandard(studentDto.getStandard());
			student.setPhNo(studentDto.getPhNo());
			student.setEmailID(studentDto.getEmailId());

			Student updatedStudent = this.studentRepo.save(student);

			return this.studentToDto(updatedStudent);

		} else {

			return null;

		}

	}

	@Override
	public StudentDto getStudentById(Integer stdID) {
		Student student = this.studentRepo.findById(stdID)
				.orElseThrow(() -> new ResourceNotFoundException("Student", "id", stdID));
		return this.studentToDto(student);
	}

	@Override
	public List<StudentDto> getAllStudents() {
		// TODO Auto-generated method stub

		List<Student> students = this.studentRepo.findAll();
		List<StudentDto> studentsDtos = students.stream().map(Student -> this.studentToDto(Student))
				.collect(Collectors.toList());

		return studentsDtos;
	}

	@Override
	public void deleteStudent(Integer stdID) {
		// TODO Auto-generated method stub
		
		Student student = this.studentRepo.findById(stdID)
				.orElseThrow(() -> new ResourceNotFoundException("Student", "id", stdID));
		this.studentRepo.delete(student);
		

	}

	private Student dtoToStudent(StudentDto dto) {

		Student student = new Student();

		student.setStdID(dto.getStdID());
		student.setFirstName(dto.getFirstName());
		student.setLastName(dto.getLastName());
		student.setStandard(dto.getStandard());
		student.setDob(dto.getDob());
		student.setPhNo(dto.getPhNo());
		student.setEmailID(dto.getEmailId());

		return student;
	}

	private StudentDto studentToDto(Student student) {

		StudentDto dto = new StudentDto();

		dto.setStdID(student.getStdID());
		dto.setFirstName(student.getFirstName());
		dto.setLastName(student.getLastName());
		dto.setStandard(student.getStandard());
		dto.setDob(student.getDob());
		dto.setPhNo(student.getPhNo());
		dto.setEmailId(student.getEmailID());

		return dto;
	}

}