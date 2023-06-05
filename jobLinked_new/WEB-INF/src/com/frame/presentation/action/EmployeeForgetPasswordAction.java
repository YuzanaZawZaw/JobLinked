package com.frame.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.frame.business.service.EmployeeService;
import com.frame.presentation.form.EmployeeForm;

/**
 * 
 * @author Yuzana Zaw Zaw
 */
public class EmployeeForgetPasswordAction extends BaseAction {
	private EmployeeService myEmployeeService;

	public EmployeeService getMyEmployeeService() {
		return myEmployeeService;
	}

	public void setMyEmployeeService(EmployeeService myEmployeeService) {
		this.myEmployeeService = myEmployeeService;
	}

	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		// TODO Auto-generated method stub
		EmployeeForm myForm = (EmployeeForm) form;
		myForm.setForgetPassError(null);
		myForm.setSuccessMsg(null);

		if (myForm.getFrmForgetPassEmail().equals("")) {
			myForm.setForgetPassError("Email is required!!");
			return "gotoForgetPass";
		}
		if (myForm.getFrmForgetPassSecurityQuest().equals("")) {
			myForm.setForgetPassError("Security answer is required!!");
			return "gotoForgetPass";
		}
		myEmployeeService.verifySecurityQuestion(myForm);
		if (myForm.getLoginUser() == null) {
			myForm.setForgetPassError("Your email and security answer are invalid");
			return "gotoForgetPass";
		} else {
			request.getSession(true);
			request.getSession().setAttribute("id",
					request.getSession().getId());
			myForm.setSuccessMsg("Login Successfully!!");
			myForm.setFrmForgetPassEmail("");
			myForm.setFrmForgetPassSecurityQuest("");
			return "gotoEmployeeModule";
		}

	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		EmployeeForm myForm = (EmployeeForm) form;
		myForm.setFrmForgetPassEmail("");
		myForm.setFrmForgetPassSecurityQuest("");
		myForm.setForgetPassError(null);
		myForm.setSuccessMsg(null);
		return "gotoForgetPass";
	}

}
