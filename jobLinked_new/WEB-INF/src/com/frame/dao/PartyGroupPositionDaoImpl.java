package com.frame.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.frame.business.entity.PartyGroup;
import com.frame.business.entity.PartyGroupPosition;
import com.frame.business.entity.PartyGroupPositionType;
/**
*
* @author Yuzana Zaw Zaw
*/
public class PartyGroupPositionDaoImpl extends HibernateDaoSupport implements
PartyGroupPositionDao {
	public void savePartyGroupPosition(PartyGroupPosition partyGroupPositionId) {
		getHibernateTemplate().saveOrUpdate(partyGroupPositionId);
	}
	public List<PartyGroupPosition> getLoadPartyGroupPositionList() {
		String hql = "from PartyGroupPosition i";
		List<PartyGroupPosition> l = getHibernateTemplate().find(hql);
		return l.isEmpty() || l == null ? null : l;
	}
	public void deletePartyGroupPosition(PartyGroupPosition st) {
		getHibernateTemplate().bulkUpdate("delete from PartyGroupPosition i where i.id="+st.getId());
	}
	public PartyGroupPosition searchPartyGroupPositionById(Integer partyGroupPositionId) {
		String hql="from PartyGroupPosition i where i.Id=?";
		List l= getHibernateTemplate().find(hql,partyGroupPositionId);
		return l==null? null:(PartyGroupPosition)l.get(0);
	}
	public PartyGroupPosition searchPartyGroupPositionByName(String string) {
		String hql="from PartyGroupPosition i where i.PositionName=?";
		List l= getHibernateTemplate().find(hql,string);
		return l==null? null:(PartyGroupPosition)l.get(0);
	}
	public List<PartyGroupPosition> getLoadPositionListByRecCompany(Integer id) {
		String hql = "from PartyGroupPosition i where i.PartyGroup.Id";
		List<PartyGroupPosition> l = getHibernateTemplate().find(hql,id);
		return l.isEmpty() || l == null ? null : l;
	}
	public List<PartyGroupPosition> getPartyGroupPositionListByPositionType(
			PartyGroupPositionType positionType) {
		String hql = "from PartyGroupPosition i where i.PartyGroupPositionType=?";
		List<PartyGroupPosition> l = getHibernateTemplate().find(hql,positionType);
		return l.isEmpty() || l == null ? null : l;
	}
	
	public List<PartyGroupPosition> getPartyGroupPositionListByPartyGroup(
			PartyGroup partyGroup) {
		String hql = "from PartyGroupPosition i where i.PartyGroup=?";
		List<PartyGroupPosition> l = getHibernateTemplate().find(hql,partyGroup);
		return l.isEmpty() || l == null ? null : l;
	}
	
	public PartyGroupPosition getPositionByPositionTypeAndCompanyName(
			PartyGroupPositionType positionType, PartyGroup partyGroup) {
		String hql="from PartyGroupPosition i where i.PartyGroupPositionType=? and i.PartyGroup=?";
		Object[] param = { positionType, partyGroup };
		List l= getHibernateTemplate().find(hql,param);
		return l.isEmpty() || l == null ? null:(PartyGroupPosition)l.get(0);
	}
}
