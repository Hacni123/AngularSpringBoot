package com.grokonez.jwtauthentication.controller;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grokonez.jwtauthentication.dto.CakeDTO;
import com.grokonez.jwtauthentication.dto.CartDTO;
import com.grokonez.jwtauthentication.dto.OrderDTO;
import com.grokonez.jwtauthentication.model.Cake;
import com.grokonez.jwtauthentication.model.Cart;
import com.grokonez.jwtauthentication.model.Order;
import com.grokonez.jwtauthentication.service.CartService;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/auth/carts")
public class CartController {

	@Autowired
    private CartService cartService;

	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/getAll")
    public List<CartDTO> getAllCARTS() {
        List<Cart> orderList = cartService.getCart();
        return orderList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

	 @GetMapping("/getAllCarts/{id}")
	    public List<CartDTO> getAllCartByUserId(@PathVariable(value = "id") Long id,Pageable pageable) throws Exception {
	        Page<Cart> cartList = this.cartService.findByUserId(id, pageable);
	        return cartList.stream()
	                .map(this::convertToDTO)
	                .collect(Collectors.toList());
	    }
	 
	 @GetMapping("/get/{cartid}")
	    public Cart getCart(@PathVariable long cartid){
	        return cartService.getCart(cartid);
	    }
 @PostMapping("/create/{userId}")
 public CartDTO createCartByUser(@PathVariable(value = "userId") Long id, @RequestBody CartDTO cartdto) throws Exception {
	 Cart cart = convertToEntity(cartdto);
     return convertToDTO(cartService.createCartByUser(id, cart));
 }
 
 private CartDTO convertToDTO(Cart cart) {
	 CartDTO cartDTO = modelMapper.map(cart, CartDTO.class);
		return cartDTO;
	}

	private Cart convertToEntity(CartDTO cartdto) throws ParseException {
		Cart cart = modelMapper.map(cartdto, Cart.class);
		return cart;
	}
	
}
