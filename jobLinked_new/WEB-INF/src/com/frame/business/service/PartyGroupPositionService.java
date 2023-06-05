package com.frame.business.service;
import java.util.List;

import com.frame.business.entity.EmployeePositionFulfillment;
import com.frame.business.entity.JobPost;
import com.frame.business.entity.PartyGroup;
import com.frame.business.entity.PartyGroupPosition;
import com.frame.business.entity.PartyGroupPositionType;
import com.frame.business.entity.Recruiters;
import com.frame.dao.EmployeeExpDao;
import com.frame.dao.JobPostDao;
import com.frame.dao.PartyGroupDao;
import com.frame.dao.PartyGroupPositionDao;
import com.frame.dao.PositionTypeDao;
import com.frame.dao.RecruitersDao;
import com.frame.presentation.form.JobPostListForm;
import com.frame.presentation.form.PartyGroupPositionForm;

/**
*
* @author Yuzana Zaw Zaw
*/
public class PartyGroupPositionService {
	private PartyGroupPositionDao myPartyGroupPositionDao;
	private PositionTypeDao myPositionTypeDao;
	private EmployeeExpDao myEmployeeExpDao;
	private JobPostDao myJobPostDao;
	private RecruitersDao myRecruitersDao;
	
	public RecruitersDao getMyRecruitersDao() {
		return myRecruitersDao;
	}


	public void setMyRecruitersDao(RecruitersDao myRecruitersDao) {
		this.myRecruitersDao = myRecruitersDao;
	}


	public JobPostDao getMyJobPostDao() {
		return myJobPostDao;
	}


	public void setMyJobPostDao(JobPostDao myJobPostDao) {
		this.myJobPostDao = myJobPostDao;
	}


	public EmployeeExpDao getMyEmployeeExpDao() {
		return myEmployeeExpDao;
	}


	public void setMyEmployeeExpDao(EmployeeExpDao myEmployeeExpDao) {
		this.myEmployeeExpDao = myEmployeeExpDao;
	}


	public PositionTypeDao getMyPositionTypeDao() {
		return myPositionTypeDao;
	}


	public void setMyPositionTypeDao(PositionTypeDao myPositionTypeDao) {
		this.myPositionTypeDao = myPositionTypeDao;
	}


	public PartyGroupDao getMyPartyGroupDao() {
		return myPartyGroupDao;
	}


	public void setMyPartyGroupDao(PartyGroupDao myPartyGroupDao) {
		this.myPartyGroupDao = myPartyGroupDao;
	}

	private PartyGroupDao myPartyGroupDao;

	public PartyGroupPositionDao getMyPartyGroupPositionDao() {
		return myPartyGroupPositionDao;
	}


	public void setMyPartyGroupPositionDao(
			PartyGroupPositionDao myPartyGroupPositionDao) {
		this.myPartyGroupPositionDao = myPartyGroupPositionDao;
	}


	public void createPartyGroupPosition(PartyGroupPositionForm myForm) 
	{	
		PartyGroupPositionType positionType=myPositionTypeDao.searchPartyGroupPositionTypeById(Integer.parseInt(myForm.getFrmPositionType()));
		PartyGroup partyGroup=myPartyGroupDao.searchPartyGroupById(Integer.parseInt(myForm.getFrmCompanyName()));
		//PartyGroupPosition newPartyGroupPosition=myPartyGroupPositionDao.getPositionByPositionTypeAndCompanyName(positionType,partyGroup);
		/*if(newPartyGroupPosition!=null){
			myForm.setErrorMsg("Position is already exist!!");
		}else{
			PartyGroupPosition partyGroupPosition=new PartyGroupPosition();
			partyGroupPosition.setId(null);
			partyGroupPosition.setPartyGroupPositionType(positionType);
			partyGroupPosition.setPartyGroup(partyGroup);
			partyGroupPosition.setPositionName(myForm.getFrmPositionName());
			myPartyGroupPositionDao.savePartyGroupPosition(partyGroupPosition);
			myForm.setSuccessMsg("Successfully created!!");
		}*/
		PartyGroupPosition partyGroupPosition=new PartyGroupPosition();
		partyGroupPosition.setId(null);
		partyGroupPosition.setPartyGroupPositionType(positionType);
		partyGroupPosition.setPartyGroup(partyGroup);
		partyGroupPosition.setPositionName(myForm.getFrmPositionName());
		myPartyGroupPositionDao.savePartyGroupPosition(partyGroupPosition);
		myForm.setSuccessMsg("Successfully created!!");
		myForm.setFrmPositionType("0");
		myForm.setFrmCompanyName("0");
		myForm.setFrmPositionName("");
	}


	public void firstLoadPartyGroupPositionDisplayTag(PartyGroupPositionForm myForm) {
		List<PartyGroupPosition> l=myPartyGroupPositionDao.getLoadPartyGroupPositionList();
		if(l!=null){
			myForm.setFrmPartyGroupPositionList(l);
		}
		
	}

	public void deletePartyGroupPosition(PartyGroupPositionForm myForm,int partyGroupPositionId) {
		PartyGroupPosition partyGroupPosition=myPartyGroupPositionDao.searchPartyGroupPositionById(partyGroupPositionId);
		List<EmployeePositionFulfillment> emplPositionList=myEmployeeExpDao.getEmployeeExpListByPosition(partyGroupPosition);
		List<JobPost> jobPostList=myJobPostDao.getJobPostListByPositionId(partyGroupPositionId);
		List<Recruiters> recruiterList=myRecruitersDao.getRecruiterListByPosition(partyGroupPosition);
		if(emplPositionList!=null || jobPostList!=null || recruiterList!=null){
			myForm.setErrorMsg("You can't delete this position "+partyGroupPosition.getPositionName() +" is used in another process!!");
		}else{
			PartyGroupPosition st=new PartyGroupPosition();
			st.setId(partyGroupPositionId);
			myPartyGroupPositionDao.deletePartyGroupPosition(st);
			myForm.setSuccessMsg("Successfully deleted!!");
		}
	}
	public void firstLoadPartyGroupPosition(PartyGroupPositionForm myForm) {
		List<PartyGroupPositionType> positionList = myPositionTypeDao.getLoadPartyGroupPositionTypeList();
		List<PartyGroup> partyGroupList=myPartyGroupDao.getLoadPartyGroupList();
		if(positionList!=null){
			myForm.setFrmPositionTypeList(positionList);
		}
		if(partyGroupList!=null){
			myForm.setFrmPartyGroupList(partyGroupList);
		}
		myForm.setFrmPositionName("");
	}


	public void firstLoadPartyGroupPositionDisplayTag(JobPostListForm myForm) {
		List<PartyGroupPosition> l=myPartyGroupPositionDao.getLoadPartyGroupPositionList();
		if(l!=null){
			myForm.setFrmPositionList(l);
		}
	}
	
}
