package com.frame.presentation.form;

import java.util.List;

import org.apache.struts.validator.ValidatorForm;

import com.frame.business.entity.PartyGroup;
/**
*
* @author Yuzana Zaw Zaw
*/
public class PartyGroupForm extends ValidatorForm {
	//to create company profile
	private String frmCompanyName;
	private String frmTotalEmployee;
	private String frmDescription;
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

	private List<PartyGroup> frmPartyGroupList;
	
	public List<PartyGroup> getFrmPartyGroupList() {
		return frmPartyGroupList;
	}

	public void setFrmPartyGroupList(List<PartyGroup> frmPartyGroupList) {
		this.frmPartyGroupList = frmPartyGroupList;
	}

	public String getFrmCompanyName() {
		return frmCompanyName;
	}

	public void setFrmCompanyName(String frmCompanyName) {
		this.frmCompanyName = frmCompanyName;
	}

	public String getFrmTotalEmployee() {
		return frmTotalEmployee;
	}

	public void setFrmTotalEmployee(String frmTotalEmployee) {
		this.frmTotalEmployee = frmTotalEmployee;
	}

	public String getFrmDescription() {
		return frmDescription;
	}

	public void setFrmDescription(String frmDescription) {
		this.frmDescription = frmDescription;
	}

	public int getPartyGroupId() {
		return partyGroupId;
	}

	public void setPartyGroupId(int partyGroupId) {
		this.partyGroupId = partyGroupId;
	}

	//for delete party Group
	private int partyGroupId;
	
	private String frmCompanyNameErr;

	public String getFrmCompanyNameErr() {
		return frmCompanyNameErr;
	}

	public void setFrmCompanyNameErr(String frmCompanyNameErr) {
		this.frmCompanyNameErr = frmCompanyNameErr;
	}

	}
