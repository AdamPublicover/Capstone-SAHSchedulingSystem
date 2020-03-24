package com.sahm.scheduler.model.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DtInstrument")
@Access(AccessType.FIELD)
public class DtInstrument {
	
	@Id
	@Column(name="DiInstrumentId", nullable=false, unique=true)
	private int DiInstrumentId;
	
	@Column(name="DsInstrumentName", nullable=false, unique=true)
	String DsInstrumentName;
	
	// This column indicates whether or not a teacher needs to bring it to the lesson.
	@Column(name="DiRequiredByTeacher", nullable=false)
	int DiRequiredByTeacher;
	
	public DtInstrument() {};
	
	public int getId() {return this.DiInstrumentId; }
	public String getName() {return this.DsInstrumentName;}
	public int getRequiredByTeacher() {return this.DiRequiredByTeacher;}
	
	public void setName(String name) { this.DsInstrumentName = name; }
	public void setRequiredByTeacher(int requiredByTeacher) { this.DiRequiredByTeacher = requiredByTeacher; }
	
	public String toString() {
		String out = this.DsInstrumentName;
		if (this.DiRequiredByTeacher == 1) { out += ", is required by teacher"; }
		return out;
	}
}
