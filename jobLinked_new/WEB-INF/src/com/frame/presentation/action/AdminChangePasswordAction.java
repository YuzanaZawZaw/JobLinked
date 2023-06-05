package com.frame.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.frame.business.service.AdminService;
import com.frame.presentation.form.AdminForm;
/**
*
* @author Yuzana Zaw Zaw
*/
public class AdminChangePasswordAction extends BaseAction {
	private AdminService myAdminService;

	public AdminService getMyAdminService() {
		return myAdminService;
	}

	public void setMyAdminService(AdminService myAdminService) {
		this.myAdminService = myAdminService;
	}

	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		// TODO Auto-generated method stub
		AdminForm myForm = (AdminForm) form;
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		myForm.setSuccessMsg(null);
		myForm.setPasswordError(null);
		
		//getting Login User form bean
		AdminForm loginForm = (AdminForm) request.getSession().getAttribute(
				"AdminLoginFormBean");
		myForm.setLoginUser(loginForm.getLoginUser());
		boolean loginUserFlag = myAdminService.checkLoginUser(loginForm
				.getLoginUser().getEmail(), myForm.getFrmChangeOldPassword());
		if (myForm.getFrmChangeOldPassword().equals("")) {			
			myForm.setPasswordError("Old Password is required!!");
			return "gotoAdminChangePass";
		}
		if (myForm.getFrmChangeNewPassword().equals("")) {			
			myForm.setPasswordError("New Password is required!!");
			return "gotoAdminChangePass";
		}
		if (myForm.getFrmChangeConfirmPassword().equals("")) {			
			myForm.setPasswordError("Confirm Password is required!!");
			return "gotoAdminChangePass";
		}
		if (loginUserFlag == true) {
			if (myForm.getFrmChangeNewPassword().equals(
					myForm.getFrmChangeConfirmPassword())
					&& !myForm.getFrmChangeNewPassword().equals("")
					&& !myForm.getFrmChangeConfirmPassword().equals("")) {
				myAdminService.saveUpdateAdmin(myForm);
				myForm.setSuccessMsg("Successfully Updated");
				return "gotoHome";
			} else {				
				myForm.setPasswordError("New Password and Confirmed Password are mismatch!!");
				return "gotoAdminChangePass";
			}
		} else {			
			myForm.setPasswordError("Old Password is invalid!!"); 
			return "gotoAdminChangePass";
		}
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		AdminForm myForm = (AdminForm) form;
		
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		myForm.setSuccessMsg(null);
		myForm.setPasswordError(null);
		
		return "gotoAdminChangePass";
	}

}
