package com.capgemini.empwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.empwebapp.dao.EmployeeDAO;
import com.capgemini.empwebapp.dao.EmployeeDAOImple;
import com.capgemini.empwebapp.dto.EmployeeBean;

@WebServlet("/addEmployee")
public class AddServlet {

		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String id = req.getParameter("id");
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			String mobile = req.getParameter("mobile");
			String age = req.getParameter("age");
			EmployeeBean bean = new EmployeeBean();
			bean.setId(id);
			bean.setName(name);
			bean.setEmailid(email); 
			bean.setPassword(password);
			bean.setMobilenumber(mobile);
			bean.setAge(age);

			EmployeeDAO dao = new EmployeeDAOImple();
			boolean check= dao.addEmployee(bean);
			 PrintWriter out=resp.getWriter();
			    out.println("<html>");
				out.println("<head>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h1></h1>");
				
			    if(check==true) {
							out.println("Insertion sucessfull");
						}
						else {
							out.println("Insertion unsucessfull");
						}
								
			    out.println("</h1>"); 
				  
				out.println("</body>");
				out.println("</html>");
				 RequestDispatcher dispatcher=req.getRequestDispatcher("/homepage.html");
				    dispatcher.include(req, resp);
}
}