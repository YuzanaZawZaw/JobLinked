package com.frame.business.service;
import java.util.List;

import com.frame.business.entity.Employee;
import com.frame.business.entity.EmployeePositionFulfillment;
import com.frame.business.entity.EmployeeSkill;
import com.frame.business.entity.SkillType;
import com.frame.dao.EmployeeExpDao;
import com.frame.dao.EmployeeSkillDao;
import com.frame.dao.SkillTypeDao;
import com.frame.presentation.form.EmployeeExpForm;
import com.frame.presentation.form.EmployeeSkillForm;
import com.frame.presentation.form.SkillTypeForm;

/**
*
* @author Yuzana Zaw Zaw
*/
public class SkillTypeService {
	private SkillTypeDao mySkillTypeDao;
	private EmployeeSkillDao myEmployeeSkillDao;

	
	public EmployeeSkillDao getMyEmployeeSkillDao() {
		return myEmployeeSkillDao;
	}

	public void setMyEmployeeSkillDao(EmployeeSkillDao myEmployeeSkillDao) {
		this.myEmployeeSkillDao = myEmployeeSkillDao;
	}

	public SkillTypeDao getMySkillTypeDao() {
		return mySkillTypeDao;
	}

	public void setMySkillTypeDao(SkillTypeDao mySkillTypeDao) {
		this.mySkillTypeDao = mySkillTypeDao;
	}
	
	public void createSkillType(SkillTypeForm myForm) 
	{
		SkillType skillType=new SkillType();
		skillType.setId(null);
		skillType.setDescription(myForm.getFrmSkillTypeName());
		mySkillTypeDao.saveSkillType(skillType);
		myForm.setFrmSkillTypeName("");
	}


	public void firstLoadSkillTypeDisplayTag(SkillTypeForm myForm) {
		List<SkillType> l=mySkillTypeDao.getLoadSkillTypeList();
		if(l!=null){
			myForm.setFrmSkillTypeList(l);
		}
	}

	public void deleteSkillType(SkillTypeForm myForm,int skillTypeId) {
		SkillType skillType=mySkillTypeDao.getSkillTypeById(myForm.getSkillTypeId());
		List<EmployeeSkill> empSkillList=myEmployeeSkillDao.getEmployeeSkillListAll(myForm.getSkillTypeId());
		if(empSkillList!=null){
			myForm.setErrorMsg("You can't delete this skill type "+skillType.getDescription()+" is used in employee skill !!");
		}else{
			SkillType st=new SkillType();
			st.setId(myForm.getSkillTypeId());
			mySkillTypeDao.deleteSkillType(st);		
			myForm.setSuccessMsg("Successfully deleted!!");
		}
	}
}
