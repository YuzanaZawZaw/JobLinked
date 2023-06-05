package com.frame.dao;

import java.util.List;

import com.frame.business.entity.EmpImageFile;
import com.frame.business.entity.Employee;
/**
*
* @author Yuzana Zaw Zaw
*/
public interface EmployeeDao {
	public void saveEmployee(Employee empl);

	public Employee getEmployeeByEmail(String frmEmail);

	public Employee getEmployeeByEmailAndPassword(String frmEmail,
			String frmPassword);

	public Employee getEmployeeByEmailAndSecurityQ(String frmForgetPassEmail,
			String frmForgetPassSecurityQuest);

	public void saveUpdateEmployeePass(Employee myEmployee);

	public void saveNewEmployeeImage(EmpImageFile myFile);
	
	public Employee getEmployeeById(Integer id);

	public List<Employee> getAllEmployeeList();

	public List<Employee> getEmployeeListByStatus(int id);
}
