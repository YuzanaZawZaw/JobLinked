package com.frame.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.frame.business.service.PositionTypeService;
import com.frame.presentation.form.PositionTypeForm;
import com.frame.presentation.form.SkillTypeForm;
/**
*
* @author Yuzana Zaw Zaw
*/

public class DeletePositionTypeAction extends BaseAction {
	private PositionTypeService myPositionTypeService;
	

	public PositionTypeService getMyPositionTypeService() {
		return myPositionTypeService;
	}

	public void setMyPositionTypeService(PositionTypeService myPositionTypeService) {
		this.myPositionTypeService = myPositionTypeService;
	}

	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		
		return "gotoAdminModule";
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		
		PositionTypeForm myForm = (PositionTypeForm) form;
		myForm.setSuccessMsg(null);
		myForm.setErrorMsg(null);
		myForm.setPositionTypeNameErr(null);
		int id=myForm.getPositionTypeId();
		myPositionTypeService.deletePartyGroupPositionType(myForm, id);
		myPositionTypeService.firstLoadPositionTypeDisplayTag(myForm);
		return "gotoPositionType";
		
	}

}
