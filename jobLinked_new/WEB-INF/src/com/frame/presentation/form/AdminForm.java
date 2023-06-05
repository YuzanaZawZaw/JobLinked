package com.frame.presentation.form;

import org.apache.struts.validator.ValidatorForm;

import com.frame.business.entity.Admin;
/**
*
* @author Yuzana Zaw Zaw
*/
public class AdminForm extends ValidatorForm {

	//for Login
	private String frmLoginEmail;
	private String frmLoginPassword;
	public String getFrmLoginEmail() {
		return frmLoginEmail;
	}
	public void setFrmLoginEmail(String frmLoginEmail) {
		this.frmLoginEmail = frmLoginEmail;
	}
	public String getFrmLoginPassword() {
		return frmLoginPassword;
	}
	public void setFrmLoginPassword(String frmLoginPassword) {
		this.frmLoginPassword = frmLoginPassword;
	}
	public Admin getLoginUser() {
		return loginUser;
	}
	public void setLoginUser(Admin loginUser) {
		this.loginUser = loginUser;
	}
	private Admin loginUser;	
	
	//for Change Password
	private String frmChangeOldPassword;
	public String getFrmChangeOldPassword() {
		return frmChangeOldPassword;
	}
	public void setFrmChangeOldPassword(String frmChangeOldPassword) {
		this.frmChangeOldPassword = frmChangeOldPassword;
	}
	public String getFrmChangeNewPassword() {
		return frmChangeNewPassword;
	}
	public void setFrmChangeNewPassword(String frmChangeNewPassword) {
		this.frmChangeNewPassword = frmChangeNewPassword;
	}
	public String getFrmChangeConfirmPassword() {
		return frmChangeConfirmPassword;
	}
	public void setFrmChangeConfirmPassword(String frmChangeConfirmPassword) {
		this.frmChangeConfirmPassword = frmChangeConfirmPassword;
	}
	private String frmChangeNewPassword;
	private String frmChangeConfirmPassword;
	
	//for error message and success message
	private String passwordError;
	private String successMsg;
	
	public String getPasswordError() {
		return passwordError;
	}
	public void setPasswordError(String passwordError) {
		this.passwordError = passwordError;
	}
	public String getSuccessMsg() {
		return successMsg;
	}
	public void setSuccessMsg(String successMsg) {
		this.successMsg = successMsg;
	}
	//for login error msg
	private String loginError;
	public String getLoginError() {
		return loginError;
	}
	public void setLoginError(String loginError) {
		this.loginError = loginError;
	}

}
