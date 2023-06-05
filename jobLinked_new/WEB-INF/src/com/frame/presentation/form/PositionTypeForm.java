package com.frame.presentation.form;

import java.util.List;

import org.apache.struts.validator.ValidatorForm;

import com.frame.business.entity.PartyGroupPositionType;
/**
*
* @author Yuzana Zaw Zaw
*/
public class PositionTypeForm extends ValidatorForm {
	//for creating position types
	private String frmPositionTypeName;
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

	//getting position type list
	private List<PartyGroupPositionType> frmPositionTypeList;
	public List<PartyGroupPositionType> getFrmPositionTypeList() {
		return frmPositionTypeList;
	}
	public void setFrmPositionTypeList(
			List<PartyGroupPositionType> frmPositionTypeList) {
		this.frmPositionTypeList = frmPositionTypeList;
	}
	public String getFrmPositionTypeName() {
		return frmPositionTypeName;
	}
	public void setFrmPositionTypeName(String frmPositionTypeName) {
		this.frmPositionTypeName = frmPositionTypeName;
	}
	
	private int positionTypeId;
	public int getPositionTypeId() {
		return positionTypeId;
	}
	public void setPositionTypeId(int positionTypeId) {
		this.positionTypeId = positionTypeId;
	}
	private String positionTypeNameErr;
	public String getPositionTypeNameErr() {
		return positionTypeNameErr;
	}
	public void setPositionTypeNameErr(String positionTypeNameErr) {
		this.positionTypeNameErr = positionTypeNameErr;
	}
}
