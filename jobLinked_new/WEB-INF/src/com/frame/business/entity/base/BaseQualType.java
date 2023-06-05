package com.frame.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the qual_type table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="qual_type"
 */

public abstract class BaseQualType  implements Serializable {

	public static String REF = "QualType";
	public static String PROP_DESCRIPTION = "Description";
	public static String PROP_ID = "Id";


	// constructors
	public BaseQualType () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseQualType (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String description;

	// collections
	private java.util.Set<com.frame.business.entity.JobPostQual> jobPostQuals;
	private java.util.Set<com.frame.business.entity.Employee> employees;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="qual_type_id"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: description
	 */
	public java.lang.String getDescription () {
		return description;
	}

	/**
	 * Set the value related to the column: description
	 * @param description the description value
	 */
	public void setDescription (java.lang.String description) {
		this.description = description;
	}



	/**
	 * Return the value associated with the column: JobPostQuals
	 */
	public java.util.Set<com.frame.business.entity.JobPostQual> getJobPostQuals () {
		return jobPostQuals;
	}

	/**
	 * Set the value related to the column: JobPostQuals
	 * @param jobPostQuals the JobPostQuals value
	 */
	public void setJobPostQuals (java.util.Set<com.frame.business.entity.JobPostQual> jobPostQuals) {
		this.jobPostQuals = jobPostQuals;
	}

	public void addToJobPostQuals (com.frame.business.entity.JobPostQual jobPostQual) {
		if (null == getJobPostQuals()) setJobPostQuals(new java.util.TreeSet<com.frame.business.entity.JobPostQual>());
		getJobPostQuals().add(jobPostQual);
	}



	/**
	 * Return the value associated with the column: Employees
	 */
	public java.util.Set<com.frame.business.entity.Employee> getEmployees () {
		return employees;
	}

	/**
	 * Set the value related to the column: Employees
	 * @param employees the Employees value
	 */
	public void setEmployees (java.util.Set<com.frame.business.entity.Employee> employees) {
		this.employees = employees;
	}

	public void addToEmployees (com.frame.business.entity.Employee employee) {
		if (null == getEmployees()) setEmployees(new java.util.TreeSet<com.frame.business.entity.Employee>());
		getEmployees().add(employee);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.frame.business.entity.QualType)) return false;
		else {
			com.frame.business.entity.QualType qualType = (com.frame.business.entity.QualType) obj;
			if (null == this.getId() || null == qualType.getId()) return false;
			else return (this.getId().equals(qualType.getId()));
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