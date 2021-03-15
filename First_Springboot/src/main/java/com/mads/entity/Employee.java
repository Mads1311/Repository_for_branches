package com.mads.entity;

public class Employee {
	private int employeeId;
	private String employeeFirstName;
	private String employeeLastName;
	private double employeeSalary;
	private String employeeDept;
	public Employee(int employeeId, String employeeFirstName, String employeeLastName, double employeeSalary,
			String employeeDept) {
		super();
		this.employeeId = employeeId;
		this.employeeFirstName = employeeFirstName;
		this.employeeLastName = employeeLastName;
		this.employeeSalary = employeeSalary;
		this.employeeDept = employeeDept;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeFirstName() {
		return employeeFirstName;
	}
	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}
	public String getEmployeeLastName() {
		return employeeLastName;
	}
	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}
	public double getEmployeeSalary() {
		return employeeSalary;
	}
	public void setEmployeeSalary(double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	public String getEmployeeDept() {
		return employeeDept;
	}
	public void setEmployeeDept(String employeeDept) {
		this.employeeDept = employeeDept;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeFirstName=" + employeeFirstName + ", employeeLastName="
				+ employeeLastName + ", employeeSalary=" + employeeSalary + ", employeeDept=" + employeeDept + "]";
	}
	public Employee() {
		super();
	}
	public Employee(String employeeDept) {
		super();
		this.employeeDept = employeeDept;
	}
	
	
	
	
	

}
