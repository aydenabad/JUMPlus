package com.cognixia.jump.utility;

import com.cognixia.jump.utility.ColorsUtility;

public class ConsolePrinterUtility {
	
	// welcome
	public static void printWelcome() {
		System.out.println(ColorsUtility.CYAN + "+---------------------------+");
		System.out.println("| DOLLARSBANK Welcomes You! |");
		System.out.println("+---------------------------+");
		System.out.println("1. Create New Account");
		System.out.println("2. Login");
		System.out.println("3. Exit" + ColorsUtility.RESET);
	}
	
	// new account
	public static void printNewAccount() {
		System.out.println(ColorsUtility.CYAN + "+-------------------------------+");
		System.out.println("| Enter Details For New Account |");
		System.out.println("+-------------------------------+" + ColorsUtility.RESET);
	}
	
	
	// login
	public static void printLogin() {
		System.out.println(ColorsUtility.CYAN + "+---------------------+");
		System.out.println("| Enter Login Details |");
		System.out.println("+---------------------+" + ColorsUtility.RESET);
	}
	
	// main
	public static void printMain() {
		System.out.println(ColorsUtility.CYAN + "+------------------------+");
		System.out.println("| WELCOME Customer ! ! ! |");
		System.out.println("+------------------------+");
		System.out.println("1. Deposit Amount");
		System.out.println("2. Withdraw Amount");
		System.out.println("3. Funds Transfer");
		System.out.println("4. View 5 Recent Transactions");
		System.out.println("5. Display Customer Information");
		System.out.println("6. Sign Out" + ColorsUtility.RESET);
	}
	
	
	// recent transactions
	public static void printTransactions() {
		System.out.println(ColorsUtility.CYAN + "+----------------------+");
		System.out.println("| Recent Transactions: |");
		System.out.println("+----------------------+" + ColorsUtility.RESET);
	}
	
}
