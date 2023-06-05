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
public class CreateJobPostAction extends BaseAction {
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
		RecruiterForm loginForm = (RecruiterForm) request.getSession()
		.getAttribute("RecFormBean");
		
		JobPostForm myForm = (JobPostForm) form;
		myForm.setSuccessMsg(null);
		myForm.setErrorMsg(null);
		if(Integer.parseInt(myForm.getFrmPositionName())==0){
			myForm.setErrorMsg("Position name is required!!");
			return "gotoCreateJobPost";
		}
		if(Integer.parseInt(myForm.getFrmStatusName())==0){
			myForm.setErrorMsg("Status is required!!");
			return "gotoCreateJobPost";
		}
		if(myForm.getFrmLocation().equals("")){
			myForm.setErrorMsg("Location is required!!");
			return "gotoCreateJobPost";
		}
		if(Integer.parseInt(myForm.getFrmEmploymentType())==0){
			myForm.setErrorMsg("Employment type is required!!");
			return "gotoCreateJobPost";
		}
		if(myForm.getFrmSalary().equals("")){
			myForm.setErrorMsg("Salary is required!!");
			return "gotoCreateJobPost";
		}
		if(myForm.getFrmFromDate().equals("")){
			myForm.setErrorMsg("Start date is required!!");
			return "gotoCreateJobPost";
		}
		if(myForm.getFrmThruDate().equals("")){
			myForm.setErrorMsg("End date is required!!");
			return "gotoCreateJobPost";
		}
		myJobPostService.createJobPost(myForm,loginForm);
		myForm.setSuccessMsg("Successfully created!!");
		myJobPostService.firstLoadJobPostListTag(myForm,loginForm.getLoginUser());
		return "gotoCreateJobPost";
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		JobPostForm myForm = (JobPostForm) form;
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		myForm.setSuccessMsg(null);
		myForm.setErrorMsg(null);
		RecruiterForm loginForm = (RecruiterForm) request.getSession()
		.getAttribute("RecFormBean");
		//getting job post list
		myJobPostService.firstLoadJobPostListTag(myForm,loginForm.getLoginUser());
		//getting position list
		myJobPostService.firstLoadPositionList(myForm,loginForm);
		//getting status list
		myJobPostService.firstLoadStatusList(myForm,loginForm);
		return "gotoCreateJobPost";
	}
}
