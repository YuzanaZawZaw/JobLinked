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
import com.frame.business.service.RecruitersService;
import com.frame.presentation.form.AdminForm;
import com.frame.presentation.form.RecruiterForm;

/**
 * 
 * @author Yuzana Zaw Zaw
 */
public class AdminViewRecruiterListAction extends BaseAction {
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
		RecruiterForm myForm=(RecruiterForm) form;
		myForm.setSuccessMsg(null);
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		/*AdminForm loginForm = (AdminForm) request.getSession().getAttribute(
				"AdminLoginFormBean");
		//search by criteria
		if (request.getParameter("btnSearch") != null) {
			if(Integer.parseInt(myForm.getFrmStatusName())==0) {
				myRecruitersService.getFirstLoadRecruiterList(myForm,loginForm);
			}else if(!myForm.getFrmStatusName().equals("")){
				myRecruitersService.getLoadRecruiterListByStatus(myForm,loginForm);
			}	
		}*/
		return "gotoRecList";
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		RecruiterForm myForm=(RecruiterForm) form;
		myForm.setSuccessMsg(null);
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		AdminForm loginForm = (AdminForm) request.getSession().getAttribute(
				"AdminLoginFormBean");
		//getting recruiter list
		myRecruitersService.getFirstLoadRecruiterList(myForm,loginForm);
		return "gotoRecList";
	}

}
