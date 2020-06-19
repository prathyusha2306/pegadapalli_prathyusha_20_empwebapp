package com.capgemini.empwebapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.empwebapp.dao.EmployeeDAO;
import com.capgemini.empwebapp.dao.EmployeeDAOImple;

public class DeleteContoller  extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String id=req.getParameter("id1");
	EmployeeDAO dao=new EmployeeDAOImple();
	boolean check=dao.deleteEmployee(Integer.parseInt(id));
	PrintWriter out=resp.getWriter();
	out.println("<html>");
	out.println("<head>");
	out.println("</head>");
	out.println("<body>");
	out.println("<h1>");
	
    if(check==true) {
				out.println("Deletion sucessfull");
			}
			else {
				out.println("Deletion unsucessfull");
			}
					
    out.println("</h1>");
    RequestDispatcher dispatcher=req.getRequestDispatcher("/homepage.html");
    dispatcher.include(req, resp);
	  
	out.println("</body>");
	out.println("</html>");
}
}
