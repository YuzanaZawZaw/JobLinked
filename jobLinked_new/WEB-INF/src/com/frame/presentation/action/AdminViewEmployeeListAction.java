package com.frame.presentation.action;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.frame.business.entity.EmpImageFile;
import com.frame.business.entity.Employee;
import com.frame.business.entity.Status;
import com.frame.business.service.AdminService;
import com.frame.business.service.EmployeeService;
import com.frame.presentation.form.AdminForm;
import com.frame.presentation.form.EmployeeForm;

/**
 * 
 * @author Yuzana Zaw Zaw
 */
public class AdminViewEmployeeListAction extends BaseAction {
	private EmployeeService myEmployeeService;
	
	public EmployeeService getMyEmployeeService() {
		return myEmployeeService;
	}

	public void setMyEmployeeService(EmployeeService myEmployeeService) {
		this.myEmployeeService = myEmployeeService;
	}

	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		EmployeeForm myForm=(EmployeeForm) form;
		myForm.setSuccessMsg(null);
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		/*AdminForm loginForm = (AdminForm) request.getSession().getAttribute(
				"AdminLoginFormBean");
		List<Employee> newEmpList=new ArrayList<Employee>();
		//search by criteria
		if (request.getParameter("btnSearch") != null) {
			if(Integer.parseInt(myForm.getFrmStatusName())==0) {
				myEmployeeService.getFirstLoadEmployeeList(myForm,loginForm);
				List<Employee> empList=myForm.getEmployeeList();
				List<EmpImageFile> imageList=myForm.getFrmImageFileList();
				if(empList!=null){
					for(Employee emp:empList){
						for(EmpImageFile image:imageList){
							if(emp.getEmail().equals(image.getEmployee().getEmail())){
								try {
									String filePath = getServlet().getServletContext().getRealPath(
											"")
											+ "/images/" + image.getImageName();
									BufferedOutputStream outStream = new BufferedOutputStream(
											new FileOutputStream(filePath));
									InputStream in = image.getImageData()
											.getBinaryStream();
									byte[] buffer = new byte[1000];
									int n = 0;
									while ((n = in.read(buffer)) != -1) {
										outStream.write(buffer, 0, n);
									}
									in.close();
									outStream.close();
								} catch (Exception e) {
									e.printStackTrace();
								}
								emp.setImagePath("images/"
										+ image.getImageName());
							}
						}
						newEmpList.add(emp);
					}
				}
				myForm.setEmployeeList(newEmpList);
			}else if(!myForm.getFrmStatusName().equals("")){
				myEmployeeService.getLoadEmployeeListByStatus(myForm,loginForm);
				List<Employee> empList=myForm.getEmployeeList();
				List<EmpImageFile> imageList=myForm.getFrmImageFileList();
				if(empList!=null){
					for(Employee emp:empList){
						for(EmpImageFile image:imageList){
							if(emp.getEmail().equals(image.getEmployee().getEmail())){
								try {
									String filePath = getServlet().getServletContext().getRealPath(
											"")
											+ "/images/" + image.getImageName();
									BufferedOutputStream outStream = new BufferedOutputStream(
											new FileOutputStream(filePath));
									InputStream in = image.getImageData()
											.getBinaryStream();
									byte[] buffer = new byte[1000];
									int n = 0;
									while ((n = in.read(buffer)) != -1) {
										outStream.write(buffer, 0, n);
									}
									in.close();
									outStream.close();
								} catch (Exception e) {
									e.printStackTrace();
								}
								emp.setImagePath("images/"
										+ image.getImageName());
							}
						}
						newEmpList.add(emp);
					}
				}
				myForm.setEmployeeList(newEmpList);
			}	
		}*/
		return "gotoEmpList";
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		EmployeeForm myForm=(EmployeeForm) form;
		myForm.setSuccessMsg(null);
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		AdminForm loginForm = (AdminForm) request.getSession().getAttribute(
				"AdminLoginFormBean");
		List<Employee> newEmpList=new ArrayList<Employee>();
		
		//getting employee list
		myEmployeeService.getFirstLoadEmployeeList(myForm,loginForm);
		List<Employee> empList=myForm.getEmployeeList();
		List<EmpImageFile> imageList=myForm.getFrmImageFileList();
		if(empList!=null){
			for(Employee emp:empList){
				for(EmpImageFile image:imageList){
					if(emp.getEmail().equals(image.getEmployee().getEmail())){
						try {
							String filePath = getServlet().getServletContext().getRealPath(
									"")
									+ "/images/" + image.getImageName();
							BufferedOutputStream outStream = new BufferedOutputStream(
									new FileOutputStream(filePath));
							InputStream in = image.getImageData()
									.getBinaryStream();
							byte[] buffer = new byte[1000];
							int n = 0;
							while ((n = in.read(buffer)) != -1) {
								outStream.write(buffer, 0, n);
							}
							in.close();
							outStream.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
						emp.setImagePath("images/"
								+ image.getImageName());
					}
				}
				newEmpList.add(emp);
			}
		}
		myForm.setEmployeeList(newEmpList);
		return "gotoEmpList";
	}

}
