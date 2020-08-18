package com.customer.registration.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.customer.registration.models.CustomerRegistrationDetail;
import com.customer.registration.models.CustomerRegistrationResponse;
import com.customer.registration.service.CustomerRegistrationService;

@RestController
@CrossOrigin

public class CustomerRegistrationController {

	@Autowired
	private CustomerRegistrationService CustomerRegistrationService;

	@Autowired
	private CustomerRegistrationResponse CustomerRegistrationResponse;

	/*
	 * static Context context; private static final LambdaLogger logger =
	 * context.getLogger();
	 */
	private static final Logger log = LoggerFactory.getLogger(CustomerRegistrationController.class);

	@RequestMapping(value = "/registration")

	public ResponseEntity Register(@Valid @RequestBody CustomerRegistrationDetail Customer_dtl) throws Exception {
		log.info("inside_Register");
		// logger.log("inside_Register");
		CustomerRegistrationResponse = CustomerRegistrationService.Registration(Customer_dtl);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Cutomer", "Registration");
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		if (CustomerRegistrationResponse.getId() == 200)
			return new ResponseEntity(CustomerRegistrationResponse, responseHeaders, HttpStatus.OK);
		else
			return new ResponseEntity(CustomerRegistrationResponse, responseHeaders, HttpStatus.BAD_REQUEST);

	}

	@PostMapping("/login")
	@ResponseBody
	public ResponseEntity Login(@Valid @RequestBody CustomerRegistrationDetail Customer_dtl) throws Exception {
		log.info("inside_Login");

		// logger.log("******************8inside_Login*****************8");
		CustomerRegistrationResponse = CustomerRegistrationService.Login(Customer_dtl);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Cutomer", "Registration");
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		if (CustomerRegistrationResponse.getId() == 200)
			return new ResponseEntity(CustomerRegistrationResponse, responseHeaders, HttpStatus.OK);
		else
			return new ResponseEntity(CustomerRegistrationResponse, responseHeaders, HttpStatus.BAD_REQUEST);
	}

}