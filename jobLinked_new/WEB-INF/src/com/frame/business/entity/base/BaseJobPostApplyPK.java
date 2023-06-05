package com.frame.business.entity.base;

import java.io.Serializable;


public abstract class BaseJobPostApplyPK implements Serializable {

	protected int hashCode = Integer.MIN_VALUE;

	private com.frame.business.entity.JobPost jobPost;
	private com.frame.business.entity.Employee employee;


	public BaseJobPostApplyPK () {}
	
	public BaseJobPostApplyPK (
		com.frame.business.entity.JobPost jobPost,
		com.frame.business.entity.Employee employee) {

		this.setJobPost(jobPost);
		this.setEmployee(employee);
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



	/**
	 * Return the value associated with the column: employee_id
	 */
	public com.frame.business.entity.Employee getEmployee () {
		return employee;
	}

	/**
	 * Set the value related to the column: employee_id
	 * @param employee the employee_id value
	 */
	public void setEmployee (com.frame.business.entity.Employee employee) {
		this.employee = employee;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.frame.business.entity.JobPostApplyPK)) return false;
		else {
			com.frame.business.entity.JobPostApplyPK mObj = (com.frame.business.entity.JobPostApplyPK) obj;
			if (null != this.getJobPost() && null != mObj.getJobPost()) {
				if (!this.getJobPost().equals(mObj.getJobPost())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getEmployee() && null != mObj.getEmployee()) {
				if (!this.getEmployee().equals(mObj.getEmployee())) {
					return false;
				}
			}
			else {
				return false;
			}
			return true;
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			StringBuilder sb = new StringBuilder();
			if (null != this.getJobPost()) {
				sb.append(this.getJobPost().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getEmployee()) {
				sb.append(this.getEmployee().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			this.hashCode = sb.toString().hashCode();
		}
		return this.hashCode;
	}


}