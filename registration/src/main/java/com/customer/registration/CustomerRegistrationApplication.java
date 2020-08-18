package com.customer.registration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = {"com.customer.registration"})
public class CustomerRegistrationApplication extends SpringBootServletInitializer {
	private static final Logger log = LoggerFactory.getLogger(CustomerRegistrationApplication.class);
	
	public static void main(String[] args) {
		log.info("inside_CustomerRegistrationApplication");
		System.out.print("inside_CustomerRegistrationApplication");
		SpringApplication.run(CustomerRegistrationApplication.class, args);
	}

}
