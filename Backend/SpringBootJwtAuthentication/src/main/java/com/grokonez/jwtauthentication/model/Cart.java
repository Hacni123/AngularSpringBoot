package com.grokonez.jwtauthentication.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cartid;
	
	@Column(name = "cakeid")
	private String cakeid;
	
	@Column(name = "name")
	private String name;

	@Column(name = "total_price")
	private int total_price;
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "quantity")
	private String quantity;
	
	@Column(name = "price")
	private String price;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User user;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "cart")
	@JsonIgnore
	private Order order;
	
	public Cart() {
	
	}

	public Cart(long cartid, String cakeid, String name, int total_price, String image, String quantity, String price, User user, Order order) {
		super();
		this.cartid = cartid;
		this.cakeid = cakeid;
		this.name = name;
		this.total_price = total_price;
		this.image = image;
		this.quantity = quantity;
		this.price = price;
		
		this.user = user;
		this.order = order;
	}

	public long getCartid() {
		return cartid;
	}

	public void setCartid(long cartid) {
		this.cartid = cartid;
	}

	public String getCakeid() {
		return cakeid;
	}

	public void setCakeid(String cakeid) {
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

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	@JsonIgnore
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	
	
	
}
