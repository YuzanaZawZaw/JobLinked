package com.frame.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.frame.business.service.EmployeeExpService;
import com.frame.presentation.form.EmployeeExpForm;
import com.frame.presentation.form.EmployeeForm;

/**
*
* @author Yuzana Zaw Zaw
*/
public class EmployeeExpAction extends BaseAction {
	private EmployeeExpService myEmployeeExpService;

	
	public EmployeeExpService getMyEmployeeExpService() {
		return myEmployeeExpService;
	}

	public void setMyEmployeeExpService(EmployeeExpService myEmployeeExpService) {
		this.myEmployeeExpService = myEmployeeExpService;
	}

	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		EmployeeExpForm myForm = (EmployeeExpForm) form;
		EmployeeForm loginForm = (EmployeeForm) request.getSession()
		.getAttribute("EmpLoginFormBean");
	
		myForm.setFrmPositionNameErr(null);
		myForm.setFrmEmploymentTypeErr(null);
		myForm.setFrmLocationErr(null);
		myForm.setFrmCurrentRoleErr(null);
		myForm.setFrmFromDateErr(null);
		myForm.setFrmThruDateErr(null);
		myForm.setSuccessMsg(null);
		myForm.setDeleteSuccessMsg(null);
		myForm.setErrorMsg(null);
		
		if(request.getParameter("btnSave")!=null){
			if(Integer.parseInt(myForm.getFrmPositionName())==0){
				myForm.setFrmPositionNameErr("Position name is required!!");
				return "gotoEmpExp";
			}
			if(Integer.parseInt(myForm.getFrmEmploymentType())==0){
				myForm.setFrmEmploymentTypeErr("Employment Type is required!!");
				return "gotoEmpExp";
			}
			if(myForm.getFrmLocation().equals("")){
				myForm.setFrmLocationErr("Location is required!!");
				return "gotoEmpExp";
			}
			if(Integer.parseInt(myForm.getFrmCurrentRole())==0){
				myForm.setFrmCurrentRoleErr("Current role is required!!");
				return "gotoEmpExp";
			}
			if(myForm.getFrmFromDate().equals("")){
				myForm.setFrmFromDateErr("Start date is required!!");
				return "gotoEmpExp";
			}
			if(myForm.getFrmThruDate().equals("")){
				myForm.setFrmThruDateErr("End date is required!!");
				return "gotoEmpExp";
			}
			myEmployeeExpService.createEmployeePositionFulfillment(myForm,loginForm);
			
			myEmployeeExpService.firstLoadEmployeeExpDisplayTag(myForm, loginForm.getLoginUser());
		}
		return "gotoEmpExp";
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		EmployeeExpForm myForm = (EmployeeExpForm) form;
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		EmployeeForm loginForm = (EmployeeForm) request.getSession()
		.getAttribute("EmpLoginFormBean");
		myForm.setFrmPositionNameErr(null);		
		myForm.setFrmEmploymentTypeErr(null);
		myForm.setFrmLocationErr(null);
		myForm.setFrmCurrentRoleErr(null);
		myForm.setFrmFromDate(null);
		myForm.setFrmThruDateErr(null);
		myForm.setSuccessMsg(null);
		myForm.setDeleteSuccessMsg(null);	
		myForm.setErrorMsg(null);
		myEmployeeExpService.firstLoadEmployeeExpDisplayTag(myForm,loginForm.getLoginUser());
		myEmployeeExpService.firstLoadPosition(myForm);
		return "gotoEmpExp";
	}

}
