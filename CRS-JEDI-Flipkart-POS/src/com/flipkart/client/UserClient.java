package com.flipkart.client;

import java.util.Scanner;

import com.flipkart.service.StudentOperation;
import com.flipkart.service.UserOperation;

public class UserClient {
    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        UserClient newUser = new UserClient();
        newUser.createMenu();
    }

    private void createMenu() {
        try {
            while(true) {
            	System.out.println("\n\n==~~=~~=~~=~~=~~=~CRS~=~~=~~=~~=~~=~~==");
                System.out.println("Choose an option: ");
                System.out.println("---------------------------------------");
                System.out.println("1 : Register a new user");
                System.out.println("2 : Login");
                System.out.println("3 : Exit menu");
                System.out.println("=======================================");

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
        String username, password, role;

        try {
        	System.out.println("=======================================");
            System.out.print("Username: ");
            username = sc.nextLine();
            System.out.print("Password: ");
            password = sc.nextLine();
            System.out.print("Enter Role (Student/Professor/Admin): ");
            role = sc.nextLine();
            
            UserOperation uo = new UserOperation();
            
            if(uo.loginUser(username, password, role))
            {
            	if(role.equals("Student"))
            	{
            		System.out.println("=======================================");
            		System.out.println("Logged In Succesully as a Student");
            		StudentClient sc = new StudentClient();
            		sc.createStudentMenu(username);
            		return;
            	}
            	else if(role.equals("Professor"))
            	{
            		System.out.println("=======================================");
            		System.out.println("Logged In Succesully as a Professor");
            		ProfessorClient pc = new ProfessorClient();
            		pc.createProfessorMenu(username);
            		return;
            	}
            	else if(role.equals("Admin"))
            	{
            		System.out.println("=======================================");
            		System.out.println("Logged In Succesully as a Admin");
            		AdminClient ac = new AdminClient();
            		ac.createAdminMenu(username);
            		return;
            	}
            	else
            	{
            		System.out.println("Invalid Role");
            		System.out.println("=======================================");
            	}
            		
            }
            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void registerUser() {
        String username, password;

        try {
            while(true) {
            	System.out.println("=======================================");
                System.out.println("Register: ");
                System.out.println("---------------------------------------");
                System.out.println("1 : Student");
                System.out.println("2 : Exit registration");
                System.out.println("=======================================");

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
        	System.out.println("=======================================");
            System.out.println("Enter your details");
            System.out.println("---------------------------------------");
            System.out.print("Username: ");
            username = sc.nextLine();
            System.out.print("Password: ");
            password = sc.nextLine();
            System.out.print("Name: ");
            name = sc.nextLine();
            System.out.print("Department: ");
            department = sc.nextLine();
            System.out.print("Year of joining: ");
            joiningYear = sc.nextLine();
            System.out.print("Contact Number: ");
            contact = sc.nextLine();
            System.out.println("=======================================");
            
            so.addStudent(username, name, password, department, contact, Integer.parseInt(joiningYear));
            
            System.out.println("User Added Successfully");
            System.out.println("=======================================");

            // to do : create student bean

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
