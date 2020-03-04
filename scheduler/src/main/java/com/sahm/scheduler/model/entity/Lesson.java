package com.sahm.scheduler.model.entity;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Lesson { }

/*
@Entity
@Access(AccessType.FIELD)
public class Lesson {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", nullable=false, unique=true)
	private int id;
	
	@Enumerated(EnumType.STRING)
	@Column(name="teacher", nullable=false)
	private Teacher teacher;
	
	@Enumerated(EnumType.STRING)
	@Column(name="parent", nullable=false)
	private Parent parent;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="startDate", nullable=false)
	private Date startDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="endDate", nullable=false)
	private Date endDate;

	
	public Lesson() {} ;
	
	public String getParentAddress() {
		return this.parent.getAddress();
	}
	
	public int getId () { return this.id;}
	public Teacher getTeacher() {return this.teacher;}
	public Parent getParent() {return this.parent;}
	public Date getStartDate() {return this.startDate;}
	public Date getEndDate() {return this.endDate;}
	public void setId(int Id) { this.id = Id; }
	public void setTeacher(Teacher teacher) {this.teacher = teacher;}
	public void setParent(Parent parent) {this.parent = parent;}
	public void setStartDate(Date date) {this.startDate = date;}
	public void setEndDate(Date date) {this.endDate = date;}
}
*/