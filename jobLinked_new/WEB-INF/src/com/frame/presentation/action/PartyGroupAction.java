package com.frame.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.frame.business.service.PartyGroupService;
import com.frame.presentation.form.PartyGroupForm;

/**
*
* @author Yuzana Zaw Zaw
*/
public class PartyGroupAction extends BaseAction {
	private PartyGroupService myPartyGroupService;
	
	public PartyGroupService getMyPartyGroupService() {
		return myPartyGroupService;
	}

	public void setMyPartyGroupService(PartyGroupService myPartyGroupService) {
		this.myPartyGroupService = myPartyGroupService;
	}

	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		PartyGroupForm myForm = (PartyGroupForm) form;
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		if (myForm.getFrmCompanyName().equals("")) {
			myForm.setFrmCompanyNameErr("Company Name is required!!");
			return "gotoPartyGroup";
		}
		myForm.setErrorMsg(null);
		myForm.setSuccessMsg(null);
		myForm.setFrmCompanyNameErr(null);
		//create company
		myPartyGroupService.createPartyGroup(myForm);
		myForm.setSuccessMsg("Successfully Created");
		//load again company lists
		myPartyGroupService.firstLoadPartyGroupDisplayTag(myForm);
		return "gotoPartyGroup";
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		PartyGroupForm myForm = (PartyGroupForm) form;
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		myForm.setErrorMsg(null);
		myForm.setSuccessMsg(null);
		myForm.setFrmCompanyNameErr(null);
		//getting company list
		myPartyGroupService.firstLoadPartyGroupDisplayTag(myForm);
		return "gotoPartyGroup";
		
	}

}
