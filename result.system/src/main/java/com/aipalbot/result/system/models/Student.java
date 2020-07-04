package com.aipalbot.result.system.models;

import java.util.List;

public class Student {

	private String id;
	private String name;
	
	public Student(String id, String name) {
		this.id = id;
		this.name = name;
	}
	public String dept;
	
	public List<Course> courses;

	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
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
	
	
}
