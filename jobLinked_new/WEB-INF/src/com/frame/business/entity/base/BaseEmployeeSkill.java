package com.frame.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the employee_skill table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="employee_skill"
 */

public abstract class BaseEmployeeSkill  implements Serializable {

	public static String REF = "EmployeeSkill";
	public static String PROP_SKILL_LEVEL = "SkillLevel";
	public static String PROP_ID = "Id";


	// constructors
	public BaseEmployeeSkill () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseEmployeeSkill (com.frame.business.entity.EmployeeSkillPK id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private com.frame.business.entity.EmployeeSkillPK id;

	// fields
	private java.lang.String skillLevel;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     */
	public com.frame.business.entity.EmployeeSkillPK getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (com.frame.business.entity.EmployeeSkillPK id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: skill_level
	 */
	public java.lang.String getSkillLevel () {
		return skillLevel;
	}

	/**
	 * Set the value related to the column: skill_level
	 * @param skillLevel the skill_level value
	 */
	public void setSkillLevel (java.lang.String skillLevel) {
		this.skillLevel = skillLevel;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.frame.business.entity.EmployeeSkill)) return false;
		else {
			com.frame.business.entity.EmployeeSkill employeeSkill = (com.frame.business.entity.EmployeeSkill) obj;
			if (null == this.getId() || null == employeeSkill.getId()) return false;
			else return (this.getId().equals(employeeSkill.getId()));
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