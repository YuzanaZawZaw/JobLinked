package com.frame.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
public class EmployeeRegistrationAction extends BaseAction {
	private EmployeeService myEmployeeService;

	public EmployeeService getMyEmployeeService() {
		return myEmployeeService;
	}

	public void setMyEmployeeService(EmployeeService myEmployeeService) {
		this.myEmployeeService = myEmployeeService;
	}

	@Override
	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		EmployeeForm myForm = (EmployeeForm) form;
		myForm.setRegistError(null);
		myForm.setSuccessMsg(null);
		if (request.getParameter("btnRegisterCancel") != null) {
			myForm.setFrmFirstName("");
			myForm.setFrmLastName("");
			myForm.setFrmFatherName("");
			myForm.setFrmEmail("");
			myForm.setFrmPassword("");
			myForm.setFrmPhone("");
			myForm.setFrmNrc("");
			myForm.setFrmGender("");
			myForm.setFrmAddress("");
			myForm.setFrmSecurityQuest("");
			myForm.setFrmBirthDate(null);
			myForm.setFrmRegFormControl(null);
			return "gotoLogin";
		}
		if (request.getParameter("btnSaveCancel") != null) {
			myForm.setFrmRegFormControl(null);
			return "gotoRegister";
		}
		if (isCancelled(request)) {
			return "gotoHome";
		}
		if (request.getParameter("btnRegister") != null) {
			if (myForm.getFrmFirstName().equals("")) {
				myForm.setRegistError("First name is required!!");
				return "gotoRegister";
			}
			if (myForm.getFrmLastName().equals("")) {
				myForm.setRegistError("Last name is required!!");
				return "gotoRegister";
			}
			if (myForm.getFrmFatherName().equals("")) {
				myForm.setRegistError("Father name is required!!");
				return "gotoRegister";
			}
			if (myForm.getFrmEmail().equals("")) {
				myForm.setRegistError("Email is required!!");
				return "gotoRegister";
			}
			if (myForm.getFrmPassword().equals("")) {
				myForm.setRegistError("Password is required!!");
				return "gotoRegister";
			}
			if (myForm.getFrmPhone().equals("")) {
				myForm.setRegistError("Phone number is required!!");
				return "gotoRegister";
			}
			if (myForm.getFrmBirthDate().equals("")) {
				myForm.setRegistError("Birth date is required!!");
				return "gotoRegister";
			}
			if (myForm.getFrmNrc().equals("")) {
				myForm.setRegistError("Nrc number is required!!");
				return "gotoRegister";
			}
			if (myForm.getFrmGender().equals("")) {
				myForm.setRegistError("Gender is required!!");
				return "gotoRegister";
			}
			if (myForm.getFrmAddress().equals("")) {
				myForm.setRegistError("Address is required!!");
				return "gotoRegister";
			}
			if (myForm.getFrmSecurityQuest().equals("")) {
				myForm.setRegistError("Security answer is required!!");
				return "gotoRegister";
			}
				myEmployeeService.checkEmail(myForm);
				if (myForm.getFrmEmailError().equals("error")) {
					myForm.setRegistError("Your email is duplicated!!");
					return "gotoRegister";
				}
		}

		if (request.getParameter("btnSave") != null) {
			myEmployeeService.saveNewEmployee(myForm);
			myForm.setSuccessMsg("Successfully created!!");
			return "gotoHome";

		}
		return "gotoRegister";
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		EmployeeForm myForm = (EmployeeForm) form;
		myForm.setRegistError(null);
		myForm.setSuccessMsg(null);
		myEmployeeService.firstLoadRegistration(myForm);
		return "gotoRegister";
	}

}
