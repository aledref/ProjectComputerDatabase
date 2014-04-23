package com.excilys.formation.webproject.servlet;

import java.sql.Timestamp;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.excilys.formation.webproject.om.Company;
import com.excilys.formation.webproject.om.Computer;
import com.excilys.formation.webproject.service.MainService;

public class FormServlet extends HttpServlet {

	public Computer retrieveComputer(HttpServletRequest request,HttpServletResponse response) {
		String	name = new String(request.getParameter("name"));
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		ParsePosition parseposition = new ParsePosition(0);
		Date introduceddate = null;
		Date discontinueddate = null;
		Timestamp introduced = null;
		Timestamp discontinued = null;
		if (request.getParameter("introducedDate") != null) {
			try {
			introduceddate = formatter.parse(request.getParameter("introducedDate"),parseposition);
			introduced = new Timestamp(introduceddate.getTime());
			} catch(NullPointerException e) {
				introduced = new Timestamp(0);
			}					
		}else {
			introduced = new Timestamp(0);
		}
		parseposition.setIndex(0);	
		if (request.getParameter("discontinuedDate") != null) {
			try {
			discontinueddate = formatter.parse(request.getParameter("discontinuedDate"),parseposition);
			discontinued = new Timestamp(discontinueddate.getTime());
			} catch(NullPointerException e) {
				discontinued = new Timestamp(0);
			}
		}else {
			discontinued = new Timestamp(0);	
		}	
		
		Long companyid = Long.decode(request.getParameter("companyid"));
		Company company = MainService.Singleton.findCompany(companyid);	
		
		return new Computer(name,introduced,discontinued,company);	
	}
}
