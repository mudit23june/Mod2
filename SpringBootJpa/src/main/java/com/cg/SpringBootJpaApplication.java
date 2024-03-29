package com.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.cg")
@EntityScan("com.cg.beans")

public class SpringBootJpaApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(SpringBootJpaApplication.class, args);
	}
}
