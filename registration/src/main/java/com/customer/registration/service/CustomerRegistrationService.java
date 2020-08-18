package com.customer.registration.service;

import com.customer.registration.models.CustomerRegistrationResponse;
import com.customer.registration.repo.CustomerRegistrationRepository;
import com.customer.registration.models.CustomerRegistrationDetail;

import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerRegistrationService 

{
	@Autowired
	private CustomerRegistrationResponse CustomerRegistrationResponse;

	@Autowired
	private CustomerRegistrationRepository CustomerRegistrationRepository;
	private static final Logger log = LoggerFactory.getLogger(CustomerRegistrationService.class);
	

	interface GreetingCustomer {
	      void sayMessage(String message);
	   }
	private static final String User_null = "User name cannot be blank";
	
	
	public CustomerRegistrationResponse Login(CustomerRegistrationDetail Customer_dtl)
			throws SQLException, IOException {
		log.info("Customer Register : Inside Customer Registration Service");
		boolean Flag = true;
		Optional user_name = Optional.ofNullable(Customer_dtl.getUser_name());
		if (!user_name.isPresent() || (Customer_dtl.getUser_name().length() == 0))

		{
			log.info(User_null);
			CustomerRegistrationResponse.setMessage(User_null);
			CustomerRegistrationResponse.setId(400);
			Flag = false;
		}
		Optional password = Optional.ofNullable(Customer_dtl.getPassword());
		if (!password.isPresent() || (Customer_dtl.getPassword().length() == 0)) {
			log.info("passowrd cannot be blank");
			CustomerRegistrationResponse.setMessage("password cannot be blank");
			CustomerRegistrationResponse.setId(400);
			Flag = false;
		}
		if (Flag == true) {
			Base64.Encoder encoder = Base64.getEncoder();
			String encodedPassword = encoder.encodeToString(Customer_dtl.getPassword().getBytes(StandardCharsets.UTF_8));
			List<CustomerRegistrationDetail> Custlist = CustomerRegistrationRepository.loginCheck(Customer_dtl.getUser_name(), encodedPassword);

			GreetingCustomer GreetingCustomer = (message) ->
		      System.out.println("Hello " + message);
		      
			if (Custlist.stream().count() > 0) {
				log.info("Login Successful");
				GreetingCustomer.sayMessage(Customer_dtl.getUser_name() +"your login is successful");
				CustomerRegistrationResponse.setMessage("Login Successful");
				CustomerRegistrationResponse.setId(200);
			} else {
				log.info("Invalid credentials/user not found");
				CustomerRegistrationResponse.setId(400);
				GreetingCustomer.sayMessage(Customer_dtl.getUser_name() +"your login is not successful");
				CustomerRegistrationResponse.setMessage("Invalid credentials/user not found");
			}

		}

		return CustomerRegistrationResponse;

	}

	public CustomerRegistrationResponse Registration(CustomerRegistrationDetail Customer_dtl)
			throws SQLException, IOException {
		log.info("Customer Register : Inside Customer Registration Service");

		boolean Flag = true;

		Optional user_name = Optional.ofNullable(Customer_dtl.getUser_name());
		if (!user_name.isPresent() || (Customer_dtl.getUser_name().length() == 0)) {
			log.info(User_null);
			CustomerRegistrationResponse.setMessage(User_null);
			Flag = false;
		} else if (Customer_dtl.getUser_name().length() > 0) {

			List<CustomerRegistrationDetail> Custlist = CustomerRegistrationRepository.userCheck(Customer_dtl.getUser_name());
			
			if (Custlist.stream().count() > 0) {
				log.info("The cutomer already exists");
				CustomerRegistrationResponse.setId(400);
				CustomerRegistrationResponse.setMessage("The cutomer already exists");
				Flag = false;
			}

		}

		Optional first_name = Optional.ofNullable(Customer_dtl.getFirst_name());
		if (!first_name.isPresent() || (Customer_dtl.getFirst_name().length() == 0)) {
			log.info("customer name cannot be blank");
			CustomerRegistrationResponse.setId(400);
			CustomerRegistrationResponse.setMessage("Customer name cannot be blank");
			Flag = false;
		}
		Optional email = Optional.ofNullable(Customer_dtl.getEmail());
		if (!email.isPresent() || (Customer_dtl.getEmail().length() == 0)) {
			log.info("email cannot be blank");
			CustomerRegistrationResponse.setId(400);
			CustomerRegistrationResponse.setMessage("Email cannot be blank");
			Flag = false;
		}
		Optional pan = Optional.ofNullable(Customer_dtl.getPan());
		if (!pan.isPresent() || (Customer_dtl.getPan().length() == 0)) {
			log.info("PAN cannot be blank");
			CustomerRegistrationResponse.setMessage("PAN number cannot be blank");
			CustomerRegistrationResponse.setId(400);
			Flag = false;
		}
		Optional dob = Optional.ofNullable(Customer_dtl.getDob());
		if (!dob.isPresent() || (Customer_dtl.getDob().length() == 0)) {
			log.info("DOB cannot be blank");
			CustomerRegistrationResponse.setMessage("DOB cannot be blank");
			CustomerRegistrationResponse.setId(400);
			Flag = false;
		}
		Optional address = Optional.ofNullable(Customer_dtl.getAddress());
		if (!address.isPresent() || (Customer_dtl.getAddress().length() == 0)) {
			log.info("address name cannot be blank");
			CustomerRegistrationResponse.setMessage("Address cannot be blank");
			CustomerRegistrationResponse.setId(400);
			Flag = false;
		}
		Optional pass = Optional.ofNullable(Customer_dtl.getPassword());
		if (!pass.isPresent() || (Customer_dtl.getPassword().length() == 0)) {
			log.info("password name cannot be blank");
			CustomerRegistrationResponse.setMessage("password cannot be blank");
			CustomerRegistrationResponse.setId(400);
			Flag = false;
		}

		if (Flag == true) {

			try {
				java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
				Base64.Encoder encoder = Base64.getEncoder();
				String encodedPassword = encoder
						.encodeToString(Customer_dtl.getPassword().getBytes(StandardCharsets.UTF_8));
				Customer_dtl.setUpdatedat(date);
				Customer_dtl.setUpdatedby(Customer_dtl.getUser_name());
				Customer_dtl.setPassword(encodedPassword);
				CustomerRegistrationRepository.save(Customer_dtl);
				log.info("The cutomer detail is Registered");
				CustomerRegistrationResponse.setMessage("The cutomer detail is Registered");
				CustomerRegistrationResponse.setId(200);
			} catch (Exception e) {
				CustomerRegistrationResponse.setMessage("The cutomer already exists");
				CustomerRegistrationResponse.setId(400);
			}
		}

		return CustomerRegistrationResponse;

	}

}