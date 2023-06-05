package com.frame.presentation.form;

import java.util.List;

import org.apache.struts.validator.ValidatorForm;

import com.frame.business.entity.PartyGroupPosition;
import com.frame.business.entity.Recruiters;
import com.frame.business.entity.Status;
/**
*
* @author Yuzana Zaw Zaw
*/
public class RecruiterForm extends ValidatorForm {

	//for Login
	private String frmLoginEmail;
	private String frmLoginPassword;
	private Recruiters loginUser;
	
	public Recruiters getLoginUser() {
		return loginUser;
	}
	public void setLoginUser(Recruiters loginUser) {
		this.loginUser = loginUser;
	}
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

	//for Registration
	private String frmFirstName;
	private String frmLastName;
	private String frmEmail;
	private String frmEmailError;
	private String frmPositionName;
	private List<PartyGroupPosition> frmPositionList;
	
	public List<PartyGroupPosition> getFrmPositionList() {
		return frmPositionList;
	}
	public void setFrmPositionList(List<PartyGroupPosition> frmPositionList) {
		this.frmPositionList = frmPositionList;
	}
	public String getFrmPositionName() {
		return frmPositionName;
	}
	public void setFrmPositionName(String frmPositionName) {
		this.frmPositionName = frmPositionName;
	}
	public String getFrmEmailError() {
		return frmEmailError;
	}
	public void setFrmEmailError(String frmEmailError) {
		this.frmEmailError = frmEmailError;
	}
	public String getFrmFirstName() {
		return frmFirstName;
	}
	public void setFrmFirstName(String frmFirstName) {
		this.frmFirstName = frmFirstName;
	}
	public String getFrmLastName() {
		return frmLastName;
	}
	public void setFrmLastName(String frmLastName) {
		this.frmLastName = frmLastName;
	}
	public String getFrmEmail() {
		return frmEmail;
	}
	public void setFrmEmail(String frmEmail) {
		this.frmEmail = frmEmail;
	}
	public String getFrmPassword() {
		return frmPassword;
	}
	public void setFrmPassword(String frmPassword) {
		this.frmPassword = frmPassword;
	}
	public String getFrmPhone() {
		return frmPhone;
	}
	public void setFrmPhone(String frmPhone) {
		this.frmPhone = frmPhone;
	}
	public String getFrmNrc() {
		return frmNrc;
	}
	public void setFrmNrc(String frmNrc) {
		this.frmNrc = frmNrc;
	}
	public String getFrmGender() {
		return frmGender;
	}
	public void setFrmGender(String frmGender) {
		this.frmGender = frmGender;
	}
	public String getFrmAddress() {
		return frmAddress;
	}
	public void setFrmAddress(String frmAddress) {
		this.frmAddress = frmAddress;
	}
	public String getFrmSecurityQuest() {
		return frmSecurityQuest;
	}
	public void setFrmSecurityQuest(String frmSecurityQuest) {
		this.frmSecurityQuest = frmSecurityQuest;
	}
	public String getFrmRegFormControl() {
		return frmRegFormControl;
	}
	public void setFrmRegFormControl(String frmRegFormControl) {
		this.frmRegFormControl = frmRegFormControl;
	}
	private String frmPassword;
	private String frmPhone;
	private String frmNrc;
	private String frmGender;
	private String frmAddress;
	private String frmSecurityQuest;
	private String frmRegFormControl;
	
	//for forget password

	private String frmForgetPassEmail;
	public String getFrmForgetPassEmail() {
		return frmForgetPassEmail;
	}
	public void setFrmForgetPassEmail(String frmForgetPassEmail) {
		this.frmForgetPassEmail = frmForgetPassEmail;
	}
	public String getFrmForgetPassSecurityQuest() {
		return frmForgetPassSecurityQuest;
	}
	public void setFrmForgetPassSecurityQuest(String frmForgetPassSecurityQuest) {
		this.frmForgetPassSecurityQuest = frmForgetPassSecurityQuest;
	}

	private String frmForgetPassSecurityQuest;
	
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
	private String frmBirthDate;

	public String getFrmBirthDate() {
		return frmBirthDate;
	}
	public void setFrmBirthDate(String frmBirthDate) {
		this.frmBirthDate = frmBirthDate;
	}
	
	//for Recruiter list
	private List<Recruiters> frmRecruiterList;
	private String frmStatusName;
	private List<Status> frmStatusList;
	public List<Status> getFrmStatusList() {
		return frmStatusList;
	}
	public void setFrmStatusList(List<Status> frmStatusList) {
		this.frmStatusList = frmStatusList;
	}
	public String getFrmStatusName() {
		return frmStatusName;
	}
	public void setFrmStatusName(String frmStatusName) {
		this.frmStatusName = frmStatusName;
	}

	private int frmTotalRecruiter;

	public int getFrmTotalRecruiter() {
		return frmTotalRecruiter;
	}
	public void setFrmTotalRecruiter(int frmTotalRecruiter) {
		this.frmTotalRecruiter = frmTotalRecruiter;
	}
	public List<Recruiters> getFrmRecruiterList() {
		return frmRecruiterList;
	}
	public void setFrmRecruiterList(List<Recruiters> frmRecruiterList) {
		this.frmRecruiterList = frmRecruiterList;
	}
	
	//for de activate,activate account
	private String frmRecruiterId;

	public String getFrmRecruiterId() {
		return frmRecruiterId;
	}
	public void setFrmRecruiterId(String frmRecruiterId) {
		this.frmRecruiterId = frmRecruiterId;
	}
	
	//for error and success message
	private String loginerror;
	private String registError;
	private String successMsg;
	private String forgetPassError;
	private String passwordError;
	public String getPasswordError() {
		return passwordError;
	}
	public void setPasswordError(String passwordError) {
		this.passwordError = passwordError;
	}
	public String getForgetPassError() {
		return forgetPassError;
	}
	public void setForgetPassError(String forgetPassError) {
		this.forgetPassError = forgetPassError;
	}
	public String getLoginerror() {
		return loginerror;
	}
	public void setLoginerror(String loginerror) {
		this.loginerror = loginerror;
	}
	public String getRegistError() {
		return registError;
	}
	public void setRegistError(String registError) {
		this.registError = registError;
	}
	public String getSuccessMsg() {
		return successMsg;
	}
	public void setSuccessMsg(String successMsg) {
		this.successMsg = successMsg;
	}
}
