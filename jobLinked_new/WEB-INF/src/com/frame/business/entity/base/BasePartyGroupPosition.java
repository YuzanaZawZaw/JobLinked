package com.frame.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the party_group_position table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="party_group_position"
 */

public abstract class BasePartyGroupPosition  implements Serializable {

	public static String REF = "PartyGroupPosition";
	public static String PROP_POSITION_NAME = "PositionName";
	public static String PROP_PARTY_GROUP = "PartyGroup";
	public static String PROP_ID = "Id";
	public static String PROP_PARTY_GROUP_POSITION_TYPE = "PartyGroupPositionType";


	// constructors
	public BasePartyGroupPosition () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePartyGroupPosition (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BasePartyGroupPosition (
		java.lang.Integer id,
		com.frame.business.entity.PartyGroup partyGroup,
		com.frame.business.entity.PartyGroupPositionType partyGroupPositionType) {

		this.setId(id);
		this.setPartyGroup(partyGroup);
		this.setPartyGroupPositionType(partyGroupPositionType);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String positionName;

	// many to one
	private com.frame.business.entity.PartyGroup partyGroup;
	private com.frame.business.entity.PartyGroupPositionType partyGroupPositionType;

	// collections
	private java.util.Set<com.frame.business.entity.JobPost> jobPosts;
	private java.util.Set<com.frame.business.entity.Recruiters> recruiters;
	private java.util.Set<com.frame.business.entity.Employee> employees;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="party_group_position_id"
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
	 * Return the value associated with the column: position_name
	 */
	public java.lang.String getPositionName () {
		return positionName;
	}

	/**
	 * Set the value related to the column: position_name
	 * @param positionName the position_name value
	 */
	public void setPositionName (java.lang.String positionName) {
		this.positionName = positionName;
	}



	/**
	 * Return the value associated with the column: party_group_id
	 */
	public com.frame.business.entity.PartyGroup getPartyGroup () {
		return partyGroup;
	}

	/**
	 * Set the value related to the column: party_group_id
	 * @param partyGroup the party_group_id value
	 */
	public void setPartyGroup (com.frame.business.entity.PartyGroup partyGroup) {
		this.partyGroup = partyGroup;
	}



	/**
	 * Return the value associated with the column: party_group_position_type_id
	 */
	public com.frame.business.entity.PartyGroupPositionType getPartyGroupPositionType () {
		return partyGroupPositionType;
	}

	/**
	 * Set the value related to the column: party_group_position_type_id
	 * @param partyGroupPositionType the party_group_position_type_id value
	 */
	public void setPartyGroupPositionType (com.frame.business.entity.PartyGroupPositionType partyGroupPositionType) {
		this.partyGroupPositionType = partyGroupPositionType;
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
		if (!(obj instanceof com.frame.business.entity.PartyGroupPosition)) return false;
		else {
			com.frame.business.entity.PartyGroupPosition partyGroupPosition = (com.frame.business.entity.PartyGroupPosition) obj;
			if (null == this.getId() || null == partyGroupPosition.getId()) return false;
			else return (this.getId().equals(partyGroupPosition.getId()));
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