package com.frame.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.frame.business.service.JobPostRequirementService;
import com.frame.business.service.JobPostService;
import com.frame.presentation.form.JobPostRequirementForm;
import com.frame.presentation.form.RecruiterForm;

/**
*
* @author Yuzana Zaw Zaw
*/
public class CreateJobPostRequirementAction extends BaseAction {
	private JobPostRequirementService myJobPostRequirementService;
	private JobPostService myJobPostService;

	public JobPostService getMyJobPostService() {
		return myJobPostService;
	}

	public void setMyJobPostService(JobPostService myJobPostService) {
		this.myJobPostService = myJobPostService;
	}

	public JobPostRequirementService getMyJobPostRequirementService() {
		return myJobPostRequirementService;
	}

	public void setMyJobPostRequirementService(
			JobPostRequirementService myJobPostRequirementService) {
		this.myJobPostRequirementService = myJobPostRequirementService;
	}

	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		RecruiterForm loginForm = (RecruiterForm) request.getSession()
		.getAttribute("RecFormBean");
		JobPostRequirementForm myForm = (JobPostRequirementForm) form;
		myForm.setErrorMsg(null);
		myForm.setSuccessMsg(null);
		myJobPostRequirementService.createJobPostRequirement(myForm,loginForm);
		myForm.setSuccessMsg("Successfully created!!");
		myJobPostRequirementService.firstLoadJobPostRequirement(myForm,loginForm);
		//myJobPostService.viewJobPostProfile(myForm,loginForm);
		
		return "gotoJobPostRequirement";
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		JobPostRequirementForm myForm = (JobPostRequirementForm) form;
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		myForm.setErrorMsg(null);
		myForm.setSuccessMsg(null);
		RecruiterForm loginForm = (RecruiterForm) request.getSession()
		.getAttribute("RecFormBean");
		//getting job post's requirements
		myJobPostRequirementService.firstLoadJobPostRequirement(myForm,loginForm);
		//myJobPostService.viewJobPostProfile(myForm,loginForm);
		return "gotoJobPostRequirement";
	}
}
