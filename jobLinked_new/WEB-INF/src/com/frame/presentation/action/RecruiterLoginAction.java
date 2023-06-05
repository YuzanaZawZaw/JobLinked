package com.frame.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
public class RecruiterLoginAction extends BaseAction {
	private RecruitersService myRecruitersService;
	
	public RecruitersService getMyRecruitersService() {
		return myRecruitersService;
	}

	public void setMyRecruitersService(RecruitersService myRecruitersService) {
		this.myRecruitersService = myRecruitersService;
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		RecruiterForm myForm=(RecruiterForm)form;
		myForm.setFrmLoginEmail("");
		myForm.setFrmLoginPassword("");
		myForm.setLoginerror(null);
		myForm.setSuccessMsg(null);
		return "gotoLogin";
	}

	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		// TODO Auto-generated method stub
	   RecruiterForm myForm=(RecruiterForm)form;
	   myForm.setLoginerror(null);
	   myForm.setSuccessMsg(null);
	   //checking login user
	   myRecruitersService.checkLoginUser(myForm);
	   if(request.getParameter("btnLogin")!=null){
		   if(myForm.getFrmLoginEmail().equals("")){				  
			   myForm.setLoginerror("Email is required!!");
			   return "gotoLogin";
		   }
		   if(myForm.getFrmLoginPassword().equals("")){				   
			   myForm.setLoginerror("Password is required!!");
			   return "gotoLogin";
		   }
		   if(myForm.getLoginUser()==null)
		   { 		  
			   myForm.setLoginerror("Email and Password are mismatch!!");
			   return "gotoLogin";
		   }else if(myForm.getLoginUser().getStatus().getDescription().equals("INACTIVE")){		  
			   myForm.setLoginerror("You can't login to this web site, Your account is no longer active!!");
			   return "gotoLogin";
		   }
		   else
		   {
			   request.getSession(true);
			   request.getSession().setAttribute("id", request.getSession().getId());
			   myForm.setFrmLoginEmail("");
			   myForm.setFrmLoginPassword("");
			   myForm.setSuccessMsg("Login Successfully!!");
			   return "gotoRecModule";
		   }
	   }else{
		   return "gotoLogin";
	   }
	   
		
	}


}
