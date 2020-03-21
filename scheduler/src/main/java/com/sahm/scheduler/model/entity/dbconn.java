package com.sahm.scheduler.model.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbconn {
	
	// import the sql file into your local databases for the code below to run 
	
	public static Connection con;
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			System.err.println("Unable to load MySQL Driver");
		}
	}
	
	public ResultSet Query(String inputQuery) throws Exception {
		
		Statement stmt = con.createStatement();
		ResultSet rset = stmt.executeQuery(inputQuery);
		return rset;
	}
	
	public static void main(String args[]) throws Exception {		
		
		String jdbcUrl = "jdbc:mysql://localhost/sahs_scheduler";
		
			con = DriverManager.getConnection(jdbcUrl, "root", "root");
			System.out.println("Connected!");		
		
	}

}
