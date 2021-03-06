package com.excilys.formation.webproject.service;

import java.util.List;

import com.excilys.formation.webproject.om.Computer;
import com.excilys.formation.webproject.om.Company;
import com.excilys.formation.webproject.common.PageWrapper;

/**
 * 
 * @author excilys
 *
 */
public interface MainService {
	/**
	 * @return the Computer in the table computer matching the id
	 */
	public Computer findComputer(Long id);
	/**
	 * 
	 * @return the size of the table computer
	 */
	public Integer getListComputerSize();
	/**
	 * 
	 * @param pagewrapper An object countaining the info for the next query
	 */
	public void getListComputer(PageWrapper pageWrapper); 
	/**
	 * 
	 * @param pageWrapper
	 * @return the size of the List<Computer> of Computer in the table computer to be displayed
	 */
	public Integer getListComputerSizeWithName(PageWrapper pageWrapper);
	/**
	 * 
	 * @param pageWrapper
	 * @return a List<Computer> of Computer in the table computer to be displayed
	 */
	public List getListComputerWithName(PageWrapper pageWrapper);
	/**
	 * 
	 * @param comp A Computer to be put in the table computer to be displayed
	 */
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
	 * @return the Company in the table company matching the id
	 */
	public Company findCompanyById(Long id);
	/**
	 * @return the Company in the table company matching the name
	 */
	public Company findCompanyByName(String name); 
	/**
	 * 
	 * @return a List<Company> of every Company in the table company
	 */
	public List getListCompany();
	/**
	 * 
	 * @param comp A Computer to be put in the table company
	 */
	public void insertCompany(Company comp);
}