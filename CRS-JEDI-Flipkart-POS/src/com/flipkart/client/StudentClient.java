package com.flipkart.client;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.flipkart.bean.Course;
import com.flipkart.bean.ReportCard;
import com.flipkart.bean.Student;
import com.flipkart.dao.StudentDaoOperation;
import com.flipkart.exception.FeesPendingException;
import com.flipkart.exception.GradeNotAddedException;
import com.flipkart.exception.StudentNotApproved;
import com.flipkart.exception.StudentNotApprovedException;
import com.flipkart.exception.StudentNotRegisteredException;
import com.flipkart.service.StudentOperation;

public class StudentClient {
     static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        StudentClient test = new StudentClient();
        System.out.println("Enter You Username");
        String username = sc.nextLine();
        test.createStudentMenu(username);
    }

    public void createStudentMenu(String username) {

        try {
        	
        	Student student = getStudentfromUserName(username);

            while(true) {
            	System.out.println("==~~=~~=~~=~~=~Student Panel~=~~=~~=~~=~~==");
                System.out.println("Choose an option: ");
                System.out.println("---------------------------------------");
                System.out.println("1 : View report card");
                System.out.println("2 : View registered courses");
                System.out.println("3 : Open semester registration dashboard");
                System.out.println("4 : Logout");
                System.out.println("=======================================");

                int menuOption = sc.nextInt();
                sc.nextLine();

                switch(menuOption) {
                    case 1 :
                        viewGradeCard(student.getStudentID(),1);
                        break;
                    case 2 :
                        viewRegisteredCourses(student.getStudentID(),1);
                        break;
                    case 3:
                        createRegistrationDashboard();
                        break;
                    case 4:
                    	System.out.println("Logging Out ...");
                    	System.exit(0);
                    default:
                        System.out.println("Invalid input");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
	private void createRegistrationDashboard() {
        Scanner sc = new Scanner(System.in);

        try {

            while(true) {
            	System.out.println("=======================================");
                System.out.println("Semester registration : ");
                System.out.println("---------------------------------------");
                System.out.println("1 : View available course details");
                System.out.println("2 : Add course");
                System.out.println("3 : Drop course");
                System.out.println("4 : Make a payment");
                System.out.println("5 : Finish registration and exit");
                System.out.println("=======================================");

                int menuOption = sc.nextInt();
                sc.nextLine();

                switch(menuOption) {
                    case 1 :
                        viewAvailableCourses();
                        break;
                    case 2 :
                        addCourse();
                        break;
                    case 3:
                        deleteCourse();
                        break;
                    case 4:
                        payRegistrationFee();
                        break;
                    case 5:
                        finishRegistration();
                        return;
                    default:
                        System.out.println("Invalid input");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void finishRegistration() {
        // to do : clean up, exit from registration, and return registered courses list
    }

    private void payRegistrationFee() {
        // to do : fee payment logic, and return transactionID object
    }

    private void deleteCourse() {

        System.out.println("Delete Course");
        System.out.println("Enter course ID: ");

        String courseID = sc.nextLine();

        // to do : implementation of course deletion
    }

    private void addCourse() {

    	System.out.println("=======================================");
        System.out.println("Add Course");
        System.out.println("Enter course ID: ");

        String courseID = sc.nextLine();

        // to do : implementation of course deletion
    }

    private void viewAvailableCourses() {
        // to do : get available courses from db
    	
    }

    private void viewRegisteredCourses(int studentID, int semesterID) throws StudentNotRegisteredException, SQLException {
        // to do : get courses from db, and return a list
    	StudentOperation so = new StudentOperation();
    	List<Course> courses = so.viewRegisteredCourses(studentID, semesterID);
    	System.out.println("These are your registered courses : ");
    	for(Course c: courses) {
    		System.out.println("Course ID : "+c.getCourseID()+" \t Course Name : "+ c.getCoursename()+"\t Instructor : "+c.getInstructorID());
    	}
    }

    private void viewGradeCard(int studentID, int semesterID) throws SQLException, GradeNotAddedException, StudentNotApproved, FeesPendingException, StudentNotApprovedException {
    	StudentOperation so = new StudentOperation();
    	ReportCard R = so.viewReportCard(studentID, semesterID);
    	System.out.println("StudentID : "+R.getStudentID()+"\t SemesterID : "+R.getSemesterID());
    	System.out.println("Course  Grade");
    	R.getGrades().entrySet().forEach(entry -> {
    	    System.out.println(entry.getKey() + "    " + entry.getValue());
    	});
    }
    
    private Student getStudentfromUserName(String username) throws StudentNotRegisteredException, SQLException {
		
    	StudentDaoOperation sdo = new StudentDaoOperation();
    	Student  st = sdo.getStudentfromUserName(username);
		return st;
	}
}
