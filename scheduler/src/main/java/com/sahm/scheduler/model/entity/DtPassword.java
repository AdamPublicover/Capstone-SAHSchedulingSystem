package com.sahm.scheduler.model.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DtPassword")
@Access(AccessType.FIELD)
public class DtPassword {
	
	@Id
	@Column(name="DsEmail", nullable=false, unique=true)
	private String DsEmail;
	
	@Column(name="DsPassword", nullable=false)
	private String DsPassword;
	
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
	
	public void setDsEmail(String dsEmail) { this.DsEmail = dsEmail; }
	public void setDsPassword(String dsPassword) { this.DsPassword = dsPassword; }
	public void setDiAccountType(int diAccountType) { this.DiAccountType = diAccountType; }
	public String getDsEmail() { return this.DsEmail; } 
	public String getDsPassword() { return this.DsPassword; }
	public int getDiAccountType() { return this.DiAccountType; }

}
