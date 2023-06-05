package com.frame.business.entity;

import com.frame.business.entity.base.BaseEmployee;



public class Employee extends BaseEmployee {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Employee () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Employee (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Employee (
		java.lang.Integer id,
		com.frame.business.entity.Status status) {

		super (
			id,
			status);
	}

/*[CONSTRUCTOR MARKER END]*/


}