package com.excilys.formation.webproject.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DAOInterface {

	/**
	 * 
	 * @return A Connection to the database Root
	 */
	public Connection getConnection();
	
	/**
	 * 
	 * @param rs The ResulSet from the query on the database Root
	 * @return A List of Computer
	 */
	public List extractFromResultSet(ResultSet rs) throws SQLException;
	
	/**
	 * 
	 * @param rs
	 * @param stmt
	 * @param cn
	 * @return true if the 
	 */
	public boolean disconnect(ResultSet rs,Statement stmt,Connection cn) 
}
