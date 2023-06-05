package com.frame.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.frame.business.service.EmployeeSkillService;
import com.frame.presentation.form.EmployeeForm;
import com.frame.presentation.form.EmployeeSkillForm;
/**
*
* @author Yuzana Zaw Zaw
*/
public class DeleteEmployeeSkillAction extends BaseAction {
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
		return "gotoEmpSkill";
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		EmployeeForm loginForm = (EmployeeForm) request.getSession().getAttribute(
		"EmpLoginFormBean");
		EmployeeSkillForm myForm = (EmployeeSkillForm) form;
		myForm.setFrmSkillLevelErr(null);
		myForm.setFrmSkillTypeNameErr(null);
		myForm.setSuccessMsg(null);
		myForm.setDeleteSuccessMsg(null);
		//delete employee's skill
		myEmployeeSkillService.deleteEmployeeSkill(myForm);
		myForm.setDeleteSuccessMsg("Successfully deleted!!");
		//getting employee skills
		myEmployeeSkillService.firstLoadEmployeeSkillDisplayTag(myForm, loginForm.getLoginUser());
		return "gotoEmpSkill";
		
	}
}
