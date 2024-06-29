package com.cust.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cust.customer.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
