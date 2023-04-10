package com.cognixia.jump.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.model.Account;
import com.cognixia.jump.model.Customer;
import com.cognixia.jump.model.Transaction;

public class AccountDaoSQL implements AccountDao {
	
	private Connection conn = ConnectionManager.getConnection();
	
	
	@Override
	public Account getAccountByID(String customerID) {
		
		try {
			// first get the customer and transactions
			CustomerDaoSQL currCustomerDAO = new CustomerDaoSQL();
			Customer customer = currCustomerDAO.getCustomerByID(customerID);
			
			TransactionDaoSQL currTransactionDao = new TransactionDaoSQL();
			List<Transaction> transactions = currTransactionDao.getAllTransactionsByID(customerID);
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM account WHERE customerId = customerID");
			
			while (rs.next()) {
				float balance = rs.getFloat("balance");
				
				Account account = new Account(balance, customer, transactions);
				return account;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Customer with id = " + customerID + " not found.");
		}
		
		return null;
	}

	@Override
	public boolean addAccount(Account account) {
		try {
			PreparedStatement pstmt = conn.prepareStatement("INSERT into account(customerId, balance) values(?, ?)");
			pstmt.setString(1, account.getCustomer().getId());
			pstmt.setFloat(2, account.getBalance());
			
			int i = pstmt.executeUpdate();
			
			if(i > 0) {
				return true;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean updateAccount(Account account) {
		
		try {
			PreparedStatement pstmt = conn.prepareStatement("UPDATE account SET balance = ? WHERE customerId = ?");
			pstmt.setFloat(1, account.getBalance());
			pstmt.setString(2, account.getCustomer().getId());
			
			int i = pstmt.executeUpdate();
			
			if(i > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}



}
