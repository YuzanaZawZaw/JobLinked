package com.frame.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.frame.business.service.JobPostService;
import com.frame.presentation.form.EmployeeForm;
import com.frame.presentation.form.JobPostForm;
import com.frame.presentation.form.JobPostListForm;
import com.frame.presentation.form.RecruiterForm;

/**
*
* @author Yuzana Zaw Zaw
*/
public class EmpViewJobPostProfileAction extends BaseAction {
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
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		
		return "gotoViewJobPostProfile";
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		JobPostListForm myForm = (JobPostListForm) form;
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		
		EmployeeForm loginForm = (EmployeeForm) request.getSession()
		.getAttribute("EmpLoginFormBean");
		myForm.setLoginUser(loginForm.getLoginUser());
		//for getting job post profile from employee
		myJobPostService.empViewJobPostProfile(myForm,loginForm);
		return "gotoViewJobPostProfile";
	}

}
