package com.sahm.scheduler.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

public class Admin { }
/*
@Entity
public class Admin {
	
	@Id
	@Column(name = "email", nullable=false, unique=true)
	private String email; 
	private String password; 
	
	public Admin(String e, String p) {
		email = e;
		password = p;
	}
	
	public Admin () {};
	
	public void setEmail(String e) {
		email = e;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setPass(String p) {
		password = p;
	}
	
	public String getPass() {
		return password;
	}
	
	public String toString() {
		return ("Email: " + email + "\nPassword: " + password);
	}
}
*/