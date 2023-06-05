package com.frame.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.frame.business.service.EmployeeQualService;
import com.frame.presentation.form.EmployeeForm;
import com.frame.presentation.form.EmployeeQualForm;
/**
*
* @author Yuzana Zaw Zaw
*/
public class EmployeeQualAction extends BaseAction {
	private EmployeeQualService myEmployeeQualService;

	public EmployeeQualService getMyEmployeeQualService() {
		return myEmployeeQualService;
	}

	public void setMyEmployeeQualService(
			EmployeeQualService myEmployeeQualService) {
		this.myEmployeeQualService = myEmployeeQualService;
	}

	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		EmployeeQualForm myForm = (EmployeeQualForm) form;
		EmployeeForm loginForm = (EmployeeForm) request.getSession()
		.getAttribute("EmpLoginFormBean");
		myForm.setDeleteSuccessMsg(null);
		myForm.setFrmDegreeErr(null);
		myForm.setFrmQualTypeNameErr(null);
		myForm.setFrmSchoolNameErr(null);
		myForm.setFrmFieldOfActivityErr(null);
		myForm.setFrmFieldOfStudyErr(null);
		myForm.setFrmFromDateErr(null);
		myForm.setFrmThruDateErr(null);
		myForm.setDeleteSuccessMsg(null);
		myForm.setSuccessMsg(null);
		myForm.setErrorMsg(null);
		if(request.getParameter("btnSave")!=null){
			if(Integer.parseInt(myForm.getFrmQualTypeName())==0){
				myForm.setFrmQualTypeNameErr("Qualification type name is required!!");
				return "gotoEmpQual";
			}
			if(myForm.getFrmSchoolName().equals("")){
				myForm.setFrmSchoolNameErr("School Name is required!!");
				return "gotoEmpQual";
			}
			if(myForm.getFrmDegree().equals("")){
				myForm.setFrmDegreeErr("Degree is required!!");
				return "gotoEmpQual";
			}
			if(myForm.getFrmFieldOfStudy().equals("")){
				myForm.setFrmFieldOfStudyErr("Field of study is required!!");
				return "gotoEmpQual";
			}
			if(myForm.getFrmFieldOfActivity().equals("")){
				myForm.setFrmFieldOfActivityErr("Field of activity is required!!");
				return "gotoEmpQual";
			}
			if(myForm.getFrmFromDate().equals("")){
				myForm.setFrmFromDateErr("Start date is required!!");
				return "gotoEmpQual";
			}
			if(myForm.getFrmThruDate().equals("")){
				myForm.setFrmThruDateErr("End date is required!!");
				return "gotoEmpQual";
			}
			myEmployeeQualService.createEmployeeQual(myForm,loginForm);
			myEmployeeQualService.firstLoadEmployeeQualDisplayTag(myForm,
					loginForm.getLoginUser());
		}
		return "gotoEmpQual";
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		EmployeeQualForm myForm = (EmployeeQualForm) form;
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";

		}
		EmployeeForm loginForm = (EmployeeForm) request.getSession()
				.getAttribute("EmpLoginFormBean");
		myForm.setDeleteSuccessMsg(null);
		myForm.setFrmDegreeErr(null);
		myForm.setFrmQualTypeNameErr(null);
		myForm.setFrmSchoolNameErr(null);
		myForm.setFrmFieldOfActivityErr(null);
		myForm.setFrmFieldOfStudyErr(null);
		myForm.setFrmFromDateErr(null);
		myForm.setFrmThruDateErr(null);
		myForm.setDeleteSuccessMsg(null);
		myForm.setSuccessMsg(null);
		myForm.setErrorMsg(null);
		myEmployeeQualService.firstLoadEmployeeQualDisplayTag(myForm,
				loginForm.getLoginUser());
		myEmployeeQualService.firstLoadQualType(myForm);
		return "gotoEmpQual";

	}

}
