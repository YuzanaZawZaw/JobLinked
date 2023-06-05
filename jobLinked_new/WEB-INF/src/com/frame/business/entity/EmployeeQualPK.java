package com.frame.business.entity;

import com.frame.business.entity.base.BaseEmployeeQualPK;

public class EmployeeQualPK extends BaseEmployeeQualPK {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public EmployeeQualPK () {}
	
	public EmployeeQualPK (
		com.frame.business.entity.Employee employee,
		com.frame.business.entity.QualType qualType) {

		super (
			employee,
			qualType);
	}
/*[CONSTRUCTOR MARKER END]*/


}