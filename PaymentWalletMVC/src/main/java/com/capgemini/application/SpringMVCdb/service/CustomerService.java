package com.capgemini.application.SpringMVCdb.service;

import java.math.BigDecimal;
//import java.util.Optional;  
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestMapping;

import com.capgemini.application.SpringMVCdb.beans.Customer;
import com.capgemini.application.SpringMVCdb.exception.DuplicatePhoneNo;
import com.capgemini.application.SpringMVCdb.exception.PhoneNoDoesNotExist;
import com.capgemini.application.SpringMVCdb.repo.CustomerRepository;  

@Service  
public class CustomerService
{   
	@Autowired  
    private CustomerRepository customerRepository;  
  
	public List<Customer> getAllCustomers()
	{
		List<Customer> CustomerRecords = new ArrayList<>(); 
		customerRepository.findAll().forEach(CustomerRecords::add);
		return CustomerRecords;  
    }  
	
	public Customer getCustomer(String mobile)
	{
		if(!customerRepository.existsById(mobile))
		{
			throw new PhoneNoDoesNotExist();
		}
		return customerRepository.findById(mobile).get();
    }  
	
	public Customer getCustomerByName(String name)
	{  
		for(Customer c : customerRepository.findAll())
		{
			if((c.getName()).equals(name))
			{
				return c;
			}
		}
		return null;
    } 
   
	public void addCustomer(Customer customerRecord)
	{
		
		if(customerRepository.existsById(customerRecord.getMobileNumber()))
		{
			throw new DuplicatePhoneNo();
		}
		customerRepository.save(customerRecord);  
    }  
   
	public void delete(String mobile)
	{  
		if(!customerRepository.existsById(mobile))
		{
			throw new PhoneNoDoesNotExist();
		}
	 	customerRepository.deleteById(mobile);  
    }  
	
	public void withdraw(String mobile, BigDecimal amount)
	{
		if(!customerRepository.existsById(mobile))
		{
			throw new PhoneNoDoesNotExist();
		}
		Customer c = customerRepository.findById(mobile).get();
		c.getWallet().setBalance(c.getWallet().getBalance().subtract(amount));
		customerRepository.save(c);
	}
	
	public void deposit(String mobile, BigDecimal amount)
	{
		if(!customerRepository.existsById(mobile))
		{
			throw new PhoneNoDoesNotExist();
		}
		Customer c = customerRepository.findById(mobile).get();
		c.getWallet().setBalance(c.getWallet().getBalance().add(amount));
		customerRepository.save(c);
	}
	
	public void transfer(String mobile1, String mobile2, BigDecimal amount)
	{
		Customer c1 = customerRepository.findById(mobile1).get();
		Customer c2 = customerRepository.findById(mobile2).get();
		c1.getWallet().setBalance(c1.getWallet().getBalance().subtract(amount));
		c2.getWallet().setBalance(c2.getWallet().getBalance().add(amount));
		customerRepository.save(c1);
		customerRepository.save(c2);
	}
}  