package com.grokonez.jwtauthentication.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.grokonez.jwtauthentication.model.Cake;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class CategoryDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String category_name;
    
	private Collection<CakeDTO> cake ;

	public CategoryDTO() {
		
	}

	public CategoryDTO(long id, String category_name, Collection<CakeDTO> cake) {
		
		this.id = id;
		this.category_name = category_name;
		this.cake = cake;
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

	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	public Collection<CakeDTO> getCake() {
		return cake;
	}

	public void setCake(Collection<CakeDTO> cake) {
		this.cake = cake;
	}

	
}
