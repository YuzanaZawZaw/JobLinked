package com.frame.presentation.form;

import java.util.List;

import org.apache.struts.validator.ValidatorForm;

import com.frame.business.entity.EmpImageFile;
import com.frame.business.entity.JobPost;
import com.frame.business.entity.JobPostApply;
import com.frame.business.entity.JobPostQual;
import com.frame.business.entity.JobPostRequirement;
import com.frame.business.entity.PartyGroupPosition;
import com.frame.business.entity.QualType;
import com.frame.business.entity.Recruiters;
import com.frame.business.entity.Status;

/**
*
* @author Yuzana Zaw Zaw
*/
public class JobPostForm extends ValidatorForm {
	private String frmPositionName;
	private Recruiters loginUser;
	public Recruiters getLoginUser() {
		return loginUser;
	}
	public void setLoginUser(Recruiters loginUser) {
		this.loginUser = loginUser;
	}
	public String getFrmPositionName() {
		return frmPositionName;
	}
	public void setFrmPositionName(String frmPositionName) {
		this.frmPositionName = frmPositionName;
	}
	public List<PartyGroupPosition> getFrmPositionList() {
		return frmPositionList;
	}
	public void setFrmPositionList(List<PartyGroupPosition> frmPositionList) {
		this.frmPositionList = frmPositionList;
	}
	public String getFrmLocation() {
		return frmLocation;
	}
	public void setFrmLocation(String frmLocation) {
		this.frmLocation = frmLocation;
	}
	public String getFrmEmploymentType() {
		return frmEmploymentType;
	}
	public void setFrmEmploymentType(String frmEmploymentType) {
		this.frmEmploymentType = frmEmploymentType;
	}
	public String getFrmSalary() {
		return frmSalary;
	}
	public void setFrmSalary(String frmSalary) {
		this.frmSalary = frmSalary;
	}
	public String getFrmFromDate() {
		return frmFromDate;
	}
	public void setFrmFromDate(String frmFromDate) {
		this.frmFromDate = frmFromDate;
	}
	public String getFrmThruDate() {
		return frmThruDate;
	}
	public void setFrmThruDate(String frmThruDate) {
		this.frmThruDate = frmThruDate;
	}
	private List<PartyGroupPosition> frmPositionList;
	private String frmStatusName;
	public String getFrmStatusName() {
		return frmStatusName;
	}
	public void setFrmStatusName(String frmStatusName) {
		this.frmStatusName = frmStatusName;
	}
	public List<Status> getFrmStatusList() {
		return frmStatusList;
	}
	public void setFrmStatusList(List<Status> frmStatusList) {
		this.frmStatusList = frmStatusList;
	}
	private List<Status> frmStatusList;
	private String frmLocation;
	private String frmEmploymentType;
	private String frmSalary;
	private String frmFromDate;
	private String frmThruDate;
	private String frmJobPostId;
	private int jobPostId;
	private List<QualType> frmQualTypeList;
	private List<QualType> qualList;
	public List<QualType> getQualList() {
		return qualList;
	}
	public void setQualList(List<QualType> qualList) {
		this.qualList = qualList;
	}
	private String frmJobPostQualId;
	private String frmJobPostRequirementId;
	private String frmCompanyName;
	private String frmTotalEmployee;
	private String frmRecruiterFirstName;
	private String frmRecruiterPhone;
	private String frmRecruiterEmail;
	public String getFrmRecruiterPhone() {
		return frmRecruiterPhone;
	}
	public void setFrmRecruiterPhone(String frmRecruiterPhone) {
		this.frmRecruiterPhone = frmRecruiterPhone;
	}
	public String getFrmRecruiterEmail() {
		return frmRecruiterEmail;
	}
	public void setFrmRecruiterEmail(String frmRecruiterEmail) {
		this.frmRecruiterEmail = frmRecruiterEmail;
	}
	public String getFrmRecruiterFirstName() {
		return frmRecruiterFirstName;
	}
	public void setFrmRecruiterFirstName(String frmRecruiterFirstName) {
		this.frmRecruiterFirstName = frmRecruiterFirstName;
	}
	private String frmRecruiterLastName;
	
