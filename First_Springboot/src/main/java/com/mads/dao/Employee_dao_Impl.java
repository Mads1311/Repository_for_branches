package com.mads.dao;

import com.mads.Config.DBConfig;
import com.mads.entity.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Employee_dao_Impl implements Employee_dao_i {

	private Connection connection= DBConfig.getConnection();;

	@Override
	public String saveEmployee(Employee employee) {
		//connection = DBConfig.getConnection();
		String msg = "";

		try {

			String sql = "INSERT INTO employee(EmployeeFirstName, EmployeeLastName, EmployeeSalary, EmployeeDept) values (?,?,?,?)";
			System.out.println("Inside Dao before ps");
			PreparedStatement ps = connection.prepareStatement(sql);
			System.out.println("Inside Dao after ps");

			ps.setString(1,employee.getEmployeeFirstName());
			ps.setString(2,employee.getEmployeeLastName());
			ps.setDouble(3,employee.getEmployeeSalary());
			ps.setString(4,employee.getEmployeeDept());

			int result = ps.executeUpdate();
			if (result > 0)
				msg = "success";
			else
				msg = "failed";

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;

	}

	@Override
	public String deleteemp(int id) {
		String msg = "";
	try {
		PreparedStatement ps = connection.prepareStatement("DELETE FROM employee where EmployeeId = ?");
		ps.setInt(1, id);
		int result = ps.executeUpdate();
		if(result >0)
			msg = "Deleted Successfully";
		else
			msg = "Can not Delete";
			
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
			
		return msg;
	}

	@Override
	public List<Employee> showemp() {
		List<Employee> list = new ArrayList<>();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM employee");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				int id = rs.getInt(1);
				String Fname = rs.getString(2);
				String Lname = rs.getString(3);
				Double salary = rs.getDouble(4);
				String dept = rs.getString(5);
				Employee emp = new Employee(id,Fname,Lname,salary,dept);
				list.add(emp);
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int updateemp(Employee employee) {
		int id =0;
		String sql = "UPDATE employee SET  EmployeeFirstName=?, EmployeeLastName=?, EmployeeSalary=?, EmployeeDept=? WHERE EmployeeId= ?";
	try {
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1, employee.getEmployeeFirstName());
		ps.setString(2, employee.getEmployeeLastName());
		ps.setDouble(3, employee.getEmployeeSalary());
		ps.setString(4, employee.getEmployeeDept());
		ps.setInt(5, employee.getEmployeeId());
		int result = ps.executeUpdate();
		
		if(result > 0)
			id = employee.getEmployeeId();
		else
			id=0;
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return id;
	}

	@Override
	public int updatebyid(Employee employee,int id1) {
		int id =0;
		List<Employee> list = new ArrayList<>();
		String sql = "UPDATE employee SET  EmployeeFirstName=?, EmployeeLastName=?, EmployeeSalary=?, EmployeeDept=? WHERE EmployeeId= ?";
	try {
PreparedStatement ps = connection.prepareStatement(sql);
		System.out.println("After ps");
		ps.setString(1, employee.getEmployeeFirstName());
		ps.setString(2, employee.getEmployeeLastName());
		ps.setDouble(3, employee.getEmployeeSalary());
		ps.setString(4, employee.getEmployeeDept());
		ps.setInt(5, id1);
		int result = ps.executeUpdate();
		System.out.println(result);
		if(result > 0)
			id = id1;
		else
			id=0;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return id;
	}

	@Override
	public List<Employee> getempbysalary(Double salary) {
		List<Employee> list = new ArrayList<>();
		String sql = "SELECT * FROM employee where EmployeeSalary > ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setDouble(1,salary);
			ResultSet rs =ps.executeQuery();
			while(rs.next())
			{
				int id = rs.getInt(1);
				String fname = rs.getString(2);
				String lname = rs.getString(3);
				Double salary1 = rs.getDouble(4);
				String dept = rs.getString(5);
				Employee emp = new Employee(id,fname,lname,salary1,dept);
				list.add(emp);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return list;
	}

	@Override
	public List<Employee> getempbysalary_dept(Double salary, String dept) {
		List<Employee> list = new ArrayList<>();
		String sql = "SELECT * FROM employee where EmployeeSalary = ? AND EmployeeDept = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setDouble(1,salary);
			ps.setString(2, dept);
			ResultSet rs =ps.executeQuery();
			while(rs.next())
			{
				int id = rs.getInt(1);
				String fname = rs.getString(2);
				String lname = rs.getString(3);
				Double salary1 = rs.getDouble(4);
				String dept1 = rs.getString(5);
				Employee emp = new Employee(id,fname,lname,salary1,dept1);
				list.add(emp);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return list;
	}

	@Override
	public List<Employee> getempbydept_distinct() {
		List<Employee> list = new ArrayList<>();
		String sql = "SELECT DISTINCT EmployeeDept FROM employee ";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ResultSet rs =ps.executeQuery();
			while(rs.next())
			{
				
				String dept1 = rs.getString(1);
				System.out.println(dept1);
				Employee emp = new Employee(dept1);
				list.add(emp);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return list;
	}
}
