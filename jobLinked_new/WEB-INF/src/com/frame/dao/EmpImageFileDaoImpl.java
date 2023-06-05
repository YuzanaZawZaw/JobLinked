package com.frame.dao;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.frame.business.entity.EmpImageFile;
import com.frame.business.entity.EmployeePositionFulfillment;
/**
*
* @author Yuzana Zaw Zaw
*/
public class EmpImageFileDaoImpl extends HibernateDaoSupport implements EmpImageFileDao {

	public void saveNewEmployeeImage(EmpImageFile myFile) {
		getHibernateTemplate().saveOrUpdate(myFile);
	}

	public EmpImageFile getEmpImageFileById(Integer id) {
		String hql = "from EmpImageFile i where i.Employee.Id=?";
		List l = getHibernateTemplate().find(hql, id);
		return l.isEmpty()||l == null ? null : (EmpImageFile) l.get(0);
	}

	public void deleteEmpImageFile(Integer id) {
		String hql="delete from EmpImageFile i where i.Employee.Id=?";
		getHibernateTemplate().bulkUpdate(hql, id);
		
	}

	public List<EmpImageFile> getAllEmployeeImage() {
		String hql = "from EmpImageFile i";
		List<EmpImageFile> l = getHibernateTemplate().find(hql);
		return l.isEmpty() || l == null ? null : l;
	}
}
