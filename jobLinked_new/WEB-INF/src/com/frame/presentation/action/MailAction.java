package com.frame.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.frame.business.service.MailService;
import com.frame.presentation.form.MailForm;
import com.frame.presentation.form.RecruiterForm;

/**
 * 
 * @author Yuzana Zaw Zaw
 */
public class MailAction extends BaseAction {

	private MailService myMailService;

	public MailService getMyMailService() {
		return myMailService;
	}

	public void setMyMailService(MailService myMailService) {
		this.myMailService = myMailService;
	}

	@Override
	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		MailForm myForm = (MailForm) form;
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";

		}
		RecruiterForm loginForm = (RecruiterForm) request.getSession()
		.getAttribute("RecFormBean");
		myForm.setLoginUser(loginForm.getLoginUser());
		if (request.getParameter("btnSend") != null) {
			//calling prepareForMail
			myMailService.prepareForMail(myForm);
			return "gotoMail";
		}
		if (isCancelled(request)) {
			return "gotoHome";
		}
		return null;
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		MailForm myForm = (MailForm) form;
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";

		}
		RecruiterForm loginForm = (RecruiterForm) request.getSession()
		.getAttribute("RecFormBean");
		//first load empty data
		myForm.setLoginUser(loginForm.getLoginUser());
		myForm.setFrmMailSubject(null);
		myForm.setFrmMailBody(null);
		myForm.setFrmMailName(null);
		myForm.setFrmMailAdd(null);
		myForm.setFrmMailMessage(null);
		return "gotoMail";
	}

}
