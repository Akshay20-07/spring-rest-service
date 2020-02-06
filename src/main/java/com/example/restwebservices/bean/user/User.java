package com.example.restwebservices.bean.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@ApiModel(description="Constraints about the User")
public class User {

	@Size(min=2,message="String is less than 2")
	@ApiModelProperty(notes="String should be more than 2 character")
	private String name;
	private Integer id;
	@ApiModelProperty(notes="DOB should be in past")
	@Past
	private Date date;

	protected User(){
		
	}
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
