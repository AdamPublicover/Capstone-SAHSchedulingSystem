package com.sahm.scheduler.model.entity;

import java.util.List;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "DtParent", schema="sahs_scheduler")
@Access(AccessType.FIELD)
public class DtParent {
	
	@Id
	@Column(name="DsEmail", nullable=false, unique=true)
	private String dsEmail;
	
	@Column(name="DsFirstName", nullable=true)
	private String DsFirstName;
	
	@Column(name="DsLastName", nullable=true)
	private String DsLastName;
	
	@Column(name="DsAddress", nullable=false)
	private String DsAddress;
	
	@Column(name="DsPhone", nullable=false)
	private String DsPhone;
	
	public DtParent() { }

	public String getEmail() {
		return this.dsEmail;
	}

	public void setEmail(String email) {
		this.dsEmail = email;
	}

	public String getAddress() {
		return this.DsAddress;
	}

	public void setAddress(String Address) {
		this.DsAddress = Address;
	}

	public String getFirstName() {
		return this.DsFirstName;
	}

	public void setFirstName(String firstName) {
		this.DsFirstName = firstName;
	}

	public String getLastName() {
		return this.DsLastName;
	}

	public void setLastName(String lastName) {
		this.DsLastName = lastName;
	}

	
	public String getPhoneNum() {
		return this.DsPhone;
	}

	public void setPhoneNum(String phoneNum) {
		this.DsPhone = phoneNum;
	}
}