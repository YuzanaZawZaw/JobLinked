package com.frame.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.frame.business.service.PositionTypeService;
import com.frame.presentation.form.PositionTypeForm;

/**
*
* @author Yuzana Zaw Zaw
*/
public class PositionTypeAction extends BaseAction {
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
		PositionTypeForm myForm = (PositionTypeForm) form;
		if (myForm.getFrmPositionTypeName().equals("")) {
			myForm.setPositionTypeNameErr("Position Type Name is required!!");
			return "gotoPositionType";
		}
		
		myForm.setPositionTypeNameErr(null);
		myForm.setSuccessMsg(null);
		myForm.setErrorMsg(null);
		//create position type
		myPositionTypeService.createPartyGroupPositionType(myForm);
		myForm.setSuccessMsg("Successfully Created");
		//load again position types 
		myPositionTypeService.firstLoadPositionTypeDisplayTag(myForm);
		return "gotoPositionType";
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		PositionTypeForm myForm = (PositionTypeForm) form;
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		myForm.setPositionTypeNameErr(null);
		myForm.setSuccessMsg(null);
		myForm.setErrorMsg(null);
		//getting position types
		myPositionTypeService.firstLoadPositionTypeDisplayTag(myForm);
		return "gotoPositionType";
		
	}

}
