package com.frame.presentation.form;


import java.util.List;

import org.apache.struts.validator.ValidatorForm;

import com.frame.business.entity.QualType;

/**
*
* @author Yuzana Zaw Zaw
*/
public class JobPostQualForm extends ValidatorForm {
	//for creating job post qualification
	private String frmDescription;
	private String frmJobPostId;
	private String frmQualType;
	private String frmJobPostQualId;
	//for success and error message
	private String successMsg;
	private String errorMsg;
	public String getFrmJobPostQualId() {
		return frmJobPostQualId;
	}

	public void setFrmJobPostQualId(String frmJobPostQualId) {
		this.frmJobPostQualId = frmJobPostQualId;
	}

	private List<QualType> qualList;
	

	public List<QualType> getQualList() {
		return qualList;
	}

	public void setQualList(List<QualType> qualList) {
		this.qualList = qualList;
	}

	public String getFrmQualType() {
		return frmQualType;
	}

	public void setFrmQualType(String frmQualType) {
		this.frmQualType = frmQualType;
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
