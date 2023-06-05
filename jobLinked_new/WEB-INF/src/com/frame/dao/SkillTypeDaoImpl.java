package com.frame.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.frame.business.entity.SkillType;
/**
*
* @author Yuzana Zaw Zaw
*/
public class SkillTypeDaoImpl extends HibernateDaoSupport implements
SkillTypeDao {

	public void saveSkillType(SkillType skillType) {
		getHibernateTemplate().saveOrUpdate(skillType);
	}

	public List<SkillType> getLoadSkillTypeList() {
		String hql = "from SkillType";
		List<SkillType> l = getHibernateTemplate().find(hql);
		return l.isEmpty() || l == null ? null : l;
	}

	public void deleteSkillType(SkillType st) {
		getHibernateTemplate().bulkUpdate("delete from SkillType i where i.id="+st.getId());
	}

	public SkillType searchSkillTypeById(String skillTypeId) {
		String hql="from SkillType i where i.Id=?";
		SkillType l=(SkillType) getHibernateTemplate().find(hql,skillTypeId);
		return l==null? null:(SkillType)l;
	}

	public SkillType getSkillTypeById(int frmSkillTypeId) {
		String hql="from SkillType i where i.Id=?";
		List l= getHibernateTemplate().find(hql,frmSkillTypeId);
		return l==null? null:(SkillType)l.get(0);
	}
}
