package com.frame.presentation.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.frame.business.service.EmpImageFileService;
import com.frame.business.service.EmployeeService;
import com.frame.presentation.form.EmployeeViewProfileForm;
import com.frame.presentation.form.RecruiterForm;
/**
*
* @author Yuzana Zaw Zaw
*/
public class EmployeeCVDownloadAction extends BaseAction {

	private EmployeeService myEmployeeService;
	private EmpImageFileService myEmpImageFileService;

	public EmpImageFileService getMyEmpImageFileService() {
		return myEmpImageFileService;
	}

	public void setMyEmpImageFileService(
			EmpImageFileService myEmpImageFileService) {
		this.myEmpImageFileService = myEmpImageFileService;
	}

	public EmployeeService getMyEmployeeService() {
		return myEmployeeService;
	}

	public void setMyEmployeeService(EmployeeService myEmployeeService) {
		this.myEmployeeService = myEmployeeService;
	}

	@Override
	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		return "gotoCV";
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		//file path for cv download
		String FILE_NAME = getServlet().getServletContext().getRealPath("")
				+ "/output/";
		//for job seeker profile image path
		String IMAGE_FILE_NAME ="";

		EmployeeViewProfileForm myForm = (EmployeeViewProfileForm) form;
		myForm.setSuccessMsg(null);
		myForm.setErrorMsg(null);
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}

		//getting job seeker profile image
		myEmpImageFileService.retrieveEmployeeImage(myForm,myForm.getFrmEmployeeId());
		if(myForm.getImageFile()!=null){
			//setting image file path
			IMAGE_FILE_NAME = getServlet().getServletContext().getRealPath("")
			+ "/images/" + myForm.getImageFile().getImageName();
			//calling cv download service
			myEmployeeService.employeeCVDownload(myForm,FILE_NAME,IMAGE_FILE_NAME);
		}else{
			//calling cv download service
			myEmployeeService.employeeCVDownloadWithoutImage(myForm,FILE_NAME);
		}
		return "gotoCV";
	}

}
