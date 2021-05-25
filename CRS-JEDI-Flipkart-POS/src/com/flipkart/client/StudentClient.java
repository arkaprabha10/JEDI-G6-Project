package com.flipkart.client;

import com.flipkart.bean.Student;

import java.util.Scanner;

public class StudentClient {
    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        StudentClient test = new StudentClient();
        test.createStudentMenu();
    }

    public void createStudentMenu() {

        try {

            while(true) {
                System.out.println("Choose an option : ");
                System.out.println("1 : View report card");
                System.out.println("2 : View registered courses");
                System.out.println("3 : Open semester registration dashboard");
                System.out.println("4 : Logout");

                int menuOption = sc.nextInt();
                sc.nextLine();

                switch(menuOption) {
                    case 1 :
                        viewGradeCard();
                        break;
                    case 2 :
                        viewRegisteredCourses();
                        break;
                    case 3:
                        createRegistrationDashboard();
                        break;
                    case 4:
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
                System.out.println("Semester registration : ");
                System.out.println("1 : View course details");
                System.out.println("2 : Add course");
                System.out.println("3 : Drop course");
                System.out.println("4 : Make a payment");
                System.out.println("5 : Finish registration and exit");

                int menuOption = sc.nextInt();
                sc.nextLine();

                switch(menuOption) {
                    case 1 :
                        viewCourseDetails();
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
    }

    private void payRegistrationFee() {
    }

    private void deleteCourse() {

        System.out.println("Delete Course");
        System.out.println("Enter course ID: ");

        String courseID = sc.nextLine();

        // to do : implementation of course deletion
    }

    private void addCourse() {

        System.out.println("Add Course");
        System.out.println("Enter course ID: ");

        String courseID = sc.nextLine();

        // to do : implementation of course deletion
    }

    private void viewCourseDetails() {
    }

    private void viewRegisteredCourses() {
    }

    private void viewGradeCard() {
    }
}
