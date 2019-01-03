package org.revature.bankEmployee;

import java.sql.SQLException;
import java.util.Scanner;

import org.revature.bank.App;
import org.revature.bank.BankAdmin;
import org.revature.bank.BankData;
import org.revature.bank.BankingAccount;

public class BankEmployee extends BankAdmin {


	public BankEmployee(){
		
	}
	
	public void UserApplicationStatus() throws SQLException {
		boolean quit = false;
		
		
		Scanner userinput = new Scanner(System.in);
		
		String customerTableStatement = "SELECT * FROM customer";
		String jointcustomerTableStatement= "SELECT * FROM jointcustomer";
				
		
		do {
			System.out.println("Press 1 to see customer accounts;");
			System.out.println("Press 2 to see joint accounts");
			System.out.println("Press 3 to change status of bank accounts");
			System.out.println("Press 0 to quit;");
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
			case 0:
				quit = true;
				App.DisplayMenu();
				break;
				
				default:
					System.out.println("You have entered something invalid");
					break;
			}
		}while(!quit);
		System.out.println("You successfully quitted");
		
	
	
	}
}