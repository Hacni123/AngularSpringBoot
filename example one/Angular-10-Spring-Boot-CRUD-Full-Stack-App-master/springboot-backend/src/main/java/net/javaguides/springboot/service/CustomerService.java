package net.javaguides.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Customer;
import net.javaguides.springboot.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
    private CustomerRepository customerRepository;
	
	public List<Customer> getCustomer(){
        return customerRepository.findAll();
    }
    public Customer getCustomer(long customer_id){
        Optional<Customer> customer = customerRepository.findById(customer_id);
        if(!customer.isPresent())
                throw new ResourceNotFoundException("Customer not found!");
        return customer.get();
    }
    public Customer addCustomer(Customer customer){
        return customerRepository.save(customer);
    }
    public Customer updateCustomer(long customer_id,Customer customer){
    	customer.setCustomer_id(customer_id);
        return customerRepository.save(customer);
    }
    public void deleteCustomer(long customer_id){
    	customerRepository.deleteById(customer_id);
    }
}
