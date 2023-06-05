package com.frame.dao;

import java.util.List;

import com.frame.business.entity.Employee;
import com.frame.business.entity.EmployeeSkill;
import com.frame.business.entity.EmployeeSkillPK;
import com.frame.business.entity.SkillType;
/**
*
* @author Yuzana Zaw Zaw
*/
public interface EmployeeSkillDao {

	List<EmployeeSkill> getEmployeeSkillListAll(Employee loginUser);

	void deleteEmployeeSkill(EmployeeSkillPK empSkill);

	void saveEmployeeSkill(EmployeeSkill empSkill);

	List<EmployeeSkill> getEmployeeSkillListAll(int skillTypeId);
	
}
