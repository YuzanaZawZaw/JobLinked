package com.frame.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.frame.business.entity.JobPost;
import com.frame.business.entity.JobPostQual;
import com.frame.business.entity.QualType;
/**
*
* @author Yuzana Zaw Zaw
*/
public class JobPostQualDaoImpl extends HibernateDaoSupport implements
JobPostQualDao {
	public List<JobPostQual> getJobPostQualByJobPostId(JobPost myJobPost) {
		String hql = "from JobPostQual i where i.JobPost=?";
		List<JobPostQual> l = getHibernateTemplate().find(hql,
				myJobPost);
		return l.isEmpty() || l == null ? null : l;
	}

	public void createJobPostQual(JobPostQual qualification) {
		getHibernateTemplate().saveOrUpdate(qualification);
	}

	public void deleteJobPostQual(JobPostQual qualification) {
		getHibernateTemplate().bulkUpdate("delete from JobPostQual i where i.id="+qualification.getId());
		
	}

	public List<JobPostQual> getJobPostQualByQualType(QualType qualType) {
		String hql = "from JobPostQual i where i.QualType=?";
		List<JobPostQual> l = getHibernateTemplate().find(hql,
				qualType);
		return l.isEmpty() || l == null ? null : l;
	}

}
