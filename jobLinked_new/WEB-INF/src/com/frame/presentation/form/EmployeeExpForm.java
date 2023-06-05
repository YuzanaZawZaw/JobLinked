package com.frame.presentation.form;
import java.util.List;
import org.apache.struts.validator.ValidatorForm;
import com.frame.business.entity.EmployeePositionFulfillment;
import com.frame.business.entity.PartyGroupPosition;

/**
*
* @author Yuzana Zaw Zaw
*/
public class EmployeeExpForm extends ValidatorForm {

	//for Employee profile details
	private List<EmployeePositionFulfillment> frmDetailEmpPositionList;

	public List<EmployeePositionFulfillment> getFrmDetailEmpPositionList() {
		return frmDetailEmpPositionList;
	}

	public void setFrmDetailEmpPositionList(
			List<EmployeePositionFulfillment> frmDetailEmpPositionList) {
		this.frmDetailEmpPositionList = frmDetailEmpPositionList;
	}
	
	//for create employee experiences
	private String frmPositionName;
	private List<PartyGroupPosition> frmPositionList;
	public List<PartyGroupPosition> getFrmPositionList() {
		return frmPositionList;
	}

	public void setFrmPositionList(List<PartyGroupPosition> frmPositionList) {
		this.frmPositionList = frmPositionList;
	}

	public String getFrmPositionName() {
		return frmPositionName;
	}

	public void setFrmPositionName(String frmPositionName) {
		this.frmPositionName = frmPositionName;
	}

	public String getFrmEmploymentType() {
		return frmEmploymentType;
	}

	public void setFrmEmploymentType(String frmEmploymentType) {
		this.frmEmploymentType = frmEmploymentType;
	}

	public String getFrmLocation() {
		return frmLocation;
	}

	public void setFrmLocation(String frmLocation) {
		this.frmLocation = frmLocation;
	}

	public String getFrmCurrentRole() {
		return frmCurrentRole;
	}

	public void setFrmCurrentRole(String frmCurrentRole) {
		this.frmCurrentRole = frmCurrentRole;
	}

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

	private String frmEmploymentType;
	private String frmLocation;
	private String frmCurrentRole;
	private String frmFromDate;
	private String frmThruDate;
	
	//for delete employee positions
	private String frmEmployeeId;
	public String getFrmEmployeeId() {
		return frmEmployeeId;
	}

	public void setFrmEmployeeId(String frmEmployeeId) {
		this.frmEmployeeId = frmEmployeeId;
	}

	public String getFrmPositionId() {
		return frmPositionId;
	}

	public void setFrmPositionId(String frmPositionId) {
		this.frmPositionId = frmPositionId;
	}

	private String frmPositionId;
	
	//for success and error message
	private String frmPositionNameErr;
	private String frmEmploymentTypeErr;
	private String frmLocationErr;
	private String frmCurrentRoleErr;
	private String frmFromDateErr;
	private String frmThruDateErr;
	private String deleteSuccessMsg;
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

	public String getFrmPositionNameErr() {
		return frmPositionNameErr;
	}

	public void setFrmPositionNameErr(String frmPositionNameErr) {
		this.frmPositionNameErr = frmPositionNameErr;
	}

	public String getFrmEmploymentTypeErr() {
		return frmEmploymentTypeErr;
	}

	public void setFrmEmploymentTypeErr(String frmEmploymentTypeErr) {
		this.frmEmploymentTypeErr = frmEmploymentTypeErr;
	}

	public String getFrmLocationErr() {
		return frmLocationErr;
	}

	public void setFrmLocationErr(String frmLocationErr) {
		this.frmLocationErr = frmLocationErr;
	}

	public String getFrmCurrentRoleErr() {
		return frmCurrentRoleErr;
	}

	public void setFrmCurrentRoleErr(String frmCurrentRoleErr) {
		this.frmCurrentRoleErr = frmCurrentRoleErr;
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
