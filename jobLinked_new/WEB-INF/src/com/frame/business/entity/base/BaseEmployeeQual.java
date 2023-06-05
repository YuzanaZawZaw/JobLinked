package com.frame.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the employee_qual table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="employee_qual"
 */

public abstract class BaseEmployeeQual  implements Serializable {

	public static String REF = "EmployeeQual";
	public static String PROP_THRU_DATE = "ThruDate";
	public static String PROP_FIELD_OF_ACTIVITY = "FieldOfActivity";
	public static String PROP_DEGREE = "Degree";
	public static String PROP_FIELD_OF_STUDY = "FieldOfStudy";
	public static String PROP_SCHOOL_NAME = "SchoolName";
	public static String PROP_FROM_DATE = "FromDate";
	public static String PROP_ID = "Id";
	public static String PROP_QUAL_GRADE = "QualGrade";


	// constructors
	public BaseEmployeeQual () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseEmployeeQual (com.frame.business.entity.EmployeeQualPK id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseEmployeeQual (
		com.frame.business.entity.EmployeeQualPK id,
		java.util.Date fromDate) {

		this.setId(id);
		this.setFromDate(fromDate);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private com.frame.business.entity.EmployeeQualPK id;

	// fields
	private java.lang.String schoolName;
	private java.lang.String degree;
	private java.lang.String fieldOfStudy;
	private java.util.Date fromDate;
	private java.util.Date thruDate;
	private java.lang.String fieldOfActivity;
	private java.lang.String qualGrade;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     */
	public com.frame.business.entity.EmployeeQualPK getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (com.frame.business.entity.EmployeeQualPK id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: school_name
	 */
	public java.lang.String getSchoolName () {
		return schoolName;
	}

	/**
	 * Set the value related to the column: school_name
	 * @param schoolName the school_name value
	 */
	public void setSchoolName (java.lang.String schoolName) {
		this.schoolName = schoolName;
	}



	/**
	 * Return the value associated with the column: degree
	 */
	public java.lang.String getDegree () {
		return degree;
	}

	/**
	 * Set the value related to the column: degree
	 * @param degree the degree value
	 */
	public void setDegree (java.lang.String degree) {
		this.degree = degree;
	}



	/**
	 * Return the value associated with the column: field_of_study
	 */
	public java.lang.String getFieldOfStudy () {
		return fieldOfStudy;
	}

	/**
	 * Set the value related to the column: field_of_study
	 * @param fieldOfStudy the field_of_study value
	 */
	public void setFieldOfStudy (java.lang.String fieldOfStudy) {
		this.fieldOfStudy = fieldOfStudy;
	}



	/**
	 * Return the value associated with the column: from_date
	 */
	public java.util.Date getFromDate () {
		return fromDate;
	}

	/**
	 * Set the value related to the column: from_date
	 * @param fromDate the from_date value
	 */
	public void setFromDate (java.util.Date fromDate) {
		this.fromDate = fromDate;
	}



	/**
	 * Return the value associated with the column: thru_date
	 */
	public java.util.Date getThruDate () {
		return thruDate;
	}

	/**
	 * Set the value related to the column: thru_date
	 * @param thruDate the thru_date value
	 */
	public void setThruDate (java.util.Date thruDate) {
		this.thruDate = thruDate;
	}



	/**
	 * Return the value associated with the column: field_of_activity
	 */
	public java.lang.String getFieldOfActivity () {
		return fieldOfActivity;
	}

	/**
	 * Set the value related to the column: field_of_activity
	 * @param fieldOfActivity the field_of_activity value
	 */
	public void setFieldOfActivity (java.lang.String fieldOfActivity) {
		this.fieldOfActivity = fieldOfActivity;
	}



	/**
	 * Return the value associated with the column: qual_grade
	 */
	public java.lang.String getQualGrade () {
		return qualGrade;
	}

	/**
	 * Set the value related to the column: qual_grade
	 * @param qualGrade the qual_grade value
	 */
	public void setQualGrade (java.lang.String qualGrade) {
		this.qualGrade = qualGrade;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.frame.business.entity.EmployeeQual)) return false;
		else {
			com.frame.business.entity.EmployeeQual employeeQual = (com.frame.business.entity.EmployeeQual) obj;
			if (null == this.getId() || null == employeeQual.getId()) return false;
			else return (this.getId().equals(employeeQual.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}