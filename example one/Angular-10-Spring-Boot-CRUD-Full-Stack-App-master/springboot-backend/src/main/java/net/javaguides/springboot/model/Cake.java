package net.javaguides.springboot.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cakes")
public class Cake {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cake_id;
	
	@Column(name = "cake_name")
	private String cake_name;

	@Column(name = "price")
	private int price;
	
	@Column(name = "description")
	private String description;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "cakes")
	private Set<Order> orders = new HashSet<>();
	
	public Cake() {
		
	}

	public Cake(String cake_name, int price, String description) {
		super();
		this.cake_name = cake_name;
		this.price = price;
		this.description = description;
	}



	public long getCake_id() {
		return cake_id;
	}

	public void setCake_id(long cake_id) {
		this.cake_id = cake_id;
	}

	public String getCake_name() {
		return cake_name;
	}

	public void setCake_name(String cake_name) {
		this.cake_name = cake_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
	
}
