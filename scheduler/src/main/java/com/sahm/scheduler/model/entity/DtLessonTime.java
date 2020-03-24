package com.sahm.scheduler.model.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DtLessonTime")
@Access(AccessType.FIELD)
public class DtLessonTime {
	
	@Id
	@Column(name="DiLessonTimeId", nullable=false, unique=true)
	private int DiLessonTimeId;
	
	@Column(name="DiLessonId", nullable=false, unique=false)
	private int DiLessonId;
	
	@Column(name="DdLessonDate", nullable=false, unique=false)
	private java.sql.Timestamp DdLessonDate;
	
	@Column(name="DiLength", nullable=false, unique=false)
	private int DiLength;
	
	public DtLessonTime() {}
	
	
	public int getDiLessonId() { return this.DiLessonId; }
	public java.sql.Timestamp getDdLessonDate() { return this.DdLessonDate; }
	public int getDiLength() { return this.DiLength; }
	
	public void setDiLessonId(int DiLessonId) { this.DiLessonId = DiLessonId; }
	public void setDdLessonDate(String datetime) { this.DdLessonDate = java.sql.Timestamp.valueOf(datetime); } 
	public void setDiLength(int DiLength) { this.DiLength = DiLength; }
	
}
