package mains;

import java.util.Scanner;

public class MainMenu {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HeadMain headStuff = new HeadMain();
		AdminMain adminStuff = new AdminMain();
		EmployeeMain empStuff = new EmployeeMain();
		
		while(true) {
			System.out.println("!! Welcom To HRMS System !! \n\n"
					+"1. You Are Head. \n"
					+"2. You Are Admin. \n"
					+"3. You Are Employee. \n");
			

			System.out.print("Enter Your Choice : ");
			int choice = sc.nextInt();
			switch(choice) {
			
			case 1:
				headStuff.HeadOperation();
				break;
				
			case 2:
				adminStuff.AdminOperation();
				break;
				
			case 3:
				empStuff.EmployeeOperation();
				break;
				
			default:
				System.out.println("Invalid Choice ! Please Try Again..");
			}
		}
	}
}
