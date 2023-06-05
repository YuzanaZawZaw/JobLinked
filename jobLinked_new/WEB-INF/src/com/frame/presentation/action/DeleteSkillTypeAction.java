package com.frame.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.frame.business.service.SkillTypeService;
import com.frame.presentation.form.SkillTypeForm;

/**
*
* @author Yuzana Zaw Zaw
*/
public class DeleteSkillTypeAction extends BaseAction {
	private SkillTypeService mySkillTypeService;
	

	public SkillTypeService getMySkillTypeService() {
		return mySkillTypeService;
	}

	public void setMySkillTypeService(SkillTypeService mySkillTypeService) {
		this.mySkillTypeService = mySkillTypeService;
	}

	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		return "gotoSkillType";
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		SkillTypeForm myForm = (SkillTypeForm) form;
		myForm.setSuccessMsg(null);
		myForm.setErrorMsg(null);
		myForm.setSkillTypeNameErr(null);
		int id=myForm.getSkillTypeId();
		mySkillTypeService.deleteSkillType(myForm,id);
		mySkillTypeService.firstLoadSkillTypeDisplayTag(myForm);
		return "gotoSkillType";
		
	}

}
