package com.flipkart.client;

import com.flipkart.bean.Course;
import com.flipkart.bean.ReportCard;
import com.flipkart.bean.Student;
import com.flipkart.dao.StudentDaoInterface;
import com.flipkart.dao.StudentDaoOperation;
import com.flipkart.exception.*;
import com.flipkart.service.SemesterRegistrationInterface;
import com.flipkart.service.SemesterRegistrationOperation;
import com.flipkart.service.StudentInterface;
import com.flipkart.service.StudentOperation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentClient {
    static Scanner sc = new Scanner(System.in);
    private int studentID;
    
    SemesterRegistrationInterface sro = SemesterRegistrationOperation.getInstance();
    StudentInterface so = StudentOperation.getInstance();
    StudentDaoInterface sdo = StudentDaoOperation.getInstance();

    public static void main(String[] args) {
        StudentClient test = new StudentClient();
        System.out.println("Enter You Username");
        String username = sc.nextLine();
        test.createStudentMenu(username);
    }

    public void createStudentMenu(String username) {

        try {
        	
        	studentID = getStudentID(username);
            assert studentID != -1;

            while(true) {
            	System.out.println("\n\n==~~=~~=~~=~~=~Student Panel~=~~=~~=~~=~~==");
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
                        viewGradeCard(studentID,1);
                        break;
                    case 2 :
                        viewRegisteredCourses(studentID,1);
                        break;
                    case 3:
                        createRegistrationDashboard();
                        break;
                    case 4:
                    	System.out.println("Logging Out ...");
                    	return;
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

                switch(menuOption) {
                    case 1 :
                        viewAvailableCourses();
                        break;
                    case 2 :
                        addCourse();
                        break;
                    case 3:
                        dropCourse();
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

//        SemesterRegistrationOperation sro = new SemesterRegistrationOperation();

        System.out.println("=======================================");
        System.out.println("Finishing registration...");

        boolean registrationFinished = sro.finishRegistration(studentID, 1);

        if(registrationFinished) {
            System.out.println("Registration completed successfully!");
        }
        else {
            System.out.println("Registration did not complete.");
        }
    }

    private void payRegistrationFee() {
        // to do : fee payment logic, and return transactionID object
    }

    private void dropCourse() {

//        SemesterRegistrationOperation sro = new SemesterRegistrationOperation();

        System.out.println("=======================================");
        System.out.println("Delete Course");
        System.out.println("Enter course ID: ");

        String courseID = sc.nextLine();

        boolean courseDropped = false;
		try {
			courseDropped = sro.dropCourse(studentID, 1, courseID);
		} catch (CourseNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CourseNotDeletedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (StudentNotRegisteredException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        if(courseDropped) {
            System.out.println("Course dropped successfully!");
        }
        else {
            System.out.println("Course was not dropped from the cart.");
        }
    }

    private void addCourse() {

//        SemesterRegistrationOperation sro = new SemesterRegistrationOperation();

    	System.out.println("=======================================");
        System.out.println("Add Course");
        System.out.println("Enter course ID: ");

        String courseID = sc.nextLine();

        boolean courseAdded = false;
		try {
			courseAdded = sro.addCourse(studentID, 1, courseID);
		} catch (CourseNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CourseNotAssignedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CourseAlreadyRegisteredException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CourseLimitExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (StudentNotRegisteredException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        if(courseAdded) {
            System.out.println("Course added successfully!");
        }
        else {
            System.out.println("Course was not added to the cart.");
        }
    }

    private void viewAvailableCourses() {

//        SemesterRegistrationOperation sro = new SemesterRegistrationOperation();
        ArrayList<Course> courseCatalog = null;
		try {
			courseCatalog = sro.viewAvailableCourses();
		} catch (StudentNotRegisteredException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Course catalog : ");
        for(Course c : courseCatalog) {
            System.out.println("Course ID : "+c.getCourseID()+" \t Course Name : "+ c.getCoursename()+"\t Instructor : "+c.getInstructorID());
        }
    }

    private void viewRegisteredCourses(int studentID, int semesterID) throws StudentNotRegisteredException, SQLException {

//    	StudentOperation so = new StudentOperation();
    	List<Course> courses = so.viewRegisteredCourses(studentID, semesterID);
    	System.out.println("These are your registered courses : ");
    	for(Course c: courses) {
    		System.out.println("Course ID : "+c.getCourseID()+" \t Course Name : "+ c.getCoursename()+"\t Instructor : "+c.getInstructorID());
    	}
    }

    private void viewGradeCard(int studentID, int semesterID) throws SQLException, GradeNotAddedException, StudentNotApproved, FeesPendingException, StudentNotApprovedException {
//    	StudentOperation so = new StudentOperation();
    	ReportCard R = so.viewReportCard(studentID, semesterID);
    	System.out.println("StudentID : "+R.getStudentID()+"\t SemesterID : "+R.getSemesterID());
    	System.out.println("Course  Grade");
    	R.getGrades().forEach((key, value) -> System.out.println(key + "    " + value));
    }
    
    private int getStudentID(String username) throws StudentNotRegisteredException, SQLException {
		
//    	StudentDaoOperation sdo = new StudentDaoOperation();
        return sdo.getStudentIDFromUserName(username);
	}
}
