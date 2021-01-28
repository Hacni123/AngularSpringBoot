package com.grokonez.jwtauthentication.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderid;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "order_date")
	private Date order_date;
	
	 
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "cart_id")
	private Cart cart;
	
	 
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;
	
	public Order() {
		
	}

	public Order( String status, Date order_date) {
		
		
		this.status = status;
		this.order_date = order_date;
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

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getCartid() {
		return cart.getCartid();
	}
	public Long getId() {
        return user.getId();
    }
	public int getTotal_price() {
		return cart.getTotal_price();
	}
	
}
