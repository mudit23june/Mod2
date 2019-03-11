package com.capgemini.application.SpringMVCdb.beans;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.validation.constraints.NotNull;

@Entity
@Table(name = "pay")
public class Customer
{
	@Id
	private String mobileNumber;
	
	private String name;
	@Embedded
	private Wallet wallet;

	public String getMobileNumber()
	{
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber)
	{
		this.mobileNumber = mobileNumber;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Wallet getWallet()
	{
		return wallet;
	}

	public void setWallet(Wallet wallet)
	{
		this.wallet = wallet;
	}

	public Customer(String mobileNumber, String name, Wallet wallet)
	{
		super();
		this.mobileNumber = mobileNumber;
		this.name = name;
		this.wallet = wallet;
	}

	public Customer()
	{
		super();
	}
}