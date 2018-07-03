package com.oam.dao;

import java.util.List;

import com.oam.models.EmployeeModel;

public interface EmployeeDAO {

	public Integer addEmployee(EmployeeModel employeeModel);
	public Integer updateEmployee(EmployeeModel employeeModel);
	public Integer deleteEmployee(EmployeeModel employeeModel);
	public EmployeeModel getEmployeeById(Integer employeeId);
	public List<EmployeeModel> getAllEmployees();
}
