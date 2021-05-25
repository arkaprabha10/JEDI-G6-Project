package com.flipkart.client;

import com.flipkart.bean.Admin;

import java.util.Scanner;

public class AdminClient {
    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        AdminClient test = new AdminClient();
        test.createAdminMenu();
    }

    public void createAdminMenu() {
        try {

            while(true) {
                System.out.println("Choose an option : ");
                System.out.println("1 : Edit course details");
                System.out.println("2 : Generate report card");
                System.out.println("3 : Approve student registration");
                System.out.println("4 : Edit professor details");
                System.out.println("5 : View course student list");
                System.out.println("6 : Logout");

                int menuOption = sc.nextInt();
                sc.nextLine();

                switch(menuOption) {
                    case 1 :
                        editCourseDetails();
                        break;
                    case 2 :
                        generateReportCard();
                        break;
                    case 3:
                        approveStudentRegistration();
                        break;
                    case 4:
                        editProfessorDetails();
                        break;
                    case 5:
                        viewCourseStudentList();
                        break;
                    case 6:
                        return;
                    default:
                        System.out.println("Invalid input");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void viewCourseStudentList() {
        String courseID;
        System.out.println("Enter course ID: ");
        courseID = sc.nextLine();

        // to do : get students per course
    }

    private void editProfessorDetails() {
        String professorID;
        System.out.println("Enter professor ID: ");
        professorID = sc.nextLine();
        
        // to do : update details on user object, if user is professor
    }

    private void approveStudentRegistration() {
        String studentID;
        System.out.println("Enter student ID: ");
        studentID = sc.nextLine();

        // to do : approve student reg logic
    }

    private void generateReportCard() {
        String studentID;
        System.out.println("Enter student ID: ");
        studentID = sc.nextLine();

        // to do : get student courses and grade, and generate report card
    }

    private void editCourseDetails() {
        
        try {

            while(true) {
                System.out.println("Options : ");
                System.out.println("1 : Add course");
                System.out.println("2 : Remove course");
                System.out.println("3 : exit");

                int menuOption = sc.nextInt();
                sc.nextLine();

                switch(menuOption) {
                    case 1 :
                        addCourse();
                        break;
                    case 2 :
                        removeCourse();
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Invalid input");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void removeCourse() {
        String courseID;
        System.out.println("Enter course ID: ");
        courseID = sc.nextLine();
        
        // to do : remove course from db
    }

    private void addCourse() {

        String name, courseID, courseInstructor;
        int offeredSemester;

        System.out.println("Enter course details");
        System.out.println("Course name: ");
        name = sc.nextLine();
        System.out.println("Course ID: ");
        courseID = sc.nextLine();
        System.out.println("Course Instructor: ");
        courseInstructor = sc.nextLine();
        System.out.println("Semester : ");
        offeredSemester = sc.nextInt();
        sc.nextLine();
        
        // to do : create course object, update course in db
    }
}
