package com.aipalbot.result.system.services;

import java.util.ArrayList;
import java.util.List;

import com.aipalbot.result.system.models.Course;

public class StudentService {

	public List<Course> courses;
	
	public StudentService() {
		courses= new ArrayList<>();
	}
	
	public void registerCourse(Course course) {
		if(courses != null) {
			courses.add(course);
		}else {
			courses= new ArrayList<>();
			courses.add(course);
		}
	}
	
	public List<Course> getRegisteredCourses(){
		return courses;
	}
	
	
	
}
