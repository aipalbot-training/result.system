package com.aipalbot.result.system;

import java.util.List;
import java.util.Scanner;

import com.aipalbot.result.system.models.Course;
import com.aipalbot.result.system.models.Student;
import com.aipalbot.result.system.services.StudentService;
import com.aipalbot.result.system.util.Department;
import com.aipalbot.result.system.util.Gender;
import com.aipalbot.result.system.util.Terminate;

/**
 * Hello world!
 *
 */
public class App 
{
	
   static StudentService service; 
    
    public static void main( String[] args )
    {
    	 service = new StudentService();
       
    	 System.out.println( "Welcome to Student Result System 1.0 :-) :-) :-)" );
      
        enterCourses();
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter student name");               
        String name = input.nextLine();
        
        System.out.println("Enter student id");
        String id = input.nextLine();
        
        System.out.println("Enter student gender");
        String gender = input.nextLine();
        
        System.out.println("Enter student department");
        String dept = input.nextLine();
        
     
           
        
      Student student =   service.createStudent(name, id, gender, dept);
      
      enterScores(student);
      
      
      System.out.println("End of my program!!!");

    }
    
    public static void enterCourses() {
    	 
    	int count=1;
    	
    	   	
        while(true) {
        	
        	System.out.println("Begin to register course " + count);
        	System.out.println("**********************************************************************");
        	System.out.print("Enter code:");
        	Scanner in = new Scanner(System.in);
        	String code = in.nextLine();
        	
        	System.out.print("Enter Credit Hr:");
        	int creditHr = in.nextInt();
        	
        	Scanner in1 = new Scanner(System.in);        	
         	System.out.print("Enter name:");
        	String name = in1.nextLine();        	
         
         	
         	Course course = new Course();
         	course.setCode(code);
         	course.setCreditHr(creditHr);         	
         	course.setName(name);
      
         	
         	service.registerCourse(course); // this adds each course to the basket or courses
         	
         	System.out.println("Do you want to register another course yes/no");
           	Scanner input = new Scanner(System.in);
           	String yesNo = input.next();
           	
           	if(yesNo.equalsIgnoreCase(Terminate.no.toString())) {
           		break;
           	}
         	
           	count++;
        }
        
        
        //to display all the courses, use the getRegisteredCourses method
        List<Course> registeredCourses = service.getRegisteredCourses();
        
        System.out.println("Display the list of the courses");
        for(Course c : registeredCourses) {
        	System.out.println(c.toString());        	
        }
        
        
    }
    
    
    
    public static void enterScores(Student student) {
    	
    	for(Course course: student.getCourses()) {
    		System.out.println("Enter score for Course " + course.getName());
    		Scanner in = new Scanner(System.in);
    		double score = in.nextDouble();
    		course.setScore(score);    		
    	}
    }
}
