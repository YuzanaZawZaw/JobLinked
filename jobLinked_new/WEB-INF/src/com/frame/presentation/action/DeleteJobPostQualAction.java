package com.frame.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.frame.business.service.JobPostQualService;
import com.frame.business.service.JobPostService;
import com.frame.presentation.form.JobPostForm;
import com.frame.presentation.form.JobPostQualForm;
import com.frame.presentation.form.RecruiterForm;

/**
*
* @author Yuzana Zaw Zaw
*/
public class DeleteJobPostQualAction extends BaseAction {
	private JobPostQualService myJobPostQualService;
	private JobPostService myJobPostService;
	
	public JobPostService getMyJobPostService() {
		return myJobPostService;
	}

	public void setMyJobPostService(JobPostService myJobPostService) {
		this.myJobPostService = myJobPostService;
	}

	public JobPostQualService getMyJobPostQualService() {
		return myJobPostQualService;
	}

	public void setMyJobPostQualService(JobPostQualService myJobPostQualService) {
		this.myJobPostQualService = myJobPostQualService;
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
		 
		JobPostForm  myForm = (JobPostForm) form; 
		myForm.setSuccessMsg(null);
		int id=Integer.parseInt(myForm.getFrmJobPostQualId());
		myJobPostQualService.deleteJobPostQual(myForm, id);
		myForm.setSuccessMsg("Successfully Deleted!!");
		myJobPostService.firstLoadJobPostQualTag(myForm,loginForm);
		
		return "gotoCreateJobPost";
		
	}

}
