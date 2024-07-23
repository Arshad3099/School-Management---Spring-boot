package com.school.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.management.models.Teacher;

public interface TeacherRepo extends JpaRepository<Teacher, Integer> {
	
}
