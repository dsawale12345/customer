package com.cust.customer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cust.customer.model.Customer;
import com.cust.customer.repository.CustomerRepository;
import com.cust.customer.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository custRep;
	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return custRep.findAll();
	}

	@Override
	public Customer createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return custRep.save(customer);
	}

	@Override
	public Customer UpdateCustomer(Customer customer, long id) {
		// TODO Auto-generated method stub
		Customer cust=custRep.findById(id).orElseThrow();
		cust.setId(customer.getId());
		cust.setName(customer.getName());
		cust.setEmail(customer.getEmail());
		cust.setPrice(customer.getPrice());
		return custRep.save(cust);
	}

	@Override
	public void deleteCust(long id) {
		// TODO Auto-generated method stub
		
		custRep.deleteById(id);
	}

	@Override
	public Customer getbyCustomer(long id) {
		// TODO Auto-generated method stub
		return custRep.findById(id).orElseThrow();
	}

}
