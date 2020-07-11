package com.aipalbot.result.system.services;

import java.util.ArrayList;
import java.util.List;

import com.aipalbot.result.system.models.Course;
import com.aipalbot.result.system.models.ReportCard;
import com.aipalbot.result.system.models.Student;
import com.aipalbot.result.system.util.CommonUtils;
import com.aipalbot.result.system.util.Department;
import com.aipalbot.result.system.util.Gender;
import com.aipalbot.result.system.util.GradingScale;

public class StudentService {

	public List<Course> courses;

	public StudentService() {
		courses = new ArrayList<>();
	}

	public void registerCourse(Course course) {
		if (courses != null) {
			courses.add(course);
		} else {
			courses = new ArrayList<>();
			courses.add(course);
		}
	}

	public List<Course> getRegisteredCourses() {
		return courses;
	}
//	
//	public void fillStudentScores() {
//		
//	}

	public Student createStudent(String name, String id, String gender, String dept) {
		Student student = new Student(id, name);

		// convert string to enum
		Gender sex = Gender.valueOf(gender);
		Department department = Department.valueOf(dept);

		student.setDept(department);
		student.setGender(sex);

		if (courses.size() > 0) {
			student.setCourses(courses);			
		}

		return student;
	}


	@SuppressWarnings("unused")
	public void prepareStudentResult(Student student) {
		
	double gpaTotal = 0;
	double totalCreditHr=0.0;
	//calculate gpa and credit hour total and also set grade and point for each course
		for (Course course : student.getCourses()) {
			
		
			if (course.getScore() >= 86 && course.getScore() <= 100) {
				course.setGrade("A");
				course.setPoint(5.0);				
			} else if (course.getScore() >= 70 && course.getScore() <= 85) {
				course.setGrade("B");
				course.setPoint(4.0);		
			} else if (course.getScore() >= 60 && course.getScore() <= 69) {
				course.setGrade("C");
				course.setPoint(3.0);
			} else if (course.getScore() >= 50 && course.getScore() <= 59) {
				course.setGrade("D");
				course.setPoint(2.0);
			} else if (course.getScore() >= 40 && course.getScore() <= 49) {
				course.setGrade("E");
				course.setPoint(1.0);			
			} else {
				course.setGrade("F");
				course.setPoint(0.0);			
			}
			
			
			double pointbyCreditHr = course.getPoint() * course.getCreditHr();
			
			course.setPointCreditHr(pointbyCreditHr);
			
			gpaTotal += course.getPointCreditHr();
			
			totalCreditHr+=course.getCreditHr();
		}
		
		double gpa = gpaTotal / totalCreditHr;
		gpa = CommonUtils.roundTo2Decimal(gpa);
		
		ReportCard report = new ReportCard();
		report.setGpa(gpa);	
		computeOverAllGrading(report);
		//we want to set OverAll Grading
		
		//GradingScale gpG =	computeOverAllGrading(gpa);
		//report.setOverAllGrading(gpG);
		
		//give report card to student
		student.setReportCard(report);

	}
	
	//overload the computeOverAllGrading
	public void computeOverAllGrading(ReportCard report) {	
		if (report.getGpa() >= 3.5 && report.getGpa()  <= 4.0) {			
			 report.setOverAllGrading(GradingScale.Excellence);
		} else if (report.getGpa()  >= 3.0  && report.getGpa()  <= 3.4) {
			 report.setOverAllGrading(GradingScale.VeryGood);
		} else if (report.getGpa()  >= 2.5 && report.getGpa()  <=2.99) {
			 report.setOverAllGrading(GradingScale.Good);
		} else if (report.getGpa()  >= 2.0 && report.getGpa()  <= 2.49) {
			 report.setOverAllGrading(GradingScale.Average);
		} else {
			 report.setOverAllGrading(GradingScale.Poor);
		}		
	}

	public GradingScale computeOverAllGrading(double gpa) {
		if (gpa>= 3.5 && gpa <= 4.0) {			
			 return GradingScale.Excellence;
		} else if (gpa  >= 3.0  && gpa  <= 3.4) {
		return GradingScale.VeryGood;
		} else if (gpa  >= 2.5 && gpa <=2.99) {
		return GradingScale.Good;
		} else if (gpa  >= 2.0 && gpa <= 2.49) {
		return GradingScale.Average;
		} else {
			return GradingScale.Poor;
		}		
	}
	

}
