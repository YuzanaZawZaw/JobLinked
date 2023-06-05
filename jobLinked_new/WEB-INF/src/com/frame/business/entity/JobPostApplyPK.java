package com.frame.business.entity;

import com.frame.business.entity.base.BaseJobPostApplyPK;

public class JobPostApplyPK extends BaseJobPostApplyPK {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public JobPostApplyPK () {}
	
	public JobPostApplyPK (
		com.frame.business.entity.JobPost jobPost,
		com.frame.business.entity.Employee employee) {

		super (
			jobPost,
			employee);
	}
/*[CONSTRUCTOR MARKER END]*/


}