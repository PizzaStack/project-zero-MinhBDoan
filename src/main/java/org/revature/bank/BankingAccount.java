package org.revature.bank;

import java.util.Scanner;

public class BankingAccount {
	
	private double checkingbalance;
	private double savingsbalance;
	String username;
	String password;
	double amount;
	
	
	
	public BankingAccount(String user, String password){
		this.checkingbalance=0.0;
		this.savingsbalance=0.0;
		this.username = user;
		this.password = password;
	}
	
	public double getCheckingBalance() {
		System.out.println(checkingbalance);
		return checkingbalance;
	}
	public double getSavingsBalance() {
		System.out.println(savingsbalance);
		return savingsbalance;
	}
		
	void checkingbalancedeposit(double amount){
		if(amount >= 0) {
			checkingbalance = checkingbalance + amount;
			}
		else {
			System.out.println("Invalid Amount");
			}
		}
	void savingsbalancedeposit(double amount){
		if(amount >= 0) {
			savingsbalance = savingsbalance + amount;
			}
		else {
			System.out.println("Invalid Amount");
			}
		}
	void checkingbalancewithdraw(double amount) {
		if(amount <= checkingbalance) {
			checkingbalance = checkingbalance - amount;
		}
		else if(amount > checkingbalance){
			System.out.println("Overdrawing from account");
		}
		else{
			System.out.println("Invalid Amount");
		}
	}
	void savingsbalancewithdraw(double amount) {
		if(amount <= savingsbalance) {
			savingsbalance = savingsbalance - amount;
		}
		else if(amount > savingsbalance){
			System.out.println("Overdrawing from account");
		}
		else{
			System.out.println("Invalid Amount");
		}
	}
	
	
	
}

