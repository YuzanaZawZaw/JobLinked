package com.frame.business.entity;

import com.frame.business.entity.base.BaseJobPostRequirement;



public class JobPostRequirement extends BaseJobPostRequirement {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public JobPostRequirement () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public JobPostRequirement (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public JobPostRequirement (
		java.lang.Integer id,
		com.frame.business.entity.JobPost jobPost) {

		super (
			id,
			jobPost);
	}

/*[CONSTRUCTOR MARKER END]*/


}