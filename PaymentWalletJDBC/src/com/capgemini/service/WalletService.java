package com.capgemini.service;

//import java.math.BigDecimal;

import com.capgemini.beans.Customer;
//import com.capgemini.exception.DuplicatePhoneNo;
//import com.capgemini.exception.PhoneNoDoesNotExist;
import com.capgemini.exception.DuplicatePhoneNo;
import com.capgemini.exception.PhoneNoDoesNotExist;

public interface WalletService {
	public Customer createAccount(String name,String mobileNumber,long amount) throws DuplicatePhoneNo;
	public Customer showBalance(String mobileNumber) throws DuplicatePhoneNo, PhoneNoDoesNotExist;
	public Customer fundTransfer(String sourceMobileNumber,String targetMobileNumber,long amount) throws DuplicatePhoneNo, PhoneNoDoesNotExist;
	public Customer depositAmount(String mobileNumber,long amount) throws DuplicatePhoneNo, PhoneNoDoesNotExist;
	public Customer withdrawAmount(String mobileNumber,long amount) throws DuplicatePhoneNo, PhoneNoDoesNotExist;
}
