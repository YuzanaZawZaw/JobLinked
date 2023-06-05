package com.frame.business.entity;

import com.frame.business.entity.base.BaseEmployeeSkillPK;

public class EmployeeSkillPK extends BaseEmployeeSkillPK {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public EmployeeSkillPK () {}
	
	public EmployeeSkillPK (
		com.frame.business.entity.Employee employee,
		com.frame.business.entity.SkillType skillType) {

		super (
			employee,
			skillType);
	}
/*[CONSTRUCTOR MARKER END]*/


}