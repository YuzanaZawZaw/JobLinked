package com.frame.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.frame.business.service.JobPostApplyService;
import com.frame.business.service.JobPostService;
import com.frame.presentation.form.EmployeeForm;
import com.frame.presentation.form.JobPostListForm;
/**
*
* @author Yuzana Zaw Zaw
*/
public class CreateJobPostApplyAction extends BaseAction {
	private JobPostApplyService myJobPostApplyService;
	private JobPostService myJobPostService;
	public JobPostService getMyJobPostService() {
		return myJobPostService;
	}

	public void setMyJobPostService(JobPostService myJobPostService) {
		this.myJobPostService = myJobPostService;
	}

	public JobPostApplyService getMyJobPostApplyService() {
		return myJobPostApplyService;
	}

	public void setMyJobPostApplyService(
			JobPostApplyService myJobPostApplyService) {
		this.myJobPostApplyService = myJobPostApplyService;
	}

	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {		
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		
		return "gotoViewJobPostList";
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		JobPostListForm myForm = (JobPostListForm) form;
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		myForm.setSuccessMsg(null);
		myForm.setErrorMsg(null);
		EmployeeForm loginForm = (EmployeeForm) request.getSession()
				.getAttribute("EmpLoginFormBean");
		//apply employee to job post 
		myJobPostApplyService.createJobPostApply(myForm, loginForm);
		return "gotoViewJobPostList";
	}
}
