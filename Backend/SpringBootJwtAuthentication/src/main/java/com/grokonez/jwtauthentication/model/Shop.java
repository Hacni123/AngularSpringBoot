package com.grokonez.jwtauthentication.model;

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
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "shop")
public class Shop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long shop_id;
	
	@Column(name = "shop_name")
	private String shop_name;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "phone")
	private int phone;
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "shops")
	private Set<Employee> employees = new HashSet<>();
	
	public Shop() {
		
	}

	public Shop(String shop_name, String address, int phone) {
		super();
		this.shop_name = shop_name;
		this.address = address;
		this.phone = phone;
	}

	public long getShop_id() {
		return shop_id;
	}

	public void setShop_id(long shop_id) {
		this.shop_id = shop_id;
	}

	public String getShop_name() {
		return shop_name;
	}

	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
}
