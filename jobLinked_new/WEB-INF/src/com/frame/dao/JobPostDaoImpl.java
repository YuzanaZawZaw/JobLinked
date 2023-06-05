package com.frame.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.frame.business.entity.JobPost;
import com.frame.business.entity.Recruiters;
/**
*
* @author Yuzana Zaw Zaw
*/
public class JobPostDaoImpl extends HibernateDaoSupport implements
		JobPostDao {

	public List<JobPost> getAllJobPostListByLoginUser(Recruiters recruiters) {
		String hql = "from JobPost i where i.Recruiter.Id=?";
		List<JobPost> l = getHibernateTemplate().find(hql,
				recruiters.getId());
		return l.isEmpty() || l == null ? null : l;
	}

	public void createJobPost(JobPost jobPost) {
		getHibernateTemplate().saveOrUpdate(jobPost);
		
	}

	public JobPost getJobPostByLoginUserAndJobPostId(Integer frmJobPostId,
			Recruiters myLoginUser) {
		String hql = "from JobPost i where i.Id=? and i.Recruiter.Id=?";
		Object[] param = { frmJobPostId, myLoginUser.getId() };
		List l = getHibernateTemplate().find(hql, param);
		return l.isEmpty()||l == null ? null : (JobPost) l.get(0);
	}

	public List<JobPost> getActiveJobPostList() {
		String hql = "from JobPost i where i.Status.Description=?";
		List<JobPost> l = getHibernateTemplate().find(hql,"ACTIVE");
		return l.isEmpty() || l == null ? null : l;
	}

	public JobPost getJobPostById(int frmJobPostId) {
		String hql = "from JobPost i where i.Id=?";
		List l = getHibernateTemplate().find(hql, frmJobPostId);
		return l.isEmpty()||l == null ? null : (JobPost) l.get(0);
	}

	public List<JobPost> getJobPostListByPosition(int position) {
		String hql = "from JobPost i where i.Status.Id=? and i.PartyGroupPosition.Id=?";
		Object[] param = {9,position};
		List<JobPost> l = getHibernateTemplate().find(hql,param);
		return l.isEmpty() || l == null ? null : l;
	}

	public List<JobPost> getJobPostListByLocationAndPosition(
			String frmLocation, int position) {
		String hql = "from JobPost i where i.Status.Id=? and i.Location like ? and i.PartyGroupPosition.Id=?";
		Object[] param = { 9,frmLocation, position};
		List<JobPost> l = getHibernateTemplate().find(hql,param);
		return l.isEmpty() || l == null ? null : l;
	}

	public List<JobPost> getJobPostListByLocation(String frmLocation) {
		String hql = "from JobPost i where i.Status.Id=? and i.Location like ?";
		Object[] param = { 9,frmLocation};
		List<JobPost> l = getHibernateTemplate().find(hql,param);
		return l.isEmpty() || l == null ? null : l;
	}

	public List<JobPost> getJobPostListByPositionId(int partyGroupPositionId) {
		String hql = "from JobPost i where i.PartyGroupPosition.Id=?";
		List<JobPost> l = getHibernateTemplate().find(hql,partyGroupPositionId);
		return l.isEmpty() || l == null ? null : l;
	}

}
