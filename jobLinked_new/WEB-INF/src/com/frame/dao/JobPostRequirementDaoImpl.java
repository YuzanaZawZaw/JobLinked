package com.frame.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.frame.business.entity.JobPost;
import com.frame.business.entity.JobPostRequirement;
/**
*
* @author Yuzana Zaw Zaw
*/
public class JobPostRequirementDaoImpl extends HibernateDaoSupport implements
JobPostRequirementDao {

	public List<JobPostRequirement> getJobPostRequirementByJobPostId(
			JobPost myJobPost) {
		String hql = "from JobPostRequirement i where i.JobPost.Id=?";
		List<JobPostRequirement> l = getHibernateTemplate().find(hql,
				myJobPost.getId());
		return l.isEmpty() || l == null ? null : l;
	}

	public List<JobPostRequirement> getJobPostRequirementList() {
		String hql = "from JobPostRequirement";
		List<JobPostRequirement> l = getHibernateTemplate().find(hql);
		return l.isEmpty() || l == null ? null : l;
	}

	public void createJobPostRequirement(JobPostRequirement requirement) {
		getHibernateTemplate().saveOrUpdate(requirement);
		
	}

	public JobPostRequirement getJobPostRequirementById(
			int frmJobPostRequirementId) {
		String hql="from JobPostRequirement i where i.Id=?";
		List l= getHibernateTemplate().find(hql,frmJobPostRequirementId);
		return l==null? null:(JobPostRequirement)l.get(0);
	}

	public void deleteJobPostRequirement(JobPostRequirement req) {
		getHibernateTemplate().bulkUpdate("delete from JobPostRequirement i where i.Id="+req.getId());
	}

}
