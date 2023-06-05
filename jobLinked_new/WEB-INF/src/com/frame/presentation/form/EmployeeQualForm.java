package com.frame.presentation.form;
import java.util.List;

import org.apache.struts.validator.ValidatorForm;

import com.frame.business.entity.EmployeeQual;
import com.frame.business.entity.QualType;

/**
*
* @author Yuzana Zaw Zaw
*/
public class EmployeeQualForm extends ValidatorForm {

	//for Employee profile details
	private EmployeeQual frmDetailEmpQual;
	private List<QualType> frmQualTypeList;
	public List<QualType> getFrmQualTypeList() {
		return frmQualTypeList;
	}

	public void setFrmQualTypeList(List<QualType> frmQualTypeList) {
		this.frmQualTypeList = frmQualTypeList;
	}

	public EmployeeQual getFrmDetailEmpQual() {
		return frmDetailEmpQual;
	}

	public void setFrmDetailEmpQual(EmployeeQual frmDetailEmpQual) {
		this.frmDetailEmpQual = frmDetailEmpQual;
	}

	public List<EmployeeQual> getFrmDetailEmpQualList() {
		return frmDetailEmpQualList;
	}

	public void setFrmDetailEmpQualList(List<EmployeeQual> frmDetailEmpQualList) {
		this.frmDetailEmpQualList = frmDetailEmpQualList;
	}

	public String getFrmDetailEmpQualId() {
		return frmDetailEmpQualId;
	}

	public void setFrmDetailEmpQualId(String frmDetailEmpQualId) {
		this.frmDetailEmpQualId = frmDetailEmpQualId;
	}

	public String getFrmControl() {
		return frmControl;
	}

	public void setFrmControl(String frmControl) {
		this.frmControl = frmControl;
	}

	private List<EmployeeQual> frmDetailEmpQualList;
	private String frmDetailEmpQualId;
	private String frmControl;
	
	//for adding employee qualification
	private String frmQualTypeName;
	public String getFrmQualTypeName() {
		return frmQualTypeName;
	}

	public void setFrmQualTypeName(String frmQualTypeName) {
		this.frmQualTypeName = frmQualTypeName;
	}

	public String getFrmSchoolName() {
		return frmSchoolName;
	}

	public void setFrmSchoolName(String frmSchoolName) {
		this.frmSchoolName = frmSchoolName;
	}

	public String getFrmDegree() {
		return frmDegree;
	}

	public void setFrmDegree(String frmDegree) {
		this.frmDegree = frmDegree;
	}

	public String getFrmFieldOfStudy() {
		return frmFieldOfStudy;
	}

	public void setFrmFieldOfStudy(String frmFieldOfStudy) {
		this.frmFieldOfStudy = frmFieldOfStudy;
	}

	public String getFrmFieldOfActivity() {
		return frmFieldOfActivity;
	}

	public void setFrmFieldOfActivity(String frmFieldOfActivity) {
		this.frmFieldOfActivity = frmFieldOfActivity;
	}

	private String frmSchoolName;
	private String frmDegree;
	private String frmFieldOfStudy;
	private String frmFieldOfActivity;
	private String frmFromDate;
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

	private String frmThruDate;
	
	//for delete employee skill
	private int frmEmployeeId;
	private int frmQualTypeId;
	public int getFrmEmployeeId() {
		return frmEmployeeId;
	}

	public void setFrmEmployeeId(int frmEmployeeId) {
		this.frmEmployeeId = frmEmployeeId;
	}

	public int getFrmQualTypeId() {
		return frmQualTypeId;
	}

	public void setFrmQualTypeId(int frmQualTypeId) {
		this.frmQualTypeId = frmQualTypeId;
	}
	
	//for error and success message
	private String deleteSuccessMsg;
	private String frmQualTypeNameErr;
	private String frmSchoolNameErr;
	private String frmDegreeErr;
	private String frmFieldOfStudyErr;
	private String frmFieldOfActivityErr;
	private String frmFromDateErr;
	private String frmThruDateErr;
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

	public String getDeleteSuccessMsg() {
		return deleteSuccessMsg;
	}

	public void setDeleteSuccessMsg(String deleteSuccessMsg) {
		this.deleteSuccessMsg = deleteSuccessMsg;
	}

	public String getFrmQualTypeNameErr() {
		return frmQualTypeNameErr;
	}

	public void setFrmQualTypeNameErr(String frmQualTypeNameErr) {
		this.frmQualTypeNameErr = frmQualTypeNameErr;
	}

	public String getFrmSchoolNameErr() {
		return frmSchoolNameErr;
	}

	public void setFrmSchoolNameErr(String frmSchoolNameErr) {
		this.frmSchoolNameErr = frmSchoolNameErr;
	}

	public String getFrmDegreeErr() {
		return frmDegreeErr;
	}

	public void setFrmDegreeErr(String frmDegreeErr) {
		this.frmDegreeErr = frmDegreeErr;
	}

	public String getFrmFieldOfStudyErr() {
		return frmFieldOfStudyErr;
	}

	public void setFrmFieldOfStudyErr(String frmFieldOfStudyErr) {
		this.frmFieldOfStudyErr = frmFieldOfStudyErr;
	}

	public String getFrmFieldOfActivityErr() {
		return frmFieldOfActivityErr;
	}

	public void setFrmFieldOfActivityErr(String frmFieldOfActivityErr) {
		this.frmFieldOfActivityErr = frmFieldOfActivityErr;
	}

	public String getFrmFromDateErr() {
		return frmFromDateErr;
	}

	public void setFrmFromDateErr(String frmFromDateErr) {
		this.frmFromDateErr = frmFromDateErr;
	}

	public String getFrmThruDateErr() {
		return frmThruDateErr;
	}

	public void setFrmThruDateErr(String frmThruDateErr) {
		this.frmThruDateErr = frmThruDateErr;
	}
}
