package com.frame.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.frame.business.service.JobPostService;
import com.frame.presentation.form.JobPostForm;
import com.frame.presentation.form.RecruiterForm;

/**
 * 
 * @author Yuzana Zaw Zaw
 */
public class UpdateJobPostAction extends BaseAction {
	private JobPostService myJobPostService;

	public JobPostService getMyJobPostService() {
		return myJobPostService;
	}

	public void setMyJobPostService(JobPostService myJobPostService) {
		this.myJobPostService = myJobPostService;
	}

	@Override
	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		JobPostForm myForm = (JobPostForm) form;
		myForm.setSuccessMsg(null);
		myForm.setErrorMsg(null);
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		RecruiterForm loginForm = (RecruiterForm) request.getSession()
				.getAttribute("RecFormBean");
		myForm.setLoginUser(loginForm.getLoginUser());

		if (request.getParameter("btnUpdateCancel") != null) {
			return "gotoCreateJobPost";
		}
		if (Integer.parseInt(myForm.getFrmStatusName()) == 0) {
			myForm.setErrorMsg("Status is required!!");
			return "gotoUpdateJobPost";
		}

		if (request.getParameter("btnUpdate") != null) {
			myJobPostService.saveUpdateJobPost(myForm);
			myJobPostService.firstLoadJobPostListTag(myForm,
					loginForm.getLoginUser());
			myForm.setSuccessMsg("Successfully updated!!");
			return "gotoCreateJobPost";
		}

		return "gotoUpdateJobPost";
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {

		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";

		}
		JobPostForm myForm = (JobPostForm) form;
		myForm.setSuccessMsg(null);
		myForm.setErrorMsg(null);
		RecruiterForm loginForm = (RecruiterForm) request.getSession()
				.getAttribute("RecFormBean");
		myForm.setLoginUser(loginForm.getLoginUser());
		// first load for update job post profile
		myJobPostService.firstLoadUpdateProfile(myForm);
		// first load job post qualifications
		//myJobPostService.firstLoadJobPostQual(myForm);
		// myJobPostService.firstLoadJobPostAppliedEmployee(myForm);
		// first load job post requirement
		//myJobPostService.firstLoadJobPostRequirement(myForm);
		return "gotoUpdateJobPost";
	}

}
