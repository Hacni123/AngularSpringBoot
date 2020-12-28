package net.javaguides.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Order;
import net.javaguides.springboot.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
    private OrderRepository orderRepository;
	
	public List<Order> getOrder(){
        return orderRepository.findAll();
    }
    public Order getOrder(long order_id){
        Optional<Order> employee = orderRepository.findById(order_id);
        if(!employee.isPresent())
                throw new ResourceNotFoundException("Order not found!");
        return employee.get();
    }
    public Order addOrder(Order employee){
        return orderRepository.save(employee);
    }
    public Order updateOrder(long order_id,Order order){
    	order.setOrder_id(order_id);
        return orderRepository.save(order);
    }
    public void deleteOrder(long order_id){
    	orderRepository.deleteById(order_id);
    }
}
