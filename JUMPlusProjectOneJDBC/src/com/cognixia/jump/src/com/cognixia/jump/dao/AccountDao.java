package com.cognixia.jump.dao;

import com.cognixia.jump.model.Account;

public interface AccountDao {
	
	public Account getAccountByID(String id);
	
	public boolean addAccount(Account account);
	
	public boolean updateAccount(Account account);
	
}
