package mains;

import java.util.List;
import java.util.Scanner;

import dao.UserDao;
import dao.AdminDao;
import dao.UserDaoImpl;
import dao.AdminDaoImpl;
import models.Employee;
import models.User;
import service.UserService;
import service.AdminService;
import service.UserServiceImpl;
import service.AdminServiceImpl;
import service.EmployeeService;
import service.EmployeeServiceImpl;
import dao.EmployeeDao;
import dao.EmployeeDaoImpl;

public class AdminMain {
	
	private static	Scanner sc = new Scanner(System.in);
	private UserService userService = new UserServiceImpl();
	private UserDao userDao = new UserDaoImpl();
	private AdminService adminService = new AdminServiceImpl();
	private AdminDao adminDao = new AdminDaoImpl();
	private EmployeeDao empDao = new EmployeeDaoImpl();
	private EmployeeService empService = new EmployeeServiceImpl();
	
	public void AdminOperation() {
		while(true) {
			System.out.println("1. Sign In \n"
					+"2. Forget Password \n"
					+"3. Exit \n");

			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
				case 1:
					System.out.println("Sign In ");
					System.out.print("Enter Your Email: ");
					String email = sc.next();
					System.out.print("Enter Your Password: ");
					String password = sc.next();
					System.out.println();
					
					User users = userDao.signIn(email, password);
					
					if (users != null) {
						if("Admin".equals(users.getRole())) {
							System.out.println("Welcome, " + users.getName());
							System.out.println("---------------------------------------");
							System.out.println(users.getName() + " details:");
							System.out.println("User ID : " +users.getUserId());
							System.out.println("Email: " + users.getEmail());
							System.out.println("Phone Number: " + users.getPhoneNumber());
							System.out.println("Role: " + users.getRole());
							System.out.println("----------------------------------------");

							while(true) {
								System.out.println("What You Wnat To Do \n\n"
										+"1. Register Employee \n"
										+"2. Get All Employees \n"
										+"3. Delete Employee \n"
										+"4. Change Password \n"
										+"5. Change Email \n"
										+"6. Change Employee Status \n"
										+"7. Log Out \n");
								
								System.out.print("Enter Choice: ");
								
								int option = sc.nextInt();
								switch(option) {
									case 1: 
										System.out.println();
										System.out.println("You Want To Register Employee's Data, okk! \n");
										User employee = new User();
										
										System.out.print("Enter Name: ");
										employee.setName(sc.next());
										
										System.out.print("Enter Email: ");
										employee.setEmail(sc.next());
										
										System.out.println("Enter Password: ");
										employee.setPassword(sc.next());
										
										System.out.println("Enter Contact Number: ");
										employee.setPhoneNumber(sc.next());
										
										employee.setRole("Employee"); // Fixed role to Employee

										// Add user (employee) to users table
										int userId = adminService.createEmployee(employee);
										if(userId > 0) {
											Employee emp = new Employee();
											System.out.println("Employee registered with user_id: " + userId);

											// Now add additional employee details
											emp.setUserId(userId);
											
											System.out.println("Enter Salary: ");
											emp.setSalary(sc.nextDouble());
											
											System.out.println("Enter Address: ");
											emp.setAddress(sc.next());
											
											System.out.println("Enter Department: ");
											emp.setDepartment(sc.next());
											
											System.out.println("Enter Gender: ");
											emp.setGender(sc.next());
											
											// Status enum constraint - ensure only 'Active' or 'Inactive'
											System.out.println("Enter Status (Active/Inactive): ");
											String status = sc.next();
											if ("Active".equalsIgnoreCase(status) || "Inactive".equalsIgnoreCase(status)) {
												emp.setStatus(status);
											} else {
												System.out.println("Invalid status. Setting to default: 'Active'.");
												emp.setStatus("Active");
											}

											// Create employee entry in employee table
											String anss = empService.createEmployee(emp);
											System.out.println(anss);
										}
										break;
									
									case 2:
										List<User> allEmployees = adminService.getAllEmployee();
										System.out.println("List of All Employees:");
										
										for(User u : allEmployees) {
											System.out.println("-----------------------------");
											System.out.println("User Id : " + u.getUserId());
											System.out.println("Name : " + u.getName());
											System.out.println("Email : " + u.getEmail());
											System.out.println("Contact Number : " + u.getPhoneNumber());
											System.out.println("Role : " + u.getRole());
											System.out.println("-----------------------------");
										}
										break;
										
									case 3:
										System.out.println("Oh! You Want To Delete Employee");
										
										System.out.print("Enter the Employee ID That You Want to Delete: ");
										int empId = sc.nextInt();
										
										String deleteMsg = adminService.deleteEmployee(empId);
										System.out.println(deleteMsg);
										break;
									
									case 4:
										System.out.println("Change Password");
	                                     User user = new User();

	                                     System.out.print("Enter Your ID: ");
	                                     user.setUserId(sc.nextInt());

	                                     System.out.print("Enter New Password: ");
	                                     user.setPassword(sc.next());

	                                     String changePasswordResponse = userService.updatePassword(user);
	                                     System.out.println(changePasswordResponse);
	                                     break;
	                                    
									case 5:
										System.out.println("Change Email");
	                                	User userr = new User();
	                                	
	                                	System.out.print("Enter Your ID: ");
	                                	userr.setUserId(sc.nextInt());
	                                	
	                                	System.out.print("Enter New Email : ");
	                                	userr.setEmail(sc.next());
	                                	
	                                	String changeEmailResponse = userService.updateEmail(userr);
	                                	System.out.println(changeEmailResponse);
	                                	break;
	                                
									case 6:
										System.out.println("Change Status");
	                                	Employee emp = new Employee();
	                                	
	                                	System.out.print("Enter Your User ID: ");
	                                	emp.setUserId(sc.nextInt());
	                                	
	                                	System.out.print("Enter Status : ");
	                                	emp.setStatus(sc.next());
	                                	
	                                	String changeStatus = empService.updateStatus(emp);
	                                	System.out.println(changeStatus);
	                                	break;
	                                	
									case 7:
									return;
								}
							}
						} else {
							System.out.println("Access Denied! You are not authorized to perform admin operations.");
						}
					} else {
						System.out.println("Invalid email or password! Please try again.");
					}
					break;
					
				case 2:
					System.out.println("You Want To Change Your Password");
					User u = new User();
					
					System.out.print("Enter Your ID:");
					u.setUserId(sc.nextInt());
					
					System.out.print("Enter New Password:");
					u.setPassword(sc.next());
					
					String changePasswordMessage = userService.updatePassword(u);
					System.out.println(changePasswordMessage);
					break;
				
				case 3: 
					return;
					
				default:
					System.out.println("Invalid Choice! Please Try Again.");
			}

		}
	}
}
