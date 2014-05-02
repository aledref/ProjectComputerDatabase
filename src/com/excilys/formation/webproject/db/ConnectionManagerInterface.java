package com.excilys.formation.webproject.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public interface ConnectionManagerInterface {

	/**
	 * 
	 * @return A Connection to the database Root
	 */
	public Connection getConnection(); 
	
	/**
	 * 
	 * @param rs
	 * @param stmt
	 * @param cn
	 * @return true if the 
	 */
	public boolean disconnect(ResultSet rs,Statement stmt,Connection cn);
}