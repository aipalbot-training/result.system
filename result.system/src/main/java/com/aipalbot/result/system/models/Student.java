package com.aipalbot.result.system.models;

import java.util.List;

import com.aipalbot.result.system.util.Department;
import com.aipalbot.result.system.util.Gender;

public class Student {

	private String id;
	private String name;
	private Department dept;
	private Gender gender;
	public List<Course> courses;
    private ReportCard reportCard;
    
	
	public Student(String id, String name) {
			this.id = id;
		this.name = name;	
	}
	

	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public ReportCard getReportCard() {
		return reportCard;
	}

	public void setReportCard(ReportCard reportCard) {
		this.reportCard = reportCard;
	}
	
	
}
