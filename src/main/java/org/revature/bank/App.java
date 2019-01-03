package org.revature.bank;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.revature.bankEmployee.BankEmployee;


public class App 
{
	public static void main(String[] args) throws SQLException{
		DisplayMenu();
	}
	public static void DisplayMenu() throws SQLException {
        Scanner userInput = new Scanner(System.in);
        String READ_MENU;
        boolean quit = false;
     do {   
        System.out.println("____________________________________________");
        System.out.println("|  *****   Welcome to Bank World   ******  |");
        System.out.println("____________________________________________");
        System.out.println("| Options:                                 |");
        System.out.println("|        1. Create Single User Bank Account|");
        System.out.println("|        2. Create Joint User Bank Account |");
        System.out.println("|        3. Log In                         |");
        System.out.println("|        4. Employee                       |");
        System.out.println("|        5. Bank Admin                     |");
        System.out.println("|        6. Delete All Database Records    |");
        System.out.println("|        7. Exit                           |");
        System.out.println("____________________________________________");

        System.out.print("Select option: ");

        READ_MENU = userInput.next();


        switch (READ_MENU) {
            case "1":
                BankingAccount bankingaccount = new BankingAccount();
                bankingaccount.createAccount();
                break;
            case "2":
            	BankingAccount jointaccount = new BankingAccount();
            	jointaccount.createJointAccount();
                break;
            case "3":
            	BankingAccount login = new BankingAccount();
            	login.LogIn();
                break;
            case "4":
                BankEmployee bankemployee = new BankEmployee();
                bankemployee.UserApplicationStatus();
                break;
            case "5":
                BankAdmin bankadmin = new BankAdmin();
                bankadmin.ManageAccounts();
                break;
            case "6":
                System.out.println("Deletion of all databases from server successful");
                break;
            case "7":
            	System.out.println("See you soon!");
            	quit = true;
                System.exit(0);
                break;
            default:
                System.out.println("Invalid selection");
                break;
        }
        }while(!quit);
        	
        
        
    }
}



