package com.frame.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the emp_image_file table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="emp_image_file"
 */

public abstract class BaseEmpImageFile  implements Serializable {

	public static String REF = "EmpImageFile";
	public static String PROP_IMAGE_NAME = "ImageName";
	public static String PROP_EMPLOYEE = "Employee";
	public static String PROP_IMAGE_SIZE = "ImageSize";
	public static String PROP_IMAGE_DATA = "ImageData";
	public static String PROP_IMAGE_CONTENT_TYPE = "ImageContentType";
	public static String PROP_ID = "Id";
	public static String PROP_IMAGE_TYPE = "ImageType";


	// constructors
	public BaseEmpImageFile () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseEmpImageFile (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseEmpImageFile (
		java.lang.Integer id,
		com.frame.business.entity.Employee employee) {

		this.setId(id);
		this.setEmployee(employee);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String imageName;
	private java.lang.String imageType;
	private java.lang.String imageContentType;
	private java.sql.Blob imageData;
	private java.lang.Integer imageSize;

	// many to one
	private com.frame.business.entity.Employee employee;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="emp_image_file_id"
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
	 * Return the value associated with the column: image_name
	 */
	public java.lang.String getImageName () {
		return imageName;
	}

	/**
	 * Set the value related to the column: image_name
	 * @param imageName the image_name value
	 */
	public void setImageName (java.lang.String imageName) {
		this.imageName = imageName;
	}



	/**
	 * Return the value associated with the column: image_type
	 */
	public java.lang.String getImageType () {
		return imageType;
	}

	/**
	 * Set the value related to the column: image_type
	 * @param imageType the image_type value
	 */
	public void setImageType (java.lang.String imageType) {
		this.imageType = imageType;
	}



	/**
	 * Return the value associated with the column: image_content_type
	 */
	public java.lang.String getImageContentType () {
		return imageContentType;
	}

	/**
	 * Set the value related to the column: image_content_type
	 * @param imageContentType the image_content_type value
	 */
	public void setImageContentType (java.lang.String imageContentType) {
		this.imageContentType = imageContentType;
	}



	/**
	 * Return the value associated with the column: image_data
	 */
	public java.sql.Blob getImageData () {
		return imageData;
	}

	/**
	 * Set the value related to the column: image_data
	 * @param imageData the image_data value
	 */
	public void setImageData (java.sql.Blob imageData) {
		this.imageData = imageData;
	}



	/**
	 * Return the value associated with the column: image_size
	 */
	public java.lang.Integer getImageSize () {
		return imageSize;
	}

	/**
	 * Set the value related to the column: image_size
	 * @param imageSize the image_size value
	 */
	public void setImageSize (java.lang.Integer imageSize) {
		this.imageSize = imageSize;
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
		if (!(obj instanceof com.frame.business.entity.EmpImageFile)) return false;
		else {
			com.frame.business.entity.EmpImageFile empImageFile = (com.frame.business.entity.EmpImageFile) obj;
			if (null == this.getId() || null == empImageFile.getId()) return false;
			else return (this.getId().equals(empImageFile.getId()));
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