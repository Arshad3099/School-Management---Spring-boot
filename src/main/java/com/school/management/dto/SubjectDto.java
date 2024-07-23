package com.school.management.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class SubjectDto {

	private Integer subId;
	
	@NotNull
	@Size(min = 3, max = 10, message = "Subject name should have range between 3 to 10")
	private String subjectName;
	
	@NotNull
	@Min(value = 0, message = "the minimum marks for the subject is 0")
	@Max(value = 100, message = "Maximum marks for the subject is 100")
	private Integer maxMarks;

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

	public SubjectDto(Integer subId, String subjectName, Integer maxMarks) {
		super();
		this.subId = subId;
		this.subjectName = subjectName;
		this.maxMarks = maxMarks;
	}

	public SubjectDto() {
		super();
	}

}
