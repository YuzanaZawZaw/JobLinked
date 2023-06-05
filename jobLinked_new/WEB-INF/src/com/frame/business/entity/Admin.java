package com.frame.business.entity;

import com.frame.business.entity.base.BaseAdmin;



public class Admin extends BaseAdmin {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Admin () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Admin (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Admin (
		java.lang.Integer id,
		java.lang.String email) {

		super (
			id,
			email);
	}

/*[CONSTRUCTOR MARKER END]*/


}