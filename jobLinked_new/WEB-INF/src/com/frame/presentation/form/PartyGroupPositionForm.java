package com.frame.presentation.form;

import java.util.List;

import org.apache.struts.validator.ValidatorForm;

import com.frame.business.entity.PartyGroup;
import com.frame.business.entity.PartyGroupPosition;
import com.frame.business.entity.PartyGroupPositionType;
/**
*
* @author Yuzana Zaw Zaw
*/
public class PartyGroupPositionForm extends ValidatorForm {
	//for creating position 
	private String frmCompanyName;
	private String frmPositionType;
	private String frmPositionName;
	
	private String frmCompanyNameErr;
	private String frmPositionTypeErr;
	private String frmPositionNameErr;
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
	public String getFrmCompanyNameErr() {
		return frmCompanyNameErr;
	}
	public void setFrmCompanyNameErr(String frmCompanyNameErr) {
		this.frmCompanyNameErr = frmCompanyNameErr;
	}
	public String getFrmPositionTypeErr() {
		return frmPositionTypeErr;
	}
	public void setFrmPositionTypeErr(String frmPositionTypeErr) {
		this.frmPositionTypeErr = frmPositionTypeErr;
	}
	public String getFrmPositionNameErr() {
		return frmPositionNameErr;
	}
	public void setFrmPositionNameErr(String frmPositionNameErr) {
		this.frmPositionNameErr = frmPositionNameErr;
	}
	private List<PartyGroup> frmPartyGroupList;
	private List<PartyGroupPositionType> frmPositionTypeList;
	
	private List<PartyGroupPosition> frmPartyGroupPositionList;
	
	public String getFrmCompanyName() {
		return frmCompanyName;
	}
	public void setFrmCompanyName(String frmCompanyName) {
		this.frmCompanyName = frmCompanyName;
	}
	public String getFrmPositionType() {
		return frmPositionType;
	}
	public void setFrmPositionType(String frmPositionType) {
		this.frmPositionType = frmPositionType;
	}
	public String getFrmPositionName() {
		return frmPositionName;
	}
	public void setFrmPositionName(String frmPositionName) {
		this.frmPositionName = frmPositionName;
	}
	public List<PartyGroup> getFrmPartyGroupList() {
		return frmPartyGroupList;
	}
	public void setFrmPartyGroupList(List<PartyGroup> frmPartyGroupList) {
		this.frmPartyGroupList = frmPartyGroupList;
	}
	public List<PartyGroupPositionType> getFrmPositionTypeList() {
		return frmPositionTypeList;
	}
	public void setFrmPositionTypeList(
			List<PartyGroupPositionType> frmPositionTypeList) {
		this.frmPositionTypeList = frmPositionTypeList;
	}
	public List<PartyGroupPosition> getFrmPartyGroupPositionList() {
		return frmPartyGroupPositionList;
	}
	public void setFrmPartyGroupPositionList(
			List<PartyGroupPosition> frmPartyGroupPositionList) {
		this.frmPartyGroupPositionList = frmPartyGroupPositionList;
	}
	public int getPartyGroupPositionId() {
		return partyGroupPositionId;
	}
	public void setPartyGroupPositionId(int partyGroupPositionId) {
		this.partyGroupPositionId = partyGroupPositionId;
	}
	private int partyGroupPositionId;
}
