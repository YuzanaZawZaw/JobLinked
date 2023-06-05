package com.frame.business.service;
import java.util.List;

import com.frame.business.entity.Employee;
import com.frame.business.entity.EmployeePositionFulfillment;
import com.frame.business.entity.EmployeeSkill;
import com.frame.business.entity.PartyGroupPosition;
import com.frame.business.entity.PartyGroupPositionType;
import com.frame.business.entity.SkillType;
import com.frame.dao.EmployeeExpDao;
import com.frame.dao.EmployeeSkillDao;
import com.frame.dao.PartyGroupPositionDao;
import com.frame.dao.PositionTypeDao;
import com.frame.dao.SkillTypeDao;
import com.frame.presentation.form.EmployeeExpForm;
import com.frame.presentation.form.EmployeeSkillForm;
import com.frame.presentation.form.PositionTypeForm;
import com.frame.presentation.form.SkillTypeForm;

/**
*
* @author Yuzana Zaw Zaw
*/
public class PositionTypeService {
	private PositionTypeDao myPositionTypeDao;
	private PartyGroupPositionDao myPartyGroupPositionDao;
	
	public PartyGroupPositionDao getMyPartyGroupPositionDao() {
		return myPartyGroupPositionDao;
	}


	public void setMyPartyGroupPositionDao(
			PartyGroupPositionDao myPartyGroupPositionDao) {
		this.myPartyGroupPositionDao = myPartyGroupPositionDao;
	}


	public PositionTypeDao getMyPositionTypeDao() {
		return myPositionTypeDao;
	}


	public void setMyPositionTypeDao(PositionTypeDao myPositionTypeDao) {
		this.myPositionTypeDao = myPositionTypeDao;
	}


	public void createPartyGroupPositionType(PositionTypeForm myForm) 
	{
		PartyGroupPositionType positionType=new PartyGroupPositionType();
		positionType.setId(null);
		positionType.setDescription(myForm.getFrmPositionTypeName());
		myPositionTypeDao.savePartyGroupPositionType(positionType);
		myForm.setFrmPositionTypeName("");
	}


	public void firstLoadPositionTypeDisplayTag(PositionTypeForm myForm) {
		List<PartyGroupPositionType> l=myPositionTypeDao.getLoadPartyGroupPositionTypeList();
		if(l!=null){
			myForm.setFrmPositionTypeList(l);
		}
	}

	public void deletePartyGroupPositionType(PositionTypeForm myForm,int positionTypeId) {
		PartyGroupPositionType positionType=myPositionTypeDao.searchPartyGroupPositionTypeById(positionTypeId);
		List<PartyGroupPosition> partyGroupPosition=myPartyGroupPositionDao.getPartyGroupPositionListByPositionType(positionType);
		if(partyGroupPosition!=null){
			myForm.setErrorMsg("You can't delete this position type "+positionType.getDescription()+ "is used in position !!");
		}else{
			PartyGroupPositionType st=new PartyGroupPositionType();
			st.setId(positionTypeId);
			myPositionTypeDao.deletePartyGroupPositionType(st);
			myForm.setSuccessMsg("Successfully deleted!!");
		}
		
	}
	
}
