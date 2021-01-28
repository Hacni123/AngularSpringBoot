package com.grokonez.jwtauthentication.dto;

import java.io.Serializable;

import com.grokonez.jwtauthentication.model.RoleName;

public class RoleDTO implements Serializable{

	private Long id;
	private RoleName name;
	
	public RoleDTO() {
		super();
	}
	
	public RoleDTO(Long id, RoleName name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public RoleName getName() {
		return name;
	}
	public void setName(RoleName name) {
		this.name = name;
	}
	
	
}
