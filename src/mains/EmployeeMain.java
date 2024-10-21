package mains;

import java.util.Scanner;

import models.Employee;
import models.User;
import service.UserService;
import service.EmployeeService;
import service.UserServiceImpl;
import service.EmployeeServiceImpl;
import dao.UserDao;
import dao.UserDaoImpl;

public class EmployeeMain {
	Scanner sc = new Scanner(System.in);
	private UserService userService = new UserServiceImpl();
	private EmployeeService empService = new EmployeeServiceImpl();
	UserDao userDao = new UserDaoImpl();
	Employee emp = new Employee();
	
	
	public void EmployeeOperation() {
	    while (true) {
	        System.out.println("1. Sign In \n"
	                + "2. Forget Password \n"
	                + "3. Exit \n");

	        System.out.print("Enter Choice : ");
	        int choice = sc.nextInt();
	        switch (choice) {
	            case 1:
	                System.out.print("Enter Your Email: ");
	                String email = sc.next();
	                System.out.print("Enter Your Password: ");
	                String password = sc.next();
	                System.out.println();

	                User users = userDao.signIn(email, password);
	                if (users != null) {
	                    if ("Employee".equals(users.getRole())) {
	                        emp = empService.getAllEmployee(users.getUserId()); // Fetch employee details

	                        if ("Active".equalsIgnoreCase(emp.getStatus())) { // Check if the employee is active
	                            System.out.println("Welcome!, " + users.getName());
	                            System.out.println("---------------------------------------");
	                            System.out.println("User ID : " + users.getUserId());
	                            System.out.println("Employee ID : " + emp.getEmpId());
	                            System.out.println("Name : " + users.getName());
	                            System.out.println("Email: " + users.getEmail());
	                            System.out.println("Phone Number: " + users.getPhoneNumber());
	                            System.out.println("Role: " + users.getRole());
	                            System.out.println("Salary : " + emp.getSalary());
	                            System.out.println("Address : " + emp.getAddress());
	                            System.out.println("Department : " + emp.getDepartment());
	                            System.out.println("Status : " + emp.getStatus());
	                            System.out.println("----------------------------------------");

	                            while (true) {
	                                System.out.println("What You Want To Do \n\n"
	                                        + "1. Change Email \n"
	                                        + "2. Change Password \n"
	                                        + "3. Change Address \n"
	                                        + "4. Change Number \n"
	                                        + "5. Log Out");

	                                System.out.println();
	                                System.out.print("Enter your option: ");
	                                int option = sc.nextInt();
	                                sc.nextLine();

	                                switch (option) {
	                                    case 1:
	                                        System.out.println("Change Email");
	                                        User userr = new User();

	                                        System.out.print("Enter Your User ID: ");
	                                        userr.setUserId(sc.nextInt());

	                                        System.out.print("Enter New Email : ");
	                                        userr.setEmail(sc.next());

	                                        String changeEmailResponse = userService.updateEmail(userr);
	                                        System.out.println(changeEmailResponse);
	                                        break;

	                                    case 2:
	                                        System.out.println("Change Password");
	                                        User user = new User();

	                                        System.out.print("Enter Your User ID: ");
	                                        user.setUserId(sc.nextInt());

	                                        System.out.print("Enter New Password: ");
	                                        user.setPassword(sc.next());

	                                        String changePasswordResponse = userService.updatePassword(user);
	                                        System.out.println(changePasswordResponse);
	                                        break;

	                                    case 3:
	                                        System.out.println("Change Address");
	                                        Employee empUpdate = new Employee();

	                                        System.out.print("Enter Your Employee ID: ");
	                                        empUpdate.setEmpId(sc.nextInt());

	                                        System.out.print("Enter New Address: ");
	                                        empUpdate.setAddress(sc.next());

	                                        String changeAddress = empService.changeAddress(empUpdate);
	                                        System.out.println(changeAddress);
	                                        break;

	                                    case 4:
	                                    	System.out.println("Change Address");
	                                        User empNumber = new User();

	                                        System.out.print("Enter Your User ID: ");
	                                        empNumber.setUserId(sc.nextInt());

	                                        System.out.print("Enter New Number: ");
	                                        empNumber.setPhoneNumber(sc.next());

	                                        String changeNumber = empService.changeNumber(empNumber);
	                                        System.out.println(changeNumber);
	                                        break;
	                                    case 5:
	                                        break; // Log out

	                                    default:
	                                        System.out.println("Invalid option. Please try again.");
	                                        break;
	                                }
	                            }
	                        } else {
	                            System.out.println("Your account is not active. Please contact the admin.");
	                        }

	                    } else {
	                        System.out.println("Access Denied! You are not authorized to perform employee operations.\n");
	                    }
	                } else {
	                    System.out.println("Invalid email or password! Please try again.");
	                }
	                break;

	            case 2:
	                System.out.println("Change Password");
	                User user = new User();

	                System.out.print("Enter Your ID: ");
	                user.setUserId(sc.nextInt());

	                System.out.print("Enter New Password: ");
	                user.setPassword(sc.next());

	                String changePasswordResponse = userService.updatePassword(user);
	                System.out.println(changePasswordResponse);
	                break;

	            case 3:
	                return;
	        }
	    }
	}

}
