package com.grokonez.jwtauthentication.controller;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.grokonez.jwtauthentication.dto.OrderDTO;
import com.grokonez.jwtauthentication.exception.ResourceNotFoundException;

import org.modelmapper.ModelMapper;
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
import com.grokonez.jwtauthentication.model.Order;
import com.grokonez.jwtauthentication.repository.OrderRepository;
import com.grokonez.jwtauthentication.repository.UserRepository;
import com.grokonez.jwtauthentication.service.OrderService;



@RestController
@CrossOrigin(origins ="http://localhost:4200")
@RequestMapping("/api/auth/orders")
public class OrderController {
	@Autowired
    private OrderService orderService;

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	UserRepository userRepository;

	@Autowired
    private OrderRepository orderRepository;
	
	@RequestMapping("/oder/count")
	private Long getNumberOfOrders(){
	    return orderRepository.count();
	}
	
	@GetMapping("/getAll")
    public List<OrderDTO> getAllOrders() {
        List<Order> orderList = orderService.getOrder();
        return orderList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

	@GetMapping("/getAll1")
	public List<Order> getAllOrders1(){
		return orderService.getOrder();
	}
	
	
 @PostMapping("/create/{userId}/{cartid}")
 public OrderDTO createOrderByUser(@PathVariable(value = "userId") Long id, @PathVariable(value = "cartid") Long cartid, @RequestBody OrderDTO orderdto) throws Exception {
     Order order = convertToEntity(orderdto);
     return convertToDTO(orderService.createOrderByUser(id,cartid, order));
 }

 @GetMapping("/get/{orderid}")
 public OrderDTO getOrderById(@PathVariable(value = "orderid") Long orderid) throws Exception {
	 Order order = this.orderService.getOrder(orderid);
     return convertToDTO(order);
 }
	
 @GetMapping("/getbyuserid/{userid}")
 public OrderDTO getOrderByUserId(@PathVariable(value = "userid") Long userid) throws Exception {
	 Order order = this.orderService.getbyUserId(userid);
     return convertToDTO(order);
 }
 
 @PutMapping("/update/{id}/{orderid}")
 public Order updateCourse(@PathVariable(value = "id") Long id,
     @PathVariable(value = "orderid") Long orderid, @Valid @RequestBody Order courseRequest)
 throws ResourceNotFoundException {
     if (!userRepository.existsById(id)) {
         throw new ResourceNotFoundException("instructorId not found");
     }

     return orderRepository.findById(orderid).map(course -> {
         course.setStatus(courseRequest.getStatus());
         return orderRepository.save(course);
     }).orElseThrow(() -> new ResourceNotFoundException("course id not found"));
 }
 
 @DeleteMapping("/delete/{id}/{orderid}")
 public ResponseEntity < ? > deleteOrder(@PathVariable(value = "id") Long id,
     @PathVariable(value = "orderid") Long orderid) throws ResourceNotFoundException {
     return orderRepository.findByorderidAndUserId(orderid, id).map(course -> {
    	 orderRepository.delete(course);
         return ResponseEntity.ok().build();
     }).orElseThrow(() -> new ResourceNotFoundException(
         "Course not found with id " + orderid + " and instructorId " + id));
 }
 
 
	/* get all employees
	@GetMapping("/getAll")
	public List<Order> getAllOrders(){
		return orderService.getOrder();
	}		
	
	@PostMapping("/create")
    public ResponseEntity<?> saveCustomer(@RequestBody Order customer) {
       return new ResponseEntity<>(orderService.saveCustomer(customer), HttpStatus.CREATED);
    }



	// get employee by id rest api
	@GetMapping("/get/{order_id}")
    public Order getOrder(@PathVariable long order_id){
        return orderService.getOrder(order_id);
    }
	
	// update employee rest api
	
	@PutMapping("/update/{order_id}")
	public Order createOrder(@PathVariable long order_id,@RequestBody Order orders){
        return orderService.updateOrder(order_id, orders);
    }
	
	// delete employee rest api
	@DeleteMapping("/delete/{order_id}")
	public void deleteOrder(@PathVariable long order_id){
		orderService.deleteOrder(order_id);
    }
*/
	private OrderDTO convertToDTO(Order order) {
		OrderDTO orderDTO = modelMapper.map(order, OrderDTO.class);
		return orderDTO;
	}

	private Order convertToEntity(OrderDTO orderDTO) throws ParseException {
		Order order = modelMapper.map(orderDTO, Order.class);
		return order;
	}
}
