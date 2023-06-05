package com.frame.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.frame.business.entity.PartyGroupPositionType;

/**
*
* @author Yuzana Zaw Zaw
*/
public class PositionTypeDaoImpl extends HibernateDaoSupport implements
		PositionTypeDao {
	public void savePartyGroupPositionType(PartyGroupPositionType positionTypeId) {
		getHibernateTemplate().saveOrUpdate(positionTypeId);

	}

	public List<PartyGroupPositionType> getLoadPartyGroupPositionTypeList() {
		String hql = "from PartyGroupPositionType";
		List<PartyGroupPositionType> l = getHibernateTemplate().find(hql);
		return l.isEmpty() || l == null ? null : l;
	}

	public void deletePartyGroupPositionType(PartyGroupPositionType st) {
		getHibernateTemplate()
				.bulkUpdate(
						"delete from PartyGroupPositionType i where i.id="
								+ st.getId());

	}

	public PartyGroupPositionType searchPartyGroupPositionTypeById(
		 Integer positionTypeId) {
		String hql = "from PartyGroupPositionType i where i.Id=?";
		List l =  getHibernateTemplate()
				.find(hql, positionTypeId);
		return l.isEmpty() || l==null ? null: (PartyGroupPositionType)l.get(0);
	}
}
