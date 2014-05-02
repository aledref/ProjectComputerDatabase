package com.excilys.formation.webproject.service;

import java.util.List;

import com.excilys.formation.webproject.om.Computer;
import com.excilys.formation.webproject.om.Company;
import com.excilys.formation.webproject.dto.PageWrapper;

/**
 * 
 * @author excilys
 *
 */
public interface MainService {
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
	 * @return 
	 */
	public Integer getListComputerSize();
	/**
	 * 
	 * @param pagewrapper
	 */
	public void getListComputer(PageWrapper pageWrapper); 
	/**
	 * 
	 * @param pageWrapper
	 * @return
	 */
	public Integer getListComputerSizeWithName(PageWrapper pageWrapper);
	/**
	 * 
	 * @return A List<Computer> of Computer in the table computer containing namefilter
	 */
	public List getListComputerWithName(PageWrapper pageWrapper);
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
	public Company findCompanyById(Long id);
	/**
	 * @return The Company in the table company matching the name
	 */
	public Company findCompanyByName(String name); 
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