package com.grokonez.jwtauthentication.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.grokonez.jwtauthentication.exception.ResourceNotFoundException;
import com.grokonez.jwtauthentication.model.Cake;
import com.grokonez.jwtauthentication.model.Cart;
import com.grokonez.jwtauthentication.model.Order;
import com.grokonez.jwtauthentication.model.User;
import com.grokonez.jwtauthentication.repository.OrderRepository;
import com.grokonez.jwtauthentication.security.services.UserDetailsServiceImpl;


@Service
public class OrderService {

	@Autowired
    private OrderRepository orderRepository;
	
	@Autowired
	private CakeService cakeService;
	
	@Autowired
	private UserDetailsServiceImpl userService;
	
	@Autowired
	private CartService cartService;
	
        /*public Order saveOrder(Order order) {
            Order newCustomer = new Order();
            newCustomer.setStatus(order.getStatus());
            newCustomer.getCakes()
                    .addAll(order
                            .getCakes()
                            .stream()
                            .map(v -> {
                                Cake vv = cakeService.findCakeById(v.getCakeid());
                                vv.getOrders().add(newCustomer);
                                return vv;
                            }).collect(Collectors.toList()));
            return orderRepository.save(newCustomer);
        }*/

	
        public Order createOrderByUser(long id,long cartid, Order order) throws Exception {
            User user = this.userService.getUserById(id);
            order.setUser(user);
            Cart cart =this.cartService.getCartByCartId(cartid);
            order.setCart(cart);
            return orderRepository.save(order);
        }
	
	
        public Order getbyUserId(long userid){
            Optional<Order> employee = orderRepository.findByUserId(userid);
            if(!employee.isPresent())
                    throw new ResourceNotFoundException("Order not found!");
            return employee.get();
        }
	
	 


	public List<Order> getOrder(){
        return orderRepository.findAll();
        
    }
    public Order getOrder(long orderid){
        Optional<Order> employee = orderRepository.findById(orderid);
        if(!employee.isPresent())
                throw new ResourceNotFoundException("Order not found!");
        return employee.get();
    }
    public Order addOrder(Order employee){
        return orderRepository.save(employee);
        
    }
    public Order updateOrder(long id,Order order) throws Exception{
    	 User user = this.userService.getUserById(id);
         order.setUser(user);
        return orderRepository.save(order);
    }
    public void deleteOrder(long orderid){
    	orderRepository.deleteById(orderid);
    }
}
