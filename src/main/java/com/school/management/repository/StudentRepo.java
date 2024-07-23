package com.school.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.management.models.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{

}
