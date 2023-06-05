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
public class DeleteUpdateStatusJobPostAction extends BaseAction {
	private JobPostService myJobPostService;

	public JobPostService getMyJobPostService() {
		return myJobPostService;
	}

	public void setMyJobPostService(JobPostService myJobPostService) {
		this.myJobPostService = myJobPostService;
	}

	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		JobPostForm myForm = (JobPostForm) form; 
		 RecruiterForm loginForm = (RecruiterForm) request.getSession()
			.getAttribute("RecFormBean");
		 myForm.setLoginUser(loginForm.getLoginUser());

		return "gotoCreateJobPost";
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
		 
		 myJobPostService.deleteUpdateJobPostStatus(myForm);
		 myForm.setSuccessMsg("Successfully deleted!!");
		 myJobPostService.firstLoadJobPostListTag(myForm, loginForm.getLoginUser());
		return "gotoCreateJobPost";
		
	}
}
