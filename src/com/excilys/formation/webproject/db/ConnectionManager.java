package com.excilys.formation.webproject.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public enum ConnectionManager implements ConnectionManagerInterface{
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
	 * @param rs
	 * @param stmt
	 * @param cn
	 * @return true if the 
	 */
	public boolean disconnect(ResultSet rs,Statement stmt,Connection cn) {
		if (rs != null) {
			try {
				rs.close();
			} catch(SQLException e) {
			return false;
			}
		} if (stmt != null) {
			try {
				stmt.close();
			} catch(SQLException e) {
				return false;
			}
		} if (cn != null){
			try { 	
				cn.close();
			} catch (SQLException e) {
				return false;
			}
		}
		return true;
	}
}