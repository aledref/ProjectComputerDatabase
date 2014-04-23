package com.excilys.formation.webproject.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.excilys.formation.webproject.om.Company;
import com.excilys.formation.webproject.om.Computer;
import com.excilys.formation.webproject.service.MainService;

/**
 * 
 * @author excilys
 *
 */
public class AddServlet extends FormServlet {
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {		
		
		List<Company> companylist = (ArrayList<Company>)MainService.Singleton.getListCompany();
		request.setAttribute("companylist", companylist);
		request.setAttribute("companylistsize", companylist.size());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/addComputer.jsp").forward(request,response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {		
		
		Computer computer = retrieveComputer(request,response);
		
		MainService.Singleton.insertComputer(computer);	
		 
		this.getServletContext().getRequestDispatcher("/dashboard").forward(request,response);
	}	
}
