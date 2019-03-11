package com.capgemini.application.SpringMVCdb.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.application.SpringMVCdb.beans.Customer;;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, String>
{  
	
}  