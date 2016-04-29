package com.sermo.xx.model;

import java.io.Serializable;

public class User implements Serializable{
	
	private static final long serialVersionUID = 4400869085785338444L;
	
	private Integer id;
	
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
