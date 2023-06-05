package com.frame.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.frame.business.service.PartyGroupPositionService;
import com.frame.presentation.form.PartyGroupPositionForm;

/**
*
* @author Yuzana Zaw Zaw
*/
public class PartyGroupPositionAction extends BaseAction {
	private PartyGroupPositionService myPartyGroupPositionService;
	
	public PartyGroupPositionService getMyPartyGroupPositionService() {
		return myPartyGroupPositionService;
	}

	public void setMyPartyGroupPositionService(
			PartyGroupPositionService myPartyGroupPositionService) {
		this.myPartyGroupPositionService = myPartyGroupPositionService;
	}

	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		PartyGroupPositionForm myForm = (PartyGroupPositionForm) form;	
		myForm.setFrmCompanyNameErr(null);
		myForm.setFrmPositionNameErr(null);
		myForm.setFrmPositionTypeErr(null);
		myForm.setErrorMsg(null);
		myForm.setSuccessMsg(null);
		if(Integer.parseInt(myForm.getFrmCompanyName()) == 0){
			myForm.setFrmCompanyNameErr("Company Name is required!!");
			return "gotoPartyGroupPosition";
		}
		if(Integer.parseInt(myForm.getFrmPositionType())==0){
			myForm.setFrmPositionTypeErr("Position Type is required!!");
			return "gotoPartyGroupPosition";
		}
		if(myForm.getFrmPositionName().equals("")){
			myForm.setFrmPositionNameErr("Position Name is required!!");
			return "gotoPartyGroupPosition";
		}
		
		//create position
		myPartyGroupPositionService.createPartyGroupPosition(myForm);
		//load again positions
		myPartyGroupPositionService.firstLoadPartyGroupPositionDisplayTag(myForm);
		return "gotoPartyGroupPosition";
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		PartyGroupPositionForm myForm = (PartyGroupPositionForm) form;
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		myForm.setFrmCompanyNameErr(null);
		myForm.setFrmPositionNameErr(null);
		myForm.setFrmPositionTypeErr(null);
		myForm.setSuccessMsg(null);
		myForm.setErrorMsg(null);
		//first load positions 
		myPartyGroupPositionService.firstLoadPartyGroupPositionDisplayTag(myForm);
		myPartyGroupPositionService.firstLoadPartyGroupPosition(myForm);
		return "gotoPartyGroupPosition";
		
	}
}
