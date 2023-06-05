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
public class DeleteQualTypeAction extends BaseAction {
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
		
		return "gotoQualType";
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		QualTypeForm myForm = (QualTypeForm) form;
		myForm.setErrorMsg(null);
		myForm.setSuccessMsg(null);
		myForm.setFrmQualTypeNameErr(null);
		int id=myForm.getQualTypeId();
		myQualTypeService.deleteQualType(myForm, id);
		myQualTypeService.firstLoadQualTypeDisplayTag(myForm);
		return "gotoQualType";
		
	}

}
