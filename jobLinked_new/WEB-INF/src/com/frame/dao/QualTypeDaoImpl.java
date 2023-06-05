package com.frame.dao;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.frame.business.entity.QualType;
/**
*
* @author Yuzana Zaw Zaw
*/
public class QualTypeDaoImpl extends HibernateDaoSupport implements
QualTypeDao {
	public void saveQualType(QualType qualType) {
		getHibernateTemplate().saveOrUpdate(qualType);
		
	}

	public List<QualType> getLoadQualTypeList() {
		String hql = "from QualType";
		List<QualType> l = getHibernateTemplate().find(hql);
		return l.isEmpty() || l == null ? null : l;
	}

	public void deleteQualType(QualType st) {
		getHibernateTemplate().bulkUpdate("delete from QualType i where i.id="+st.getId());
	}

	public QualType searchQualTypeById(String qualTypeId) {
		String hql="from QualType i where i.Id=?";
		QualType l=(QualType) getHibernateTemplate().find(hql,qualTypeId);
		return l==null? null:(QualType)l;
	}

	public QualType getQualTypeById(int parseInt) {
		String hql="from QualType i where i.Id=?";
		List l=getHibernateTemplate().find(hql,parseInt);
		return l.isEmpty()||l==null? null:(QualType)l.get(0);
	}
}
