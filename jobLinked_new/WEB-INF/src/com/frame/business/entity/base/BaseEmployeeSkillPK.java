package com.frame.business.entity.base;

import java.io.Serializable;


public abstract class BaseEmployeeSkillPK implements Serializable {

	protected int hashCode = Integer.MIN_VALUE;

	private com.frame.business.entity.Employee employee;
	private com.frame.business.entity.SkillType skillType;


	public BaseEmployeeSkillPK () {}
	
	public BaseEmployeeSkillPK (
		com.frame.business.entity.Employee employee,
		com.frame.business.entity.SkillType skillType) {

		this.setEmployee(employee);
		this.setSkillType(skillType);
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
	 * Return the value associated with the column: skill_type_id
	 */
	public com.frame.business.entity.SkillType getSkillType () {
		return skillType;
	}

	/**
	 * Set the value related to the column: skill_type_id
	 * @param skillType the skill_type_id value
	 */
	public void setSkillType (com.frame.business.entity.SkillType skillType) {
		this.skillType = skillType;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.frame.business.entity.EmployeeSkillPK)) return false;
		else {
			com.frame.business.entity.EmployeeSkillPK mObj = (com.frame.business.entity.EmployeeSkillPK) obj;
			if (null != this.getEmployee() && null != mObj.getEmployee()) {
				if (!this.getEmployee().equals(mObj.getEmployee())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getSkillType() && null != mObj.getSkillType()) {
				if (!this.getSkillType().equals(mObj.getSkillType())) {
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
			if (null != this.getSkillType()) {
				sb.append(this.getSkillType().hashCode());
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