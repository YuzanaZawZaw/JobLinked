package com.frame.business.service;

import java.util.List;

import com.frame.business.entity.JobPost;
import com.frame.business.entity.JobPostRequirement;
import com.frame.dao.JobPostDao;
import com.frame.dao.JobPostRequirementDao;
import com.frame.presentation.form.JobPostForm;
import com.frame.presentation.form.JobPostRequirementForm;
import com.frame.presentation.form.RecruiterForm;
/**
*
* @author Yuzana Zaw Zaw
*/
public class JobPostRequirementService {
	private JobPostRequirementDao myJobPostReqDao;
	private JobPostDao myJobPostDao;

	public JobPostDao getMyJobPostDao() {
		return myJobPostDao;
	}

	public void setMyJobPostDao(JobPostDao myJobPostDao) {
		this.myJobPostDao = myJobPostDao;
	}

	public JobPostRequirementDao getMyJobPostReqDao() {
		return myJobPostReqDao;
	}

	public void setMyJobPostReqDao(JobPostRequirementDao myJobPostReqDao) {
		this.myJobPostReqDao = myJobPostReqDao;
	}

	public void createJobPostRequirement(JobPostRequirementForm myForm,
			RecruiterForm loginForm) {
		JobPost myJobPost=myJobPostDao.getJobPostByLoginUserAndJobPostId(Integer.parseInt(myForm.getFrmJobPostId()),loginForm.getLoginUser());
		JobPostRequirement requirement=new JobPostRequirement();
		requirement.setId(null);
		requirement.setJobPost(myJobPost);
		requirement.setDescription(myForm.getFrmDescription());
		myJobPostReqDao.createJobPostRequirement(requirement);
		myForm.setFrmDescription("");
	}

	public void deleteJobPostRequirement(JobPostForm myForm,
			RecruiterForm loginForm) {
		JobPostRequirement req=myJobPostReqDao.getJobPostRequirementById(Integer.parseInt(myForm.getFrmJobPostRequirementId()));
		myJobPostReqDao.deleteJobPostRequirement(req);
	}

	public void firstLoadJobPostRequirement(JobPostRequirementForm myForm,
			RecruiterForm loginForm) {
		JobPost myJobPost=myJobPostDao.getJobPostByLoginUserAndJobPostId(Integer.parseInt(myForm.getFrmJobPostId()),loginForm.getLoginUser());
		List<JobPostRequirement> reqList=myJobPostReqDao.getJobPostRequirementByJobPostId(myJobPost);
		if(reqList!=null){
			myForm.setFrmJobPostRequirementList(reqList);
		}
	}
}
