package com.sahm.scheduler.model.entity;

// @Entity(name = "Instrument")
public class Instrument {
	
	// @Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	// @Column(name="id", nullable=false, unique=true)
	private int id;
	
	String name;
	int requiredByTeacher;
	
	Instrument() {};
	
	public int getId() {return this.id; }
	public String getName() {return this.name;}
	public int getRequiredByTeacher() {return this.requiredByTeacher;}
	
	public void setName(String name) { this.name = name; }
	public void setRequiredByTeacher(int requiredByTeacher) { this.requiredByTeacher = requiredByTeacher; }
	
}
