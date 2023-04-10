package com.cognixia.jump.application;

import java.util.Scanner;

import com.cognixia.jump.controller.DollarsBankController;
import com.cognixia.jump.model.Account;
import com.cognixia.jump.utility.ConsolePrinterUtility;
import com.cognixia.jump.utility.ColorsUtility;

public class DollarsBankApplication {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String choice = "";

		boolean running = true;
		// main loop, will loop until app stops running
		while (running) {

			Account account = null;
			boolean loggedIn = false;

			// loop for welcome page
			while (!loggedIn) {
				ConsolePrinterUtility.printWelcome();
				System.out.println(ColorsUtility.GREEN + "Enter Choice (1, 2, or 3)" + ColorsUtility.RESET);

				choice = scan.nextLine();

				switch (choice) {
				case ("1"):
					account = DollarsBankController.newAccount(scan);
					if (account != null) {
						loggedIn = true;
					}
					break;

				case ("2"):
					account = DollarsBankController.login(scan);
					if (account != null) {
						loggedIn = true;
					}
					break;

				case ("3"):
					System.out.println(ColorsUtility.GREEN + "bye!" + ColorsUtility.RESET);
					scan.close();
					System.exit(0);
					break;

				default:
					System.out.println(ColorsUtility.RED + "Invalid Option! Try again." + ColorsUtility.RESET);
				}
				 
			}

			// loop for login in page
			while (loggedIn) {

				ConsolePrinterUtility.printMain();
				System.out.println(ColorsUtility.GREEN + "Enter Choice (1, 2, 3, 4, 5, or 6)" + ColorsUtility.RESET);
				choice = scan.nextLine();

				switch (choice) {
				case ("1"):
					System.out.println("Enter Deposit amount:");
					account.deposit(scan.nextFloat());
					scan.nextLine();
					break;

				case ("2"):
					System.out.println("Enter Withdraw amount:");
					account.withdraw(scan.nextFloat());
					scan.nextLine();
					break;

				case ("3"):
					System.out.println("Enter Account Id to transfer to:");
					String transferTo = scan.nextLine();

					System.out.println("Enter amount to transfer:");
					float amount = scan.nextFloat();
					scan.nextLine();

					account.transfer(amount, transferTo);
					break;

				case ("4"):
					account.viewTransactions();
					break;

				case ("5"):
					account.displayCustomer();
					break;

				case ("6"):
					System.out.println(ColorsUtility.GREEN + "bye!" + ColorsUtility.RESET);
					account = null;
					loggedIn = false;
					break;
				}
			}
		}
	}
}
