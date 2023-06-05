package com.frame.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.frame.business.entity.Admin;
/**
*
* @author Yuzana Zaw Zaw
*/
public class AdminDaoImpl extends HibernateDaoSupport implements
		AdminDao {	
	
	public Admin getAdminByEmailAndPassword(String frmLoginEmail,
			String frmLoginPassword) {
		String hql = "from Admin i where i.Email=? and i.Password=?";
		Object[] param = { frmLoginEmail, frmLoginPassword };
		List l = getHibernateTemplate().find(hql, param);
		return l.isEmpty() || l == null ? null : (Admin) l.get(0);
	}

	public void saveAdmin(Admin myAdmin) {
		getHibernateTemplate().saveOrUpdate(myAdmin);
	}

}
