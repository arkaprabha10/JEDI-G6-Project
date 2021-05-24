package com.flipkart.client;

import java.util.Scanner;

public class UserClient {
    public static void main(String[] args) {

        UserClient newUser = new UserClient();
        newUser.createMenu();
    }

    private void createMenu() {
        Scanner sc = new Scanner(System.in);

        try {
            while(true) {
                System.out.println("Choose an option: ");
                System.out.println("1 : Register a new user");
                System.out.println("2 : Login");
                System.out.println("3 : Exit menu");

                int menuOption = sc.nextInt();

                switch(menuOption) {
                    case 1:
                        registerUser();
                        break;

                    case 2:
                        loginUser();
                        break;

                    case 3:
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid input");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loginUser() {

        Scanner sc = new Scanner(System.in);
        String username, password;

        try {
            System.out.println("Username: ");
            username = sc.nextLine();
            System.out.println("Password: ");
            password = sc.nextLine();

            // to do : verify Credentials and create appropriate object

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void registerUser() {

        Scanner sc = new Scanner(System.in);
        String username, password;

        try {
            while(true) {
                System.out.println("Register: ");
                System.out.println("1 : Student");
                System.out.println("2 : Professor");
                System.out.println("3 : Admin");
                System.out.println("4 : Exit registration");

                int userType = sc.nextInt();

                switch(userType) {
                    case 1:
                        registerStudent();
                        break;
                    case 2:
//                        registerProfessor();
                        break;
                    case 3:
//                        registerAdmin();
                        break;
                    case 4:
//                        sc.close();
                        return;
                    default:
                        System.out.println("Invalid input");
                } 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void registerStudent() {

        Scanner sc = new Scanner(System.in);
        String username, password, name, department, studentID, joiningYear, address;
//        String role = ?

        try {

            System.out.println("Enter your details");
            System.out.println("Username: ");
            username = sc.nextLine();
            System.out.println("Password: ");
            password = sc.nextLine();
            System.out.println("Name: ");
            name = sc.nextLine();
            System.out.println("Department: ");
            department = sc.nextLine();
            System.out.println("Student ID: ");
            studentID = sc.nextLine();
            System.out.println("Year of joining: ");
            joiningYear = sc.nextLine();
            System.out.println("Address: ");
            address = sc.nextLine();

            // to do : create student bean

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    private void registerProfessor() {
//
//    }
//
//    private void registerAdmin() {
//
//    }
}
