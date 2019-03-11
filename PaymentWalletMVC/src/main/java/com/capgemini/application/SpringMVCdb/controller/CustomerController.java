package com.capgemini.application.SpringMVCdb.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.application.SpringMVCdb.beans.Customer;
import com.capgemini.application.SpringMVCdb.service.CustomerService;

@RestController
public class CustomerController
{
	@Autowired
	private CustomerService customerService;

	@RequestMapping("/customers")
	public List<Customer> getAllCustomer()
	{
		return customerService.getAllCustomers();
	}

	@RequestMapping("/test")
	public String test()
	{
		return "test";
	}

	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	public ResponseEntity<Object> addCustomer(@RequestBody Customer customerRecord)
	{
		customerService.addCustomer(customerRecord);
		return new ResponseEntity<Object>(customerRecord,HttpStatus.OK);
	}

	@RequestMapping(value = "/getCustomer/{mobile}", method = RequestMethod.GET)
	public ResponseEntity<Object> getCustomer(@PathVariable String mobile)
	{
		return new ResponseEntity<Object>(customerService.getCustomer(mobile), HttpStatus.OK);
	}

	@RequestMapping(value = "/getCustomerByName/{name}", method = RequestMethod.GET)
	public Customer getCustomerByName(@PathVariable String name)
	{
		return customerService.getCustomerByName(name);
	}

	@RequestMapping(value = "/deleteCustomer/{mobile}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteCustomer(@PathVariable String mobile)
	{
		customerService.delete(mobile);
		return new ResponseEntity<Object>(HttpStatus.OK);
		
	}

	@RequestMapping(value = "/withdraw/{mobile}/{amount}", method = RequestMethod.POST)
	public ResponseEntity<Object> withdraw(@PathVariable String mobile, @PathVariable BigDecimal amount)
	{
		customerService.withdraw(mobile, amount);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@RequestMapping(value = "/deposit/{mobile}/{amount}", method = RequestMethod.POST)
	public ResponseEntity<Object> deposit(@PathVariable String mobile, @PathVariable BigDecimal amount)
	{
		customerService.deposit(mobile, amount);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@RequestMapping(value = "/transfer/{mobile1}/{mobile2}/{amount}", method = RequestMethod.POST)
	public void transfer(@PathVariable String mobile1, @PathVariable String mobile2, @PathVariable BigDecimal amount)
	{
		customerService.transfer(mobile1, mobile2, amount);
	}
}