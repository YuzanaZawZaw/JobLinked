package com.frame.business.service;

import java.util.List;

import com.frame.business.entity.JobPost;
import com.frame.business.entity.JobPostQual;
import com.frame.business.entity.QualType;
import com.frame.dao.JobPostDao;
import com.frame.dao.JobPostQualDao;
import com.frame.dao.QualTypeDao;
import com.frame.presentation.form.JobPostForm;
import com.frame.presentation.form.JobPostQualForm;
import com.frame.presentation.form.RecruiterForm;

/**
*
* @author Yuzana Zaw Zaw
*/
public class JobPostQualService {
	private JobPostDao myJobPostDao;
	private QualTypeDao myQualTypeDao;
	private JobPostQualDao myJobPostQualDao;

	public JobPostQualDao getMyJobPostQualDao() {
		return myJobPostQualDao;
	}

	public void setMyJobPostQualDao(JobPostQualDao myJobPostQualDao) {
		this.myJobPostQualDao = myJobPostQualDao;
	}

	public QualTypeDao getMyQualTypeDao() {
		return myQualTypeDao;
	}

	public void setMyQualTypeDao(QualTypeDao myQualTypeDao) {
		this.myQualTypeDao = myQualTypeDao;
	}

	public JobPostDao getMyJobPostDao() {
		return myJobPostDao;
	}

	public void setMyJobPostDao(JobPostDao myJobPostDao) {
		this.myJobPostDao = myJobPostDao;
	}

	public void createJobPostQual(JobPostQualForm myForm,
			RecruiterForm loginForm) {
		JobPost myJobPost=myJobPostDao.getJobPostByLoginUserAndJobPostId(Integer.parseInt(myForm.getFrmJobPostId()),loginForm.getLoginUser());
		QualType myQualType=myQualTypeDao.getQualTypeById(Integer.parseInt(myForm.getFrmQualType()));
		JobPostQual qualification=new JobPostQual();
		qualification.setId(null);
		qualification.setJobPost(myJobPost);
		qualification.setQualType(myQualType);
		qualification.setDescription(myForm.getFrmDescription());
		myJobPostQualDao.createJobPostQual(qualification);
		myForm.setFrmDescription("");
		myForm.setFrmQualType("");
		
	}

	public void deleteJobPostQual(JobPostForm myForm, int id) {
		JobPostQual qualification=new JobPostQual();
		qualification.setId(id);
		myJobPostQualDao.deleteJobPostQual(qualification);
	}
}
