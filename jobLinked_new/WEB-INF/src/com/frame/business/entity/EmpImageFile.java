package com.frame.business.entity;

import com.frame.business.entity.base.BaseEmpImageFile;



public class EmpImageFile extends BaseEmpImageFile {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public EmpImageFile () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public EmpImageFile (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public EmpImageFile (
		java.lang.Integer id,
		com.frame.business.entity.Employee employee) {

		super (
			id,
			employee);
	}

/*[CONSTRUCTOR MARKER END]*/


}