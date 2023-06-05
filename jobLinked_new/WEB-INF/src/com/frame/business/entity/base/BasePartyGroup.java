package com.frame.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the party_group table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="party_group"
 */

public abstract class BasePartyGroup  implements Serializable {

	public static String REF = "PartyGroup";
	public static String PROP_DESCRIPTION = "Description";
	public static String PROP_TOTAL_EMPLOYEE = "TotalEmployee";
	public static String PROP_GROUP_NAME_LOCAL = "GroupNameLocal";
	public static String PROP_ID = "Id";


	// constructors
	public BasePartyGroup () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePartyGroup (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String groupNameLocal;
	private java.lang.String totalEmployee;
	private java.lang.String description;

	// collections
	private java.util.Set<com.frame.business.entity.PartyGroupPosition> partyGroupPositions;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="party_group_id"
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
	 * Return the value associated with the column: group_name_local
	 */
	public java.lang.String getGroupNameLocal () {
		return groupNameLocal;
	}

	/**
	 * Set the value related to the column: group_name_local
	 * @param groupNameLocal the group_name_local value
	 */
	public void setGroupNameLocal (java.lang.String groupNameLocal) {
		this.groupNameLocal = groupNameLocal;
	}



	/**
	 * Return the value associated with the column: total_employee
	 */
	public java.lang.String getTotalEmployee () {
		return totalEmployee;
	}

	/**
	 * Set the value related to the column: total_employee
	 * @param totalEmployee the total_employee value
	 */
	public void setTotalEmployee (java.lang.String totalEmployee) {
		this.totalEmployee = totalEmployee;
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
	 * Return the value associated with the column: PartyGroupPositions
	 */
	public java.util.Set<com.frame.business.entity.PartyGroupPosition> getPartyGroupPositions () {
		return partyGroupPositions;
	}

	/**
	 * Set the value related to the column: PartyGroupPositions
	 * @param partyGroupPositions the PartyGroupPositions value
	 */
	public void setPartyGroupPositions (java.util.Set<com.frame.business.entity.PartyGroupPosition> partyGroupPositions) {
		this.partyGroupPositions = partyGroupPositions;
	}

	public void addToPartyGroupPositions (com.frame.business.entity.PartyGroupPosition partyGroupPosition) {
		if (null == getPartyGroupPositions()) setPartyGroupPositions(new java.util.TreeSet<com.frame.business.entity.PartyGroupPosition>());
		getPartyGroupPositions().add(partyGroupPosition);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.frame.business.entity.PartyGroup)) return false;
		else {
			com.frame.business.entity.PartyGroup partyGroup = (com.frame.business.entity.PartyGroup) obj;
			if (null == this.getId() || null == partyGroup.getId()) return false;
			else return (this.getId().equals(partyGroup.getId()));
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