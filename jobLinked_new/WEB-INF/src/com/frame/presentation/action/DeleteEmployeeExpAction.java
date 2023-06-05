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
public class DeleteEmployeeExpAction extends BaseAction {
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
		return "gotoEmpExp";
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		EmployeeForm loginForm = (EmployeeForm) request.getSession().getAttribute(
		"EmpLoginFormBean");
		EmployeeExpForm myForm = (EmployeeExpForm) form;
		
		myForm.setFrmPositionNameErr(null);
		myForm.setFrmEmploymentTypeErr(null);
		myForm.setFrmLocationErr(null);
		myForm.setFrmCurrentRoleErr(null);
		myForm.setFrmFromDate(null);
		myForm.setFrmThruDateErr(null);
		myForm.setSuccessMsg(null);
		myForm.setDeleteSuccessMsg(null);
		myForm.setErrorMsg(null);
		//delete experience for employee
		myEmployeeExpService.deleteEmployeeExperience(myForm);
		myForm.setDeleteSuccessMsg("Successfully Deleted!!");
		//getting employee experiences
		myEmployeeExpService.firstLoadEmployeeExpDisplayTag(myForm, loginForm.getLoginUser());
		return "gotoEmpExp";
		
	}
}
