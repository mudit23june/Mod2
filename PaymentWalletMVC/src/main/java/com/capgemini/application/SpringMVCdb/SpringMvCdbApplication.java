package com.capgemini.application.SpringMVCdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.capgemini.application.SpringMVCdb.dao")
@ComponentScan("com.capgemini.application.SpringMVCdb.service")
@ComponentScan("com.capgemini.application.SpringMVCdb.controller")
@EntityScan("com.capgemini.application.SpringMVCdb.beans")
public class SpringMvCdbApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(SpringMvCdbApplication.class, args);
	}
}
