package com.sahm.scheduler.model.entity;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

public class Parent { }
/*
@Entity
@Access(AccessType.FIELD)
public class Parent {
	
	@Id
	@Column(name="email", nullable=false, unique=true)
	private String email;
	
	@Column(name="password", nullable=false)
	private String password;
	
	@Column(name="firstName", nullable=true)
	private String firstName;
	
	@Column(name="lastName", nullable=true)
	private String lastName;
	
	@Column(name="Address", nullable=false)
	private String address;
	
	@Column(name="Phone", nullable=false)
	private String Phone;
	
	public Parent() {
		setEmail("");
		setPassword("");
		setFirstName("");
		setLastName("");
		setAddress("");
		setPhoneNum("");
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNum() {
		return this.Phone;
	}

	public void setPhoneNum(String phoneNum) {
		this.Phone = phoneNum;
	}
}
*/