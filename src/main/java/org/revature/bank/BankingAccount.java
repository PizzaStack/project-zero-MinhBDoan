package org.revature.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

public class BankingAccount extends BankData{
	
 

	 void LogIn() throws SQLException {
		Scanner userinput = new Scanner(System.in);
		String accountchoice;
		System.out.println("Enter s for single user; Enter j for joint account");
		accountchoice = userinput.next();
		
		String username;
		System.out.println("Enter username: ");
		username = userinput.next();
		
		String password;
		System.out.println("Enter password: ");
		password = userinput.next();
			
		String customertable = String.format("SELECT id, address, phonenumber, socialsecuritynumber, checkingbalance, savingbalance FROM customer WHERE username='%s' AND password = '%s'", username, password);
		String jointtable= String.format("SELECT id, address, phonenumber, socialsecuritynumber, jointaddress, jointphonenumber, jointsocialsecuritynumber, checkingbalance, savingbalance FROM jointcustomer WHERE username='%s' AND password = '%s'", username, password);
		
		Integer singlecheckingindex = 5;
		Integer singlesavingindex = 6;
		
		Integer jointcheckingindex = 8;
		Integer jointsavingindex= 9;
		
		if(accountchoice.equals("s")) {
		loggingIn(username, password, accountchoice, customertable, singlecheckingindex, singlesavingindex);
		}
		else if(accountchoice.equals("j") ) {
			
			loggingIn(username, password, accountchoice, jointtable, jointcheckingindex, jointsavingindex);
			
		}else {
				System.out.println("Invalid Choice");
			
		}	
	}
	
	
	@Override
	  List<Double> Transactions(List<Double> listbalance, Integer id, String accountchoice) throws SQLException {
		Scanner userinput = new Scanner(System.in);
		
		double amount;
		boolean quit = false;
		Double checkingbalance = listbalance.get(0);
		Double savingbalance = listbalance.get(1);
		
		do {
			System.out.println("Enter 1 to check checking balance.");
			System.out.println("Enter 2 to check saving balance.");
			System.out.println("Enter 3 to Withdraw from checking balance.");
			System.out.println("Enter 4 to Withdraw from saving balance.");
			System.out.println("Enter 5 to Deposit to checking balance.");
			System.out.println("Enter 6 to Deposit to saving balance.");
			System.out.println("Enter 7 to transfer funds from checking to savings.");
			System.out.println("Enter 8 to transfer funds from savings to checking.");
			System.out.println("Enter 0 to quit.");
			int key = userinput.nextInt();
			switch (key) {
			case 1:
				System.out.println("The checking balance is: " + checkingbalance);
				System.out.println();
				break;

			case 2:
				System.out.println("The saving balance is: " + savingbalance);
				System.out.println();
				break;


			case 3:
				System.out.println("Now enter the amount you would like to withdraw.");
				amount = userinput.nextDouble();
				if(amount<=0 || amount > checkingbalance) {
					System.err.println("Cannot run this transaction");
				}else {
				checkingbalance = checkingbalance - amount;

				}
				break;


			case 4:
				System.out.println("Now enter the amount you would like to withdraw.");
				amount = userinput.nextDouble();
				if(amount<=0 || amount > savingbalance) {
					System.err.println("Cannot run this transaction");
				}else {
				savingbalance = savingbalance - amount;
				}
				break;

			case 5:
				
				System.out.println("Now enter the amount you would like to deposit.");
				amount = userinput.nextDouble();
				if (amount <= 0) {
					System.err.println("Cannot enter a negative amount!");
				} else {
				checkingbalance= checkingbalance + amount;
				}
				break;
				

			case 6:
		
				System.out.println("Now enter the amount you would like to deposit.");
				amount = userinput.nextDouble();
				if (amount <= 0) {
					System.err.println("Cannot enter a negative amount!");
				} else {
				savingbalance = savingbalance + amount;
				}
				break;
				
			case 7: 
				
				System.out.println("Now enter the amount you would like to transfer");
				amount = userinput.nextDouble();
				if(amount <=0 || amount>checkingbalance) {
					System.err.println("Cannot run this transaction");
				}else {
				checkingbalance= checkingbalance -amount;
				savingbalance = savingbalance + amount;
				}
				break;
			case 8: 
				
				System.out.println("Now enter the amount you would like to transfer");
				amount = userinput.nextDouble();
				if (amount <= 0 || amount > savingbalance) {
					System.err.println("Cannot complete transaction.");
				} else {
				checkingbalance = checkingbalance + amount;
				savingbalance = savingbalance - amount;
				}
				break;
			case 0:
				
				quit = true;
				break;

			default:
				System.out.println("You have entered something invalid.");
				break;
			}
		} while (!quit);
		System.out.println("You have successfully quitted.");

		
		String singlebalancestatement ="UPDATE customer SET checkingbalance= '" + checkingbalance + "',savingbalance = '" + savingbalance + "' WHERE id = " + id;
		String jointbalancestatement ="UPDATE jointcustomer SET checkingbalance= '" + checkingbalance + "',savingbalance = '" + savingbalance + "' WHERE id = " + id;
		
		String displaysinglestatement = "SELECT checkingbalance, savingbalance FROM customer WHERE id = " + id;
		String displayjointstatement = "SELECT checkingbalance, savingbalance FROM jointcustomer WHERE id = " + id;
		
		if(accountchoice.equals("s")) {
		UpdateBalance(singlebalancestatement, displaysinglestatement);
		}else if(accountchoice.equals("j")) {
			UpdateBalance(jointbalancestatement, displayjointstatement);
		}else {
			System.out.println("Invalid Choice");
		}

		return listbalance;
		
	}


	

	
	
	
	
	
	
	
	
	
}

