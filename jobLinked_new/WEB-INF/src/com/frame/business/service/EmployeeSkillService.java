package com.frame.business.service;
import java.util.List;

import com.frame.business.entity.Employee;
import com.frame.business.entity.EmployeeSkill;
import com.frame.business.entity.EmployeeSkillPK;
import com.frame.business.entity.SkillType;
import com.frame.dao.EmployeeDao;
import com.frame.dao.EmployeeSkillDao;
import com.frame.dao.SkillTypeDao;
import com.frame.presentation.form.EmployeeForm;
import com.frame.presentation.form.EmployeeSkillForm;

/**
*
* @author Yuzana Zaw Zaw
*/
public class EmployeeSkillService {
	private EmployeeSkillDao myEmployeeSkillDao;
	private EmployeeDao myEmployeeDao;
	private SkillTypeDao mySkillTypeDao;

	public SkillTypeDao getMySkillTypeDao() {
		return mySkillTypeDao;
	}

	public void setMySkillTypeDao(SkillTypeDao mySkillTypeDao) {
		this.mySkillTypeDao = mySkillTypeDao;
	}

	public EmployeeDao getMyEmployeeDao() {
		return myEmployeeDao;
	}

	public void setMyEmployeeDao(EmployeeDao myEmployeeDao) {
		this.myEmployeeDao = myEmployeeDao;
	}

	public EmployeeSkillDao getMyEmployeeSkillDao() {
		return myEmployeeSkillDao;
	}

	public void setMyEmployeeSkillDao(EmployeeSkillDao myEmployeeSkillDao) {
		this.myEmployeeSkillDao = myEmployeeSkillDao;
	}

	public void firstLoadEmployeeSkillDisplayTag(EmployeeSkillForm myForm,
			Employee loginUser) {
		List<EmployeeSkill> skillList=myEmployeeSkillDao.getEmployeeSkillListAll(loginUser);
		if(skillList!=null){
			myForm.setFrmDetailEmpSkillList(skillList);
		}else{
			myForm.setFrmDetailEmpSkillList(null);
		}
	}

	public void deleteEmployeeSkill(EmployeeSkillForm myForm) {
		System.out.println("empid"+myForm.getFrmEmployeeId());
		System.out.println("skilltypeid"+myForm.getFrmSkillTypeId());
		
		Employee emp=myEmployeeDao.getEmployeeById(myForm.getFrmEmployeeId());
		SkillType skillType=mySkillTypeDao.getSkillTypeById(myForm.getFrmSkillTypeId());
		
		EmployeeSkill empSkill=new EmployeeSkill();
		EmployeeSkillPK pk=new EmployeeSkillPK();
		
		pk.setEmployee(emp);
		pk.setSkillType(skillType);
		empSkill.setId(pk);
		System.out.println("empskill"+empSkill.getSkillLevel());
		myEmployeeSkillDao.deleteEmployeeSkill(pk);
	}

	public void createEmployeeSkill(EmployeeSkillForm myForm,
			EmployeeForm loginForm) {
		Employee employee=loginForm.getLoginUser();
		EmployeeSkill empSkill=new EmployeeSkill();
		SkillType skillType=mySkillTypeDao.getSkillTypeById(Integer.parseInt(myForm.getFrmSkillTypeName()));
		List<EmployeeSkill> newEmpSkill=myEmployeeSkillDao.getEmployeeSkillListAll(skillType.getId());
		if(newEmpSkill!=null){
			myForm.setErrorMsg("This skill type is already created!!");
		}else{
			EmployeeSkillPK pk=new EmployeeSkillPK();
			pk.setEmployee(employee);
			pk.setSkillType(skillType);
			empSkill.setId(pk);
			empSkill.setSkillLevel(myForm.getFrmSkillLevel());
			myEmployeeSkillDao.saveEmployeeSkill(empSkill);
			myForm.setSuccessMsg("Successfully created!!");
		}
		
		myForm.setFrmSkillTypeName("");
		myForm.setFrmSkillLevel("");
		
	}

	public void firstLoadSkillType(EmployeeSkillForm myForm) {
		List<SkillType> skillTypeList=mySkillTypeDao.getLoadSkillTypeList();
		if(skillTypeList!=null){
			myForm.setFrmSkillTypeList(skillTypeList);
		}else{
			myForm.setFrmSkillTypeList(null);
		}
		
		myForm.setFrmSkillLevel("");
	}
	
}
