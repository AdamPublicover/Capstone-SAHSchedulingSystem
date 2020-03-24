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
	private int DtInstrumentId;
	private String DsTeacherEmail;
	
	public TTeacherPlaysInstrument() {}
	
	public void setDtInstrumentId(int DtInstrumentId) { this.DtInstrumentId = DtInstrumentId; }
	public void setDsTeacherEmail(String DsTeacherEmail) { this.DsTeacherEmail = DsTeacherEmail; }
	
	public int gettTeacherPlaysInstrumentId() { return this.tTeacherPlaysInstrumentId; }
	public int getDtInstrumentId() { return this.DtInstrumentId; }
	public String DsTeacherEmail() { return this.DsTeacherEmail; }
}
