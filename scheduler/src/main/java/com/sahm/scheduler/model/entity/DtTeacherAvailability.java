package com.sahm.scheduler.model.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DtTeacherAvailability")
@Access(AccessType.FIELD)
public class DtTeacherAvailability {
	
	@Id
	@Column(name="DiTeacherAvailabilityId", nullable=false, unique=true)
	private int DiTeacherAvailabilityId;
	
	@Column(name="DsTeacherEmail", nullable=false, unique=false)
	private String dsteacheremail;
	
	private int DiMOffStart;
	private int DiMOffEnd;
	private int DiTOffStart;
	private int DiTOffEnd;
	private int DiWOffStart;
	private int DiWOffEnd;
	private int DiROffStart;
	private int DiROffEnd;
	private int DiFOffStart;
	private int DiFOffEnd;
	private int DiSatOffStart;
	private int DiSatOffEnd;
	private int DiSunOffStart;
	private int DiSunOffEnd;
	
	public DtTeacherAvailability() {}
	
	public void setDsTeacherEmail(String DsTeacherEmail) {this.dsteacheremail = DsTeacherEmail;}
	public void setDiMOffStart(int DiMOffStart) {this.DiMOffStart = DiMOffStart; }
	public void setDiMOffEnd(int DiMOffEnd) { this.DiMOffEnd = DiMOffEnd; }
	public void setDiTOffStart(int DiTOffStart) { this.DiTOffStart = DiTOffStart; }
	public void setDiTOffEnd(int DiTOffEnd) { this.DiTOffEnd = DiTOffEnd; }
	public void setDiWOffStart(int DiWOffStart) { this.DiWOffStart = DiWOffStart; }
	public void setDiWOffEnd(int DiWOffEnd) { this.DiWOffEnd = DiWOffEnd; }
	public void setDiROffStart(int DiROffStart) { this.DiROffStart = DiROffStart; }
	public void setDiROffEnd(int DiROffEnd) { this.DiROffEnd = DiROffEnd; }
	public void setDiFOffStart(int DiFOffStart) { this.DiFOffStart = DiFOffStart; }
	public void setDiFOffEnd(int DiFOffEnd) { this.DiFOffEnd = DiFOffEnd; }
	public void setDiSatOffStart(int DiSatOffStart) { this.DiSatOffStart = DiSatOffStart; }
	public void setDiSatOffEnd(int DiSatOffEnd) { this.DiSatOffEnd = DiSatOffEnd; }
	public void setDiSunOffStart(int DiSunOffStart) { this.DiSunOffStart = DiSunOffStart; }
	public void setDiSunOffEnd(int DiSunOffEnd) { this.DiSunOffEnd = DiSunOffEnd; }
	
	public int getDiTeacherAvailabilityId() { return this.DiTeacherAvailabilityId; }
	public String getDsTeacherEmail() { return this.dsteacheremail;}
	public int getDiMOffStart() { return this.DiMOffStart; }
	public int getDiMOffEnd() { return this.DiMOffEnd; }
	public int getDiTOffStart() { return this.DiTOffStart; }
	public int getDiTOffEnd() { return this.DiTOffEnd; }
	public int getDiWOffStart() { return this.DiWOffStart; }
	public int getDiWOffEnd() { return this.DiWOffEnd; }
	public int getDiROffStart() { return this.DiROffStart; }
	public int getDiROffEnd() { return this.DiROffEnd; }
	public int getDiFOffStart() { return this.DiFOffStart; }
	public int getDiFOffEnd() { return this.DiFOffEnd; }
	public int getDiSatOffStart() { return this.DiSatOffStart; }
	public int getDiSatOffEnd() { return this.DiSatOffEnd; }
	public int getDiSunOffStart() { return this.DiSunOffStart; }
	public int getDiSunOffEnd() { return this.DiSunOffEnd; }
}
