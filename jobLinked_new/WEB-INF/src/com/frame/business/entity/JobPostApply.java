package com.frame.business.entity;

import com.frame.business.entity.base.BaseJobPostApply;



public class JobPostApply extends BaseJobPostApply {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public JobPostApply () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public JobPostApply (com.frame.business.entity.JobPostApplyPK id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public JobPostApply (
		com.frame.business.entity.JobPostApplyPK id,
		java.util.Date fromDate) {

		super (
			id,
			fromDate);
	}

/*[CONSTRUCTOR MARKER END]*/


}