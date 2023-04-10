package com.cognixia.jump.exception;

import com.cognixia.jump.utility.ColorsUtility;

public class AccountAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	public AccountAlreadyExistsException(String accountId) {
		super(ColorsUtility.RED + "account id: " + accountId + " already exists. Try again!" + ColorsUtility.RESET);
	}
	
}


