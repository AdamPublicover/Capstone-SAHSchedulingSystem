package com.sahm.scheduler.model.entity;
/*
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
*/
public class Teacher {  }
/*
@Entity
@Access(AccessType.FIELD)
public class Teacher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", nullable=false, unique=true)
	private int id;
	
	private String firstName;
	private String lastName;
	
	@Column(name="email", nullable=false)
	private String email;
	
	@Column(name="password", nullable=false)
    private String password;
    
    @Enumerated(EnumType.STRING)
    private Instrument instrument;

    public Teacher(String firstName, String lastName, int i, String e, String p, Instrument in){

        this.firstName = firstName;
        this.lastName = lastName;
        id = i;
        email = e;
        password = p;
        instrument = in;

    }
    
    // required by JPA
    public Teacher() {} ;
    
    // need to finish setters
    public void setFName(String firstName) { this.firstName = firstName; }

    public String getFName(){
        return this.firstName;
    }
    
    public String getLName() {
    	return this.lastName;
    }

    public int getId(){
        return id;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    public String getInstrument(){
        return this.instrument.getName();
    }

    public String toString(){
        String s = "Name: " + getLName() + ", " + getFName() + "\nID: " + id + "\nEmail: " + email + "\nPassword: " + password + "\nInstrument: " + instrument.getName();
        return s;
    }
}
*/