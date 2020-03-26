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
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "DtTeacher", schema="sahs_scheduler")
//@NamedQuery(name = "DtTeacher.findTeacherByInstrument",
//      query = "SELECT * FROM DtTeacher WHERE DsEmail IN "
//    		+ "( SELECT t.DsEmail FROM tTeacherPlaysInstrument t WHERE DiInstrumentId == ?1 ) ")
@Access(AccessType.FIELD)
public class DtTeacher {
	
	@Id
	@Column(name="DsEmail", nullable=false, unique=true)
	private String DsEmail;
	
	private String DsfirstName;
	private String DslastName;
    
    // required by JPA
    public DtTeacher() {} ;
    
    // need to finish setters
    public void setFName(String firstName) { this.DsfirstName = firstName; }
    public void setLName(String lastName) { this.DslastName = lastName; }
    public void setEmail(String DtEmail) { this.DsEmail = DtEmail; }
    public String getFName(){
        return this.DsfirstName;
    }
    
    public String getLName() {
    	return this.DslastName;
    }

    public String getEmail(){
        return this.DsEmail;
    }

    public String toString(){
        String s = "Name: " + getLName() + ", " + getFName() + "\nEmail: " + this.DsEmail;
        return s;
    }
}