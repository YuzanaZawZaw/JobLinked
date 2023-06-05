package com.frame.business.service;

import java.util.Date;

import com.frame.business.entity.Employee;
import com.frame.business.entity.JobPost;
import com.frame.business.entity.JobPostApply;
import com.frame.business.entity.JobPostApplyPK;
import com.frame.dao.EmployeeDao;
import com.frame.dao.JobPostApplyDao;
import com.frame.dao.JobPostDao;
import com.frame.presentation.form.EmployeeForm;
import com.frame.presentation.form.JobPostListForm;

/**
 * 
 * @author Yuzana Zaw Zaw
 */
public class JobPostApplyService {
	private JobPostApplyDao myJobPostApplyDao;
	private EmployeeDao myEmployeeDao;
	private JobPostDao myJobPostDao;

	public JobPostDao getMyJobPostDao() {
		return myJobPostDao;
	}

	public void setMyJobPostDao(JobPostDao myJobPostDao) {
		this.myJobPostDao = myJobPostDao;
	}

	public EmployeeDao getMyEmployeeDao() {
		return myEmployeeDao;
	}

	public void setMyEmployeeDao(EmployeeDao myEmployeeDao) {
		this.myEmployeeDao = myEmployeeDao;
	}

	public JobPostApplyDao getMyJobPostApplyDao() {
		return myJobPostApplyDao;
	}

	public void setMyJobPostApplyDao(JobPostApplyDao myJobPostApplyDao) {
		this.myJobPostApplyDao = myJobPostApplyDao;
	}

	public void createJobPostApply(JobPostListForm myForm,
			EmployeeForm loginForm) {
		Employee employee = myEmployeeDao.getEmployeeById(loginForm
				.getLoginUser().getId());
		JobPost jobPost = myJobPostDao.getJobPostById(Integer.parseInt(myForm
				.getFrmJobPostId()));

		JobPostApply jobPostApply = new JobPostApply();
		JobPostApplyPK jobPostApplPk = new JobPostApplyPK();
		jobPostApplPk.setEmployee(employee);
		jobPostApplPk.setJobPost(jobPost);
		jobPostApply.setId(jobPostApplPk);
		jobPostApply.setFromDate(new Date());
		
		JobPostApply existJobPostApply=myJobPostApplyDao.getJobPostApplyByLoginUser(loginForm
				.getLoginUser().getId(),Integer.parseInt(myForm
				.getFrmJobPostId()));		
		if(existJobPostApply!=null){
			myForm.setErrorMsg("You have already applied!!");
		}else{
			myJobPostApplyDao.saveJobPostApply(jobPostApply);
			myForm.setSuccessMsg("Successfully applied!!");
		}
	}
}