	public String getFrmRecruiterLastName() {
		return frmRecruiterLastName;
	}
	public void setFrmRecruiterLastName(String frmRecruiterLastName) {
		this.frmRecruiterLastName = frmRecruiterLastName;
	}
	public String getFrmTotalEmployee() {
		return frmTotalEmployee;
	}
	public void setFrmTotalEmployee(String frmTotalEmployee) {
		this.frmTotalEmployee = frmTotalEmployee;
	}
	public String getFrmCompanyName() {
		return frmCompanyName;
	}
	public void setFrmCompanyName(String frmCompanyName) {
		this.frmCompanyName = frmCompanyName;
	}
	public String getFrmJobPostRequirementId() {
		return frmJobPostRequirementId;
	}
	public void setFrmJobPostRequirementId(String frmJobPostRequirementId) {
		this.frmJobPostRequirementId = frmJobPostRequirementId;
	}
	public String getFrmJobPostQualId() {
		return frmJobPostQualId;
	}
	public void setFrmJobPostQualId(String frmJobPostQualId) {
		this.frmJobPostQualId = frmJobPostQualId;
	}
	public List<QualType> getFrmQualTypeList() {
		return frmQualTypeList;
	}
	public void setFrmQualTypeList(List<QualType> frmQualTypeList) {
		this.frmQualTypeList = frmQualTypeList;
	}
	public int getJobPostId() {
		return jobPostId;
	}
	public void setJobPostId(int jobPostId) {
		this.jobPostId = jobPostId;
	}
	private List<JobPostRequirement> frmJobPostRequirementList;
	private List<JobPostQual> frmJobPostQualList;
	private List<JobPostApply> frmJobPostAppliedEmployeeList;
	private List<EmpImageFile> frmImageFileList;

	public List<EmpImageFile> getFrmImageFileList() {
		return frmImageFileList;
	}
	public void setFrmImageFileList(List<EmpImageFile> frmImageFileList) {
		this.frmImageFileList = frmImageFileList;
	}
	public List<JobPostApply> getFrmJobPostAppliedEmployeeList() {
		return frmJobPostAppliedEmployeeList;
	}
	public void setFrmJobPostAppliedEmployeeList(
			List<JobPostApply> frmJobPostAppliedEmployeeList) {
		this.frmJobPostAppliedEmployeeList = frmJobPostAppliedEmployeeList;
	}
	public List<JobPostQual> getFrmJobPostQualList() {
		return frmJobPostQualList;
	}
	public void setFrmJobPostQualList(List<JobPostQual> frmJobPostQualList) {
		this.frmJobPostQualList = frmJobPostQualList;
	}
	public List<JobPostRequirement> getFrmJobPostRequirementList() {
		return frmJobPostRequirementList;
	}
	public void setFrmJobPostRequirementList(
			List<JobPostRequirement> frmJobPostRequirementList) {
		this.frmJobPostRequirementList = frmJobPostRequirementList;
	}
	public String getFrmJobPostId() {
		return frmJobPostId;
	}
	public void setFrmJobPostId(String frmJobPostId) {
		this.frmJobPostId = frmJobPostId;
	}
	private List<JobPost> frmJobPostList;
	public List<JobPost> getFrmJobPostList() {
		return frmJobPostList;
	}
	public void setFrmJobPostList(List<JobPost> frmJobPostList) {
		this.frmJobPostList = frmJobPostList;
	}
	
	//for success and error message
	private String successMsg;
	private String errorMsg;
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public String getSuccessMsg() {
		return successMsg;
	}
	public void setSuccessMsg(String successMsg) {
		this.successMsg = successMsg;
	}
}
