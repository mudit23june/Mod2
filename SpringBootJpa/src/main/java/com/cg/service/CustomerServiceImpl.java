package com.cg.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.beans.Customer;
import com.cg.repo.CustomerRepo;

@Transactional
@Service("service")
public class CustomerServiceImpl implements CustomerService
{
	@Autowired
	CustomerRepo repo;
	
	public CustomerRepo getRepo()
	{
		return repo;
	}

	public void setRepo(CustomerRepo repo)
	{
		this.repo = repo;
	}

	@Override
	public Customer addCustomer(Customer customer)
	{
		return repo.addCustomer(customer);
	}

	@Override
	public Customer findCustomer(int customerid)
	{
		return repo.findCustomer(customerid);
	}

	@Override
	public Customer updateCustomer(Customer customer)
	{
		return repo.updateCustomer(customer);
	}

	@Override
	public List<Customer> getCustomerList()
	{
		return repo.getCustomerList();
	}

	@Override
	public Customer removeCustomer(int custid)
	{
		return repo.removeCustomer(custid);
	}

	@Override
	public List<Customer> getCustomerByName(String name)
	{
		return repo.getCustomerByName(name);
	}
}