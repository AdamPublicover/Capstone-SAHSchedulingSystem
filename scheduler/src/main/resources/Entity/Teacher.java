package com.sahm.scheduler.Entity;

public class Teacher {
	private String name;
    private int id;
    private String email;
    private String password;
    private String instrument;

    public Teacher(String n, int i, String e, String p, String in){

        name = n;
        id = i;
        email = e;
        password = p;
        instrument = in;

    }

    public String getName(){
        return name;
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
        return instrument;
    }

    public String toString(){
        String s = "Name: " + name + "\nID: " + id + "\nEmail: " + email + "\nPassword: " + password + "\nInstrument: " + instrument;
        return s;
    }
}
