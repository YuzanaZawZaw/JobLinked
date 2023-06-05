package com.frame.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.frame.business.service.RecruitersService;
import com.frame.presentation.form.RecruiterForm;

/**
*
* @author Yuzana Zaw Zaw
*/
public class RecruiterForgetPasswordAction extends BaseAction {
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
		// TODO Auto-generated method stub
	   RecruiterForm myForm=(RecruiterForm)form;
	   myForm.setForgetPassError(null);
	   myForm.setSuccessMsg(null);
	   
	   //checking security question
	   if(myForm.getFrmForgetPassEmail().equals("")){		
		   myForm.setForgetPassError("Email is required!!");
		   return "gotoForgetPass";
	   }
	   if(myForm.getFrmForgetPassSecurityQuest().equals("")){		
		   myForm.setForgetPassError("Security answer is required!!");
		   return "gotoForgetPass";
	   }
	   myRecruitersService.verifySecurityQuestion(myForm);
	   if(myForm.getLoginUser()==null)
	   { 
		   myForm.setForgetPassError("Your Email and Security Question are invalid!!");
		   return "gotoForgetPass";
	   }
	   else
	   {
		   request.getSession(true);
		   request.getSession().setAttribute("id", request.getSession().getId());
		   myForm.setSuccessMsg("Login Successfully!!");
		   myForm.setFrmForgetPassEmail("");
		   myForm.setFrmForgetPassSecurityQuest("");
		   return "gotoRecruiterModule";
	   }
		
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		RecruiterForm myForm=(RecruiterForm)form;
		myForm.setSuccessMsg(null);
		myForm.setForgetPassError(null);
		return "gotoForgetPass";
	}


}
