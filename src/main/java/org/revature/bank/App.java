package org.revature.bank;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	boolean quit = false;
    	Scanner input = new Scanner(System.in);    	
    	System.out.println("Log in username: ");
    	String username = input.next();
    	
    	
    	System.out.println("Type in password: ");
    	String password = input.next();
    	BankingAccount user = new BankingAccount(username, password);
    	if(username.equals(username) && password.equals(password)) {
    		System.out.println("Welcome " + username);
    		
    	}
    	
    	char option ='\0';
		Scanner scanner = new Scanner(System.in);
		
		
		System.out.println("A.Get Checking Balance");
		System.out.println("B.Get Savings Balance");
		System.out.println("C.Withdraw Checking");
		System.out.println("D.Withdraw Savings");
		System.out.println("E.Deposit Checking");
		System.out.println("F.Deposit Savings");
		System.out.println("G.Transfer to Checking");
		System.out.println("H.Transfer to Savings");
		System.out.println("I.Exit");
		
		do
		{
			System.out.println("===================================================");
			System.out.println("Enter Option");
			System.out.println("===================================================");
			option = scanner.next().charAt(0);
			System.out.println("\n");
			
		switch(option) {
		case 'A':
			System.out.println("-------------------------------------------------------");
			System.out.println("Checking Balance = " + user.getCheckingBalance());
			System.out.println("-------------------------------------------------------");
			break;
		case 'B':
			System.out.println("-------------------------------------------------------");
			System.out.println("Savings Balance = " + user.getSavingsBalance());
			System.out.println("-------------------------------------------------------");
			break;
		case 'C':
			System.out.println("-------------------------------------------------------");
			System.out.println("Enter Withdrawal Amount For Checking");
			System.out.println("-------------------------------------------------------");
			double amount = scanner.nextDouble();
			user.checkingbalancewithdraw(amount);
			System.out.println("\n");
			break;
		case 'D':
			System.out.println("-------------------------------------------------------");
			System.out.println("Enter Withdrawal Amount For Savings");
			System.out.println("-------------------------------------------------------");
			amount = scanner.nextDouble();
			user.savingsbalancewithdraw(amount);
			System.out.println("\n");
			break;
		case 'E':
			System.out.println("-------------------------------------------------------");
			System.out.println("Enter Deposit Amount into Checking");
			System.out.println("-------------------------------------------------------");
			amount = scanner.nextDouble();
			user.checkingbalancedeposit(amount);
			System.out.println("\n");
			break;
		case 'F':
			System.out.println("-------------------------------------------------------");
			System.out.println("Enter Deposit Amount into Savings");
			System.out.println("-------------------------------------------------------");
			amount = scanner.nextDouble();
			user.savingsbalancedeposit(amount);
			System.out.println("\n");
			break;
		case 'G':
			System.out.println("-------------------------------------------------------");
			System.out.println("Enter Transfer Amount");
			System.out.println("-------------------------------------------------------");
			amount = scanner.nextDouble();
			
			user.savingsbalancewithdraw(amount);
			user.checkingbalancedeposit(amount);
			System.out.println("\n");
			break;
		case 'H':
			System.out.println("-------------------------------------------------------");
			System.out.println("Enter Transfer Amount");
			System.out.println("-------------------------------------------------------");
			amount = scanner.nextDouble();

			user.savingsbalancedeposit(amount);
			user.checkingbalancewithdraw(amount);
			System.out.println("\n");
			break;
		case 'I':
			quit = true;
			break;

		default:
			System.out.println("Invalid Option. Please try again");
			break;
			
			}
		}while(quit !=true); 
			System.out.println("Thank you loyal customer!");
    }
    
}


