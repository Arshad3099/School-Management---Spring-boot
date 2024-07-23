package com.school.management.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "SUBJECT")

public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer subId;

	@Column(nullable = false)
	private String subjectName;

	private Integer maxMarks;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "subject")
	private List<Teacher> teachers = new ArrayList<>();

	public Integer getSubId() {
		return subId;
	}

	public void setSubId(Integer subId) {
		this.subId = subId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Integer getMaxMarks() {
		return maxMarks;
	}

	public void setMaxMarks(Integer maxMarks) {
		this.maxMarks = maxMarks;
	}

	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Subject(Integer subId, String subjectName, Integer maxMarks) {
		super();
		this.subId = subId;
		this.subjectName = subjectName;
		this.maxMarks = maxMarks;
	}

}
