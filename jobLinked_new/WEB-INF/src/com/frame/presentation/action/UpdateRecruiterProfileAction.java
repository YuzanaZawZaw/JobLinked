package com.frame.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.frame.business.service.RecruitersService;
import com.frame.presentation.form.RecruiterForm;

/**
 * 
 * @author Yuzana Zaw Zaw
 */
public class UpdateRecruiterProfileAction extends BaseAction {
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
		RecruiterForm loginForm = (RecruiterForm) request.getSession()
				.getAttribute("RecFormBean");
		myForm.setLoginUser(loginForm.getLoginUser());
		myForm.setSuccessMsg(null);
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		if (request.getParameter("btnUpdateCancel") != null) {
			return "gotoViewRecProfile";
		}
		// saving the changes
		if (request.getParameter("btnUpdate") != null) {
			myRecruitersService.saveUpdateRecruiterProfile(myForm);
			myForm.setSuccessMsg("Successfully updated!!");
			return "gotoViewRecProfile";
		}
		return "gotoUpdateRecProfile";
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {

		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";

		}
		RecruiterForm myForm = (RecruiterForm) form;
		myForm.setSuccessMsg(null);
		RecruiterForm loginForm = (RecruiterForm) request.getSession()
				.getAttribute("RecFormBean");
		myForm.setLoginUser(loginForm.getLoginUser());
		// load existing data recruiter profile
		myRecruitersService.firstLoadUpdateProfile(myForm);

		return "gotoUpdateRecProfile";
	}

}
