package com.frame.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the employee_position_fulfillment table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="employee_position_fulfillment"
 */

public abstract class BaseEmployeePositionFulfillment  implements Serializable {

	public static String REF = "EmployeePositionFulfillment";
	public static String PROP_CURRENT_ROLE = "CurrentRole";
	public static String PROP_THRU_DATE = "ThruDate";
	public static String PROP_FROM_DATE = "FromDate";
	public static String PROP_ID = "Id";
	public static String PROP_EMPLOYMENT_TYPE = "EmploymentType";
	public static String PROP_LOCATION = "Location";


	// constructors
	public BaseEmployeePositionFulfillment () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseEmployeePositionFulfillment (com.frame.business.entity.EmployeePositionFulfillmentPK id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseEmployeePositionFulfillment (
		com.frame.business.entity.EmployeePositionFulfillmentPK id,
		java.util.Date fromDate) {

		this.setId(id);
		this.setFromDate(fromDate);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private com.frame.business.entity.EmployeePositionFulfillmentPK id;

	// fields
	private java.lang.String employmentType;
	private java.lang.String location;
	private java.lang.String currentRole;
	private java.util.Date fromDate;
	private java.util.Date thruDate;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     */
	public com.frame.business.entity.EmployeePositionFulfillmentPK getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (com.frame.business.entity.EmployeePositionFulfillmentPK id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: employment_type
	 */
	public java.lang.String getEmploymentType () {
		return employmentType;
	}

	/**
	 * Set the value related to the column: employment_type
	 * @param employmentType the employment_type value
	 */
	public void setEmploymentType (java.lang.String employmentType) {
		this.employmentType = employmentType;
	}



	/**
	 * Return the value associated with the column: location
	 */
	public java.lang.String getLocation () {
		return location;
	}

	/**
	 * Set the value related to the column: location
	 * @param location the location value
	 */
	public void setLocation (java.lang.String location) {
		this.location = location;
	}



	/**
	 * Return the value associated with the column: current_role
	 */
	public java.lang.String getCurrentRole () {
		return currentRole;
	}

	/**
	 * Set the value related to the column: current_role
	 * @param currentRole the current_role value
	 */
	public void setCurrentRole (java.lang.String currentRole) {
		this.currentRole = currentRole;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.frame.business.entity.EmployeePositionFulfillment)) return false;
		else {
			com.frame.business.entity.EmployeePositionFulfillment employeePositionFulfillment = (com.frame.business.entity.EmployeePositionFulfillment) obj;
			if (null == this.getId() || null == employeePositionFulfillment.getId()) return false;
			else return (this.getId().equals(employeePositionFulfillment.getId()));
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