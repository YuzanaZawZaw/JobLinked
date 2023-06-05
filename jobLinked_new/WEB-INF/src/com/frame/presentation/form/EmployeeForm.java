package com.frame.presentation.form;

import java.util.List;

import org.apache.struts.upload.FormFile;
import org.apache.struts.validator.ValidatorForm;

import com.frame.business.entity.EmpImageFile;
import com.frame.business.entity.Employee;
import com.frame.business.entity.Status;

/**
*
* @author Yuzana Zaw Zaw
*/
public class EmployeeForm extends ValidatorForm {

	//for Login
	private String frmLoginEmail;
	private String frmLoginPassword;
	//for profile
	private Employee loginUser;
	private List<Employee> employeeList;
	private List<Status> frmStatusList;
	private List<EmpImageFile> frmImageFileList;
	public List<EmpImageFile> getFrmImageFileList() {
		return frmImageFileList;
	}
	public void setFrmImageFileList(List<EmpImageFile> frmImageFileList) {
		this.frmImageFileList = frmImageFileList;
	}

	private String frmEmployeeId;
	
	public String getFrmEmployeeId() {
		return frmEmployeeId;
	}
	public void setFrmEmployeeId(String frmEmployeeId) {
		this.frmEmployeeId = frmEmployeeId;
	}
	public List<Status> getFrmStatusList() {
		return frmStatusList;
	}
	public void setFrmStatusList(List<Status> frmStatusList) {
		this.frmStatusList = frmStatusList;
	}

	private String frmStatusName;
	
	public String getFrmStatusName() {
		return frmStatusName;
	}
	public void setFrmStatusName(String frmStatusName) {
		this.frmStatusName = frmStatusName;
	}
	public List<Employee> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	public Employee getLoginUser() {
		return loginUser;
	}
	public void setLoginUser(Employee loginUser) {
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
	private String frmPassword;
	private String frmPhone;
	private String frmNrc;
	private String frmGender;
	private String frmAddress;
	private String frmSecurityQuest;
	private String frmRegFormControl;
	private String frmFatherName;
	private String frmBirthDate;
	private int frmTotalEmployee;
	public int getFrmTotalEmployee() {
		return frmTotalEmployee;
	}
	public void setFrmTotalEmployee(int frmTotalEmployee) {
		this.frmTotalEmployee = frmTotalEmployee;
	}
	public String getFrmBirthDate() {
		return frmBirthDate;
	}
	public void setFrmBirthDate(String frmBirthDate) {
		this.frmBirthDate = frmBirthDate;
	}

	//for employee image
	private FormFile frmUploadImage;
	private String frmViewImage;
	private EmpImageFile imageFile;
	
	public EmpImageFile getImageFile() {
		return imageFile;
	}
	public void setImageFile(EmpImageFile imageFile) {
		this.imageFile = imageFile;
	}
	public String getFrmViewImage() {
		return frmViewImage;
	}
	public void setFrmViewImage(String frmViewImage) {
		this.frmViewImage = frmViewImage;
	}
	public FormFile getFrmUploadImage() {
		return frmUploadImage;
	}
	public void setFrmUploadImage(FormFile frmUploadImage) {
		this.frmUploadImage = frmUploadImage;
	}
	public String getFrmFatherName() {
		return frmFatherName;
	}
	public void setFrmFatherName(String frmFatherName) {
		this.frmFatherName = frmFatherName;
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
	
	
	//for Forget Password
	private String frmForgetPassEmail;
	private String frmForgetPassSecurityQuest;
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
	
	//for error and success message
	private String loginerror;
	private String successMsg;
	private String registError;
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
	public String getRegistError() {
		return registError;
	}
	public void setRegistError(String registError) {
		this.registError = registError;
	}
	public String getLoginerror() {
		return loginerror;
	}
	public void setLoginerror(String loginerror) {
		this.loginerror = loginerror;
	}
	public String getSuccessMsg() {
		return successMsg;
	}
	public void setSuccessMsg(String successMsg) {
		this.successMsg = successMsg;
	}
}
