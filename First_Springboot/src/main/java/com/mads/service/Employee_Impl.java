package com.mads.service;

import java.util.List;

import com.mads.dao.Employee_dao_Impl;
import com.mads.dao.Employee_dao_i;
import com.mads.entity.Employee;

public class Employee_Impl implements Employee_i{

	
	Employee_dao_i daoi = new Employee_dao_Impl();
	@Override
	public String saveEmployee(Employee employee) {

		System.out.println("In service layer");
		
		
		return daoi.saveEmployee(employee);
	}
	@Override
	public String deleteemp(int id) {
		
		return daoi.deleteemp(id);
	}
	@Override
	public List<Employee> showemp() {
		// TODO Auto-generated method stub
		return daoi.showemp();
	}
	@Override
	public int updateemp(Employee employee) {
		// TODO Auto-generated method stub
		return daoi.updateemp(employee);
	}
	@Override
	public int updatebyid(Employee employee,int id1) {
		// TODO Auto-generated method stub
		return daoi.updatebyid(employee,id1);
	}
	@Override
	public List<Employee> getempbysalary(Double  salary) {
		// TODO Auto-generated method stub
		return daoi.getempbysalary(salary);
	}
	@Override
	public List<Employee> getempbysalary_dept(Double salary, String dept) {
		// TODO Auto-generated method stub
		return daoi.getempbysalary_dept(salary,dept);
	}
	@Override
	public List<Employee> getempbydept_distinct() {
		// TODO Auto-generated method stub
		return daoi.getempbydept_distinct();
	}

	
}
