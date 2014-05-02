package com.excilys.formation.webproject.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.excilys.formation.webproject.om.Computer;
import com.excilys.formation.webproject.dto.PageWrapper;

/**
 * 
 * @author excilys
 *
 */
public interface ComputerDAO{
	
	/**
	 * 
	 * @param rs The ResulSet from the query on the database Root
	 * @return A List of Computer
	 */
	public List extractFromResultSet(ResultSet rs) throws SQLException;
	
	/**
	 * @return The Computer in the table computer matching the id
	 */
	public Computer find(Long id);
	
	/**
	 * 
	 * @return A List<Computer> of Computer in the table computer
	 */
	public List getList();

	/**
	 * 
	 * @param pagewrapper
	 * @return
	 */
	public void getList(PageWrapper pagewrapper);
	
	/**
	 * 
	 * @param pageWrapper
	 * @return
	 */
	public Integer getListSizeWithName(PageWrapper pageWrapper);
	
	/**
	 * 
	 * @param pageWrapper
	 * @return
	 */
	public List getListWithName(PageWrapper pageWrapper);
	
	/**
	 * 
	 * @param comp A Computer to be added in the table computer
	 */
	public void insert(Computer comp);
	
	/**
	 * 
	 * @param comp A Computer to be edited in the table computer
	 * @param id The id of the edited Computer
	 */
	public void edit(Computer comp,Long id);
	
	/**
	 * 
	 * @param id The id of the Computer to be removed in the table computer
	 */
	public void remove(Long id);
}