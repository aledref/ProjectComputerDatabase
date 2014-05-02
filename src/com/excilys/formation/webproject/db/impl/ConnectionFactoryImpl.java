package com.excilys.formation.webproject.db.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.excilys.formation.webproject.db.ConnectionFactory;

/**
 * 
 * @author excilys
 *
 */
public enum ConnectionFactoryImpl implements ConnectionFactory{
	Singleton;

	/**
	 * 
	 * @return A Connection to the database Root
	 */
	public Connection getConnection() {
		Connection cn = null;
		Context ctx;
		DataSource ds;
		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/Root");
			cn = ds.getConnection();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cn;
	}

	/**
	 * 
	 * @param rs The ResultSet of the database query
	 * @param stmt The Statement for the database query
	 * @param cn The Connection to the database
	 */
	public void disconnect(ResultSet rs,Statement stmt,Connection cn) throws IllegalStateException{
		if (rs != null) {
			try {
				rs.close();
			} catch(SQLException e) {
				throw new IllegalStateException("ResultSet could not be released");
			}
		} if (stmt != null) {
			try {
				stmt.close();
			} catch(SQLException e) {
				throw new IllegalStateException("Statement could not be released");
			}
		} if (cn != null){
			try { 	
				cn.close();
			} catch (SQLException e) {
				throw new IllegalStateException("Connection could not be released");
			}
		}
	}
}