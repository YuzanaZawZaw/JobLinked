package com.frame.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import com.frame.business.service.JobPostRequirementService;
import com.frame.presentation.form.JobPostForm;
import com.frame.presentation.form.RecruiterForm;
/**
*
* @author Yuzana Zaw Zaw
*/
public class DeleteJobPostRequirementAction extends BaseAction {
	private JobPostRequirementService myJobPostRequirementService;


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
		
		return "gotoCreateJobPost";
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		RecruiterForm loginForm = (RecruiterForm) request.getSession()
		.getAttribute("RecFormBean");
		JobPostForm myForm = (JobPostForm) form;
		myForm.setSuccessMsg(null);
		myJobPostRequirementService.deleteJobPostRequirement(myForm,loginForm);
		myForm.setSuccessMsg("Successfully Deleted!!");
		return "gotoCreateJobPost";
		
	}
}
