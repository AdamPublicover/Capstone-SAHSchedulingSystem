package com.sahm.scheduler.model.entity;

public class Admin {
	
	private String email, password; 
	
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
