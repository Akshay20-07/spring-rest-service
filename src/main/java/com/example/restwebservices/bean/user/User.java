package com.example.restwebservices.bean.user;

import java.util.Date;

public class User {

	private String name;
	private Integer id;
	private Date date;

	public User(String name, Integer id, Date date) {
		super();
		this.name = name;
		this.id = id;
		this.date = date;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return String.format("User [name=%s, id=%s, date=%s]", name, id, date);
	}

}
