package com.aipalbot.result.system.services;

import java.util.ArrayList;
import java.util.List;

import com.aipalbot.result.system.models.Course;
import com.aipalbot.result.system.models.ReportCard;
import com.aipalbot.result.system.models.Student;
import com.aipalbot.result.system.util.Department;
import com.aipalbot.result.system.util.Gender;

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
//	
//	public void fillStudentScores() {
//		
//	}
	
	public Student createStudent(String name, String id, String gender, String dept) {
		Student student = new Student(name,id);
		
		//convert string to enum
        Gender sex = Gender.valueOf(gender);
        Department department = Department.valueOf(dept); 
		
        student.setDept(department);
        student.setGender(sex);
        
		if(courses.size() > 0) {
			student.setCourses(courses);;
		}
		
		return student;
	}
	
	public ReportCard calculateStudentResult(Student student) {
		
		computeGradeRange(student);
		
		return null;
	}
	
	private void computeGradeRange(Student student) {
		
		for(Course c : student.getCourses()) {
			
			if(c.getScore() >= 86 && c.getScore() <= 100) {
		    	c.setGrade("A");
		    }
		  else if(c.getScore() >= 70 && c.getScore() <= 85) {
		  c.setGrade("B");

		  }
		  else if(c.getScore() >= 60 && c.getScore() <= 69) {
			  c.setGrade("C");
		  }
		  else if(c.getScore() >= 50 && c.getScore() <= 59) {
			  c.setGrade("D");

		  }
		  else if(c.getScore() >= 40 && c.getScore() <= 49) {
			  c.setGrade("E");
		  }   
		  else {
			  c.setGrade("F");

			  }
		}
	}
	
}
