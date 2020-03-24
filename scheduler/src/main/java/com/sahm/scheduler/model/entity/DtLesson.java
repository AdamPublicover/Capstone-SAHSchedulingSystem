package com.sahm.scheduler.model.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="DtLesson")
@Access(AccessType.FIELD)
public class DtLesson {
	
	@Id
	@Column(name="DiLessonId", nullable=false, unique=true)
	private int DiLessonId;
	
	@Column(name="DsTeacherEmail", nullable=false)
	String DsTeacherEmail;
	
	@Column(name="DsParentEmail", nullable=false)
	String DsParentEmail;
	
	@Column(name="DiInstrumentId", nullable=false)
	int DiInstrumentId;
	
	public DtLesson() {}
	
	public void setDsTeacherEmail( String DsTeacherEmail) { this.DsTeacherEmail = DsTeacherEmail; }
	public void setDsParentEmail( String DsParentEmail) { this.DsParentEmail = DsParentEmail; }
	public void setDiInstrumentId( int DiInstrumentId) { this.DiInstrumentId = DiInstrumentId; }
	
	public int getId() { return this.DiLessonId; }
	public String getDsTeacherEmail() {return this.DsTeacherEmail;}
	public String getDsParentEmail() { return this.DsParentEmail; }
	public int getDiInstrumentId() { return this.DiInstrumentId; }
	
}