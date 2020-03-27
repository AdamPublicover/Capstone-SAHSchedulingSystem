package com.sahm.scheduler.model.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

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
	private int dilessonid;
	
	@Column(name="DdLessonDate", nullable=false, unique=false)
	private java.sql.Timestamp DdLessonDate;
	
	@Column(name="DiLength", nullable=false, unique=false)
	private int DiLength;
	
	@Column(name ="DsParentEmail")
	private String dsparentemail;
	
	@Column(name = "DsTeacherEmail")
	private String dsteacheremail;
	
	@Column(name="DiInstrumentId")
	private int diinstrumentid;
	
	public DtLessonTime() {}
	
	
	public int getDiLessonId() { return this.dilessonid; }
	public java.sql.Timestamp getDdLessonDate() { return this.DdLessonDate; }
	public int getDiLength() { return this.DiLength; }
	public String getDsParentEmail() { return this.dsparentemail; }
	public String getDsTeacherEmail() { return this.dsteacheremail; }
	public int getDiInstrumentId() { return this.diinstrumentid; }
	public String getStartTimeAsString() { 
		String date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").format(this.DdLessonDate);
		return date;
	}
	public String getEndTimeAsString() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(this.DdLessonDate);
		calendar.add(Calendar.MINUTE, this.DiLength);
		String date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").format(calendar);
		return date;
	}
	
	public void setDiLessonId(int DiLessonId) { this.dilessonid = DiLessonId; }
	public void setDdLessonDate(String datetime) { this.DdLessonDate = java.sql.Timestamp.valueOf(datetime); } 
	public void setDiLength(int DiLength) { this.DiLength = DiLength; }
	public void setDsParentEmail(String dsParentEmail ) { this.dsparentemail = dsParentEmail; }
	public void setDsTeacherEmail(String dsTeacherEmail ) { this.dsteacheremail = dsTeacherEmail; }
	public void setDiInstrumentId(int diInstrumentId ) { this.diinstrumentid = diInstrumentId; }
	
	
	public String ToString() { 
		String date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").format(this.DdLessonDate);
		return date + ", " + this.dsparentemail;
	}
}
