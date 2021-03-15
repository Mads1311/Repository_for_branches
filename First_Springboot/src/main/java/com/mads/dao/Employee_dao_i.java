
package com.mads.dao;

import java.util.List;

import com.mads.entity.Employee;

public interface Employee_dao_i {
	public String saveEmployee(Employee employee) ;

	public String deleteemp(int id);

	public List<Employee> showemp();



	public int updateemp(Employee employee);

	public int updatebyid(Employee employee,int id1);

	public List<Employee> getempbysalary(Double salary);

	public List<Employee> getempbysalary_dept(Double salary, String dept);

	public List<Employee> getempbydept_distinct();
}
