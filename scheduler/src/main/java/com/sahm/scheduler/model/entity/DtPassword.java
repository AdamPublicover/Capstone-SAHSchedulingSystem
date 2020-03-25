package com.sahm.scheduler.model.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="DtPassword")
@Access(AccessType.FIELD)
//@NamedQuery(name="DtPassword.findByDsEmail",
//query = "SELECT p FROM DtPassword p WHERE p.DsEmail = ?1")
public class DtPassword {
	
	@Id
	@Column(name="DsEmail", nullable=false, unique=true)
	private String email;
	
	@Column(name="DsPassword", nullable=false)
	private String password;
	
	// IMPORTANT NOTE ->
	// THE ACCOUNT TYPE CORRESPONDS TO THE USER'S STATUS - I.E.:
	// 		1 - Administrator
	//		2 - Teacher
	//		3 - Parent
	//		4 - Teacher before first lesson ->
	//		5 - Parent before first lesson  -> When Elliott creates an account they become a 4/5.
	
	@Column(name="DiAccountType", nullable=false)
	private int DiAccountType;
	
	public DtPassword() { };
	
	public void setDsEmail(String dsEmail) { this.email = dsEmail; }
	public void setDsPassword(String dsPassword) { this.password = dsPassword; }
	public void setDiAccountType(int diAccountType) { this.DiAccountType = diAccountType; }
	public String getDsEmail() { return this.email; } 
	public String getDsPassword() { return this.password; }
	public int getDiAccountType() { return this.DiAccountType; }
	
	
	public String toString() {
		return this.email + "\n" + this.password;
	}

}
