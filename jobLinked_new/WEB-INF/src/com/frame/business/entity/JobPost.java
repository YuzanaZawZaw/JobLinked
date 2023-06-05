package com.frame.business.entity;

import com.frame.business.entity.base.BaseJobPost;



public class JobPost extends BaseJobPost {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public JobPost () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public JobPost (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public JobPost (
		java.lang.Integer id,
		com.frame.business.entity.Status status,
		com.frame.business.entity.Recruiters recruiter,
		com.frame.business.entity.PartyGroupPosition partyGroupPosition,
		java.lang.String location,
		java.lang.String employmentType,
		java.lang.String salary,
		java.util.Date fromDate,
		java.util.Date thruDate) {

		super (
			id,
			status,
			recruiter,
			partyGroupPosition,
			location,
			employmentType,
			salary,
			fromDate,
			thruDate);
	}

/*[CONSTRUCTOR MARKER END]*/


}