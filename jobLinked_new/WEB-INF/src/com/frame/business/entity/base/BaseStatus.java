package com.frame.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the status table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="status"
 */

public abstract class BaseStatus  implements Serializable {

	public static String REF = "Status";
	public static String PROP_DESCRIPTION = "Description";
	public static String PROP_ID = "Id";


	// constructors
	public BaseStatus () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStatus (java.lang.Integer id) {
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
	private java.util.Set<com.frame.business.entity.Employee> employees;
	private java.util.Set<com.frame.business.entity.JobPost> jobPosts;
	private java.util.Set<com.frame.business.entity.Recruiters> recruiters;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="status_id"
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



	/**
	 * Return the value associated with the column: JobPosts
	 */
	public java.util.Set<com.frame.business.entity.JobPost> getJobPosts () {
		return jobPosts;
	}

	/**
	 * Set the value related to the column: JobPosts
	 * @param jobPosts the JobPosts value
	 */
	public void setJobPosts (java.util.Set<com.frame.business.entity.JobPost> jobPosts) {
		this.jobPosts = jobPosts;
	}

	public void addToJobPosts (com.frame.business.entity.JobPost jobPost) {
		if (null == getJobPosts()) setJobPosts(new java.util.TreeSet<com.frame.business.entity.JobPost>());
		getJobPosts().add(jobPost);
	}



	/**
	 * Return the value associated with the column: Recruiters
	 */
	public java.util.Set<com.frame.business.entity.Recruiters> getRecruiters () {
		return recruiters;
	}

	/**
	 * Set the value related to the column: Recruiters
	 * @param recruiters the Recruiters value
	 */
	public void setRecruiters (java.util.Set<com.frame.business.entity.Recruiters> recruiters) {
		this.recruiters = recruiters;
	}

	public void addToRecruiters (com.frame.business.entity.Recruiters recruiters) {
		if (null == getRecruiters()) setRecruiters(new java.util.TreeSet<com.frame.business.entity.Recruiters>());
		getRecruiters().add(recruiters);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.frame.business.entity.Status)) return false;
		else {
			com.frame.business.entity.Status status = (com.frame.business.entity.Status) obj;
			if (null == this.getId() || null == status.getId()) return false;
			else return (this.getId().equals(status.getId()));
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