package com.frame.dao;

import java.sql.Date;
import java.util.List;

import com.frame.business.entity.Employee;
import com.frame.business.entity.EmployeePositionFulfillment;
import com.frame.business.entity.EmployeePositionFulfillmentPK;
import com.frame.business.entity.PartyGroupPosition;
/**
*
* @author Yuzana Zaw Zaw
*/
public interface EmployeeExpDao {

	List<EmployeePositionFulfillment> getEmployeeExpListAll(Employee emp);

	EmployeePositionFulfillment getCurrentPositionByLoginUser(Employee loginUser);

	void saveEmployeeExperience(EmployeePositionFulfillment empPosition);

	void deleteEmployeeExperience(EmployeePositionFulfillmentPK pk);

	List<EmployeePositionFulfillment> getEmployeeExpListByPosition(
			PartyGroupPosition partyGroupPosition);

	List<EmployeePositionFulfillment> getExpListByPositionAndEmploymentType(
			PartyGroupPosition partyGroupPosition, String frmEmploymentType);

	List<EmployeePositionFulfillment> getExpListByPositionAndEmploymentTypeAndStartDate(
			PartyGroupPosition partyGroupPosition, String frmEmploymentType,
			Date startDate);
	
}
