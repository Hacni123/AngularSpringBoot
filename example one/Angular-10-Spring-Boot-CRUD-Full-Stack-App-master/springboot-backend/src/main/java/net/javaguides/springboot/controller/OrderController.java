package net.javaguides.springboot.controller;

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


import net.javaguides.springboot.model.Order;
import net.javaguides.springboot.service.OrderService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class OrderController {

	@Autowired
    private OrderService orderService;
	
	// get all employees
	@GetMapping("/orders")
	public List<Order> getAllOrders(){
		return orderService.getOrder();
	}		
	
	// create employee rest api
	@PostMapping("/orders")
	public Order createOrder(@RequestBody Order orders) {
		return orderService.addOrder(orders);
	}
	
	// get employee by id rest api
	@GetMapping("/orders/{id}")
    public Order getOrder(@PathVariable long order_id){
        return orderService.getOrder(order_id);
    }
	
	// update employee rest api
	
	@PutMapping("/orders/{id}")
	public Order createOrder(@PathVariable long order_id,@RequestBody Order orders){
        return orderService.updateOrder(order_id, orders);
    }
	
	// delete employee rest api
	@DeleteMapping("/orders/{id}")
	public void deleteOrder(@PathVariable long order_id){
		orderService.deleteOrder(order_id);
    }
	
	
}
