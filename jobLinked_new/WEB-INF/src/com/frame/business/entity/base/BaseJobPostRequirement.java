package com.frame.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the job_post_requirement table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="job_post_requirement"
 */

public abstract class BaseJobPostRequirement  implements Serializable {

	public static String REF = "JobPostRequirement";
	public static String PROP_DESCRIPTION = "Description";
	public static String PROP_ID = "Id";
	public static String PROP_JOB_POST = "JobPost";


	// constructors
	public BaseJobPostRequirement () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseJobPostRequirement (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseJobPostRequirement (
		java.lang.Integer id,
		com.frame.business.entity.JobPost jobPost) {

		this.setId(id);
		this.setJobPost(jobPost);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String description;

	// many to one
	private com.frame.business.entity.JobPost jobPost;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="job_post_requirement_id"
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
	 * Return the value associated with the column: job_post_id
	 */
	public com.frame.business.entity.JobPost getJobPost () {
		return jobPost;
	}

	/**
	 * Set the value related to the column: job_post_id
	 * @param jobPost the job_post_id value
	 */
	public void setJobPost (com.frame.business.entity.JobPost jobPost) {
		this.jobPost = jobPost;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.frame.business.entity.JobPostRequirement)) return false;
		else {
			com.frame.business.entity.JobPostRequirement jobPostRequirement = (com.frame.business.entity.JobPostRequirement) obj;
			if (null == this.getId() || null == jobPostRequirement.getId()) return false;
			else return (this.getId().equals(jobPostRequirement.getId()));
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