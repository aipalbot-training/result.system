package com.aipalbot.result.system.models;

public class Course {

	public String code;
	public int creditHr;
	public String grade;
	public String name;
	public double score;
	public double point;
	public double pointCreditHr;
	
	   public static int countCourseInstances;	
	   static {
		   countCourseInstances=0;
	   }
	   
	   public Course() {
		  countCourseInstances++;
	   }
	   	    
	    public static int getTotalNumberOfObjectsCreated() {
	    	return countCourseInstances;
	    }
	
	    
	    
	
	public double getPointCreditHr() {
			return pointCreditHr;
		}

		public void setPointCreditHr(double ponitCreditHr) {
			this.pointCreditHr = ponitCreditHr;
		}

	public double getPoint() {
			return point;
		}

		public void setPoint(double point) {
			this.point = point;
		}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getCreditHr() {
		return creditHr;
	}
	public void setCreditHr(int creditHr) {
		this.creditHr = creditHr;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	
	
	public String toString() { 
	    return "Name:" + this.name 
	    		+ ", Code: " + this.code 
	    		+ ", Credit Hour: " + this.creditHr 
	    		+ ", Score: "+ this.score 
	    		+ ", Grade: " + this.grade
	    		+ ", Point: " + this.point
	    		+ ", PointByCreditHour: " + this.pointCreditHr;
	}
	
}
