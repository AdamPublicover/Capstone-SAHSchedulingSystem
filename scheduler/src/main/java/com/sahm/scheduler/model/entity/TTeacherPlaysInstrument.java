package com.sahm.scheduler.model.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tTeacherPlaysInstrument")
@Access(AccessType.FIELD)
public class TTeacherPlaysInstrument {
	
	@Id
	@Column(name="tTeacherPlaysInstrumentId", nullable=false, unique=true)
	private int tTeacherPlaysInstrumentId;
	private int DiInstrumentId;
	private String DsEmail;
	
	public TTeacherPlaysInstrument() {}
	
	public void setDtInstrumentId(int DtInstrumentId) { this.DiInstrumentId = DtInstrumentId; }
	public void setDsTeacherEmail(String DsTeacherEmail) { this.DsEmail = DsTeacherEmail; }
	
	public int gettTeacherPlaysInstrumentId() { return this.tTeacherPlaysInstrumentId; }
	public int getDtInstrumentId() { return this.DiInstrumentId; }
	public String DsTeacherEmail() { return this.DsEmail; }
}
