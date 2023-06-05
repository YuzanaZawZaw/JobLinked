package com.frame.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import com.frame.business.service.AdminService;
import com.frame.presentation.form.AdminForm;

/**
 * 
 * @author Yuzana Zaw Zaw
 */
public class AdminLoginAction extends BaseAction {
	private AdminService myAdminService;

	public AdminService getMyAdminService() {
		return myAdminService;
	}

	public void setMyAdminService(AdminService myAdminService) {
		this.myAdminService = myAdminService;
	}
	
	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		AdminForm myForm = (AdminForm) form;
		myForm.setFrmLoginEmail("");
		myForm.setFrmLoginPassword("");
		myForm.setSuccessMsg(null);
		myForm.setLoginError(null);
		return "gotoLogin";
	}

	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		// TODO Auto-generated method stub
		//using AdminForm 
		AdminForm myForm = (AdminForm) form;
		myForm.setLoginError(null);
		myForm.setSuccessMsg(null);
		if (myForm.getFrmLoginEmail().equals("")) {			
			myForm.setLoginError("Email is required!!");
			return "gotoLogin";
		}
		if (myForm.getFrmLoginPassword().equals("")) {			
			myForm.setLoginError("Password is required!!");
			return "gotoLogin";
		}
		//checking Login User
		myAdminService.checkLoginUser(myForm);
		if (myForm.getLoginUser() == null) {			
			myForm.setLoginError("Email and Password are mismatch!!");
			return "gotoLogin";
		} else {
			
			request.getSession(true);
			request.getSession().setAttribute("id",
					request.getSession().getId());
			myForm.setFrmLoginEmail("");
			myForm.setFrmLoginPassword("");
			myForm.setSuccessMsg("Login Successfully");
			return "gotoAdminModule";
		}
	}

}
