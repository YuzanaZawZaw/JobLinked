package com.frame.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.frame.business.entity.PartyGroup;
/**
*
* @author Yuzana Zaw Zaw
*/
public class PartyGroupDaoImpl extends HibernateDaoSupport implements
		PartyGroupDao {

	public void savePartyGroup(PartyGroup partyGroup) {
		getHibernateTemplate().saveOrUpdate(partyGroup);

	}

	public List<PartyGroup> getLoadPartyGroupList() {
		String hql = "from PartyGroup";
		List<PartyGroup> l = getHibernateTemplate().find(hql);
		return l.isEmpty() || l == null ? null : l;
	}

	public void deletePartyGroup(PartyGroup st) {
		getHibernateTemplate().bulkUpdate(
				"delete from PartyGroup i where i.id=" + st.getId());

	}

	public PartyGroup searchPartyGroupById(Integer partyGroupId) {
		String hql = "from PartyGroup i where i.Id=?";
		List l =  getHibernateTemplate()
		.find(hql, partyGroupId);
		return l.isEmpty() || l==null ? null: (PartyGroup)l.get(0);
	}
}
