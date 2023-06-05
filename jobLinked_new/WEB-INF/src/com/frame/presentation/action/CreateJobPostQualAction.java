package com.frame.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.frame.business.service.EmployeeQualService;
import com.frame.business.service.JobPostQualService;
import com.frame.business.service.JobPostService;
import com.frame.business.service.QualTypeService;
import com.frame.presentation.form.JobPostQualForm;
import com.frame.presentation.form.RecruiterForm;

/**
*
* @author Yuzana Zaw Zaw
*/

public class CreateJobPostQualAction extends BaseAction {
	private JobPostQualService myJobPostQualService;
	private QualTypeService myQualTypeService;
	private JobPostService myJobPostService;

	public JobPostService getMyJobPostService() {
		return myJobPostService;
	}

	public void setMyJobPostService(JobPostService myJobPostService) {
		this.myJobPostService = myJobPostService;
	}

	public QualTypeService getMyQualTypeService() {
		return myQualTypeService;
	}

	public void setMyQualTypeService(QualTypeService myQualTypeService) {
		this.myQualTypeService = myQualTypeService;
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
		RecruiterForm loginForm = (RecruiterForm) request.getSession()
		.getAttribute("RecFormBean");
		JobPostQualForm myForm = (JobPostQualForm) form;
		myForm.setSuccessMsg(null);
		myJobPostQualService.createJobPostQual(myForm,loginForm);
		myForm.setSuccessMsg("Successfully created!!");
		myJobPostService.firstLoadJobPostQual(myForm,loginForm);
		return "gotoViewJobPostProfile";
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		JobPostQualForm myForm = (JobPostQualForm) form;
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		myQualTypeService.firstLoadQualTypeDisplayTag(myForm);
		myForm.setSuccessMsg(null);
		myForm.setFrmDescription("");
		myForm.setFrmQualType("");
		RecruiterForm loginForm = (RecruiterForm) request.getSession()
		.getAttribute("RecFormBean");
		//getting qualification types
		
		//getting job post's qualification
		myJobPostService.firstLoadJobPostQual(myForm,loginForm);
		return "gotoViewJobPostProfile";
	}
}
