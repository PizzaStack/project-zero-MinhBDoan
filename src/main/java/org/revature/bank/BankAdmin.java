package org.revature.bank;

import java.sql.SQLException;
import java.util.Scanner;



public class BankAdmin extends BankingAccount {
	public BankAdmin() {
		
	}
	
	void ManageAccounts() throws SQLException {
		boolean quit = false;
		
		
		Scanner userinput = new Scanner(System.in);
		
		Integer id=null;
		String customerTableStatement = "SELECT * FROM customer";
		String jointcustomerTableStatement= "SELECT * FROM jointcustomer";
		
		String cancelCustomerStatement =  "DELETE FROM customer WHERE id = " + id;
		String cancelJointStatement =  "DELETE FROM jointcustomer WHERE id = " + id;
		String displaystatement;
		
		
		
		do {
			System.out.println("Enter 1 to view customer accounts: ");
			System.out.println("Enter 2 to view joint customer accounts: ");
			System.out.println("Enter 3 manage bank account status: ");
			System.out.println("Enter 4 manage bank account balances: ");
			System.out.println("Enter 5 to cancel customer accounts: ");
			System.out.println("Enter 6 to cancel joint customer accounts: ");
			System.out.println("Enter 0 to exit");
			Integer key = userinput.nextInt();
			
			switch(key) {
			case 1: 
				AccountLookUp(customerTableStatement);
				break;
			case 2:
				AccountLookUp(jointcustomerTableStatement);
				break;
			case 3:
				ChangeStatus();
				break;
			case 4:
				LogIn();
				break;
			case 5:
				System.out.println("Enter customer id to delete: ");
	            id = userinput.nextInt();
	            cancelCustomerStatement =  "DELETE FROM customer WHERE id = " + id;
				CancelAccount(cancelCustomerStatement);
				break;
			
			case 6:
				System.out.println("Enter joint customer id to delete: ");
	            id = userinput.nextInt();
	            cancelJointStatement =  "DELETE FROM jointcustomer WHERE id = " + id;
				CancelAccount(cancelJointStatement);
				break;
			case 0:
				quit = true;
				App.DisplayMenu();
				break;
			default:
				System.out.println("Invalid option");
				break;
		}
		}while(!quit);
		System.out.println("You have successfully quitted");
		App.DisplayMenu();
	}
	protected void ChangeStatus() throws SQLException {
		boolean quit = false;
		Scanner userinput = new Scanner(System.in);
		String ApprovedStatus = "Approved";
		String DeniedStatus = "Denied";
		String displaystatement;
		Integer id;
		
		do {
			System.out.println("Enter 1 to approve customer accounts: ");
			System.out.println("Enter 2 to deny customer accounts: ");
			System.out.println("Enter 3 to approve joint customer accounts: ");
			System.out.println("Enter 4 to deny joint customer accounts: ");
			System.out.println("Enter 0 to exit");
			Integer key = userinput.nextInt();
			switch(key) {
			case 1:
				System.out.println("Enter customer id number: ");
				 id = userinput.nextInt();
				 String approveCustomerStatement = "UPDATE customer SET status= '" + ApprovedStatus + "' WHERE id = " + id;
				 displaystatement = "SELECT id,username, status FROM customer WHERE id = " + id;
				StatusUpdate(approveCustomerStatement, displaystatement);
				break;
			case 2:
				System.out.println("Enter customer id number: ");
				 id = userinput.nextInt();
				 String denyCustomerStatement = "UPDATE customer SET status= '" + DeniedStatus + "' WHERE id = " + id;
				 displaystatement = "SELECT id, username, status FROM customer WHERE id = " + id;
				StatusUpdate(denyCustomerStatement, displaystatement);
				break;
			case 3:
				System.out.println("Enter joint customer id number: ");
				 id = userinput.nextInt();
				 String approveJointStatement = "UPDATE jointcustomer SET status= '" + ApprovedStatus + "' WHERE id = " + id;
				 displaystatement = "SELECT id, username, status FROM jointcustomer WHERE id = " + id;
				StatusUpdate(approveJointStatement, displaystatement);
				break;
			case 4:
				System.out.println("Enter joint customer id number: ");
				 id = userinput.nextInt();
				 String denyJointStatement = "UPDATE jointcustomer SET status= '" + DeniedStatus + "' WHERE id = " + id;
				 displaystatement = "SELECT id, username, status FROM jointcustomer WHERE id = " + id;
				StatusUpdate(denyJointStatement, displaystatement);
				break;
			case 0:
				quit = true;
				break;
			}
		}while(!quit);
			System.out.println("You have successfully quitted.");
			
	}
}
