package com.capgemini.empwebapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import com.capgemini.empwebapp.dto.EmployeeBean;

public class EmployeeDAOImple implements EmployeeDAO {

	@Override
	public EmployeeBean login(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addEmployee(EmployeeBean employee) {
		String url = "jdbc:mysql://localhost:3307/emp_db?useSSL=false&user=root&password=root";
		String query = "insert into emp_db.ems_db values(?,?,?,?,?,?)";
		try (Connection connection = DriverManager.getConnection(url);
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			Class.forName("com.mysql.jdbc.Driver");
			preparedStatement.setString(1, employee.getId());
			preparedStatement.setString(2, employee.getName());
			preparedStatement.setString(3, employee.getMobilenumber());
			preparedStatement.setString(4, employee.getEmailid());
			preparedStatement.setString(5,employee.getPassword());
			preparedStatement.setString(6,employee.getAge());

			int res = preparedStatement.executeUpdate();

			if (res != 0) {
				return true;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<EmployeeBean> viewEmployee() {
		String url = "jdbc:mysql://localhost:3307/emp_db?useSSL=false&user=root&password=root";
		String query = "select * from ems_db ";
		
		List<EmployeeBean> info = new LinkedList<EmployeeBean>();
		try (Connection connection = DriverManager.getConnection(url);
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				ResultSet res = preparedStatement.executeQuery();) {
			Class.forName("com.mysql.jdbc.Driver");
			
			
			while (res.next()) {
				EmployeeBean beans = new EmployeeBean();
				beans.setId(res.getString("id"));
				beans.setName(res.getString("name"));
				beans.setEmailid(res.getString("emailId"));
				beans.setMobilenumber(res.getString("mobilenumber"));
				beans.setPassword(res.getString("password"));
				beans.setAge(res.getString("age"));
				info.add(beans);
			}

			if (info.isEmpty()) {
				return null;
			} else {
				return info;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteEmployee(int id) {
		String url = "jdbc:mysql://localhost:3307/emp_db?useSSL=false&user=root&password=root";
		String query = "delete from ems_db where id=?";

		try (Connection connection = DriverManager.getConnection(url);
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			Class.forName("com.mysql.jdbc.Driver");
			preparedStatement.setInt(1, id);
			int res = preparedStatement.executeUpdate();
			if (res != 0) {
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateEmployee(EmployeeBean employee) {
		String query = "update ems_db set name=? where id=?";
		String url = "jdbc:mysql://localhost:3307/emp_db?useSSL=false&user=root&password=root";
		try (Connection connection = DriverManager.getConnection(url);
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			Class.forName("com.mysql.jdbc.Driver");
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setString(2, employee.getId());
			int res = preparedStatement.executeUpdate();
			if (res != 0) {
				return true;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public EmployeeBean getEmployeeDetailsById(int id) {
		String url = "jdbc:mysql://localhost:3307?user=root&password=root";
		EmployeeBean employeeBean=new EmployeeBean();
		String query = "select id, lastname, firstname, email, department, salary from demo.employees where id=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, employeeBean.getId());
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				employeeBean.setId(resultSet.getString("id"));
				employeeBean.setName(resultSet.getString("name"));
				employeeBean.setMobilenumber(resultSet.getString("mobile"));
				employeeBean.setEmailid(resultSet.getString("email"));
				employeeBean.setPassword(resultSet.getString("password"));
				employeeBean.setAge(resultSet.getString("age"));
				return employeeBean;		
				
		} 
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeBean;
		
	}

	
}
