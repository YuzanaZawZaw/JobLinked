package com.frame.business.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.frame.business.entity.Employee;
import com.frame.business.entity.EmployeePositionFulfillment;
import com.frame.business.entity.EmployeePositionFulfillmentPK;
import com.frame.business.entity.PartyGroupPosition;
import com.frame.dao.EmployeeDao;
import com.frame.dao.EmployeeExpDao;
import com.frame.dao.PartyGroupPositionDao;
import com.frame.presentation.form.EmployeeExpForm;
import com.frame.presentation.form.EmployeeForm;

/**
*
* @author Yuzana Zaw Zaw
*/
public class EmployeeExpService {
	private EmployeeExpDao myEmployeeExpDao;
	private PartyGroupPositionDao myPartyGroupPositionDao;
	private EmployeeDao myEmployeeDao;

	public EmployeeDao getMyEmployeeDao() {
		return myEmployeeDao;
	}

	public void setMyEmployeeDao(EmployeeDao myEmployeeDao) {
		this.myEmployeeDao = myEmployeeDao;
	}

	public PartyGroupPositionDao getMyPartyGroupPositionDao() {
		return myPartyGroupPositionDao;
	}

	public void setMyPartyGroupPositionDao(
			PartyGroupPositionDao myPartyGroupPositionDao) {
		this.myPartyGroupPositionDao = myPartyGroupPositionDao;
	}

	public EmployeeExpDao getMyEmployeeExpDao() {
		return myEmployeeExpDao;
	}

	public void setMyEmployeeExpDao(EmployeeExpDao myEmployeeExpDao) {
		this.myEmployeeExpDao = myEmployeeExpDao;
	}

	public void firstLoadEmployeeExpDisplayTag(EmployeeExpForm myForm,
			Employee loginUser) {
		List<EmployeePositionFulfillment> expList = myEmployeeExpDao
				.getEmployeeExpListAll(loginUser);
		if(expList!=null){
			myForm.setFrmDetailEmpPositionList(expList);
		}else{
			myForm.setFrmDetailEmpPositionList(null);
		}
		

	}

	public void firstLoadPosition(EmployeeExpForm myForm) {
		List<PartyGroupPosition> l = myPartyGroupPositionDao
				.getLoadPartyGroupPositionList();
		if(l!=null){
			myForm.setFrmPositionList(l);
		}
		myForm.setFrmCurrentRole("");
		myForm.setFrmEmploymentType("");
		myForm.setFrmLocation("");
		myForm.setFrmPositionName("");
		myForm.setFrmFromDate("");
		myForm.setFrmThruDate("");
	}

	public void createEmployeePositionFulfillment(EmployeeExpForm myForm,
			EmployeeForm loginForm) {
		Employee employee = loginForm.getLoginUser();
		EmployeePositionFulfillment empPosition = new EmployeePositionFulfillment();
		PartyGroupPosition partyGroupPosition = myPartyGroupPositionDao
				.searchPartyGroupPositionById(Integer.parseInt(myForm
						.getFrmPositionName()));
		SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate;
		List<EmployeePositionFulfillment> newEmpPositionList=null;
		try {
			startDate = myformat.parse(myForm.getFrmFromDate());
			java.sql.Date start_date = new java.sql.Date(startDate.getTime());
			newEmpPositionList=myEmployeeExpDao.getExpListByPositionAndEmploymentTypeAndStartDate(partyGroupPosition,myForm.getFrmEmploymentType(),start_date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(newEmpPositionList!=null){
			myForm.setErrorMsg("This position experience is already created !!");
		}else{
			EmployeePositionFulfillmentPK pk = new EmployeePositionFulfillmentPK();
			pk.setEmployee(employee);
			pk.setPartyGroupPosition(partyGroupPosition);

			empPosition.setId(pk);
			empPosition.setEmploymentType(myForm.getFrmEmploymentType());
			empPosition.setLocation(myForm.getFrmLocation());
			empPosition.setCurrentRole(myForm.getFrmCurrentRole());
			
			Date fromDate;
			Date thruDate;

			try {
				if(!myForm.getFrmFromDate().equals("")){
					fromDate = myformat.parse(myForm.getFrmFromDate());
					java.sql.Date from_date = new java.sql.Date(fromDate.getTime());
					empPosition.setFromDate(from_date);
				}
				if(!myForm.getFrmThruDate().equals("")){
					thruDate = myformat.parse(myForm.getFrmThruDate());
					java.sql.Date thru_date = new java.sql.Date(thruDate.getTime());
					empPosition.setThruDate(thru_date);
				}
				myEmployeeExpDao.saveEmployeeExperience(empPosition);
				myForm.setSuccessMsg("Successfully created!!");
				myForm.setFrmCurrentRole("");
				myForm.setFrmEmploymentType("");
				myForm.setFrmLocation("");
				myForm.setFrmPositionName("");
				myForm.setFrmFromDate("");
				myForm.setFrmThruDate("");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
	}

	public void deleteEmployeeExperience(EmployeeExpForm myForm) {
		Employee emp = myEmployeeDao.getEmployeeById(Integer.parseInt(myForm
				.getFrmEmployeeId()));
		PartyGroupPosition position = myPartyGroupPositionDao
				.searchPartyGroupPositionById(Integer.parseInt(myForm
						.getFrmPositionId()));

		EmployeePositionFulfillment empPosition = new EmployeePositionFulfillment();
		EmployeePositionFulfillmentPK pk = new EmployeePositionFulfillmentPK();

		pk.setEmployee(emp);
		pk.setPartyGroupPosition(position);
		empPosition.setId(pk);
		myEmployeeExpDao.deleteEmployeeExperience(pk);

	}

}
