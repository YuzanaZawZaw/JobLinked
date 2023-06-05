package com.frame.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.frame.business.entity.Employee;
import com.frame.business.entity.PartyGroupPosition;
import com.frame.business.entity.Recruiters;
/**
*
* @author Yuzana Zaw Zaw
*/
public class RecruitersDaoImpl extends HibernateDaoSupport implements
		RecruitersDao {

	public void saveRecruiters(Recruiters recruiter) {
		getHibernateTemplate().saveOrUpdate(recruiter);
	}

	public Recruiters getRecruitersByEmail(String frmEmail) {
		String hql = "from Recruiters i where i.Email=?";
		List l = getHibernateTemplate().find(hql, frmEmail);
		return l.isEmpty() || l == null ? null : (Recruiters) l.get(0);
	}

	public Recruiters getRecruitersByEmailAndPassword(String frmLoginEmail,
			String frmLoginPassword) {
		String hql = "from Recruiters i where i.Email=? and i.Password=?";
		Object[] param = { frmLoginEmail, frmLoginPassword };
		List l = getHibernateTemplate().find(hql, param);

		return l.isEmpty() || l == null ? null : (Recruiters) l.get(0);
	}

	public Recruiters getRecruitersByEmailAndSecurityQ(
			String frmForgetPassEmail, String frmForgetPassSecurityQuest) {
		String hql = "from Recruiters i where i.Email=? and i.SecurityQest=?";
		Object[] param = { frmForgetPassEmail, frmForgetPassSecurityQuest };
		List l = getHibernateTemplate().find(hql, param);
		return l.isEmpty() || l == null ? null : (Recruiters) l.get(0);
	}

	public List<Recruiters> getAllRecruiterList() {
		String hql = "from Recruiters i";
		List<Recruiters> l = getHibernateTemplate().find(hql);
		return l.isEmpty()||l==null? null:l;
	}

	public List<Recruiters> getRecruiterListByStatus(int id) {
		String hql = "from Recruiters i where i.Status.Id=?";
		List<Recruiters> l = getHibernateTemplate().find(hql,id);
		return l.isEmpty()||l==null? null:l;
	}

	public Recruiters getRecruitersById(int id) {
		String hql = "from Recruiters i where i.Id=?";
		List l = getHibernateTemplate().find(hql, id);
		return l.isEmpty() || l == null ? null : (Recruiters) l.get(0);
	}

	public List<Recruiters> getRecruiterListByPosition(
			PartyGroupPosition partyGroupPosition) {
		String hql = "from Recruiters i where i.PartyGroupPosition=?";
		List<Recruiters> l = getHibernateTemplate().find(hql,partyGroupPosition);
		return l.isEmpty()||l==null? null:l;
	}

}
