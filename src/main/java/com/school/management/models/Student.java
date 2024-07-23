package com.school.management.models;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "STUDENT")

public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer stdID;
	
	@Column(nullable = false)
	private String firstName;
	
	private String lastName;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Column(nullable = false)	
	private Date dob;
	
	@Column(nullable = false, length = 2)
	private Integer standard;
	
	@Column(nullable = false, length = 15)
	private String phNo;
	
	@Column(nullable = false)
	private String emailID;
	
	
	// Getter and Setters
	public Integer getStdID() {
		return stdID;
	}

	public void setStdID(Integer stdID) {
		this.stdID = stdID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Integer getStandard() {
		return standard;
	}

	public void setStandard(Integer standard) {
		this.standard = standard;
	}

	public String getPhNo() {
		return phNo;
	}

	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	// Constructor
	public Student(Integer stdID, String firstName, String lastName, Date dob, Integer standard, String phNo,
			String emailID) {
		super();
		this.stdID = stdID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.standard = standard;
		this.phNo = phNo;
		this.emailID = emailID;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
}
