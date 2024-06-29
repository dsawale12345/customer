package com.cust.customer.service;

import java.util.List;

import com.cust.customer.model.Customer;

public interface CustomerService {

	List<Customer>getAllCustomer();
	Customer createCustomer(Customer customer);
	Customer getbyCustomer(long id);
	Customer UpdateCustomer(Customer customer,long id);
	void deleteCust(long id);
}
