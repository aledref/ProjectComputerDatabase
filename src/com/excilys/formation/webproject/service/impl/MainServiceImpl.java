package com.excilys.formation.webproject.service.impl;

import java.util.List;

import com.excilys.formation.webproject.dao.impl.CompanyDAOImpl;
import com.excilys.formation.webproject.dao.impl.ComputerDAOImpl;
import com.excilys.formation.webproject.om.Company;
import com.excilys.formation.webproject.om.Computer;
import com.excilys.formation.webproject.service.MainService;
import com.excilys.formation.webproject.dto.PageWrapper;

/**
 * 
 * @author excilys
 *
 */
public enum MainServiceImpl implements MainService{
	
	Singleton;

	/**
	 * @return the Computer in the table computer matching the id
	 */
	@Override
	public Computer findComputer(Long id) {
		return ComputerDAOImpl.Singleton.find(id);
	}
	
	/**
	 * 
	 * @return the size of the table computer
	 */
	@Override
	public Integer getListComputerSize() {
		return ComputerDAOImpl.Singleton.getListSize();	
	}
	
	/**
	 * 
	 * @param pagewrapper An object countaining the info for the next query
	 */
	@Override
	public void getListComputer(PageWrapper pageWrapper) {
		ComputerDAOImpl.Singleton.getList(pageWrapper);
	}
	
	/**
	 * 
	 * @param pageWrapper
	 * @return the size of the List<Computer> of Computer in the table computer to be displayed
	 */
	@Override
	public Integer getListComputerSizeWithName(PageWrapper pageWrapper) {
		return ComputerDAOImpl.Singleton.getListSizeWithName(pageWrapper);
	}
	
	/**
	 * 
	 * @param pageWrapper
	 * @return a List<Computer> of Computer in the table computer to be displayed
	 */
	@Override
	public List getListComputerWithName(PageWrapper pageWrapper) {
		return ComputerDAOImpl.Singleton.getListWithName(pageWrapper);
	}

	/**
	 * 
	 * @param comp A Computer to be put in the table computer to be displayed
	 */
	@Override
	public void insertComputer(Computer comp) {		
		ComputerDAOImpl.Singleton.insert(comp);
	}
	
	/**
	 * 
	 * @param comp A Computer to be edited in the table computer
	 * @param id The id of the edited Computer
	 */
	@Override
	public void editComputer(Computer comp, Long id) {
		ComputerDAOImpl.Singleton.edit(comp,id);
	}
	
	/**
	 * 
	 * @param id The id of the Computer to be removed in the table computer
	 */
	@Override
	public void removeComputer(Long id) {
		ComputerDAOImpl.Singleton.remove(id);
	}
	
	/**
	 * @return the Company in the table company matching the id
	 */
	@Override
	public Company findCompanyById(Long id) {
		return CompanyDAOImpl.Singleton.findById(id);
	}
	
	/**
	 * @return the Company in the table company matching the name
	 */
	@Override
	public Company findCompanyByName(String name) {
		return CompanyDAOImpl.Singleton.findByName(name);
	}	
	
	/**
	 * 
	 * @return a List<Company> of every Company in the table company
	 */
	@Override
	public List getListCompany() {
		return CompanyDAOImpl.Singleton.getList();
	}
	
	/**
	 * 
	 * @param comp A Computer to be put in the table company
	 */
	@Override
	public void insertCompany(Company comp) {
		CompanyDAOImpl.Singleton.insert(comp);
	}
}