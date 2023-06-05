package com.frame.business.entity;

import com.frame.business.entity.base.BaseRecruiters;



public class Recruiters extends BaseRecruiters {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Recruiters () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Recruiters (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Recruiters (
		java.lang.Integer id,
		com.frame.business.entity.Status status) {

		super (
			id,
			status);
	}

/*[CONSTRUCTOR MARKER END]*/


}