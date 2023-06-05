package com.frame.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.frame.business.service.SkillTypeService;
import com.frame.presentation.form.SkillTypeForm;

/**
*
* @author Yuzana Zaw Zaw
*/
public class SkillTypeAction extends BaseAction {
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
		SkillTypeForm myForm = (SkillTypeForm) form;
		if (myForm.getFrmSkillTypeName().equals("")) {
			myForm.setSkillTypeNameErr("Skill Type Name is required!!");
			return "gotoSkillType";
		}
		myForm.setSkillTypeNameErr(null);
		myForm.setSuccessMsg(null);
		myForm.setErrorMsg(null);
		
		//saving skill type
		mySkillTypeService.createSkillType(myForm);
		myForm.setSuccessMsg("Successfully Created");
		//load again the skill types
		mySkillTypeService.firstLoadSkillTypeDisplayTag(myForm);
		return "gotoSkillType";
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		SkillTypeForm myForm = (SkillTypeForm) form;
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		myForm.setSkillTypeNameErr(null);
		myForm.setSuccessMsg(null);
		myForm.setErrorMsg(null);
		//first load skill type
		mySkillTypeService.firstLoadSkillTypeDisplayTag(myForm);
		return "gotoSkillType";
		
	}

}
