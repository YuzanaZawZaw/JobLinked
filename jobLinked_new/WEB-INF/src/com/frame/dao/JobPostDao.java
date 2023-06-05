package com.frame.dao;

import java.util.List;
import com.frame.business.entity.JobPost;
import com.frame.business.entity.Recruiters;
/**
*
* @author Yuzana Zaw Zaw
*/
public interface JobPostDao {
	List<JobPost> getAllJobPostListByLoginUser(Recruiters recruiters);

	void createJobPost(JobPost jobPost);

	JobPost getJobPostByLoginUserAndJobPostId(Integer frmJobPostId,
			Recruiters myLoginUser);

	List<JobPost> getActiveJobPostList();

	JobPost getJobPostById(int frmJobPostId);

	List<JobPost> getJobPostListByPosition(int position);

	List<JobPost> getJobPostListByLocationAndPosition(
			String frmLocation, int position);

	List<JobPost> getJobPostListByLocation(String frmLocation);

	List<JobPost> getJobPostListByPositionId(int partyGroupPositionId);

	
}
