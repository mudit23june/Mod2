package com.cg.beans;

import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="Customer_Project")
public class Customer
{
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Range(min=100,max=105,message="Must be from 100 to 105")
	private int customerId;
	@NotNull(message="Employee first name must be not null")
	@Pattern(regexp="[A-Z][a-z]{4,10}",message="Enter valid employee first name")
	private String firstName;
	@NotNull(message="Employee last name must be not null")
	@Pattern(regexp="[A-Z][a-z]{4,10}",message="Enter valid employee last name")
	private String lastName;
	@Min(18)
	private int age;
	@NotNull(message="Employee email must be not null")
	@Pattern(regexp="^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$", message="Enter valid email id")
	private String email;
	@NotNull(message="Employee mobile number must be not null")
	@Pattern(regexp="[6-9][0-9]{9}", message="Enter valid mobile number")
	private String mobileNo;
	@NotNull(message="City must be not null")
	private String city;
	
	//create table customer(customerId Number(5),firstName VARCHAR(20),lastName VARCHAR(20),age Number(5),email VARCHAR(30),mobileNo Number(10),city VARCHAR(20)); 
	
	public int getCustomerId()
	{
		return customerId;
	}
	
	public void setCustomerId(int customerId)
	{
		this.customerId = customerId;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public void setAge(int age)
	{
		this.age = age;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public String getMobileNo()
	{
		return mobileNo;
	}
	
	public void setMobileNo(String mobileNo)
	{
		this.mobileNo = mobileNo;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public void setCity(String city)
	{
		this.city = city;
	}
}
