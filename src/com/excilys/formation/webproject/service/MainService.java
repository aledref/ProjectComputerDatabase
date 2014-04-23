package com.excilys.formation.webproject.service;

import java.util.List;

import com.excilys.formation.webproject.dao.CompanyDAO;
import com.excilys.formation.webproject.dao.ComputerDAO;
import com.excilys.formation.webproject.om.Company;
import com.excilys.formation.webproject.om.Computer;

/**
 * 
 * @author excilys
 *
 */
public enum MainService implements MainServiceInterface{
	
	Singleton;
	
	@Override
	public Computer findComputer(Long id) {
		return ComputerDAO.Singleton.findComputer(id);
	}

	@Override
	public List getListComputer() {
		return ComputerDAO.Singleton.getListComputer();	
	}
	
	@Override
	public List getListComputerWithName(String name) {
		return ComputerDAO.Singleton.getListComputerWithName(name);
	}
	
	@Override
	public void insertComputer(Computer comp) {
		ComputerDAO.Singleton.insertComputer(comp);
	}
	
	@Override
	public void editComputer(Computer comp, Long id) {
		ComputerDAO.Singleton.editComputer(comp,id);
	}

	@Override
	public void removeComputer(Long id) {
		ComputerDAO.Singleton.removeComputer(id);
	}
	
	@Override
	public Company findCompany(Long id) {
		return CompanyDAO.Singleton.findCompany(id);
	}	
	
	@Override
	public List getListCompany() {
		return CompanyDAO.Singleton.getListCompany();
	}

	@Override
	public void insertCompany(Company comp) {
		CompanyDAO.Singleton.insertCompany(comp);
	}

}
