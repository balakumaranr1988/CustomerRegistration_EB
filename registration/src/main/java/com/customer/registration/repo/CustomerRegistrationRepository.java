package com.customer.registration.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.customer.registration.models.CustomerRegistrationDetail;

@Repository
public interface CustomerRegistrationRepository extends JpaRepository<CustomerRegistrationDetail, String> {

	@Query("select cust from CustomerRegistrationDetail cust where cust.user_name=?1 and cust.password=?2")
	public List<CustomerRegistrationDetail> loginCheck(String user_name, String password);
	
	@Query("select cust from CustomerRegistrationDetail cust where cust.user_name=?1")
	public List<CustomerRegistrationDetail> userCheck(String user_name);

}
