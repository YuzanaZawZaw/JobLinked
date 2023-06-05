package com.frame.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.frame.business.service.PartyGroupPositionService;
import com.frame.presentation.form.PartyGroupForm;
import com.frame.presentation.form.PartyGroupPositionForm;
/**
*
* @author Yuzana Zaw Zaw
*/
public class DeletePartyGroupPositionAction extends BaseAction {
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
		return "gotoPartyGroupPosition";
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		PartyGroupPositionForm myForm = (PartyGroupPositionForm) form;
		myForm.setFrmCompanyNameErr(null);
		myForm.setFrmPositionNameErr(null);
		myForm.setFrmPositionTypeErr(null);
		myForm.setSuccessMsg(null);
		myForm.setErrorMsg(null);
		int id=myForm.getPartyGroupPositionId();
		myPartyGroupPositionService.deletePartyGroupPosition(myForm, id);
		myPartyGroupPositionService.firstLoadPartyGroupPositionDisplayTag(myForm);
		return "gotoPartyGroupPosition";
		
	}

}
