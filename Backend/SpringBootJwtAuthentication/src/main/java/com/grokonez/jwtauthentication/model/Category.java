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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "category_name")
	private String category_name;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Cake> cakes = new HashSet<>();
	
	

	public Category() {
		
	}

	

	public Category( String category_name) {
		
		
		this.category_name = category_name;
		
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public Set<Cake> getCakes() {
		return cakes;
	}

	public void setCakes(Set<Cake> cakes) {
		this.cakes = cakes;
	}

	
	
	

}
