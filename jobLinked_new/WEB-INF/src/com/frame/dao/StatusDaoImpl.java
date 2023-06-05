package com.frame.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.frame.business.entity.Status;

/**
*
* @author Yuzana Zaw Zaw
*/
public class StatusDaoImpl extends HibernateDaoSupport implements
StatusDao {
	
	public List<Status> getLoadStatusList() {
		String hql = "from Status";
		List<Status> l = getHibernateTemplate().find(hql);
		return l.isEmpty() || l == null ? null : l;
	}

	public Status searchStatusById(int parseInt) {
		String hql = "from Status i where i.Id=?";
		List l =  getHibernateTemplate()
				.find(hql, parseInt);
		return l.isEmpty() || l==null ? null: (Status)l.get(0);
	}

	public Status searchStatusByStatusName(String description) {
		String hql = "from Status i where i.Description=?";
		List l =  getHibernateTemplate()
				.find(hql, description);
		return l.isEmpty() || l==null ? null: (Status)l.get(0);
	}
}
