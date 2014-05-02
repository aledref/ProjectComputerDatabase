package com.excilys.formation.webproject.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.excilys.formation.webproject.om.Computer;
import com.excilys.formation.webproject.service.MainService;

public class OrderByNameServlet extends HttpServlet{

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {		

		List<Computer> computerlist = (ArrayList<Computer>)MainService.Singleton.getListComputer();
		request.setAttribute("computerlist", computerlist);
		request.setAttribute("computerlistsize", computerlist.size());
		if (request.getAttribute("pagenumber") == null) request.setAttribute("pagenumber",1);

		this.getServletContext().getRequestDispatcher("/WEB-INF/dashboard.jsp").forward(request,response);
	}
}
