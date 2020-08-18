
package com.customer.registration.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.customer.registration.models.CustomerRegistrationDetail;
import com.customer.registration.models.CustomerRegistrationResponse;

@SpringBootTest
public class CustomerRegisterServiceTest {

	@Autowired
	private CustomerRegistrationService registerService;

	@Test
	public void updateTest() throws SQLException, IOException {
		CustomerRegistrationDetail customer_dtl = new CustomerRegistrationDetail();
		customer_dtl.setAddress("chennai2");
		customer_dtl.setDob("18/06/1987");
		customer_dtl.setEmail("siva.venkatm@gmail.com");
		customer_dtl.setFirst_name("madhire");
		customer_dtl.setPan("BNGPM9521E");
		customer_dtl.setPassword("12345");
		customer_dtl.setUser_name("bala");
		CustomerRegistrationResponse custResponse = registerService.Registration(customer_dtl);
		assertEquals("The cutomer already exists", custResponse.getMessage());
	}
	@Test
	public void addresscheck() throws SQLException, IOException {
		CustomerRegistrationDetail customer_dtl = new CustomerRegistrationDetail();
		customer_dtl.setAddress(null);
		customer_dtl.setDob("18/06/1987");
		customer_dtl.setEmail("siva.venkatm@gmail.com");
		customer_dtl.setFirst_name("madhire");
		customer_dtl.setPan("BNGPM9521E");
		customer_dtl.setPassword("12345");
		Random rand = new Random();
		int name = rand.nextInt(1000) + 1;
		customer_dtl.setUser_name(Integer.toString(name));
		CustomerRegistrationResponse custResponse = registerService.Registration(customer_dtl);
		assertEquals("Address cannot be blank", custResponse.getMessage());
	}
	@Test
	public void dobcheck() throws SQLException, IOException {
		CustomerRegistrationDetail customer_dtl = new CustomerRegistrationDetail();
		customer_dtl.setAddress("address");
		customer_dtl.setDob(null);
		customer_dtl.setEmail("siva.venkatm@gmail.com");
		customer_dtl.setFirst_name("madhire");
		customer_dtl.setPan("BNGPM9521E");
		customer_dtl.setPassword("12345");
		Random rand = new Random();
		int name = rand.nextInt(1000) + 1;
		customer_dtl.setUser_name(Integer.toString(name));
		CustomerRegistrationResponse custResponse = registerService.Registration(customer_dtl);
		assertEquals("DOB cannot be blank", custResponse.getMessage());
	}
	@Test
	public void emailcheck() throws SQLException, IOException {
		CustomerRegistrationDetail customer_dtl = new CustomerRegistrationDetail();
		customer_dtl.setAddress("address");
		customer_dtl.setDob("dob");
		customer_dtl.setEmail(null);
		customer_dtl.setFirst_name("madhire");
		customer_dtl.setPan("BNGPM9521E");
		customer_dtl.setPassword("12345");
		Random rand = new Random();
		int name = rand.nextInt(1000) + 1;
		customer_dtl.setUser_name(Integer.toString(name));
		CustomerRegistrationResponse custResponse = registerService.Registration(customer_dtl);
		assertEquals("Email cannot be blank", custResponse.getMessage());
	}
	@Test
	public void firstnamecheck() throws SQLException, IOException {
		CustomerRegistrationDetail customer_dtl = new CustomerRegistrationDetail();
		customer_dtl.setAddress("address");
		customer_dtl.setDob("dob");
		customer_dtl.setEmail("email");
		customer_dtl.setFirst_name(null);
		customer_dtl.setPan("BNGPM9521E");
		customer_dtl.setPassword("12345");
		Random rand = new Random();
		int name = rand.nextInt(1000) + 1;
		customer_dtl.setUser_name(Integer.toString(name));
		CustomerRegistrationResponse custResponse = registerService.Registration(customer_dtl);
		assertEquals("Customer name cannot be blank", custResponse.getMessage());
	}
	@Test
	public void panchck() throws SQLException, IOException {
		CustomerRegistrationDetail customer_dtl = new CustomerRegistrationDetail();
		customer_dtl.setAddress("address");
		customer_dtl.setDob("dob");
		customer_dtl.setEmail("email");
		customer_dtl.setFirst_name("nama");
		customer_dtl.setPan(null);
		customer_dtl.setPassword("12345");
		customer_dtl.setUser_name("bala");
		CustomerRegistrationResponse custResponse = registerService.Registration(customer_dtl);
		assertEquals("PAN number cannot be blank", custResponse.getMessage());
	}
	@Test
	public void passchk() throws SQLException, IOException {
		CustomerRegistrationDetail customer_dtl = new CustomerRegistrationDetail();
		customer_dtl.setAddress("address");
		customer_dtl.setDob("dob");
		customer_dtl.setEmail("email");
		customer_dtl.setFirst_name("nama");
		customer_dtl.setPan("pan");
		customer_dtl.setPassword(null);
		Random rand = new Random();
		int name = rand.nextInt(1000) + 1;
		customer_dtl.setUser_name(Integer.toString(name));
		CustomerRegistrationResponse custResponse = registerService.Registration(customer_dtl);
		assertEquals("password cannot be blank", custResponse.getMessage());
	}
	@Test
	public void namechck() throws SQLException, IOException {
		CustomerRegistrationDetail customer_dtl = new CustomerRegistrationDetail();
		customer_dtl.setAddress("address");
		customer_dtl.setDob("dob");
		customer_dtl.setEmail("email");
		customer_dtl.setFirst_name("nama");
		customer_dtl.setPan("pan");
		customer_dtl.setPassword("pass");
		customer_dtl.setUser_name(null);
		CustomerRegistrationResponse custResponse = registerService.Registration(customer_dtl);
		assertEquals("User name cannot be blank", custResponse.getMessage());
	}
	@Test
	public void updateTestsuccess() throws SQLException, IOException {
		CustomerRegistrationDetail customer_dtl = new CustomerRegistrationDetail();
		customer_dtl.setAddress("chennai2");
		customer_dtl.setDob("18/06/1987");
		customer_dtl.setEmail("siva.venkatm@gmail.com");
		customer_dtl.setFirst_name("madhire");
		customer_dtl.setPan("BNGPM9521E");
		customer_dtl.setPassword("12345");
		Random rand = new Random();
		int loanid = rand.nextInt(1000) + 1;
		customer_dtl.setUser_name(Integer.toString(loanid));
		CustomerRegistrationResponse custResponse = registerService.Registration(customer_dtl);
		assertEquals("The cutomer detail is Registered", custResponse.getMessage());
	}

	@Test
	public void testLoginfailure() throws SQLException, IOException {
		CustomerRegistrationDetail customer_dtl = new CustomerRegistrationDetail();

		customer_dtl.setPassword("12345");
		customer_dtl.setUser_name("123");

		CustomerRegistrationResponse custResponse = registerService.Login(customer_dtl);

		assertEquals("Invalid credentials/user not found", custResponse.getMessage());
	}

	@Test
	public void testLoginfailurenamenull() throws SQLException, IOException {
		CustomerRegistrationDetail customer_dtl = new CustomerRegistrationDetail();
		customer_dtl.setPassword("pass");
		customer_dtl.setUser_name(null);

		CustomerRegistrationResponse custResponse = registerService.Login(customer_dtl);

		assertEquals("User name cannot be blank", custResponse.getMessage());
	}
	
	@Test
	public void testLoginfailurepassnull() throws SQLException, IOException {
		CustomerRegistrationDetail customer_dtl = new CustomerRegistrationDetail();
		customer_dtl.setPassword(null);
		customer_dtl.setUser_name("555");

		CustomerRegistrationResponse custResponse = registerService.Login(customer_dtl);

		assertEquals("password cannot be blank", custResponse.getMessage());
	}

}
