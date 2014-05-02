package com.excilys.formation.webproject.service;

import java.util.List;

import com.excilys.formation.webproject.om.Computer;
import com.excilys.formation.webproject.om.Company;

/**
 * 
 * @author excilys
 *
 */
public interface MainServiceInterface {
	/**
	 * @return The Computer in the table computer matching the id
	 */
	public Computer findComputer(Long id);
	/**
	 * 
	 * @return a List of every Computer in the database computer
	 */
	public List getListComputer();
	/**
	 * 
	 * @return A List<Computer> of Computer in the table computer containing namefilter or whose company contains namefilter
	 */
	public List getListComputerWithName(String name);
	/**
	 * 
	 * @return A List<Computer> of Computer in the table computer ordered by the field corresponding to Integer attributenumber and the String order by default "ASC"
	 */
	public List getListComputerOrdered(Integer attributenumber);
	/**
	 * 
	 * @return A List<Computer> of Computer in the table computer ordered by the field corresponding to Integer attributenumber and the String order by default "ASC"
	 */
	public List getListComputerOrdered(Integer attributenumber,String order);
	public void insertComputer(Computer comp);
	/**
	 * 
	 * @param comp A Computer to be edited in the table computer
	 * @param id The id of the edited Computer
	 */
	public void editComputer(Computer comp,Long id);
	/**
	 * 
	 * @param id The id of the Computer to be removed in the table computer
	 */
	public void removeComputer(Long id);
	/**
	 * @return The Company in the table company matching the id
	 */
	public Company findCompany(Long id);
	/**
	 * 
	 * @return a List of every Company in the database company
	 */
	public List getListCompany();
	/**
	 * 
	 * @return A List<Company> of Company in the table computer containing namefilter
	 */
	public void insertCompany(Company comp);
}