package com.frame.presentation.form;
import java.util.List;
import org.apache.struts.validator.ValidatorForm;
import com.frame.business.entity.EmployeeSkill;
import com.frame.business.entity.SkillType;

/**
*
* @author Yuzana Zaw Zaw
*/
public class EmployeeSkillForm extends ValidatorForm {

	//for Employee profile details
	private List<EmployeeSkill> frmDetailEmpSkillList;
	public List<EmployeeSkill> getFrmDetailEmpSkillList() {
		return frmDetailEmpSkillList;
	}

	public void setFrmDetailEmpSkillList(List<EmployeeSkill> frmDetailEmpSkillList) {
		this.frmDetailEmpSkillList = frmDetailEmpSkillList;
	}
	
	private String frmSkillTypeName;
	private String frmSkillLevel;
	private List<SkillType> frmSkillTypeList;
	
	
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

	public String getFrmSkillLevel() {
		return frmSkillLevel;
	}

	public void setFrmSkillLevel(String frmSkillLevel) {
		this.frmSkillLevel = frmSkillLevel;
	}
	//for delete employee skill
	private int frmEmployeeId;
	private int frmSkillTypeId;
	public int getFrmSkillTypeId() {
		return frmSkillTypeId;
	}

	public void setFrmSkillTypeId(int frmSkillTypeId) {
		this.frmSkillTypeId = frmSkillTypeId;
	}

	public int getFrmEmployeeId() {
		return frmEmployeeId;
	}

	public void setFrmEmployeeId(int frmEmployeeId) {
		this.frmEmployeeId = frmEmployeeId;
	}
	
	//for success and error message
	private String successMsg;
	private String frmSkillTypeNameErr;
	private String frmSkillLevelErr;
	private String deleteSuccessMsg;
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

	public String getFrmSkillTypeNameErr() {
		return frmSkillTypeNameErr;
	}

	public void setFrmSkillTypeNameErr(String frmSkillTypeNameErr) {
		this.frmSkillTypeNameErr = frmSkillTypeNameErr;
	}

	public String getFrmSkillLevelErr() {
		return frmSkillLevelErr;
	}

	public void setFrmSkillLevelErr(String frmSkillLevelErr) {
		this.frmSkillLevelErr = frmSkillLevelErr;
	}

	public String getDeleteSuccessMsg() {
		return deleteSuccessMsg;
	}

	public void setDeleteSuccessMsg(String deleteSuccessMsg) {
		this.deleteSuccessMsg = deleteSuccessMsg;
	}

	
}
