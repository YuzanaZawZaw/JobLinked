package com.frame.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.frame.business.service.RecruitersService;
import com.frame.presentation.form.RecruiterForm;

/**
 * 
 * @author Yuzana Zaw Zaw
 */
public class RecruiterRegistrationAction extends BaseAction {
	private RecruitersService myRecruitersService;

	public RecruitersService getMyRecruitersService() {
		return myRecruitersService;
	}

	public void setMyRecruitersService(RecruitersService myRecruitersService) {
		this.myRecruitersService = myRecruitersService;
	}

	@Override
	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		RecruiterForm myForm = (RecruiterForm) form;
		myForm.setRegistError(null);
		if (request.getParameter("btnRegister") != null) {
			if (myForm.getFrmFirstName().equals("")) {
				myForm.setRegistError("First name is required!!");
				return "gotoRegister";
			}
			if (myForm.getFrmLastName().equals("")) {
				myForm.setRegistError("Last name is required!!");
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

				myForm.setRegistError("Security question is required!!");
				return "gotoRegister";
			}
			//check email is exist or not
			myRecruitersService.checkEmail(myForm);
			if (myForm.getFrmEmailError().equals("error")) {
				myForm.setRegistError("Your email is duplicated!!");
				return "gotoRegister";
			}
		}
		
		if (request.getParameter("btnRegisterCancel") != null) {
			myForm.setFrmFirstName("");
			myForm.setFrmLastName("");
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
		

		if (request.getParameter("btnSave") != null) {
			// saving recruiter
			myRecruitersService.saveNewRecruiters(myForm);
			myForm.setSuccessMsg("Successfully created!!");
			return "gotoLogin";
		}
		return "gotoRegister";
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		RecruiterForm myForm = (RecruiterForm) form;
		myForm.setRegistError(null);
		myForm.setSuccessMsg(null);
		// first load empty data
		myRecruitersService.firstLoadRegistration(myForm);
		return "gotoRegister";
	}

}
