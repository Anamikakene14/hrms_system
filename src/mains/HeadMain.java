package mains;

import java.util.List;
import java.util.Scanner;

import dao.UserDao;
import dao.UserDaoImpl;
import service.UserService;
import service.UserServiceImpl;
import models.User;

public class HeadMain {

    private static Scanner sc = new Scanner(System.in);
    private UserService userService = new UserServiceImpl();
    private UserDao userDao = new UserDaoImpl();

    public void HeadOperation() {
        while (true) {
            System.out.println("1. Sign In \n"
                    + "2. Create New Account \n"
                    + "3. Forget Password \n"
                    + "4. Exit");
            
            System.out.println();
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();  // Consume the newline

            switch (choice) {
                case 1:
                    System.out.println("Sign In");
                    System.out.print("Enter Your Email: ");
                    String email = sc.next();
                    System.out.print("Enter Your Password: ");
                    String password = sc.next();
                    System.out.println();

                    User users = userDao.signIn(email, password);

                    if (users != null ) {
                    	if("Head".equals(users.getRole())){
                        System.out.println("Welcome!, " + users.getName());
                        System.out.println("---------------------------------------");
                        System.out.println(users.getName() + " details:");
                        System.out.println("User ID : " +users.getUserId());
                        System.out.println("Email : " + users.getEmail());
                        System.out.println("Phone Number : " + users.getPhoneNumber());
                        System.out.println("Role : " + users.getRole());
                        System.out.println("----------------------------------------");

                        while (true) {
                            System.out.println("What You Want To Do \n\n"
                                    + "1. Register Admin \n"
                                    + "2. List Of All Admins \n"
                                    + "3. Search By Id \n"
                                    + "4. Delete Admin's Data \n"
                                    + "5. Change Password \n"
                                    + "6. Change Email \n"
                                    + "7. Log Out");
                            System.out.print("Enter your option: ");
                            int option = sc.nextInt();
                            sc.nextLine();  

                            switch (option) {
                                case 1:
                                    System.out.println("Register Admin's Data");
                                    User admin = new User();

                                    System.out.print("Enter Name: ");
                                    admin.setName(sc.next());

                                    System.out.print("Enter Email: ");
                                    admin.setEmail(sc.next());

                                    System.out.print("Enter Password: ");
                                    admin.setPassword(sc.next());

                                    System.out.print("Enter Contact Number: ");
                                    admin.setPhoneNumber(sc.next());

                                    admin.setRole("Admin");

                                    String response = userService.createAdmin(admin);
                                    System.out.println(response);
                                    break;

                                case 2:
                                    List<User> adminList = userService.getAllAdmin();
                                    System.out.println("List of All Admins:");

                                    for (User u : adminList) {
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
                                	System.out.print("Enter the Admin ID That You Want to Search: ");
                                	int userId = sc.nextInt();
                                	
                                	User userList = userService.searchById(userId);
                                	if (userList != null) {
                                        System.out.println("User ID: " + userList.getUserId());
                                        System.out.println("Name: " + userList.getName());
                                        System.out.println("Email: " + userList.getEmail());
                                        System.out.println("Phone Number: " + userList.getPhoneNumber());
                                        System.out.println("Role: " + userList.getRole());
                                    } else {
                                        System.out.println("User not found with ID: " + userId);
                                    }
                                	break;
                                	
                                case 4:
                                    System.out.println("Delete Admin");
                                    System.out.print("Enter the Admin ID That You Want to Delete: ");
                                    int adminId = sc.nextInt();

                                    String deleteMsg = userService.deleteAdmin(adminId);
                                    System.out.println(deleteMsg);
                                    break;

                                case 5:
                                	 System.out.println("Change Password");
                                     User user = new User();

                                     System.out.print("Enter Your ID: ");
                                     user.setUserId(sc.nextInt());

                                     System.out.print("Enter New Password: ");
                                     user.setPassword(sc.next());

                                     String changePasswordResponse = userService.updatePassword(user);
                                     System.out.println(changePasswordResponse);
                                     break;
                                     
                                case 6:
                                	System.out.println("Change Email");
                                	User userr = new User();
                                	
                                	System.out.print("Enter Your ID: ");
                                	userr.setUserId(sc.nextInt());
                                	
                                	System.out.print("Enter New Email : ");
                                	userr.setEmail(sc.next());
                                	
                                	String changeEmailResponse = userService.updateEmail(userr);
                                	System.out.println(changeEmailResponse);
                                	break;
                                	
                                case 7:
                                    System.out.println("Logging out... \n");
                                    return;

                                default:
                                    System.out.print("Invalid Option! Please try again.");
                            }

                            if (option == 7) {
                                break;  // Log out and return to the main menu
                            }

                        }
                    }else{
                        System.out.println("Access Denied! You are not authorized to perform Head operations.\"");
                    }
                    	
                    } else {
                        System.out.println("Invalid email or password! Please try again.");
                        
                    }
                    break;

                case 2:
                    System.out.println("Create New Account (Sign Up)");
                    User newUser = new User();

                    System.out.print("Enter Your Name: ");
                    newUser.setName(sc.next());

                    System.out.print("Enter Your Email: ");
                    newUser.setEmail(sc.next());

                    System.out.print("Enter Your Password: ");
                    newUser.setPassword(sc.next());

                    System.out.print("Enter Your Contact Number: ");
                    newUser.setPhoneNumber(sc.next());

                    System.out.print("Enter Your Role: ");
                    newUser.setRole(sc.next());

                    String signUpResponse = userService.signUp(newUser);
                    System.out.println(signUpResponse);
                    break;

                case 3:
                    System.out.println("Change Password");
                    User user = new User();

                    System.out.print("Enter Your ID: ");
                    user.setUserId(sc.nextInt());

                    System.out.print("Enter New Password: ");
                    user.setPassword(sc.next());

                    String changePasswordResponse = userService.updatePassword(user);
                    System.out.println(changePasswordResponse);
                    break;

                case 4:
                    System.out.println("Exiting... \n");
                    return;

                default:
                    System.out.println("Invalid Choice! Please Try Again.");
            }
            if(choice == 4) {
            	break;
            }
        }
    }

}
	