package com.school.management.dto;

import java.sql.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class TeacherDto {

	private Integer id;
	
	@NotNull
	@Size(min = 3, max = 12, message = "The length first name should be in range of 3 to 12")
	private String firstName;
	
	
	private String lastName;
	
	private Date doj;
	
	@NotNull
	@Size(min = 10, max = 14, message = "The length phone number is range of 10 to 14")
	private String phNo;
	
	@Email
	@NotNull
	private String emailId;
	
	@NotNull
	@Min(value = 1, message = "The min value of subject is 1")
	private Integer subId;

	public TeacherDto(Integer id, String firstName, String lastName, Date doj, String phNo, String emailId, Integer subId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.doj = doj;
		this.phNo = phNo;
		this.emailId = emailId;
		this.subId = subId;
	}

	public TeacherDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getSubId() {
		return subId;
	}

	public void setSubId(Integer subId) {
		this.subId = subId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
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

}
