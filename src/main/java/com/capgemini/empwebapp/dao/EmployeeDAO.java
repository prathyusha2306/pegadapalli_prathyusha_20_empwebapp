package com.capgemini.empwebapp.dao;

import java.util.List;

import com.capgemini.empwebapp.dto.EmployeeBean;

public interface EmployeeDAO {
	EmployeeBean login(String email, String password);
	boolean addEmployee(EmployeeBean employee);
	List<EmployeeBean> viewEmployee();
	boolean deleteEmployee(int id);
	boolean updateEmployee(EmployeeBean employee);
	public EmployeeBean getEmployeeDetailsById(int id);
}
