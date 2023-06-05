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
public class EmployeeChangePasswordAction extends BaseAction {
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
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		myForm.setSuccessMsg(null);
		myForm.setPasswordError(null);
		
		EmployeeForm loginForm = (EmployeeForm) request.getSession().getAttribute(
				"EmpLoginFormBean");
		myForm.setLoginUser(loginForm.getLoginUser());
		boolean loginUserFlag = myEmployeeService.checkLoginUser(loginForm
				.getLoginUser().getEmail(), myForm.getFrmChangeOldPassword());
		if (myForm.getFrmChangeOldPassword().equals("")) {			
			myForm.setPasswordError("Old Password is required!!");
			return "gotoEmplChangePass";
		}
		if (myForm.getFrmChangeNewPassword().equals("")) {			
			myForm.setPasswordError("New Password is required!!");
			return "gotoEmplChangePass";
		}
		if (myForm.getFrmChangeConfirmPassword().equals("")) {			
			myForm.setPasswordError("Confirm Password is required!!");
			return "gotoEmplChangePass";
		}
		if (loginUserFlag == true) {
			if (myForm.getFrmChangeNewPassword().equals(
					myForm.getFrmChangeConfirmPassword())
					&& !myForm.getFrmChangeNewPassword().equals("")
					&& !myForm.getFrmChangeConfirmPassword().equals("")) {
				myEmployeeService.saveUpdateEmployeePass(myForm);
				myForm.setSuccessMsg("Successfully Updated");
				return "gotoEmplChangePass";
			} else {				
				myForm.setPasswordError("New Password and Confirmed Password are mismatch!!");
				return "gotoEmplChangePass";
			}
		} else {			
			myForm.setPasswordError("Old Password is invalid!!"); 
			return "gotoEmplChangePass";
		}
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		EmployeeForm myForm = (EmployeeForm) form;
		
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		myForm.setSuccessMsg(null);
		myForm.setPasswordError(null);
		
		return "gotoEmplChangePass";
	}

}
