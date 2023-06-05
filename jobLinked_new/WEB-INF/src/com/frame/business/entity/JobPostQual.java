package com.frame.business.entity;

import com.frame.business.entity.base.BaseJobPostQual;



public class JobPostQual extends BaseJobPostQual {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public JobPostQual () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public JobPostQual (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public JobPostQual (
		java.lang.Integer id,
		com.frame.business.entity.JobPost jobPost,
		com.frame.business.entity.QualType qualType) {

		super (
			id,
			jobPost,
			qualType);
	}

/*[CONSTRUCTOR MARKER END]*/


}