package com.excilys.formation.webproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.excilys.formation.webproject.om.Company;

/**
 * 
 * @author excilys
 *
 */
public enum CompanyDAO implements CompanyDAOInterface{

	Singleton ;

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
	/**
	 * 
	 * @param rs The ResulSet from the query on the database Root
	 * @return A List of Company
	 */
	public List extractFromResultSet(ResultSet rs) throws SQLException{
		ArrayList<Company> liste  = new ArrayList<>();
		
		while (rs.next()) {
			Company p =  new Company();
			p.setId(new Long(rs.getLong(1)));
			p.setName(rs.getString(2));			

			liste.add(p);
		}
		return liste;
	}
	/**
	 * @return The Company in the table company matching the id
	 */
	public Company findCompany(Long id) {
		ResultSet rs = null ;
		PreparedStatement stmt = null;
		Connection cn = null;
		Company company = null;

		try {
			cn = getConnection();
			stmt = cn.prepareStatement("SELECT * FROM company WHERE id = ?;");
			stmt.setString(1,String.valueOf(id));
			rs = stmt.executeQuery();	
			
			try {
				if (rs.next()) company = new Company (id,rs.getString("name"));				
			}
			catch (SQLException e) {
				System.out.println("Warning : SQL Exception on ResultSet");
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (!disconnect(rs,stmt,cn)) System.out.println("Warning : Exception while closing connection");
		}
		return company;
	}
	/**
	 * 
	 * @return A List<Company> of Company in the table company
	 */
	public List getListCompany() {
		ArrayList<Company> liste  = new ArrayList<>();
		ResultSet rs = null ;
		Statement stmt = null;
		Connection cn = null;

		try {

			cn = getConnection();
			stmt = cn.createStatement();
			rs = stmt.executeQuery("SELECT id, name FROM company;");
			
			liste = (ArrayList<Company>) extractFromResultSet(rs);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (!disconnect(rs,stmt,cn)) System.out.println("Warning : Exception while closing connection");
		}
		return liste;
	}
	/**
	 * 
	 * @param comp A Company to be added in the table company
	 */
	public void insertCompany(Company comp) {
		ResultSet rs = null ;
		PreparedStatement stmt = null;
		Connection cn = null;

		try {		
			cn = getConnection();
			stmt = cn.prepareStatement("INSERT into company(id,name) VALUES(?,?);");

			stmt.setString(1,String.valueOf(comp.getId()));
			stmt.setString(2,comp.getName());
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (!disconnect(rs,stmt,cn)) System.out.println("Warning : Exception while closing connection");
		}		
	}
}