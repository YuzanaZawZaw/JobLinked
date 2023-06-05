package com.frame.presentation.action;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.frame.business.entity.EmpImageFile;
import com.frame.business.entity.Employee;
import com.frame.business.entity.JobPostApply;
import com.frame.business.service.JobPostService;
import com.frame.presentation.form.EmployeeForm;
import com.frame.presentation.form.EmployeeViewProfileForm;
import com.frame.presentation.form.JobPostForm;
import com.frame.presentation.form.JobPostQualForm;
import com.frame.presentation.form.JobPostRequirementForm;
import com.frame.presentation.form.MailForm;
import com.frame.presentation.form.RecruiterForm;

/**
 * 
 * @author Yuzana Zaw Zaw
 */
public class JobPostViewProfileAction extends BaseAction {
	private JobPostService myJobPostService;

	public JobPostService getMyJobPostService() {
		return myJobPostService;
	}

	public void setMyJobPostService(JobPostService myJobPostService) {
		this.myJobPostService = myJobPostService;
	}

	@Override
	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}		
		return "gotoViewJobPostProfile";
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		JobPostForm myForm = (JobPostForm) form;
		JobPostQualForm qualForm = (JobPostQualForm) request.getSession()
				.getAttribute("RecJobPostQualBean");
		JobPostRequirementForm reqForm = (JobPostRequirementForm) request
				.getSession().getAttribute("RecJobPostRequirementBean");
		MailForm mailForm = (MailForm) request
		.getSession().getAttribute("MailFormBean");
		EmployeeViewProfileForm cvForm = (EmployeeViewProfileForm) request
		.getSession().getAttribute("CVFormBean");
		
		myForm.setSuccessMsg(null);
		if(reqForm!=null){
			qualForm.setSuccessMsg(null);
			qualForm.setErrorMsg(null);
		}
		if(reqForm!=null){
			reqForm.setSuccessMsg(null);
			reqForm.setErrorMsg(null);
		} 
		if(mailForm!=null){
			mailForm.setFrmMailMessage(null);
			mailForm.setFrmMailFailMessage(null);
		}
		if(cvForm!=null){
			cvForm.setSuccessMsg(null);
			cvForm.setErrorMsg(null);
		}
		RecruiterForm loginForm = (RecruiterForm) request.getSession()
				.getAttribute("RecFormBean");
		// getting job post profile
		myJobPostService.viewJobPostProfile(myForm, loginForm);
		List<JobPostApply> newjobPostApplyList = new ArrayList<JobPostApply>();
		List<JobPostApply> jobPostApplyList = myForm
				.getFrmJobPostAppliedEmployeeList();

		if (jobPostApplyList != null) {
			List<EmpImageFile> imageList = myForm.getFrmImageFileList();
			for (JobPostApply emp : jobPostApplyList) {
				for (EmpImageFile image : imageList) {
					if (emp.getId().getEmployee().getEmail()
							.equals(image.getEmployee().getEmail())) {
						try {
							String filePath = getServlet().getServletContext()
									.getRealPath("")
									+ "/images/"
									+ image.getImageName();
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
						emp.setImagePath("images/" + image.getImageName());

					}
				}
				newjobPostApplyList.add(emp);
			}
			myForm.setFrmJobPostAppliedEmployeeList(newjobPostApplyList);
		}
		return "gotoViewJobPostProfile";
	}

}
