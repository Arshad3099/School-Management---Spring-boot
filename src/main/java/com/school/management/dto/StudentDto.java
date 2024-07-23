package com.school.management.dto;


import java.sql.Date; 

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class StudentDto {

	private Integer stdID;

	@NotNull
	@Size(min = 3, message = "First name should has atleast 4 characters")
	private String firstName;
	
	@NotNull	
	private String lastName;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@NotNull
	private Date dob;
	
	@NotNull
	@Max(value = 12, message = "Maximum standard is 12")
	@Min(value = 1, message = "Minimum standard is 1")
	private Integer standard;
	
	@NotNull
	@Size(min = 10, max = 13, message = "Phone number should have minimum 10 to maximum 13 numbers")
	private String phNo;
	
	@NotNull
	@Email(message = "Email address is not valid")
	private String emailId;

	// Getters and Setters
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	// Constructors

	public StudentDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentDto(Integer stdID, String firstName, String lastName, Date dob, Integer standard, String phNo,
			String emailId) {
		super();
		this.stdID = stdID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.standard = standard;
		this.phNo = phNo;
		this.emailId = emailId;
	}

}
