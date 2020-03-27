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
	private int lessonid;
	
	@Column(name="DsTeacherEmail", nullable=false)
	String dsteacheremail;
	
	@Column(name="DsParentEmail", nullable=false)
	String dsparentemail;
	
	@Column(name="DiInstrumentId", nullable=false)
	int DiInstrumentId;
	
	public DtLesson() {}
	
	public void setDsTeacherEmail( String DsTeacherEmail) { this.dsteacheremail = DsTeacherEmail; }
	public void setDsParentEmail( String DsParentEmail) { this.dsparentemail = DsParentEmail; }
	public void setDiInstrumentId( int DiInstrumentId) { this.DiInstrumentId = DiInstrumentId; }
	
	public int getId() { return this.lessonid; }
	public String getDsTeacherEmail() {return this.dsteacheremail;}
	public String getDsParentEmail() { return this.dsparentemail; }
	public int getDiInstrumentId() { return this.DiInstrumentId; }
	
	public String ToString() { return "Parent: " + this.dsparentemail + "\nTeacher: " + this.dsteacheremail + "\nInstrumentId: " + this.DiInstrumentId; }
	
}