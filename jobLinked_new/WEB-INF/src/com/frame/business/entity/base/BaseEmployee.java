package com.frame.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the employee table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="employee"
 */

public abstract class BaseEmployee  implements Serializable {

	public static String REF = "Employee";
	public static String PROP_STATUS = "Status";
	public static String PROP_EMAIL = "Email";
	public static String PROP_SECURITY_QEST = "SecurityQest";
	public static String PROP_ADDRESS = "Address";
	public static String PROP_FIRST_NAME = "FirstName";
	public static String PROP_GENDER = "Gender";
	public static String PROP_PHONE_NO = "PhoneNo";
	public static String PROP_IMAGE_PATH = "ImagePath";
	public static String PROP_UNIVERSITY_NAME = "UniversityName";
	public static String PROP_LAST_NAME = "LastName";
	public static String PROP_ID = "Id";
	public static String PROP_NRC = "Nrc";
	public static String PROP_PASSWORD = "Password";
	public static String PROP_FATHER_NAME = "FatherName";
	public static String PROP_BIRTH_DATE = "BirthDate";


	// constructors
	public BaseEmployee () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseEmployee (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseEmployee (
		java.lang.Integer id,
		com.frame.business.entity.Status status) {

		this.setId(id);
		this.setStatus(status);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String firstName;
	private java.lang.String lastName;
	private java.lang.String email;
	private java.lang.String password;
	private java.lang.String fatherName;
	private java.lang.String phoneNo;
	private java.util.Date birthDate;
	private java.lang.String nrc;
	private java.lang.String gender;
	private java.lang.String address;
	private java.lang.String universityName;
	private java.lang.String securityQest;
	private java.lang.String imagePath;

	// many to one
	private com.frame.business.entity.Status status;

	// collections
	private java.util.Set<com.frame.business.entity.EmpImageFile> empImageFiles;
	private java.util.Set<com.frame.business.entity.JobPost> jobPosts;
	private java.util.Set<com.frame.business.entity.PartyGroupPosition> partyGroupPositions;
	private java.util.Set<com.frame.business.entity.QualType> qualTypes;
	private java.util.Set<com.frame.business.entity.SkillType> skillTypes;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="employee_id"
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
	 * Return the value associated with the column: first_name
	 */
	public java.lang.String getFirstName () {
		return firstName;
	}

	/**
	 * Set the value related to the column: first_name
	 * @param firstName the first_name value
	 */
	public void setFirstName (java.lang.String firstName) {
		this.firstName = firstName;
	}



	/**
	 * Return the value associated with the column: last_name
	 */
	public java.lang.String getLastName () {
		return lastName;
	}

	/**
	 * Set the value related to the column: last_name
	 * @param lastName the last_name value
	 */
	public void setLastName (java.lang.String lastName) {
		this.lastName = lastName;
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



	/**
	 * Return the value associated with the column: father_name
	 */
	public java.lang.String getFatherName () {
		return fatherName;
	}

	/**
	 * Set the value related to the column: father_name
	 * @param fatherName the father_name value
	 */
	public void setFatherName (java.lang.String fatherName) {
		this.fatherName = fatherName;
	}



	/**
	 * Return the value associated with the column: phone_no
	 */
	public java.lang.String getPhoneNo () {
		return phoneNo;
	}

	/**
	 * Set the value related to the column: phone_no
	 * @param phoneNo the phone_no value
	 */
	public void setPhoneNo (java.lang.String phoneNo) {
		this.phoneNo = phoneNo;
	}



	/**
	 * Return the value associated with the column: birth_date
	 */
	public java.util.Date getBirthDate () {
		return birthDate;
	}

	/**
	 * Set the value related to the column: birth_date
	 * @param birthDate the birth_date value
	 */
	public void setBirthDate (java.util.Date birthDate) {
		this.birthDate = birthDate;
	}



	/**
	 * Return the value associated with the column: nrc
	 */
	public java.lang.String getNrc () {
		return nrc;
	}

	/**
	 * Set the value related to the column: nrc
	 * @param nrc the nrc value
	 */
	public void setNrc (java.lang.String nrc) {
		this.nrc = nrc;
	}



	/**
	 * Return the value associated with the column: gender
	 */
	public java.lang.String getGender () {
		return gender;
	}

	/**
	 * Set the value related to the column: gender
	 * @param gender the gender value
	 */
	public void setGender (java.lang.String gender) {
		this.gender = gender;
	}



	/**
	 * Return the value associated with the column: address
	 */
	public java.lang.String getAddress () {
		return address;
	}

	/**
	 * Set the value related to the column: address
	 * @param address the address value
	 */
	public void setAddress (java.lang.String address) {
		this.address = address;
	}



	/**
	 * Return the value associated with the column: university_name
	 */
	public java.lang.String getUniversityName () {
		return universityName;
	}

	/**
	 * Set the value related to the column: university_name
	 * @param universityName the university_name value
	 */
	public void setUniversityName (java.lang.String universityName) {
		this.universityName = universityName;
	}



	/**
	 * Return the value associated with the column: security_qest
	 */
	public java.lang.String getSecurityQest () {
		return securityQest;
	}

	/**
	 * Set the value related to the column: security_qest
	 * @param securityQest the security_qest value
	 */
	public void setSecurityQest (java.lang.String securityQest) {
		this.securityQest = securityQest;
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



	/**
	 * Return the value associated with the column: status_id
	 */
	public com.frame.business.entity.Status getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: status_id
	 * @param status the status_id value
	 */
	public void setStatus (com.frame.business.entity.Status status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: EmpImageFiles
	 */
	public java.util.Set<com.frame.business.entity.EmpImageFile> getEmpImageFiles () {
		return empImageFiles;
	}

	/**
	 * Set the value related to the column: EmpImageFiles
	 * @param empImageFiles the EmpImageFiles value
	 */
	public void setEmpImageFiles (java.util.Set<com.frame.business.entity.EmpImageFile> empImageFiles) {
		this.empImageFiles = empImageFiles;
	}

	public void addToEmpImageFiles (com.frame.business.entity.EmpImageFile empImageFile) {
		if (null == getEmpImageFiles()) setEmpImageFiles(new java.util.TreeSet<com.frame.business.entity.EmpImageFile>());
		getEmpImageFiles().add(empImageFile);
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



	/**
	 * Return the value associated with the column: QualTypes
	 */
	public java.util.Set<com.frame.business.entity.QualType> getQualTypes () {
		return qualTypes;
	}

	/**
	 * Set the value related to the column: QualTypes
	 * @param qualTypes the QualTypes value
	 */
	public void setQualTypes (java.util.Set<com.frame.business.entity.QualType> qualTypes) {
		this.qualTypes = qualTypes;
	}

	public void addToQualTypes (com.frame.business.entity.QualType qualType) {
		if (null == getQualTypes()) setQualTypes(new java.util.TreeSet<com.frame.business.entity.QualType>());
		getQualTypes().add(qualType);
	}



	/**
	 * Return the value associated with the column: SkillTypes
	 */
	public java.util.Set<com.frame.business.entity.SkillType> getSkillTypes () {
		return skillTypes;
	}

	/**
	 * Set the value related to the column: SkillTypes
	 * @param skillTypes the SkillTypes value
	 */
	public void setSkillTypes (java.util.Set<com.frame.business.entity.SkillType> skillTypes) {
		this.skillTypes = skillTypes;
	}

	public void addToSkillTypes (com.frame.business.entity.SkillType skillType) {
		if (null == getSkillTypes()) setSkillTypes(new java.util.TreeSet<com.frame.business.entity.SkillType>());
		getSkillTypes().add(skillType);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.frame.business.entity.Employee)) return false;
		else {
			com.frame.business.entity.Employee employee = (com.frame.business.entity.Employee) obj;
			if (null == this.getId() || null == employee.getId()) return false;
			else return (this.getId().equals(employee.getId()));
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