package com.frame.business.entity.base;

import java.io.Serializable;


public abstract class BaseEmployeeQualPK implements Serializable {

	protected int hashCode = Integer.MIN_VALUE;

	private com.frame.business.entity.Employee employee;
	private com.frame.business.entity.QualType qualType;


	public BaseEmployeeQualPK () {}
	
	public BaseEmployeeQualPK (
		com.frame.business.entity.Employee employee,
		com.frame.business.entity.QualType qualType) {

		this.setEmployee(employee);
		this.setQualType(qualType);
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



	/**
	 * Return the value associated with the column: qual_type_id
	 */
	public com.frame.business.entity.QualType getQualType () {
		return qualType;
	}

	/**
	 * Set the value related to the column: qual_type_id
	 * @param qualType the qual_type_id value
	 */
	public void setQualType (com.frame.business.entity.QualType qualType) {
		this.qualType = qualType;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.frame.business.entity.EmployeeQualPK)) return false;
		else {
			com.frame.business.entity.EmployeeQualPK mObj = (com.frame.business.entity.EmployeeQualPK) obj;
			if (null != this.getEmployee() && null != mObj.getEmployee()) {
				if (!this.getEmployee().equals(mObj.getEmployee())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getQualType() && null != mObj.getQualType()) {
				if (!this.getQualType().equals(mObj.getQualType())) {
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
			if (null != this.getEmployee()) {
				sb.append(this.getEmployee().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getQualType()) {
				sb.append(this.getQualType().hashCode());
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