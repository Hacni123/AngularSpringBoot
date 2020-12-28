package net.javaguides.springboot.model;

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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long order_id;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "order_date")
	private Date order_date;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Customer customer;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "order_cake",
		joinColumns = { @JoinColumn(name = "order_id")},
		inverseJoinColumns = { @JoinColumn (name = "cake_id")})
	private Set<Cake> cakes = new HashSet<>();
	
	public Order() {
		
	}

	public Order(long order_id, String status, Date order_date) {
		super();
		this.order_id = order_id;
		this.status = status;
		this.order_date = order_date;
	}


	public long getOrder_id() {
		return order_id;
	}


	public void setOrder_id(long order_id) {
		this.order_id = order_id;
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


	public Customer getCustomer() {
		return customer;
	}
   

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	//getter method to retrieve the CustomerId
    public Long getCustomer_id(){
        return customer.getCustomer_id();
    }

    //getter Method to get the Customer full name
    public String getCustomerName(){
        return customer.getFirstName() + " " + customer.getLastName();
    }
    
    public Set<Cake> getCakes() {
		return cakes;
	}

	public void setCakes(Set<Cake> cakes) {
		this.cakes = cakes;
	}
    
}
