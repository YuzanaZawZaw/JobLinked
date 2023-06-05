package com.frame.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the job_post table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="job_post"
 */

public abstract class BaseJobPost  implements Serializable {

	public static String REF = "JobPost";
	public static String PROP_STATUS = "Status";
	public static String PROP_SALARY = "Salary";
	public static String PROP_THRU_DATE = "ThruDate";
	public static String PROP_PARTY_GROUP_POSITION = "PartyGroupPosition";
	public static String PROP_FROM_DATE = "FromDate";
	public static String PROP_ID = "Id";
	public static String PROP_EMPLOYMENT_TYPE = "EmploymentType";
	public static String PROP_RECRUITER = "Recruiter";
	public static String PROP_LOCATION = "Location";


	// constructors
	public BaseJobPost () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseJobPost (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseJobPost (
		java.lang.Integer id,
		com.frame.business.entity.Status status,
		com.frame.business.entity.Recruiters recruiter,
		com.frame.business.entity.PartyGroupPosition partyGroupPosition,
		java.lang.String location,
		java.lang.String employmentType,
		java.lang.String salary,
		java.util.Date fromDate,
		java.util.Date thruDate) {

		this.setId(id);
		this.setStatus(status);
		this.setRecruiter(recruiter);
		this.setPartyGroupPosition(partyGroupPosition);
		this.setLocation(location);
		this.setEmploymentType(employmentType);
		this.setSalary(salary);
		this.setFromDate(fromDate);
		this.setThruDate(thruDate);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String location;
	private java.lang.String employmentType;
	private java.lang.String salary;
	private java.util.Date fromDate;
	private java.util.Date thruDate;

	// many to one
	private com.frame.business.entity.Status status;
	private com.frame.business.entity.Recruiters recruiter;
	private com.frame.business.entity.PartyGroupPosition partyGroupPosition;

	// collections
	private java.util.Set<com.frame.business.entity.JobPostRequirement> jobPostRequirements;
	private java.util.Set<com.frame.business.entity.JobPostQual> jobPostQuals;
	private java.util.Set<com.frame.business.entity.Employee> employees;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="job_post_id"
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
	 * Return the value associated with the column: salary
	 */
	public java.lang.String getSalary () {
		return salary;
	}

	/**
	 * Set the value related to the column: salary
	 * @param salary the salary value
	 */
	public void setSalary (java.lang.String salary) {
		this.salary = salary;
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
	 * Return the value associated with the column: status_id
	 */
	public com.frame.business.entity.Status getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: status_id
	 * @param status the status_id value
	 */
	public void setStatus (com.frame.business.entity.Status status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: recruiter_id
	 */
	public com.frame.business.entity.Recruiters getRecruiter () {
		return recruiter;
	}

	/**
	 * Set the value related to the column: recruiter_id
	 * @param recruiter the recruiter_id value
	 */
	public void setRecruiter (com.frame.business.entity.Recruiters recruiter) {
		this.recruiter = recruiter;
	}



	/**
	 * Return the value associated with the column: party_group_position_id
	 */
	public com.frame.business.entity.PartyGroupPosition getPartyGroupPosition () {
		return partyGroupPosition;
	}

	/**
	 * Set the value related to the column: party_group_position_id
	 * @param partyGroupPosition the party_group_position_id value
	 */
	public void setPartyGroupPosition (com.frame.business.entity.PartyGroupPosition partyGroupPosition) {
		this.partyGroupPosition = partyGroupPosition;
	}



	/**
	 * Return the value associated with the column: JobPostRequirements
	 */
	public java.util.Set<com.frame.business.entity.JobPostRequirement> getJobPostRequirements () {
		return jobPostRequirements;
	}

	/**
	 * Set the value related to the column: JobPostRequirements
	 * @param jobPostRequirements the JobPostRequirements value
	 */
	public void setJobPostRequirements (java.util.Set<com.frame.business.entity.JobPostRequirement> jobPostRequirements) {
		this.jobPostRequirements = jobPostRequirements;
	}

	public void addToJobPostRequirements (com.frame.business.entity.JobPostRequirement jobPostRequirement) {
		if (null == getJobPostRequirements()) setJobPostRequirements(new java.util.TreeSet<com.frame.business.entity.JobPostRequirement>());
		getJobPostRequirements().add(jobPostRequirement);
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
		if (!(obj instanceof com.frame.business.entity.JobPost)) return false;
		else {
			com.frame.business.entity.JobPost jobPost = (com.frame.business.entity.JobPost) obj;
			if (null == this.getId() || null == jobPost.getId()) return false;
			else return (this.getId().equals(jobPost.getId()));
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