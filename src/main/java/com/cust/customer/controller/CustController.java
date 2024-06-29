package com.cust.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cust.customer.model.Customer;
import com.cust.customer.service.CustomerService;

@RestController
@RequestMapping("/test")
public class CustController {

	@Autowired
	private CustomerService custService;
	@GetMapping("hello")
	public String hello() {
		return "welcome";
	}
	@GetMapping("/all")
	public ResponseEntity<List<Customer>>getAllCustomer(){
		return ResponseEntity.ok(custService.getAllCustomer());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Customer>getCustomer(@PathVariable long id){
		return ResponseEntity.ok(custService.getbyCustomer(id));
	}
	@PostMapping("/create")
	public ResponseEntity<Customer>createCust(@RequestBody Customer customer){
		return ResponseEntity.ok(custService.createCustomer(customer));
	}
	@PutMapping("/{id}")
	public ResponseEntity<Customer> updateCust(@RequestBody Customer customer,@PathVariable long id){
		return ResponseEntity.ok(custService.UpdateCustomer(customer, id));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String>deletCust(@PathVariable(name="id")long id){
		custService.deleteCust(id);
		return new ResponseEntity<>("deleted successfully",HttpStatus.ACCEPTED);
	}
	
}
