package com.frame.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the job_post_apply table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="job_post_apply"
 */

public abstract class BaseJobPostApply  implements Serializable {

	public static String REF = "JobPostApply";
	public static String PROP_FROM_DATE = "FromDate";
	public static String PROP_ID = "Id";
	public static String PROP_IMAGE_PATH = "ImagePath";


	// constructors
	public BaseJobPostApply () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseJobPostApply (com.frame.business.entity.JobPostApplyPK id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseJobPostApply (
		com.frame.business.entity.JobPostApplyPK id,
		java.util.Date fromDate) {

		this.setId(id);
		this.setFromDate(fromDate);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private com.frame.business.entity.JobPostApplyPK id;

	// fields
	private java.util.Date fromDate;
	private java.lang.String imagePath;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     */
	public com.frame.business.entity.JobPostApplyPK getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (com.frame.business.entity.JobPostApplyPK id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
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
	 * Return the value associated with the column: image_path
	 */
	public java.lang.String getImagePath () {
		return imagePath;
	}

	/**
	 * Set the value related to the column: image_path
	 * @param imagePath the image_path value
	 */
	public void setImagePath (java.lang.String imagePath) {
		this.imagePath = imagePath;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.frame.business.entity.JobPostApply)) return false;
		else {
			com.frame.business.entity.JobPostApply jobPostApply = (com.frame.business.entity.JobPostApply) obj;
			if (null == this.getId() || null == jobPostApply.getId()) return false;
			else return (this.getId().equals(jobPostApply.getId()));
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