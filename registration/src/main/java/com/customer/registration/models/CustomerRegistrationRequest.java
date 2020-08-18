package com.customer.registration.models;

import org.springframework.stereotype.Component;

@Component
public class CustomerRegistrationRequest {
	int id;
	String name;
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}

}
