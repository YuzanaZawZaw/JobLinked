package com.frame.dao;

import java.util.List;

import com.frame.business.entity.Employee;
import com.frame.business.entity.JobPost;
import com.frame.business.entity.JobPostApply;
/**
*
* @author Yuzana Zaw Zaw
*/
public interface JobPostApplyDao {
	
	List<JobPostApply> getJobPostAppliedListByJobPostId(JobPost myJobPost);

	void saveJobPostApply(JobPostApply jobPostApply);

	JobPostApply getJobPostApplyByLoginUser(Integer id, int parseInt);

	List<JobPostApply> getJobPostApplyListByLoginUser(Employee loginUser);

}
