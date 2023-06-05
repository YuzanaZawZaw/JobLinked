package com.frame.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.frame.business.entity.Status;
import com.frame.business.service.AdminService;
import com.frame.business.service.EmployeeService;
import com.frame.business.service.RecruitersService;
import com.frame.presentation.form.AdminForm;
import com.frame.presentation.form.EmployeeForm;
import com.frame.presentation.form.RecruiterForm;

/**
 * 
 * @author Yuzana Zaw Zaw
 */
public class AdminActivateRecAccountAction extends BaseAction {
	private RecruitersService myRecruitersService;

	public RecruitersService getMyRecruitersService() {
		return myRecruitersService;
	}

	public void setMyRecruitersService(RecruitersService myRecruitersService) {
		this.myRecruitersService = myRecruitersService;
	}

	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		return "gotoRecList";
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		//RecruiterForm object
		RecruiterForm myForm = (RecruiterForm) form;
		myForm.setSuccessMsg(null);
		//getting session
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		//getting Login User form bean
		AdminForm loginForm = (AdminForm) request.getSession().getAttribute(
				"AdminLoginFormBean");
		//calling activateReAccount service from RecruitersService
		myRecruitersService.activateRecAccount(myForm, loginForm);
		myForm.setSuccessMsg("Successfully activated!!");
		myRecruitersService.getFirstLoadRecruiterList(myForm, loginForm);
		return "gotoRecList";
	}

}
