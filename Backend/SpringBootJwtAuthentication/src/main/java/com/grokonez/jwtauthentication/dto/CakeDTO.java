package com.grokonez.jwtauthentication.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.grokonez.jwtauthentication.model.Category;
import com.grokonez.jwtauthentication.model.Order;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class CakeDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

    private long cakeid;
    private String name;
    private String image;
    private String description;
    private int price;
    private int quantity;
    
    private CategoryDTO category ;
    
	public CakeDTO() {
		
	}

	public CakeDTO(long cakeid, String name, String image, String description, int price, int quantity,
			CategoryDTO category) {
		
		this.cakeid = cakeid;
		this.name = name;
		this.image = image;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	public CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}

	
    
}

