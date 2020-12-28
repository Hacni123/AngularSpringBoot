package net.javaguides.springboot.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "customer")
@Setter
@Getter
@ToString
public class Customer {

	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private Long customer_id;
	   
	   @Column(name = "customer_name")
	   private String customer_name;
	   
	   @Column(name = "phone")
	   private int phone;
	   
	   @Column(name = "email")
	   private String email;
	   
	   @Column(name = "gender")
	   private String gender;
	   
	   @Column(name = "address")
	   private String address;
	   
	   @Column(name = "id_num")
	   private int id_num;
	   
	   @OneToMany(cascade=CascadeType.ALL, mappedBy="customer")
		private Set<Booking> booking;

	public Long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getId_num() {
		return id_num;
	}

	public void setId_num(int id_num) {
		this.id_num = id_num;
	}

	public Set<Booking> getBooking() {
		return booking;
	}

	public void setBooking(Set<Booking> booking) {
		this.booking = booking;
	}
	

	
	   
}
