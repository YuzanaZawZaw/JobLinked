package com.frame.business.entity;

import com.frame.business.entity.base.BaseEmployeePositionFulfillmentPK;

public class EmployeePositionFulfillmentPK extends BaseEmployeePositionFulfillmentPK {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public EmployeePositionFulfillmentPK () {}
	
	public EmployeePositionFulfillmentPK (
		com.frame.business.entity.Employee employee,
		com.frame.business.entity.PartyGroupPosition partyGroupPosition) {

		super (
			employee,
			partyGroupPosition);
	}
/*[CONSTRUCTOR MARKER END]*/


}