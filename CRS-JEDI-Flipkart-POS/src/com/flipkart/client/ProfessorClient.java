package com.flipkart.client;

import java.util.Scanner;

public class ProfessorClient {
    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ProfessorClient test = new ProfessorClient();
//        test.createProfessorMenu();
    }

    public void createProfessorMenu(String username) {
        try {

            while(true) {
                System.out.println("Choose an option : ");
                System.out.println("1 : View registered students");
                System.out.println("2 : View student details");
                System.out.println("3 : Show available courses");
                System.out.println("4 : Register for a course");
                System.out.println("5 : Logout");

                int menuOption = sc.nextInt();
                sc.nextLine();

                switch(menuOption) {
                    case 1 :
                        viewEnrolledStudents();
                        break;
                    case 2 :
                        viewStudentDetails();
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

    private void registerCourse() {

        String courseID;

        System.out.println("Enter course ID: ");
        courseID = sc.nextLine();

        // to do : register for course
    }

    private void viewAvailableCourses() {
        // to do : retrieve course details from db
    }

    private void viewStudentDetails() {

        String studentID;

        System.out.println("Enter student ID: ");
        studentID = sc.nextLine();

        // get students details/objects

        try {

            while(true) {
                System.out.println("Options: ");
                System.out.println("1 : Add grade");
                System.out.println("2 : exit");

                int menuOption = sc.nextInt();
                sc.nextLine();

                switch(menuOption) {
                    case 1 :
                        addGrade(studentID);
                        break;
                    case 2 :
                        return;
                    default:
                        System.out.println("Invalid input");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addGrade(String studentID) {

        String courseID;

        System.out.println("Enter course ID: ");
        courseID = sc.nextLine();

        // to do : verify both student and professor are registered to the course
        // modify registeredCourse grade
    }

    private void viewEnrolledStudents() {
        // to do : get student details from db, and print them
    }
}
