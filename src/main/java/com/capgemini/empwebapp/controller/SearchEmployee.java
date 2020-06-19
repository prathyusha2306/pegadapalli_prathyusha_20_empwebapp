package com.capgemini.empwebapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.empwebapp.dao.EmployeeDAO;
import com.capgemini.empwebapp.dao.EmployeeDAOImple;
import com.capgemini.empwebapp.dto.EmployeeBean;

public class SearchEmployee extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	String id = req.getParameter("id1");
	EmployeeDAO service = new EmployeeDAOImple();
    EmployeeBean bean=service.getEmployeeDetailsById(Integer.parseInt(id));
	PrintWriter out = resp.getWriter();
	out.println("<html>");
	out.println("<head>");
	out.println("</head>");
	out.println("<body>");
	out.println("<h1></h1>");

	out.print("<table border='1' width='100%'");
	out.print(
			"<tr><th>Id</th><th>LastName</th><th>FirstName</th><th>Department</th><th>Salary</th><th>EmailId</th></tr>");

	
			out.print("<tr><td>" + bean.getId() + "</td><td>" + bean.getName() + "</td><td>" + bean.getEmailid() + "</td>" + " <td>"
					+ bean.getMobilenumber() + "</td><td>" + bean.getPassword() + "</td>" + "<td>"+ bean.getAge() +"</td></tr>");
	
	out.print("</table>");
		
	

	out.println("</body>");
	out.println("</html>");
}
}
