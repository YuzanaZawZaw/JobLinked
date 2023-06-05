package com.frame.presentation.form;

import java.util.List;

import org.apache.struts.validator.ValidatorForm;

import com.frame.business.entity.SkillType;
/**
*
* @author Yuzana Zaw Zaw
*/
public class SkillTypeForm extends ValidatorForm {
	//for creating skill types
	private String frmSkillTypeName;
	//getting skill type list
	private List<SkillType> frmSkillTypeList;
	//for delete skill type
	private int skillTypeId;
	private String skillTypeNameErr;
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

	public String getSkillTypeNameErr() {
		return skillTypeNameErr;
	}

	public void setSkillTypeNameErr(String skillTypeNameErr) {
		this.skillTypeNameErr = skillTypeNameErr;
	}

	public int getSkillTypeId() {
		return skillTypeId;
	}

	public void setSkillTypeId(int skillTypeId) {
		this.skillTypeId = skillTypeId;
	}

	public List<SkillType> getFrmSkillTypeList() {
		return frmSkillTypeList;
	}

	public void setFrmSkillTypeList(List<SkillType> frmSkillTypeList) {
		this.frmSkillTypeList = frmSkillTypeList;
	}

	public String getFrmSkillTypeName() {
		return frmSkillTypeName;
	}

	public void setFrmSkillTypeName(String frmSkillTypeName) {
		this.frmSkillTypeName = frmSkillTypeName;
	}
}
