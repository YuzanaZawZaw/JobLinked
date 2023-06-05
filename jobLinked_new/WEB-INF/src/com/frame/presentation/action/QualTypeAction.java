package com.frame.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.frame.business.service.QualTypeService;
import com.frame.presentation.form.QualTypeForm;

/**
*
* @author Yuzana Zaw Zaw
*/
public class QualTypeAction extends BaseAction {
	private QualTypeService myQualTypeService;

	public QualTypeService getMyQualTypeService() {
		return myQualTypeService;
	}

	public void setMyQualTypeService(QualTypeService myQualTypeService) {
		this.myQualTypeService = myQualTypeService;
	}

	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		QualTypeForm myForm = (QualTypeForm) form;
		myForm.setSuccessMsg(null);
		myForm.setErrorMsg(null);
		if(myForm.getFrmQualTypeName().equals("")){
			myForm.setFrmQualTypeNameErr("Qualification Type Name is required!!");
			return "gotoQualType";
		}
		
		//create qualification type
		myQualTypeService.createQualType(myForm);
		myForm.setSuccessMsg("Successfully Created");
		//load againg qual type
		myQualTypeService.firstLoadQualTypeDisplayTag(myForm);
		return "gotoQualType";
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		QualTypeForm myForm = (QualTypeForm) form;
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		myForm.setFrmQualTypeNameErr(null);
		myForm.setSuccessMsg(null);
		myForm.setErrorMsg(null);
		//getting qualification types
		myQualTypeService.firstLoadQualTypeDisplayTag(myForm);
		return "gotoQualType";
		
	}

}
