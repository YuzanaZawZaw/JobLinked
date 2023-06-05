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
public class DeletePartyGroupAction extends BaseAction {
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
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		return "gotoPartyGroup";
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		PartyGroupForm myForm = (PartyGroupForm) form;
		myForm.setErrorMsg(null);
		myForm.setSuccessMsg(null);
		myForm.setFrmCompanyNameErr(null);
		int id=myForm.getPartyGroupId();
		myPartyGroupService.deletePartyGroup(myForm, id);
		myPartyGroupService.firstLoadPartyGroupDisplayTag(myForm);
		return "gotoPartyGroup";
		
	}

}
