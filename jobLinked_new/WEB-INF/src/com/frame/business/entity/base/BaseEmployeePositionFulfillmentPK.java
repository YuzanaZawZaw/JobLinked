package com.frame.business.entity.base;

import java.io.Serializable;


public abstract class BaseEmployeePositionFulfillmentPK implements Serializable {

	protected int hashCode = Integer.MIN_VALUE;

	private com.frame.business.entity.Employee employee;
	private com.frame.business.entity.PartyGroupPosition partyGroupPosition;


	public BaseEmployeePositionFulfillmentPK () {}
	
	public BaseEmployeePositionFulfillmentPK (
		com.frame.business.entity.Employee employee,
		com.frame.business.entity.PartyGroupPosition partyGroupPosition) {

		this.setEmployee(employee);
		this.setPartyGroupPosition(partyGroupPosition);
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.frame.business.entity.EmployeePositionFulfillmentPK)) return false;
		else {
			com.frame.business.entity.EmployeePositionFulfillmentPK mObj = (com.frame.business.entity.EmployeePositionFulfillmentPK) obj;
			if (null != this.getEmployee() && null != mObj.getEmployee()) {
				if (!this.getEmployee().equals(mObj.getEmployee())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getPartyGroupPosition() && null != mObj.getPartyGroupPosition()) {
				if (!this.getPartyGroupPosition().equals(mObj.getPartyGroupPosition())) {
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
			if (null != this.getPartyGroupPosition()) {
				sb.append(this.getPartyGroupPosition().hashCode());
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