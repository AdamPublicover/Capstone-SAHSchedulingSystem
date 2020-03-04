package com.sahm.scheduler.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Instrument")
public class Instrument {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", nullable=false, unique=true)
	private int id;
	
	@Column(name="Name", nullable=false, unique=true)
	String name;
	
	// This column indicates whether or not a teacher needs to bring it to the lesson.
	@Column(name="RequiredByTeacher", nullable=false)
	int requiredByTeacher;
	
	Instrument() {};
	
	public int getId() {return this.id; }
	public String getName() {return this.name;}
	public int getRequiredByTeacher() {return this.requiredByTeacher;}
	
	public void setName(String name) { this.name = name; }
	public void setRequiredByTeacher(int requiredByTeacher) { this.requiredByTeacher = requiredByTeacher; }
	
	public String toString() {
		String out = this.name;
		if (this.requiredByTeacher == 1) { out += ", is required by teacher"; }
		
		return out;
	}
	
}
