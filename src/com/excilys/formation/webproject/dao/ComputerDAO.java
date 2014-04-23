package com.excilys.formation.webproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.excilys.formation.webproject.om.Company;
import com.excilys.formation.webproject.om.Computer;

/**
 * 
 * @author excilys
 *
 */
public enum ComputerDAO implements ComputerDAOInterface{

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
	 * @return A List of Computer
	 */
	public List extractFromResultSet(ResultSet rs) throws SQLException{
		ArrayList<Computer> liste  = new ArrayList<>();
		
		for (;rs.next();) {
			Computer p =  new Computer();
			p.setId(new Long(rs.getLong(1)));
			p.setName(rs.getString(2));
			try {
				p.setIntroduced(rs.getTimestamp(3));
			}catch (java.sql.SQLException e) {
				System.out.println("Timestamp introduced Null on " + p.getName());
			}
			try {
				p.setDiscontinued(rs.getTimestamp(4));
			}catch (java.sql.SQLException e) {
				System.out.println("Timestamp discontinued Null on " + p.getName());
			}		
			p.setCompany(new Company(new Long(rs.getLong(5)),rs.getString(6)));				
			liste.add(p);
		}
		return liste;
	}
	/**
	 * @return The Computer in the table computer matching the id
	 */
	public Computer findComputer(Long id) {
		ArrayList<Computer> liste  = new ArrayList<>();
		ResultSet rs = null ;
		PreparedStatement stmt = null;
		Connection cn = null;	
		Computer computer = null;

		try {
			cn = getConnection();
			stmt = cn.prepareStatement("SELECT DISTINCT cpu.id,cpu.name,cpu.introduced,cpu.discontinued,cpu.company_id,cpy.name FROM computer AS cpu "
					  				  +"LEFT OUTER JOIN company AS cpy ON cpu.company_id = cpy.id WHERE cpu.id = ?;");
			stmt.setString(1,String.valueOf(id));
			rs = stmt.executeQuery();
			
			liste = (ArrayList<Computer>) extractFromResultSet(rs);
			
			if (liste.size() == 0) computer = null;
			else computer = liste.get(0);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (!disconnect(rs,stmt,cn)) System.out.println("Warning, Exception while closing connection");
		}
		return computer;
	}
	/**
	 * 
	 * @return A List<Computer> of Computer in the table computer
	 */
	public List getListComputer() {
		ArrayList<Computer> liste  = new ArrayList<>();
		ResultSet rs = null ;
		Statement stmt = null;
		Connection cn = null;

		try {

			cn = getConnection();
			stmt = cn.createStatement();
			rs = stmt.executeQuery("SELECT DISTINCT cpu.id,cpu.name,cpu.introduced,cpu.discontinued,cpu.company_id,cpy.name FROM computer AS cpu "
								  +"LEFT OUTER JOIN company AS cpy ON cpu.company_id = cpy.id;");
			
			liste = (ArrayList<Computer>) extractFromResultSet(rs);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (!disconnect(rs,stmt,cn)) System.out.println("Warning, Exception while closing connection");
		}
		return liste;
	}
	/**
	 * 
	 * @return A List<Computer> of Computer in the table computer containing namefilter
	 */
	public List getListComputerWithName(String namefilter) {	

		ArrayList<Computer> liste  = new ArrayList<>();
		ResultSet rs = null ;
		PreparedStatement stmt = null;
		Connection cn = null;

		try {
			cn = getConnection();
			stmt = cn.prepareStatement("SELECT cpu.id,cpu.name,cpu.introduced,cpu.discontinued,cpu.company_id,cpy.name FROM computer AS cpu " 
									  +"LEFT OUTER JOIN company AS cpy ON cpu.company_id = cpy.id WHERE cpu.name LIKE ? OR cpy.name LIKE ?;");
			stmt.setString(1,"%"+namefilter+"%");
			stmt.setString(2,"%"+namefilter+"%");
			System.out.println(stmt.toString());
			rs = stmt.executeQuery();

			liste = (ArrayList<Computer>) extractFromResultSet(rs);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (!disconnect(rs,stmt,cn)) System.out.println("Warning, Exception while closing connection");
		}
		return liste;	
	}
	/**
	 * 
	 * @param comp A Computer to be added in the table computer
	 */
	public void insertComputer(Computer comp) {

		ResultSet rs = null ;
		PreparedStatement stmt = null;
		Connection cn = null;

		try {

			cn = getConnection();
			stmt = cn.prepareStatement("INSERT into computer(name,introduced,discontinued,company_id) VALUES (?,?,?,?);");

			stmt.setString(1,comp.getName());
			stmt.setString(2,String.valueOf(comp.getIntroduced()));
			stmt.setString(3,String.valueOf(comp.getDiscontinued()));
			stmt.setString(4,String.valueOf(comp.getCompany().getId()));
			stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (!disconnect(rs,stmt,cn)) System.out.println("Warning, Exception while closing connection");
		}		
	}
	/**
	 * 
	 * @param comp A Computer to be edited in the table computer
	 * @param id The id of the edited Computer
	 */
	public void editComputer(Computer comp,Long id){

		ResultSet rs = null ;
		PreparedStatement stmt = null;
		Connection cn = null;

		try {

			cn = getConnection();
			stmt = cn.prepareStatement("UPDATE computer SET name=?, introduced=?, discontinued=?, company_id=? WHERE id = ?");

			stmt.setString(1,comp.getName());
			stmt.setString(2,String.valueOf(comp.getIntroduced()));
			stmt.setString(3,String.valueOf(comp.getDiscontinued()));
			stmt.setString(4,String.valueOf(comp.getCompany().getId()));
			stmt.setString(5,String.valueOf(id));
			stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (!disconnect(rs,stmt,cn)) System.out.println("Warning, Exception while closing connection");
		}		
	}
	/**
	 * 
	 * @param id The id of the Computer to be removed in the table computer
	 */
	public void removeComputer(Long id) {

		ResultSet rs = null ;
		PreparedStatement stmt = null;
		Connection cn = null;

		try {

			cn = getConnection();
			stmt = cn.prepareStatement("DELETE FROM computer WHERE id = ?;");

			stmt.setString(1,String.valueOf(id));
			stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (!disconnect(rs,stmt,cn)) System.out.println("Warning, Exception while closing connection");
		}		
	}
}