package com.capgemini.exception;

@SuppressWarnings("serial")
public class DuplicatePhoneNo extends Exception {

	@Override
	public String toString() {
		return "Customer with the given mobile number already exists\n";
	}

}
