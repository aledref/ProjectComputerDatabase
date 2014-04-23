package com.excilys.formation.webproject.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.excilys.formation.webproject.service.MainService;

/**
 * 
 * @author excilys
 *
 */
public class RemoveServlet extends HttpServlet {

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {		
		
		Long removedid = Long.decode(request.getParameter("rid"));	
		MainService.Singleton.removeComputer(removedid);	
		 
		this.getServletContext().getRequestDispatcher("/dashboard").forward(request,response);
	}	
}
