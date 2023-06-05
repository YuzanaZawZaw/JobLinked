package com.frame.business.entity;

import com.frame.business.entity.base.BaseEmployeeQual;



public class EmployeeQual extends BaseEmployeeQual {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public EmployeeQual () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public EmployeeQual (com.frame.business.entity.EmployeeQualPK id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public EmployeeQual (
		com.frame.business.entity.EmployeeQualPK id,
		java.util.Date fromDate) {

		super (
			id,
			fromDate);
	}

/*[CONSTRUCTOR MARKER END]*/


}