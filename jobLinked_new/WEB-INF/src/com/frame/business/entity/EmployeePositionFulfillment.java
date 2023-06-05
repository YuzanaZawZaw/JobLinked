package com.frame.business.entity;

import com.frame.business.entity.base.BaseEmployeePositionFulfillment;



public class EmployeePositionFulfillment extends BaseEmployeePositionFulfillment {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public EmployeePositionFulfillment () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public EmployeePositionFulfillment (com.frame.business.entity.EmployeePositionFulfillmentPK id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public EmployeePositionFulfillment (
		com.frame.business.entity.EmployeePositionFulfillmentPK id,
		java.util.Date fromDate) {

		super (
			id,
			fromDate);
	}

/*[CONSTRUCTOR MARKER END]*/


}