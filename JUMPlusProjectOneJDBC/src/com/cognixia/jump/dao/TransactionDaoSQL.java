package com.cognixia.jump.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.model.Transaction;

public class TransactionDaoSQL implements TransactionDao {

	private Connection conn = ConnectionManager.getConnection();
	
	@Override
	public List<Transaction> getAllTransactionsByID(String id) {
		
		try {
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM transaction WHERE customerId = ?");
			pstmt.setString(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			List<Transaction> TransactionList = new ArrayList<Transaction>();
			
			while(rs.next()) {
				// ...iterate through to get column info...
				int transactionId = rs.getInt("transactionId");
				String customerId = rs.getString("customerId");
				String transactionString = rs.getString("transaction");
				
				// ...then add them to a list...
				Transaction transaction = new Transaction(transactionString, customerId, transactionId);
				TransactionList.add(transaction);
			}
			
			// ...and return that list once finished
			return TransactionList;
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Could not retrieve list of transactoins from database");
		}
		
		// return null just in case exception is thrown
		return null;
	}

	@Override
	public boolean addTransaction(Transaction transaction) {
		
		try {
			PreparedStatement pstmt = conn.prepareStatement("INSERT into transaction(transactionId, transaction, customerId) values(?, ?, ?)");
			pstmt.setInt(1, transaction.getTransactionId());
			pstmt.setString(2, transaction.getTransaction());
			pstmt.setString(3, transaction.getCustomerId());
			
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
