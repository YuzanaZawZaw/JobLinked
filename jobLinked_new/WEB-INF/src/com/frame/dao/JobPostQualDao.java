package com.frame.dao;

import java.util.List;

import com.frame.business.entity.JobPost;
import com.frame.business.entity.JobPostQual;
import com.frame.business.entity.QualType;

/**
*
* @author Yuzana Zaw Zaw
*/
public interface JobPostQualDao {

	List<JobPostQual> getJobPostQualByJobPostId(JobPost myJobPost);

	void createJobPostQual(JobPostQual qualification);

	void deleteJobPostQual(JobPostQual qualification);

	List<JobPostQual> getJobPostQualByQualType(QualType qualType);

	
}
