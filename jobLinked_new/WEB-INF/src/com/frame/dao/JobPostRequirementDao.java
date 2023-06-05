package com.frame.dao;

import java.util.List;

import com.frame.business.entity.JobPost;
import com.frame.business.entity.JobPostQual;
import com.frame.business.entity.JobPostRequirement;
/**
*
* @author Yuzana Zaw Zaw
*/
public interface JobPostRequirementDao {
	
	List<JobPostRequirement> getJobPostRequirementByJobPostId(JobPost myJobPost);

	List<JobPostRequirement> getJobPostRequirementList();

	void createJobPostRequirement(JobPostRequirement requirement);

	JobPostRequirement getJobPostRequirementById(int i);

	void deleteJobPostRequirement(JobPostRequirement req);


}
