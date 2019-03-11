package com.cg.mypaymentapp.service;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Wallet;
import com.cg.mypaymentapp.exception.InsufficientBalanceException;
import com.cg.mypaymentapp.exception.InvalidInputException;
import com.cg.mypaymentapp.repo.WalletRepo;
@Service("ser")
@Component(value="ser")
public class WalletServiceImpl implements WalletService
{	
	@Autowired
	private WalletRepo repo;
	
	public WalletServiceImpl()
	{
		super();
	}

	public WalletServiceImpl(WalletRepo repo)
	{
		super();
		this.repo = repo;
	}

	public Customer createAccount(Customer customer)
	{
		return repo.save(customer);
	}
	
	public Customer showBalance(String mobileNo)
	{
		Customer customer=repo.findOne(mobileNo);
		return customer;	
	}
	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount) throws InvalidInputException, InsufficientBalanceException
	{
		Customer cust1=repo.findOne(sourceMobileNo);
		Customer cust2=repo.findOne(targetMobileNo);
		if(cust1!=null)
		{
			if(cust2!=null)
			{
				BigDecimal bal1 = cust1.getWallet().getBalance();
				BigDecimal bal2 = cust2.getWallet().getBalance();
				if(bal1.compareTo(amount)>=0)
				{
					bal1 = bal1.subtract(amount);
					cust1.setWallet(new Wallet(bal1));
					repo.save(cust1);
					bal2=bal2.add(amount);
					cust2.setWallet(new Wallet(bal2));
					repo.save(cust2);
				}
				else
				{
					throw new InsufficientBalanceException("insufficient balance");					
				}
			}
			else
			{
				throw new InvalidInputException("Destination mobile number not found");
			}
		}
		else
		{
			throw new InvalidInputException("Source mobile number not found");
		}
		return cust1;
	}

	public Customer depositAmount(String mobileNo, BigDecimal amount) throws InvalidInputException
	{
			Customer cust=repo.findOne(mobileNo);
			BigDecimal bal = cust.getWallet().getBalance().add(amount);
			cust.setWallet(new Wallet(bal));
			repo.save(cust);
			return cust;	
	}

	public Customer withdrawAmount(String mobileNo, BigDecimal amount) throws InvalidInputException, InsufficientBalanceException
	{
		if(amount==null)
			throw new InvalidInputException("Amount cannot be null");
		
		if(mobileNo==null)
			throw new InvalidInputException("SourceMobile mobile number cannot be null");

		Customer cust=repo.findOne(mobileNo);
		if(cust.getMobileNo()==null)
			throw new InvalidInputException("Mobile number not found");
		BigDecimal bal = cust.getWallet().getBalance();
		if(bal.compareTo(amount)>=0)
		{
			bal = bal.subtract(amount);
			cust.setWallet(new Wallet(bal));
			repo.save(cust);
		}
		else
		{
			throw new InsufficientBalanceException("Insufficient balance");		
		}
		return cust;
	}
}