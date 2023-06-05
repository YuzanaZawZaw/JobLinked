package com.frame.presentation.form;

import java.util.List;

import org.apache.struts.validator.ValidatorForm;

import com.frame.business.entity.EmpImageFile;
import com.frame.business.entity.Employee;
import com.frame.business.entity.EmployeePositionFulfillment;
import com.frame.business.entity.EmployeeQual;
import com.frame.business.entity.EmployeeSkill;

/**
*
* @author Yuzana Zaw Zaw
*/
public class EmployeeViewProfileForm extends ValidatorForm {
	//for employee view profile
	private List<EmployeeQual> frmQualTypeList;
	private List<EmployeePositionFulfillment> frmExperinenceList;
	private List<EmployeeSkill> frmSkillList;
	private Employee frmEmployee;
	public Employee getFrmEmployee() {
		return frmEmployee;
	}
	public void setFrmEmployee(Employee frmEmployee) {
		this.frmEmployee = frmEmployee;
	}
	private String frmViewImage;
	private EmpImageFile imageFile;
	private int frmEmployeeId;
	public int getFrmEmployeeId() {
		return frmEmployeeId;
	}
	public void setFrmEmployeeId(int frmEmployeeId) {
		this.frmEmployeeId = frmEmployeeId;
	}
	public EmpImageFile getImageFile() {
		return imageFile;
	}
	public void setImageFile(EmpImageFile imageFile) {
		this.imageFile = imageFile;
	}
	public String getFrmViewImage() {
		return frmViewImage;
	}
	public void setFrmViewImage(String frmViewImage) {
		this.frmViewImage = frmViewImage;
	}
	private String frmCurrentPosition;
	
	public String getFrmCurrentPosition() {
		return frmCurrentPosition;
	}
	public void setFrmCurrentPosition(String frmCurrentPosition) {
		this.frmCurrentPosition = frmCurrentPosition;
	}
	public List<EmployeeQual> getFrmQualTypeList() {
		return frmQualTypeList;
	}
	public void setFrmQualTypeList(List<EmployeeQual> frmQualTypeList) {
		this.frmQualTypeList = frmQualTypeList;
	}
	public List<EmployeePositionFulfillment> getFrmExperinenceList() {
		return frmExperinenceList;
	}
	public void setFrmExperinenceList(
			List<EmployeePositionFulfillment> frmExperinenceList) {
		this.frmExperinenceList = frmExperinenceList;
	}
	public List<EmployeeSkill> getFrmSkillList() {
		return frmSkillList;
	}
	public void setFrmSkillList(List<EmployeeSkill> frmSkillList) {
		this.frmSkillList = frmSkillList;
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
