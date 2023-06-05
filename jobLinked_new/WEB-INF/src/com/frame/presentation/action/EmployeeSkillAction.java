package com.frame.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.frame.business.service.EmployeeSkillService;
import com.frame.presentation.form.EmployeeForm;
import com.frame.presentation.form.EmployeeSkillForm;

/**
*
* @author Yuzana Zaw Zaw
*/
public class EmployeeSkillAction extends BaseAction {
	private EmployeeSkillService myEmployeeSkillService;
	

	public EmployeeSkillService getMyEmployeeSkillService() {
		return myEmployeeSkillService;
	}

	public void setMyEmployeeSkillService(
			EmployeeSkillService myEmployeeSkillService) {
		this.myEmployeeSkillService = myEmployeeSkillService;
	}

	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		EmployeeForm loginForm = (EmployeeForm) request.getSession()
		.getAttribute("EmpLoginFormBean");
		
		EmployeeSkillForm myForm = (EmployeeSkillForm) form;
		myForm.setSuccessMsg(null);
		myForm.setFrmSkillTypeNameErr(null);
		myForm.setFrmSkillLevelErr(null);
		myForm.setDeleteSuccessMsg(null);
		myForm.setErrorMsg(null);
		if(request.getParameter("btnSave")!=null){
			if(Integer.parseInt(myForm.getFrmSkillTypeName())==0){				
				myForm.setFrmSkillTypeNameErr("Skill Type Name is required!!");
				return "gotoEmpSkill";
			}
			if(myForm.getFrmSkillLevel().equals("")){				
				myForm.setFrmSkillLevelErr("Skill Level is required!!");
				return "gotoEmpSkill";
			}
			myEmployeeSkillService.createEmployeeSkill(myForm,loginForm);
			
			myEmployeeSkillService.firstLoadEmployeeSkillDisplayTag(myForm,loginForm.getLoginUser());
		}
		return "gotoEmpSkill";
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		EmployeeSkillForm myForm = (EmployeeSkillForm) form;
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		myForm.setSuccessMsg(null);
		myForm.setFrmSkillTypeNameErr(null);
		myForm.setFrmSkillLevelErr(null);
		myForm.setDeleteSuccessMsg(null);
		myForm.setErrorMsg(null);
		
		EmployeeForm loginForm = (EmployeeForm) request.getSession()
		.getAttribute("EmpLoginFormBean");
		myEmployeeSkillService.firstLoadEmployeeSkillDisplayTag(myForm,loginForm.getLoginUser());
		myEmployeeSkillService.firstLoadSkillType(myForm);
		return "gotoEmpSkill";
	}
}
