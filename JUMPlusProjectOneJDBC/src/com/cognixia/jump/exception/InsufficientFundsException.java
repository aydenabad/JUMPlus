package com.cognixia.jump.exception;

import com.cognixia.jump.utility.ColorsUtility;

public class InsufficientFundsException extends Exception {
	private static final long serialVersionUID = 5L;

	public InsufficientFundsException() {
		super(ColorsUtility.RED + "Withdraw failed! Insufficient funds!" + ColorsUtility.RESET);
	}
}
