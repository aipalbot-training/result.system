package com.aipalbot.result.system;

import java.util.List;
import java.util.Scanner;

import com.aipalbot.result.system.models.Course;
import com.aipalbot.result.system.services.StudentService;
import com.aipalbot.result.system.utility.Terminate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Welcome to Student Result System 1.0 :-) :-) :-)" );
      
        enterCourses();
        
    }
    
    public static void enterCourses() {
    	 
    	int count=1;
    	
    	StudentService service = new StudentService();
    	
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
    
    
}
