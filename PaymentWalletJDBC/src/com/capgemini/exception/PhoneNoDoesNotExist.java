package com.capgemini.exception;

@SuppressWarnings("serial")
public class PhoneNoDoesNotExist extends Exception {

	@Override
	public String toString() {
		return "The given mobile number does not exist\n";
	}

}
