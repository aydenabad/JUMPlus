package com.cognixia.jump.dao;

import java.util.List;

import com.cognixia.jump.model.Transaction;

public interface TransactionDao {
	
	public List<Transaction> getAllTransactionsByID(String id);
	
	public boolean addTransaction(Transaction transaction);
	
}


