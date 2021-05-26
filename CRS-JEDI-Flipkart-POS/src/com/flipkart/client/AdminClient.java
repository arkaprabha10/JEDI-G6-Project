package com.flipkart.client;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AdminClient {
    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        AdminClient test = new AdminClient();
//        test.createAdminMenu();
    }

    public void createAdminMenu(String username) {
        try {

            while(true) {
            	System.out.println("==~~=~~=~~=~~=~Admin Panel~=~~=~~=~~=~~==");
                System.out.println("Choose an option : ");
                System.out.println("1 : Edit course details");
                System.out.println("2 : Generate report card");
                System.out.println("3 : Approve student registration");
                System.out.println("4 : Edit professor details");
                System.out.println("5 : View course student list");
                System.out.println("6 : Logout");
                System.out.println("=======================================");

                int menuOption = sc.nextInt();
                sc.nextLine();

                switch(menuOption) {
                    case 1 :
                        editCourseList();
                        break;
                    case 2 :
                        generateReportCard();
                        break;
                    case 3:
                        approveStudentRegistration();
                        break;
                    case 4:
                        editProfessorList();
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

    private void editProfessorList() {

        String professorID;
        System.out.println("Enter new/existing professor ID: ");

        professorID = sc.nextLine();

        try {

            while(true) {
            	System.out.println("=======================================");
                System.out.println("Options : ");
                System.out.println("1 : Add professor details");
                System.out.println("2 : Update professor details");
                System.out.println("3 : Remove professor");
                System.out.println("4 : Exit");
                System.out.println("=======================================");

                int menuOption = sc.nextInt();
                sc.nextLine();

                switch(menuOption) {
                    case 1 :
                        addProfessorDetails(professorID);
                        break;
                    case 2 :
                        updateProfessorDetails(professorID);
                        break;
                    case 3:
                        removeProfessor(professorID);
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

        // to do : update details on user object, if user is professor
    }

    private void removeProfessor(String professorID) {
        try {

            System.out.println("Remove " + professorID + " from list?");
            System.out.println("0 : No");
            System.out.println("1 : Yes");

            int menuOption = sc.nextInt();
            sc.nextLine();

            switch (menuOption) {
                case 0:
                    return;
                case 1:
                    // remove from db
                    break;
                default:
                    System.out.println("Invalid input");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateProfessorDetails(String professorID) {

        // to do : get professor object from db (try block)

        try {

            while(true) {
            	System.out.println("=======================================");
                System.out.println("Select field to edit: ");
                System.out.println("1 : Name");
                System.out.println("2 : Department");
                System.out.println("3 : Designation");
                System.out.println("4 : Save and Exit");
                System.out.println("=======================================");

                int menuOption = sc.nextInt();
                sc.nextLine();

                switch(menuOption) {
                    case 1 :
                        String newName;
                        System.out.println("Enter new name: ");
                        newName = sc.nextLine();
                        // to do : update field in obj
                        break;
                    case 2 :
                        String newDepartment;
                        System.out.println("Enter new department: ");
                        newDepartment = sc.nextLine();
                        // to do : update field in obj
                        break;
                    case 3:
                        String newDesignation;
                        System.out.println("Enter new designation: ");
                        newDesignation = sc.nextLine();
                        // to do : update field in obj
                        break;
                    case 4:
                        // to do : update db with new object
                        return;
                    default:
                        System.out.println("Invalid input");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addProfessorDetails(String professorID) {

        try {

            String name, password, department, designation, dateOfJoining;
            Date dojObj;
            
            System.out.println("=======================================");
            System.out.println("Enter professor details");
            System.out.println("Name: ");
            name = sc.nextLine();
            System.out.println("Password: ");
            password = sc.nextLine();
            System.out.println("Department: ");
            department = sc.nextLine();
            System.out.println("Designation: ");
            designation = sc.nextLine();
            System.out.println("Date of Joining (dd/MM/yyyy): ");
            dateOfJoining = sc.nextLine();
            System.out.println("=======================================");

            dojObj = new SimpleDateFormat("dd/MM/yyyy").parse(dateOfJoining);

            // to do : create professor obj, and add to db

        } catch (Exception e) {
            e.printStackTrace();
        }
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

    private void editCourseList() {
        
        try {

            while(true) {
            	System.out.println("=======================================");
                System.out.println("Options : ");
                System.out.println("1 : Add course");
                System.out.println("2 : Remove course");
                System.out.println("3 : Exit");
                System.out.println("=======================================");

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
        System.out.println("=======================================");
        System.out.println("Enter course ID: ");
        courseID = sc.nextLine();
        
        // to do : remove course from db
    }

    private void addCourse() {

        try{
            String name, courseID, courseInstructor;
            int offeredSemester;
            
            System.out.println("=======================================");
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
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
