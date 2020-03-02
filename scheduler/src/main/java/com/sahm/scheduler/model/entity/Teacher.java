package com.sahm.scheduler.model.entity;

//@Entity
public class Teacher {
	private String firstName;
	private String lastName;
	private String email;
	private int id;
    private String password;
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
