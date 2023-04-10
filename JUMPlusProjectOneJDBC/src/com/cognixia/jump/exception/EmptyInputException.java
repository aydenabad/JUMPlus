package com.cognixia.jump.exception;

import com.cognixia.jump.utility.ColorsUtility;

public class EmptyInputException extends Exception {

	private static final long serialVersionUID = 2L;

	public EmptyInputException() {
		super(ColorsUtility.RED + "Input cannot be empty. Try again!" + ColorsUtility.RESET);
	}
}


