package com.cg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.beans.Customer;
import com.cg.service.CustomerService;

@RestController	
public class CustomerController
{	
	@Autowired
	CustomerService service;
	
	public CustomerService getService()
	{
		return service;
	}

	public void setService(CustomerService service)
	{
		this.service = service;
	}
	
	/*
	@RequestMapping(value="/addCustomer",method=RequestMethod.POST)
	public Customer addCustomer(@RequestParam("fname")String firstName,
			@RequestParam("lname")String lastName,
			@RequestParam("mobno")String mobileNo,
			@RequestParam("email")String email,
			@RequestParam("city")String city,
			@RequestParam("age")int age)
	
	{
		Customer customer=new Customer();
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setEmail(email);
		customer.setMobileNo(mobileNo);
		customer.setAge(age);
		customer.setCity(city);
		
		customer=service.addCustomer(customer);
		return customer;

	}
	*/
	@RequestMapping(value="/addCustomer", consumes="application/json", produces="application/json",method=RequestMethod.POST)
	public Customer addCustomer(@Valid @RequestBody Customer customer)
	{
		customer=service.addCustomer(customer);
		return customer;
	}
	
	@RequestMapping(value="/updateCustomer", consumes="application/json", produces="application/json",method=RequestMethod.POST)
	public Customer updateCustomer(@RequestBody Customer customer)
	{
		customer=service.updateCustomer(customer);
		return customer;
	}
	
	@RequestMapping(value="/deleteCustomer/{custid}", produces="application/json",method=RequestMethod.POST)
	public Customer removeCustomer(@PathVariable int custid)
	{
		Customer customer=service.removeCustomer(custid);
		return customer;
	}
	
	@RequestMapping(value="/getCustomerList", produces="application/json")
	public List<Customer> getCustomerList() 
	{
		List<Customer> list=service.getCustomerList();
		return list;
	}
	
	@RequestMapping(value="/getCustomer/{custid}", produces="application/json")
	public Customer findCustomer(@PathVariable int custid)
	{
		Customer customer=service.findCustomer(custid);
		return customer;
	}
	
	@RequestMapping(value="/getCustomerByName/{name}", produces="application/json")
	public List<Customer> getCustomerByName(@PathVariable String name)
	{
		List<Customer> customer=service.getCustomerByName(name);
		return customer;
	}
}
