package com.frame.presentation.form;


import java.util.List;

import org.apache.struts.validator.ValidatorForm;

import com.frame.business.entity.JobPostRequirement;

/**
*
* @author Yuzana Zaw Zaw
*/
public class JobPostRequirementForm extends ValidatorForm {
	//for creating job post requirements
	private String frmDescription;
	private String frmJobPostId;
	private String frmJobPostRequirementId;
	private List<JobPostRequirement> frmJobPostRequirementList;
	
	public List<JobPostRequirement> getFrmJobPostRequirementList() {
		return frmJobPostRequirementList;
	}

	public void setFrmJobPostRequirementList(
			List<JobPostRequirement> frmJobPostRequirementList) {
		this.frmJobPostRequirementList = frmJobPostRequirementList;
	}

	public String getFrmJobPostRequirementId() {
		return frmJobPostRequirementId;
	}

	public void setFrmJobPostRequirementId(String frmJobPostRequirementId) {
		this.frmJobPostRequirementId = frmJobPostRequirementId;
	}

	public String getFrmJobPostId() {
		return frmJobPostId;
	}

	public void setFrmJobPostId(String frmJobPostId) {
		this.frmJobPostId = frmJobPostId;
	}

	public String getFrmDescription() {
		return frmDescription;
	}

	public void setFrmDescription(String frmDescription) {
		this.frmDescription = frmDescription;
	}
	
	//for success and error message
	private String successMsg;
	private String errorMsg;

	public String getSuccessMsg() {
		return successMsg;
	}

	public void setSuccessMsg(String successMsg) {
		this.successMsg = successMsg;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
}
