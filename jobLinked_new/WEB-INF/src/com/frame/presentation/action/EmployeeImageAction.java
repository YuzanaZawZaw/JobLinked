package com.frame.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.frame.business.service.EmpImageFileService;
import com.frame.presentation.form.EmpImageFileForm;
import com.frame.presentation.form.EmployeeForm;
/**
*
* @author Yuzana Zaw Zaw
*/
public class EmployeeImageAction extends BaseAction {
	private EmpImageFileService myEmpImageFileService;

	public EmpImageFileService getMyEmpImageFileService() {
		return myEmpImageFileService;
	}

	public void setMyEmpImageFileService(EmpImageFileService myEmpImageFileService) {
		this.myEmpImageFileService = myEmpImageFileService;
	}
	@Override
	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		EmpImageFileForm imageForm=(EmpImageFileForm)form;
		EmployeeForm loginForm = (EmployeeForm) request.getSession()
				.getAttribute("EmpLoginFormBean");
		imageForm.setLoginUser(loginForm.getLoginUser());
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		if (request.getParameter("btnUpload") != null) {
			//myEmpImageFileService.saveUploadImage(imageForm);
			return "gotoEmpProfile";
		}
		return null;
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		return null;
	}

}
