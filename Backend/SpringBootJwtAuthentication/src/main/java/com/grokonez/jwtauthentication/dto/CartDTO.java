package com.grokonez.jwtauthentication.dto;

import java.io.Serializable;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class CartDTO implements Serializable{

	private long cartid;
	private long cakeid;
	private String name;
	private int total_price;
	private String image;
	private int quantity;
	private int price;
	
	
	private OrderDTO order ;
	private UserDTO users ;

	public CartDTO() {
		
	}

	public CartDTO(long cartid, long cakeid, String name, int total_price, String image, int quantity, int price,
			OrderDTO order, UserDTO users) {
		super();
		this.cartid = cartid;
		this.cakeid = cakeid;
		this.name = name;
		this.total_price = total_price;
		this.image = image;
		this.quantity = quantity;
		this.price = price;
		this.order = order;
		this.users = users;
	}

	public long getCartid() {
		return cartid;
	}

	public void setCartid(long cartid) {
		this.cartid = cartid;
	}

	public long getCakeid() {
		return cakeid;
	}

	public void setCakeid(long cakeid) {
		this.cakeid = cakeid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	@JsonIgnore
	public OrderDTO getOrder() {
		return order;
	}

	public void setOrder(OrderDTO order) {
		this.order = order;
	}

	public UserDTO getUsers() {
		return users;
	}

	public void setUsers(UserDTO users) {
		this.users = users;
	}

	

	
}
