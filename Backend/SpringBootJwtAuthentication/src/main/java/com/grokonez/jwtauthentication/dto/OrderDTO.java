package com.grokonez.jwtauthentication.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.grokonez.jwtauthentication.model.Cake;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;


public class OrderDTO implements Serializable{

    private long orderid;
    private String status;
    private Date order_date;
    private long cartid;
   
    private  CartDTO cart ;
    private  UserDTO users ;
    
    public OrderDTO() {
    }

	public OrderDTO(long orderid, String status, Date order_date, long cartid, CartDTO cart, UserDTO users) {
		super();
		this.orderid = orderid;
		this.status = status;
		this.order_date = order_date;
		this.cartid = cartid;
		this.cart = cart;
		this.users = users;
	}

	public long getOrderid() {
		return orderid;
	}

	public void setOrderid(long orderid) {
		this.orderid = orderid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public long getCartid() {
		return cartid;
	}

	public void setCartid(long cartid) {
		this.cartid = cartid;
	}

	public CartDTO getCart() {
		return cart;
	}

	public void setCart(CartDTO cart) {
		this.cart = cart;
	}

	public UserDTO getUsers() {
		return users;
	}

	public void setUsers(UserDTO users) {
		this.users = users;
	}

	
	
    
}
