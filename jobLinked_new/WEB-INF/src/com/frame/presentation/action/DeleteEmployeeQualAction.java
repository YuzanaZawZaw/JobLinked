package com.frame.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.frame.business.service.EmployeeQualService;
import com.frame.presentation.form.EmployeeForm;
import com.frame.presentation.form.EmployeeQualForm;

/**
*
* @author Yuzana Zaw Zaw
*/
public class DeleteEmployeeQualAction extends BaseAction {
	private EmployeeQualService myEmployeeQualService;

	public EmployeeQualService getMyEmployeeQualService() {
		return myEmployeeQualService;
	}

	public void setMyEmployeeQualService(EmployeeQualService myEmployeeQualService) {
		this.myEmployeeQualService = myEmployeeQualService;
	}

	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		return "gotoEmpQual";
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
		EmployeeQualForm myForm = (EmployeeQualForm) form;
		myForm.setDeleteSuccessMsg(null);
		myForm.setFrmDegreeErr(null);
		myForm.setFrmQualTypeNameErr(null);
		myForm.setFrmSchoolNameErr(null);
		myForm.setFrmFieldOfActivityErr(null);
		myForm.setFrmFieldOfStudyErr(null);
		myForm.setFrmFromDateErr(null);
		myForm.setFrmThruDateErr(null);
		myForm.setDeleteSuccessMsg(null);
		myForm.setSuccessMsg(null);
		myForm.setErrorMsg(null);
		//delete employee qualification
		myEmployeeQualService.deleteEmployeeQual(myForm);
		myForm.setDeleteSuccessMsg("Successfully Deleted!!");
		//getting employee qualification
		myEmployeeQualService.firstLoadEmployeeQualDisplayTag(myForm, loginForm.getLoginUser());
		return "gotoEmpQual";
		
	}
}
