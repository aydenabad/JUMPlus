package com.cognixia.jump.exception;

import com.cognixia.jump.utility.ColorsUtility;

public class InvalidDepositException extends Exception {
	private static final long serialVersionUID = 4L;

	public InvalidDepositException() {
		super(ColorsUtility.RED + "Deposit must be greater than 0!" + ColorsUtility.RESET);
	}
}
