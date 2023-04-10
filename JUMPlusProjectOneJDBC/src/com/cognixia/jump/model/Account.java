package com.cognixia.jump.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cognixia.jump.dao.AccountDaoSQL;
import com.cognixia.jump.dao.CustomerDaoSQL;
import com.cognixia.jump.exception.AccountNotFoundException;
import com.cognixia.jump.exception.InsufficientFundsException;
import com.cognixia.jump.exception.InvalidDepositException;

public class Account {

//	public static HashMap<String, Account> allAccounts = new HashMap<String, Account>();
	
	public static AccountDaoSQL accountDaoSQL = new AccountDaoSQL();
	public static CustomerDaoSQL customerDaoSQL = new CustomerDaoSQL();

	private float balance;
	private List<Transaction> transactions = new ArrayList<Transaction>();
	private Customer customer;

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

	public Account(float balance, Customer customer) {
		super();
		this.balance = balance;
		this.customer = customer;
		
		// add account and transaction to db
		accountDaoSQL.addAccount(this);
		
		Transaction transaction = new Transaction("Account created" + " on " + dtf.format(LocalDateTime.now()), customer.getId());
		this.transactions.add(transaction);
	}
	
	// constructor for instantiating account that's already in the db
	public Account(float balance, Customer customer, List<Transaction> transactions) {
		super();
		this.balance = balance;
		this.customer = customer;
		this.transactions = transactions;
	}

	public void deposit(float amount) {
		try {
			if (amount <= 0) {
				throw new InvalidDepositException();
			}
			this.balance += amount;
			Transaction transaction = new Transaction("Deposited: " + amount + " on " + dtf.format(LocalDateTime.now()), this.customer.getId());
			this.transactions.add(transaction);
		} catch (InvalidDepositException e) {
			System.out.println(e.getMessage());
		}
		
		accountDaoSQL.updateAccount(this);

	}

	public void withdraw(float amount) {
		try {
			if (this.balance < amount) {
				throw new InsufficientFundsException();
			}
			this.balance -= amount;
			Transaction transaction = new Transaction("Withdrew: " + amount + " on " + dtf.format(LocalDateTime.now()), this.customer.getId());
			this.transactions.add(transaction);
		} catch (InsufficientFundsException e) {
			System.out.println(e.getMessage());
		}
		
		accountDaoSQL.updateAccount(this);
		
	}

	public void transfer(float amount, String accountID) {
		try {
			this.withdraw(amount);
			
			if (accountDaoSQL.getAccountByID(accountID) == null) {
				throw new AccountNotFoundException();
			}
			
			accountDaoSQL.getAccountByID(accountID).deposit(amount);
			
			Transaction transaction = new Transaction("Transfered: " + amount + " to " + accountID + " on " + dtf.format(LocalDateTime.now()), this.customer.getId());
			this.transactions.add(transaction);
			
		} catch (AccountNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		accountDaoSQL.updateAccount(this);

	}

	public void viewTransactions() {

		System.out.println("Last Five Transactions:");
		int numTransactions = transactions.size();
		for (int i = numTransactions - 1; (i >= numTransactions - 5 && i >= 0); i--) {
			System.out.println(numTransactions - i + " - " + transactions.get(i).getTransaction());
		}
		System.out.println("Balance - " + this.balance + " as of " + dtf.format(LocalDateTime.now()));
	}

	public void displayCustomer() {
		System.out.println(this.customer);
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
