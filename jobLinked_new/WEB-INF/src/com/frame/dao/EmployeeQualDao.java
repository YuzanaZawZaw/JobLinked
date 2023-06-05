package com.frame.dao;

import java.util.List;

import com.frame.business.entity.Employee;
import com.frame.business.entity.EmployeeQual;
import com.frame.business.entity.EmployeeQualPK;
import com.frame.business.entity.QualType;
/**
*
* @author Yuzana Zaw Zaw
*/
public interface EmployeeQualDao {

	List<EmployeeQual> getEmployeeQualListAll(Employee emp);

	EmployeeQual getEmployeeQualDetailById(String frmDetailEmpQualId);
	QualType getEmployeeQualTypeById(QualType qualType);

	void saveEmployeeQual(EmployeeQual empQual);

	void deleteEmployeeQual(EmployeeQualPK pk);

	List<EmployeeQual> getEmployeeQualListeByQualType(QualType qualType);
	
}
