package com.cg.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
//import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.beans.Customer;
import com.cg.exception.NameDoesNotExist;
import com.cg.exception.DuplicatePhoneNo;
//import com.cg.exception.DuplicatePhoneNo;
import com.cg.exception.IdDoesNotExist;

@Repository("repo")
public class CustomerRepoImpl implements CustomerRepo
{	
	@PersistenceContext
	EntityManager entityManager;
	
	public EntityManager getEntityManager()
	{
		return entityManager;
	}
	
	public void setEntityManager(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}

	@Override
	public Customer addCustomer(Customer customer)
	{
		if(entityManager.find(Customer.class, customer.getCustomerId())!=null)
			throw new DuplicatePhoneNo();
		entityManager.persist(customer);
		entityManager.flush();
		return customer;
	}

	@Override
	public Customer findCustomer(int customerid)
	{
		Customer customer = entityManager.find(Customer.class, customerid);
		if(customer==null)
			throw new IdDoesNotExist();
		customer.setCustomerId(customerid);
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer)
	{
		if(entityManager.find(Customer.class, customer.getCustomerId())==null)
			throw new IdDoesNotExist();
		entityManager.merge(customer);
		entityManager.flush();
		return customer;	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getCustomerList()
	{
//		TypedQuery<Customer> query=entityManager.createQuery("select customer from Customer customer ", Customer.class);			
//		List<Customer> list= query.getResultList();
		Query query = entityManager.createNativeQuery("select * from Customer_Project");
		List<Customer> list=  query.getResultList();
		if(list.isEmpty())
			throw new IdDoesNotExist();
		return list;
	}

	@Override
	public Customer removeCustomer(int custid)
	{
		Customer customer = entityManager.find(Customer.class, custid);
		if(customer==null)
			throw new IdDoesNotExist();
		entityManager.remove(customer);
		entityManager.flush();
		return customer;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getCustomerByName(String name)
	{
		Query query=entityManager.createNativeQuery("select * from Customer_Project where first_Name=?").setParameter(1, name);
		List<Customer> list = query.getResultList();
		if(list.isEmpty())
			throw new NameDoesNotExist();
		return list;
	}
}