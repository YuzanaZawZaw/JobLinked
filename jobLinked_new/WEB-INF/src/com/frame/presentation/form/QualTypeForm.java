package com.frame.presentation.form;

import java.util.List;

import org.apache.struts.validator.ValidatorForm;
import com.frame.business.entity.QualType;

/**
*
* @author Yuzana Zaw Zaw
*/
public class QualTypeForm extends ValidatorForm {
	//for creating qualification types
	private String frmQualTypeName;
	private String frmQualTypeNameErr;
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
	public String getFrmQualTypeNameErr() {
		return frmQualTypeNameErr;
	}
	public void setFrmQualTypeNameErr(String frmQualTypeNameErr) {
		this.frmQualTypeNameErr = frmQualTypeNameErr;
	}
	//getting qualification type list
	private List<QualType> frmQualTypeList;
	
	public List<QualType> getFrmQualTypeList() {
		return frmQualTypeList;
	}
	public void setFrmQualTypeList(List<QualType> frmQualTypeList) {
		this.frmQualTypeList = frmQualTypeList;
	}
	//for delete qual type
	private int qualTypeId;
	public String getFrmQualTypeName() {
		return frmQualTypeName;
	}
	public void setFrmQualTypeName(String frmQualTypeName) {
		this.frmQualTypeName = frmQualTypeName;
	}
	
	public int getQualTypeId() {
		return qualTypeId;
	}
	public void setQualTypeId(int qualTypeId) {
		this.qualTypeId = qualTypeId;
	}

}
