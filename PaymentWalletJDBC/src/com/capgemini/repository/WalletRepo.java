package com.capgemini.repository;

//import java.sql.SQLException;

import com.capgemini.beans.Customer;
//import com.capgemini.exception.PhoneNoDoesNotExist;
import com.capgemini.exception.DuplicatePhoneNo;

public interface WalletRepo {
	
	public boolean save(Customer customer);
	public Customer findOne(String mobilenumber) throws DuplicatePhoneNo;

}
