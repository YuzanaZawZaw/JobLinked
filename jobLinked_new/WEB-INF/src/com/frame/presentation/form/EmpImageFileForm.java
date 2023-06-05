package com.frame.presentation.form;

import org.apache.struts.upload.FormFile;
import org.apache.struts.validator.ValidatorForm;

import com.frame.business.entity.Employee;
/**
*
* @author Yuzana Zaw Zaw
*/
public class EmpImageFileForm extends ValidatorForm {
	
	//for employee image upload
	private FormFile frmUploadImage;
	private Employee loginUser;
	public Employee getLoginUser() {
		return loginUser;
	}
	public void setLoginUser(Employee loginUser) {
		this.loginUser = loginUser;
	}
	public FormFile getFrmUploadImage() {
		return frmUploadImage;
	}
	public void setFrmUploadImage(FormFile frmUploadImage) {
		this.frmUploadImage = frmUploadImage;
	}
	public String getFrmImageFileSizeError() {
		return frmImageFileSizeError;
	}
	public void setFrmImageFileSizeError(String frmImageFileSizeError) {
		this.frmImageFileSizeError = frmImageFileSizeError;
	}
	private String frmImageFileSizeError;

}
