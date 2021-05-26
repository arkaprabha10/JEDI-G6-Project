package com.flipkart.client;

import java.sql.SQLException;
import java.util.Scanner;

import com.flipkart.dao.ProfessorDaoOperation;
import com.flipkart.dao.StudentDaoOperation;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.GradeNotAddedException;
import com.flipkart.exception.StudentNotRegisteredException;
import com.flipkart.service.ProfessorInterface;
import com.flipkart.service.ProfessorOperation;

public class ProfessorClient {
    private Scanner sc = new Scanner(System.in);
    private int professorID;

    public static void main(String[] args) {
        ProfessorClient test = new ProfessorClient();
        test.createProfessorMenu("Arka");
    }

    public void createProfessorMenu(String username) {
        try {

            professorID = getProfessorID(username);
            assert professorID != -1;

            while(true) {
                System.out.println("\n\n==~~=~~=~~=~~=~Student Panel~=~~=~~=~~=~~==");
                System.out.println("Choose an option : ");
                System.out.println("1 : View registered students");
                System.out.println("2 : Add Grade");
                System.out.println("3 : Show available courses");
                System.out.println("4 : Register for a course");
                System.out.println("5 : Logout");
                System.out.println("=======================================");

                int menuOption = sc.nextInt();
                sc.nextLine();

                switch(menuOption) {
                    case 1 :
                        viewEnrolledStudents();
                        break;
                    case 2 :
                        addGrade();
                        break;
                    case 3:
                        viewAvailableCourses();
                        break;
                    case 4:
                        registerCourse();
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Invalid input");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void registerCourse() throws SQLException {

        String courseID;
        Integer semesterID;
        System.out.println("Enter course ID: ");
        courseID = sc.nextLine();
        System.out.println("Enter Semester ID: ");
        semesterID = sc.nextInt();
        sc.nextLine();
        ProfessorInterface profObj = new ProfessorOperation();
    	profObj.registerCourse(professorID, semesterID, courseID);

        // to do : register for course
    }

    private void viewAvailableCourses() {

    	ProfessorInterface profObj = new ProfessorOperation();
    	profObj.viewCourseProf(professorID);
    }

    private void addGrade() throws CourseNotFoundException, GradeNotAddedException {

//    	viewEnrolledStudents();
    	String courseID;
    	Integer grade,semesterID,studentID;
        System.out.println("Enter student ID: ");
        studentID = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Semester ID: ");
        semesterID = sc.nextInt();
        System.out.println("Enter course ID: ");
        sc.nextLine();
        courseID = sc.nextLine();
        System.out.println("Enter Grade: ");
        grade = sc.nextInt();
        sc.nextLine();
        ProfessorInterface profObj = new ProfessorOperation();
    	profObj.addGrade(studentID, semesterID, courseID, grade);
        // get students details/objects


    }

   

    private void viewEnrolledStudents() throws CourseNotFoundException {

    	String courseID;
    	int semesterID;

        System.out.println("Enter course ID: ");
        courseID= sc.nextLine();
        System.out.println("Enter semester ID: ");
        semesterID = sc.nextInt();

    	try {
    		
        	ProfessorInterface profObj = new ProfessorOperation();
        	profObj.viewCourseStudents(courseID, semesterID);
    	}
    	catch(Exception e) {
    		throw new CourseNotFoundException(courseID);
    	}
    	
    }

    private int getProfessorID(String username) throws SQLException {

        ProfessorDaoOperation pdo = ProfessorDaoOperation.getInstance();
        return pdo.getProfessorIDFromUserName(username);
    }
}
