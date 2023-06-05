package com.frame.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.frame.business.entity.Employee;
import com.frame.business.entity.EmployeeQual;
import com.frame.business.entity.EmployeeQualPK;
import com.frame.business.entity.QualType;
/**
*
* @author Yuzana Zaw Zaw
*/
public class EmployeeQualDaoImpl extends HibernateDaoSupport implements
		EmployeeQualDao {
	
	public List<EmployeeQual> getEmployeeQualListAll(Employee employee) {
		String hql="from EmployeeQual i where i.Id.Employee=?";
		List<EmployeeQual> l=getHibernateTemplate().find(hql,employee);
		return l.isEmpty()||l==null? null:l;
	}
	
	public QualType getEmployeeQualTypeById(QualType id) {
		String hql="from QualType i where i.Id=?";
		QualType l=(QualType) getHibernateTemplate().find(hql,id);
		return l==null? null:(QualType)l;
	}

	public EmployeeQual getEmployeeQualDetailById(String frmDetailEmpQualId) {
		String hql="from EmployeeQual i where i.Id.Employee=?";
		return null;
	}

	public void saveEmployeeQual(EmployeeQual empQual) {
		getHibernateTemplate().saveOrUpdate(empQual);		
	}

	public void deleteEmployeeQual(EmployeeQualPK pk) {
		String hql="delete from EmployeeQual i where i.Id.Employee.Id=? " +
		"and i.Id.QualType.Id=?";
		Object[] param = { pk.getEmployee().getId(), pk.getQualType().getId() };
		getHibernateTemplate().bulkUpdate(hql, param);
	}

	public List<EmployeeQual> getEmployeeQualListeByQualType(QualType qualType) {
		String hql="from EmployeeQual i where i.Id.QualType=?";
		List<EmployeeQual> l=getHibernateTemplate().find(hql,qualType);
		return l.isEmpty()||l==null? null:l;
	}
}
