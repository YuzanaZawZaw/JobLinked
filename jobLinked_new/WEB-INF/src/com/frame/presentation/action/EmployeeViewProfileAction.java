package com.frame.presentation.action;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.frame.business.entity.EmpImageFile;
import com.frame.business.service.EmpImageFileService;
import com.frame.business.service.EmployeeService;
import com.frame.presentation.form.EmployeeForm;
import com.frame.presentation.form.EmployeeViewProfileForm;

/**
*
* @author Yuzana Zaw Zaw
*/
public class EmployeeViewProfileAction extends BaseAction {
	private EmployeeService myEmployeeService;
	private EmpImageFileService myEmpImageFileService;
	
	public EmpImageFileService getMyEmpImageFileService() {
		return myEmpImageFileService;
	}

	public void setMyEmpImageFileService(EmpImageFileService myEmpImageFileService) {
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
		return "gotoHome";
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		EmployeeViewProfileForm myForm = (EmployeeViewProfileForm) form;
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		EmployeeForm loginForm = (EmployeeForm) request.getSession()
		.getAttribute("EmpLoginFormBean");
		EmployeeForm updateForm = (EmployeeForm) request.getSession()
		.getAttribute("EmpUpdateFormBean");
		if(updateForm!=null){
			updateForm.setSuccessMsg(null);
		}
		EmpImageFile imageFile=null;
		if(myForm.getFrmEmployeeId()==0){
			myEmployeeService.viewProfileByLoginUser(myForm,loginForm);
			imageFile=myEmpImageFileService.retrieveEmployeeImage(myForm,loginForm);
		}else{
			myEmployeeService.viewProfileByEmployeeId(myForm,myForm.getFrmEmployeeId());
			myEmpImageFileService.retrieveEmployeeImage(myForm,myForm.getFrmEmployeeId());
		}
		if(imageFile!=null){
			try {
				String filePath = getServlet().getServletContext().getRealPath("")
						+ "/images/" + myForm.getImageFile().getImageName();
				if(!filePath.equals("")){
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
				myForm.setFrmViewImage("images/" + myForm.getImageFile().getImageName());
		}else{
			myForm.setFrmViewImage(null);
		}
		return "gotoEmpProfile";
	}

}
