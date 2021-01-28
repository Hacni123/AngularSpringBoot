package com.grokonez.jwtauthentication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.grokonez.jwtauthentication.exception.ResourceNotFoundException;
import com.grokonez.jwtauthentication.model.Cake;
import com.grokonez.jwtauthentication.model.Cart;
import com.grokonez.jwtauthentication.model.User;
import com.grokonez.jwtauthentication.repository.CartRepository;
import com.grokonez.jwtauthentication.security.services.UserDetailsServiceImpl;

@Service
public class CartService {

	@Autowired
    private CartRepository cartRepository;
	
	@Autowired
	private UserDetailsServiceImpl userService;
	
	public Page<Cart> findByUserId(Long id, Pageable pageable) {
        return cartRepository.findByUserId(id, pageable);
    }

	
	 public Cart createCartByUser(long id, Cart cart) throws Exception {
         User user = this.userService.getUserById(id);
         cart.setUser(user);
         return cartRepository.save(cart);
     }
	 public Cart getCartById(long cartid) throws Exception {
	        return this.cartRepository.findById(cartid).orElseThrow(() -> new Exception("Couldn't find institute for id: " + cartid));
	    }
	 
	 public List<Cart> getCart(){
	        return cartRepository.findAll();
	    }
	    public Cart getCart(long cartid){
	        Optional<Cart> cart = cartRepository.findById(cartid);
	        if(!cart.isPresent())
	                throw new ResourceNotFoundException("Cart not found!");
	        return cart.get();
	    }
	    public Cart getCartByCartId(long cartid) throws Exception {
	        return this.cartRepository.findById(cartid).orElseThrow(() -> new Exception("Couldn't find institute for id: " + cartid));
	    }
	    public Cart addCart(Cart cart){
	        return cartRepository.save(cart);
	        
	    }
	    public Cart updateCart(long cartid,Cart cart){
	    	cart.setCartid(cartid);
	        return cartRepository.save(cart);
	    }
	    public void deleteCart(long cartid){
	    	cartRepository.deleteById(cartid);
	    }
}
