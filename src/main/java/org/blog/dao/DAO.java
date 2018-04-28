package org.blog.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DAO {

	Connection con;	
	PreparedStatement stmt;
	ResultSet rs;
	
	private final String URL = "jdbc:postgresql://localhost:5432/db_blog";
	private final String USER = "postgres";
	private final String PASS = "admin";
	
	protected void open()throws Exception{
		
		Class.forName("org.postgresql.Driver");
		con = DriverManager.getConnection(URL, USER, PASS);
		
	}
	
	protected void close()throws Exception{
		con.close();
	}

	
}
