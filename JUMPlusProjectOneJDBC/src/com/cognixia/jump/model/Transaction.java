package com.cognixia.jump.model;

import com.cognixia.jump.dao.TransactionDaoSQL;

public class Transaction {
	
	private static TransactionDaoSQL transactionDaoSQL = new TransactionDaoSQL();
	
	private static int idCounter = -1;
	
	private int transactionId;
	private String transaction;
	private String customerId;
	
	public Transaction(String transaction, String customerId) {
		this.transaction = transaction;
		this.customerId = customerId;
		this.transactionId = ++idCounter;
		
		transactionDaoSQL.addTransaction(this);
	}
	
	public Transaction(String transaction, String customerId, int transactionId) {
		this.transaction = transaction;
		this.customerId = customerId;
		this.transactionId = transactionId;
	}
	
	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransaction() {
		return transaction;
	}

	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
}

