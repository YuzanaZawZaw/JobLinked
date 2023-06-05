package com.frame.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.frame.business.service.JobPostService;
import com.frame.presentation.form.EmployeeForm;
import com.frame.presentation.form.JobPostListForm;

/**
 * 
 * @author Yuzana Zaw Zaw
 */
public class ViewJobPostListAction extends BaseAction {
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
		JobPostListForm myForm = (JobPostListForm) form;
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		myForm.setSuccessMsg(null);
		myForm.setErrorMsg(null);
		EmployeeForm loginForm = (EmployeeForm) request.getSession()
				.getAttribute("EmpLoginFormBean");
		//getting job post list by criteria
		if (request.getParameter("btnSearch") != null) {
			if (Integer.parseInt(myForm.getFrmPositionName()) != 0) {

				myJobPostService.searchJobPostListByPosition(myForm, loginForm);
			} else if (!myForm.getFrmLocation().equals("")
					&& Integer.parseInt(myForm.getFrmPositionName()) != 0) {

				myJobPostService.searchJobPostListByLocationAndPosition(myForm,
						loginForm);
			} else if (myForm.getFrmLocation().equals("")
					&& Integer.parseInt(myForm.getFrmPositionName()) == 0) {

				myJobPostService.viewActiveJobPostList(myForm, loginForm);
			} else if (!myForm.getFrmLocation().equals("")
					&& Integer.parseInt(myForm.getFrmPositionName()) == 0) {

				myJobPostService.searchJobPostListByLocation(myForm, loginForm);
			}
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

		EmployeeForm loginForm = (EmployeeForm) request.getSession()
				.getAttribute("EmpLoginFormBean");
		myForm.setSuccessMsg(null);
		myForm.setErrorMsg(null);
		myForm.setFrmLocation("");
		//getting position list
		myJobPostService.firstLoadPositionList(myForm, loginForm);
		//getting active job post list
		myJobPostService.viewActiveJobPostList(myForm, loginForm);
		return "gotoViewJobPostList";
	}

}
