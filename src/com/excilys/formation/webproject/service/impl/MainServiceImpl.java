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
	
	@Override
	public Computer findComputer(Long id) {
		return ComputerDAOImpl.Singleton.find(id);
	}

	@Override
	public List getListComputer() {
		return ComputerDAOImpl.Singleton.getList();	
	}
	
	@Override
	public Integer getListComputerSize() {
		return ComputerDAOImpl.Singleton.getListSize();	
	}
	
	@Override
	public void getListComputer(PageWrapper pageWrapper) {
		ComputerDAOImpl.Singleton.getList(pageWrapper);
	}
	
	@Override
	public Integer getListComputerSizeWithName(PageWrapper pageWrapper) {
		return ComputerDAOImpl.Singleton.getListSizeWithName(pageWrapper);
	}
	
	@Override
	public List getListComputerWithName(PageWrapper pageWrapper) {
		return ComputerDAOImpl.Singleton.getListWithName(pageWrapper);
	}

	@Override
	public void insertComputer(Computer comp) {
		ComputerDAOImpl.Singleton.insert(comp);
	}
	
	@Override
	public void editComputer(Computer comp, Long id) {
		ComputerDAOImpl.Singleton.edit(comp,id);
	}

	@Override
	public void removeComputer(Long id) {
		ComputerDAOImpl.Singleton.remove(id);
	}
	
	@Override
	public Company findCompanyById(Long id) {
		return CompanyDAOImpl.Singleton.findById(id);
	}
	
	@Override
	public Company findCompanyByName(String name) {
		return CompanyDAOImpl.Singleton.findByName(name);
	}	
	
	@Override
	public List getListCompany() {
		return CompanyDAOImpl.Singleton.getList();
	}

	@Override
	public void insertCompany(Company comp) {
		CompanyDAOImpl.Singleton.insert(comp);
	}

}