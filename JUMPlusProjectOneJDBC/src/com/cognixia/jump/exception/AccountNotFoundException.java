package com.cognixia.jump.exception;

import com.cognixia.jump.utility.ColorsUtility;

public class AccountNotFoundException extends Exception {
	private static final long serialVersionUID = 3L;

	public AccountNotFoundException() {
		super(ColorsUtility.RED + "Account not found!" + ColorsUtility.RESET);
	}
}
