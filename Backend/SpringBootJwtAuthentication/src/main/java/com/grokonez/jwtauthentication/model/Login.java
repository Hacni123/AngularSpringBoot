package com.grokonez.jwtauthentication.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "login")
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long login_id;
	
	@Column(name = "user_name")
	private String user_name;

	@Column(name = "password")
	private String password;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "login")
	private Employee employee;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "login")
	private Customer customer;
	public Login() {
		
	}

	public Login(String user_name, String password) {
		super();
		this.user_name = user_name;
		this.password = password;
	}

	public long getLogin_id() {
		return login_id;
	}

	public void setLogin_id(long login_id) {
		this.login_id = login_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
}
