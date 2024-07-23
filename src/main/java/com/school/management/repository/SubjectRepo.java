package com.school.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.management.models.Subject;

public interface SubjectRepo extends JpaRepository<Subject, Integer> {

}
