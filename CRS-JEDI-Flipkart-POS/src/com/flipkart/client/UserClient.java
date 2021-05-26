package com.flipkart.client;

import java.util.Scanner;

import com.flipkart.service.StudentOperation;

public class UserClient {
    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        UserClient newUser = new UserClient();
        newUser.createMenu();
    }

    private void createMenu() {
        try {
            while(true) {
                System.out.println("Choose an option: ");
                System.out.println("1 : Register a new user");
                System.out.println("2 : Login");
                System.out.println("3 : Exit menu");

                int menuOption = sc.nextInt();
                sc.nextLine();

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
        String username, password;

        try {
            System.out.println("Username: ");
            username = sc.nextLine();
            System.out.println("Password: ");
            password = sc.nextLine();

            // to do : verify Credentials, get role, create appropriate object
            // and launch menu

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void registerUser() {
        String username, password;

        try {
            while(true) {
                System.out.println("Register: ");
                System.out.println("1 : Student");
                System.out.println("2 : Exit registration");

                int userType = sc.nextInt();
                sc.nextLine();

                switch(userType) {
                    case 1:
                        registerStudent();
                        break;
                    case 2:
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

        String username, password, name, department, contact, joiningYear;
        StudentOperation so = new StudentOperation();

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
            System.out.println("Year of joining: ");
            joiningYear = sc.nextLine();
            System.out.println("Contact Number: ");
            contact = sc.nextLine();
            
            so.addStudent(username, name, password, department, contact, Integer.parseInt(joiningYear));
            
            System.out.println("User Added Successfully");

            // to do : create student bean

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
