package com.frame.presentation.action;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.frame.business.entity.EmpImageFile;
import com.frame.business.service.EmpImageFileService;
import com.frame.business.service.EmployeeService;
import com.frame.presentation.form.EmployeeForm;

/**
 * 
 * @author Yuzana Zaw Zaw
 */
public class EmployeeLoginAction extends BaseAction {
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
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		EmployeeForm myForm = (EmployeeForm) form;
		myForm.setLoginerror(null);
		myForm.setFrmLoginEmail("");
		myForm.setFrmLoginPassword("");
		myForm.setSuccessMsg(null);
		return "gotoLogin";
	}

	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		// TODO Auto-generated method stub
		EmployeeForm myForm = (EmployeeForm) form;
		myForm.setLoginerror(null);
		myForm.setFrmViewImage(null);
		myForm.setSuccessMsg(null);
		EmployeeForm regForm = (EmployeeForm) request.getSession()
		.getAttribute("EmpRegFormBean");
		if(regForm!=null){
			regForm.setSuccessMsg(null);
		}
		
		if (myForm.getFrmLoginEmail().equals("")) {
			myForm.setLoginerror("Email is required!!");
			return "gotoLogin";
		}
		if (myForm.getFrmLoginPassword().equals("")) {
			myForm.setLoginerror("Password is required!!");
			return "gotoLogin";
		}
		myEmployeeService.checkLoginUser(myForm);
		if (myForm.getLoginUser() == null) {
			myForm.setLoginerror("Email and password are mismatch!!");
			return "gotoLogin";
		} else if (myForm.getLoginUser().getStatus().getDescription()
				.equals("INACTIVE")) {
			myForm.setLoginerror("You can't login to this web site, Your account is no longer active!!");
			return "gotoLogin";
		} else {
			
			request.getSession(true);
			request.getSession().setAttribute("id",
					request.getSession().getId());
			myForm.setSuccessMsg("Login Successfully!!");
			EmpImageFile imageFile=null;
			imageFile=myEmpImageFileService.retrieveEmployeeImage(myForm);
			if (imageFile != null) {
				try {
					String filePath = getServlet().getServletContext()
							.getRealPath("")
							+ "/images/"
							+ myForm.getImageFile().getImageName();
					if (!filePath.equals("")) {
						BufferedOutputStream outStream = new BufferedOutputStream(
								new FileOutputStream(filePath));
						InputStream in = myForm.getImageFile().getImageData()
								.getBinaryStream();
						byte[] buffer = new byte[1000];
						int n = 0;
						while ((n = in.read(buffer)) != -1) {
							outStream.write(buffer, 0, n);
						}
						in.close();
						outStream.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				myForm.setFrmViewImage("images/"
						+ myForm.getImageFile().getImageName());
			} else {
				myForm.setFrmViewImage(null);
			}
			
			return "gotoEmplModule";
		}

	}

}
