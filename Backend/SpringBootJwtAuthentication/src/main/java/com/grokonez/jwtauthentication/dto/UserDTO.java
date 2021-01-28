package com.grokonez.jwtauthentication.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.grokonez.jwtauthentication.model.Order;
import com.grokonez.jwtauthentication.model.Role;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class UserDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	 private String username;
	 private String email;
	 private String address;
	 private int phone;
	 private String password;
	 
	 private Set<RoleDTO> roles = new HashSet<>();
	 private Set<OrderDTO> orders = new HashSet<>();
	 
	public UserDTO() {
		
	}

	public UserDTO(Long id, String name, String username, String email, String address, int phone, String password,
			Set<RoleDTO> roles, Set<OrderDTO> orders) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.password = password;
		this.roles = roles;
		this.orders = orders;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<RoleDTO> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleDTO> roles) {
		this.roles = roles;
	}

	public Set<OrderDTO> getOrders() {
		return orders;
	}

	public void setOrders(Set<OrderDTO> orders) {
		this.orders = orders;
	}
	 
	 

}
