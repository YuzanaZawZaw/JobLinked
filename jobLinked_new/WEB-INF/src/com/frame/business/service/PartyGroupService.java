package com.frame.business.service;
import java.util.List;

import com.frame.business.entity.PartyGroup;
import com.frame.business.entity.PartyGroupPosition;
import com.frame.dao.PartyGroupDao;
import com.frame.dao.PartyGroupPositionDao;
import com.frame.presentation.form.PartyGroupForm;

/**
*
* @author Yuzana Zaw Zaw
*/
public class PartyGroupService {
	private PartyGroupDao myPartyGroupDao;
	private PartyGroupPositionDao myPartyGroupPositionDao;

	public PartyGroupPositionDao getMyPartyGroupPositionDao() {
		return myPartyGroupPositionDao;
	}


	public void setMyPartyGroupPositionDao(
			PartyGroupPositionDao myPartyGroupPositionDao) {
		this.myPartyGroupPositionDao = myPartyGroupPositionDao;
	}


	public PartyGroupDao getMyPartyGroupDao() {
		return myPartyGroupDao;
	}


	public void setMyPartyGroupDao(PartyGroupDao myPartyGroupDao) {
		this.myPartyGroupDao = myPartyGroupDao;
	}


	public void createPartyGroup(PartyGroupForm myForm) 
	{
		PartyGroup partyGroup=new PartyGroup();
		partyGroup.setId(null);
		partyGroup.setGroupNameLocal(myForm.getFrmCompanyName());
		partyGroup.setTotalEmployee(myForm.getFrmTotalEmployee());
		partyGroup.setDescription(myForm.getFrmDescription());
		myPartyGroupDao.savePartyGroup(partyGroup);
		myForm.setFrmCompanyName("");
		myForm.setFrmTotalEmployee("");
		myForm.setFrmDescription("");
	}


	public void firstLoadPartyGroupDisplayTag(PartyGroupForm myForm) {
		List<PartyGroup> l=myPartyGroupDao.getLoadPartyGroupList();
		if(l!=null){
			myForm.setFrmPartyGroupList(l);
		}
	}

	public void deletePartyGroup(PartyGroupForm myForm,int partyGroupId) {
		PartyGroup partyGroup=myPartyGroupDao.searchPartyGroupById(partyGroupId);
		List<PartyGroupPosition> positionList=myPartyGroupPositionDao.getPartyGroupPositionListByPartyGroup(partyGroup);
		if(positionList!=null){
			myForm.setErrorMsg("You can't delete this company "+partyGroup.getGroupNameLocal()+ " is used in position !!");
		}else{
			PartyGroup st=new PartyGroup();
			st.setId(myForm.getPartyGroupId());
			myPartyGroupDao.deletePartyGroup(st);
			myForm.setSuccessMsg("Successfully deleted!!");
		}
		
	}
	
}
