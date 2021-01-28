package com.grokonez.jwtauthentication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.grokonez.jwtauthentication.model.Customer;
import com.grokonez.jwtauthentication.service.CustomerService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class CustomerController {

	@Autowired
    private CustomerService customerService;
	
	// get all employees
	@GetMapping("/customers")
	public List<Customer> getAllCustomers(){
		return customerService.getCustomer();
	}		
	
	// create employee rest api
	@PostMapping("/customers")
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerService.addCustomer(customer);
	}
	
	// get employee by id rest api
	@GetMapping("/customers/{customer_id}")
    public Customer getCustomer(@PathVariable long customer_id){
        return customerService.getCustomer(customer_id);
    }
	
	// update employee rest api
	
	@PutMapping("/customers/{customer_id}")
	public Customer createCustomer(@PathVariable long customer_id,@RequestBody Customer customer){
        return customerService.updateCustomer(customer_id, customer);
    }
	
	// delete employee rest api
	@DeleteMapping("/customers/{customer_id}")
	public void deleteCustomer(@PathVariable long customer_id){
		customerService.deleteCustomer(customer_id);
    }
	
	
}
