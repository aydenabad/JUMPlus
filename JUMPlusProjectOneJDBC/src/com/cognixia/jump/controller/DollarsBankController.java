package com.cognixia.jump.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.cognixia.jump.dao.AccountDaoSQL;
import com.cognixia.jump.exception.AccountAlreadyExistsException;
import com.cognixia.jump.exception.AccountNotFoundException;
import com.cognixia.jump.exception.EmptyInputException;
import com.cognixia.jump.model.Account;
import com.cognixia.jump.model.Customer;
import com.cognixia.jump.utility.ColorsUtility;

public class DollarsBankController {
	
	public static AccountDaoSQL accountDaoSQL = new AccountDaoSQL();

	public static Account newAccount(Scanner scan) {

		System.out.println(ColorsUtility.CYAN + "+------------------------------+");
		System.out.println("| Enter Detail For New Account |");
		System.out.println("+------------------------------+" + ColorsUtility.RESET);

		System.out.println("Customer Name:");
		String name = scan.nextLine();

		System.out.println("Customer Address:");
		String address = scan.nextLine();

		System.out.println("Customer Contact Number:");
		String number = scan.nextLine();

		String id = "";
		while (true) {
			System.out.println("User Id:");

			try {
				id = scan.nextLine();
				if (accountDaoSQL.getAccountByID(id) != null && accountDaoSQL.getAccountByID(id).getCustomer() != null) {
					System.out.println( accountDaoSQL.getAccountByID(id).getCustomer().toString() );
					throw new AccountAlreadyExistsException(id);
				}
				if (id.length() == 0) {
					throw new EmptyInputException();
				}
				break;

			} catch (AccountAlreadyExistsException e) {
				System.out.println(e.getMessage());
			} catch (EmptyInputException e) {
				System.out.println(e.getMessage());
			}

		}

		System.out.println("Password:");
		String password = scan.nextLine();

		float initialDeposit = 0;
		while (true) {

			System.out.println("Initial Deposit Amount:");

			try {
				initialDeposit = scan.nextFloat();
				if (initialDeposit < 0) {
					throw new Exception();
				}
				break;

			} catch (InputMismatchException e) {
				scan.nextLine();
				System.out.println(ColorsUtility.RED + "Invalid deposit amount! Try Again!" + ColorsUtility.RESET);
			} catch (Exception e) {
				scan.nextLine();
				System.out.println(ColorsUtility.RED + "Initial deposit must be non-negative!" + ColorsUtility.RESET);
			}

		}
		scan.nextLine();

		Customer newCustomer = new Customer(name, address, number, id, password, initialDeposit);
		Account newAccount = new Account(initialDeposit, newCustomer);

		return newAccount;
	}

	public static Account login(Scanner scan) {
		System.out.println(ColorsUtility.CYAN + "+---------------------+");
		System.out.println("| Enter Login Details |");
		System.out.println("+---------------------+" + ColorsUtility.RESET);

		System.out.println("User Id :");
		String id = scan.nextLine();

		System.out.println("Password :");
		String password = scan.nextLine();

		try {
			if (accountDaoSQL.getAccountByID(id) == null) {
//				System.out.println("user id not found");
				System.out.println("here");
				throw new AccountNotFoundException();
			}
			if (!(accountDaoSQL.getAccountByID(id).getCustomer().getPassword().equals(password))) {
//				System.out.println("password not found");
				throw new AccountNotFoundException();
			}

			System.out.println("account found");
			return accountDaoSQL.getAccountByID(id);

		} catch (AccountNotFoundException e) {
			System.out.println(e.getMessage());
			return null;
		}	
	}
}



