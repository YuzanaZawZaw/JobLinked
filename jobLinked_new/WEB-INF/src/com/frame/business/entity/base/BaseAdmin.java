package com.frame.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the admin table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="admin"
 */

public abstract class BaseAdmin  implements Serializable {

	public static String REF = "Admin";
	public static String PROP_EMAIL = "Email";
	public static String PROP_ID = "Id";
	public static String PROP_PASSWORD = "Password";


	// constructors
	public BaseAdmin () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAdmin (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseAdmin (
		java.lang.Integer id,
		java.lang.String email) {

		this.setId(id);
		this.setEmail(email);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String email;
	private java.lang.String password;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="admin_id"
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
	 * Return the value associated with the column: email
	 */
	public java.lang.String getEmail () {
		return email;
	}

	/**
	 * Set the value related to the column: email
	 * @param email the email value
	 */
	public void setEmail (java.lang.String email) {
		this.email = email;
	}



	/**
	 * Return the value associated with the column: password
	 */
	public java.lang.String getPassword () {
		return password;
	}

	/**
	 * Set the value related to the column: password
	 * @param password the password value
	 */
	public void setPassword (java.lang.String password) {
		this.password = password;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.frame.business.entity.Admin)) return false;
		else {
			com.frame.business.entity.Admin admin = (com.frame.business.entity.Admin) obj;
			if (null == this.getId() || null == admin.getId()) return false;
			else return (this.getId().equals(admin.getId()));
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