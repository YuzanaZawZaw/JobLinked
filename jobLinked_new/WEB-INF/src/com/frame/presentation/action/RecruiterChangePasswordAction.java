package com.frame.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
public class RecruiterChangePasswordAction extends BaseAction {
	private RecruitersService myRecruitersService;

	

	public RecruitersService getMyRecruitersService() {
		return myRecruitersService;
	}

	public void setMyRecruitersService(RecruitersService myRecruitersService) {
		this.myRecruitersService = myRecruitersService;
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		HttpSession session = request.getSession(false);
		RecruiterForm myForm = (RecruiterForm) form;
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		myForm.setSuccessMsg(null);
		myForm.setPasswordError(null);
		return "gotoRecChangePass";
	}

	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		// TODO Auto-generated method stub
		RecruiterForm myForm = (RecruiterForm) form;
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		
		RecruiterForm loginForm = (RecruiterForm) request.getSession().getAttribute(
				"RecFormBean");
		myForm.setLoginUser(loginForm.getLoginUser());
		//check that the the old password is correct
		boolean loginUserFlag = myRecruitersService.checkLoginUser(loginForm
				.getLoginUser().getEmail(), myForm.getFrmChangeOldPassword());
		if (myForm.getFrmChangeOldPassword().equals("")) {			
			myForm.setPasswordError("Old Password is required!!");
			return "gotoRecChangePass";
		}
		if (myForm.getFrmChangeNewPassword().equals("")) {			
			myForm.setPasswordError("New Password is required!!");
			return "gotoRecChangePass";
		}
		if (myForm.getFrmChangeConfirmPassword().equals("")) {			
			myForm.setPasswordError("Confirm Password is required!!");
			return "gotoRecChangePass";
		}
		//check that the the old password and new password are the same
		if (loginUserFlag == true) {
			if (myForm.getFrmChangeNewPassword().equals(
					myForm.getFrmChangeConfirmPassword())
					&& !myForm.getFrmChangeNewPassword().equals("")
					&& !myForm.getFrmChangeConfirmPassword().equals("")) {
				myRecruitersService.saveUpdateRecruiterPass(myForm);
				myForm.setSuccessMsg("Successfully Updated");
				return "gotoRecModule";
			} else {
				myForm.setPasswordError("New Password and Confirmed Password are mismatch!!");
				return "gotoRecChangePass";
			}
		} else {
			myForm.setPasswordError("Old Password is invalid!!"); 
			return "gotoRecChangePass";
		}
	}

}
