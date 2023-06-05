package com.frame.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.frame.business.entity.Employee;
import com.frame.business.entity.JobPost;
import com.frame.business.entity.JobPostApply;
/**
*
* @author Yuzana Zaw Zaw
*/
public class JobPostApplyDaoImpl extends HibernateDaoSupport implements
JobPostApplyDao {
	
	public List<JobPostApply> getJobPostAppliedListByJobPostId(JobPost myJobPost) {
		String hql = "from JobPostApply i where i.Id.JobPost=?";
		List<JobPostApply> l = getHibernateTemplate().find(hql,
				myJobPost);
		return l.isEmpty() || l == null ? null : l;
	}

	public void saveJobPostApply(JobPostApply jobPostApply) {
		getHibernateTemplate().saveOrUpdate(jobPostApply);
		
	}

	public JobPostApply getJobPostApplyByLoginUser(Integer id,
			int frmJobPostId) {
		String hql="from JobPostApply i where i.Id.Employee.Id=?" +
		"and i.Id.JobPost.Id=?";
		Object[] param = {id ,frmJobPostId};
		List<JobPostApply> l = getHibernateTemplate().find(hql,param);
		return l.isEmpty()|| l==null? null:l.get(0);
	}

	public List<JobPostApply> getJobPostApplyListByLoginUser(Employee loginUser) {
		String hql = "from JobPostApply i where i.Id.Employee=?";
		List<JobPostApply> l = getHibernateTemplate().find(hql,
				loginUser);
		return l.isEmpty() || l == null ? null : l;
	}

}
