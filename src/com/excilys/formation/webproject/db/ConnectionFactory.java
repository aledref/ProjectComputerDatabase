package com.excilys.formation.webproject.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 
 * @author excilys
 *
 */
public interface ConnectionFactory {

	/**
	 * 
	 * @return A Connection to the database Root
	 */
	public Connection getConnection(); 
	
	/**
	 * 
	 * @param rs The ResultSet of the database query
	 * @param stmt The Statement for the database query
	 * @param cn The Connection to the database
	 */
	public void disconnect(ResultSet rs,Statement stmt,Connection cn);
}