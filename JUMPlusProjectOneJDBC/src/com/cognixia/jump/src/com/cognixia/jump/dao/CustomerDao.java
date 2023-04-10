package com.cognixia.jump.dao;

import com.cognixia.jump.model.Customer;

public interface CustomerDao {

	public Customer getCustomerByID(String id);
	
	public boolean addCustomer(Customer customer);
	
}
