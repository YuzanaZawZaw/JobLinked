package com.frame.dao;

import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.frame.business.entity.EmpImageFile;
import com.frame.business.entity.Employee;
import com.frame.business.entity.EmployeeQual;
/**
*
* @author Yuzana Zaw Zaw
*/
public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {

	public void saveEmployee(Employee empl) {
		getHibernateTemplate().saveOrUpdate(empl);
	}

	public Employee getEmployeeByEmail(String frmEmail) {
		String hql="from Employee i where i.Email=?";
		List l=getHibernateTemplate().find(hql, frmEmail);
		return l.isEmpty()||l==null? null:(Employee)l.get(0);
	}

	public Employee getEmployeeByEmailAndPassword(String frmEmail,
			String frmPassword) {
		String hql="from Employee i where i.Email=? and i.Password=?";
		Object[] param={frmEmail,frmPassword};
		List l=getHibernateTemplate().find(hql,param);
		return l.isEmpty() || l==null ? null: (Employee)l.get(0);
	}

	public Employee getEmployeeByEmailAndSecurityQ(String frmForgetPassEmail,
			String frmForgetPassSecurityQuest) {
		String hql = "from Employee i where i.Email=? and i.SecurityQest=?";
		Object[] param = { frmForgetPassEmail, frmForgetPassSecurityQuest };
		List l = getHibernateTemplate().find(hql, param);
		return l.isEmpty() || l == null ? null : (Employee) l.get(0);
	}

	public void saveUpdateEmployeePass(Employee myEmployee) {
		getHibernateTemplate().saveOrUpdate(myEmployee);
		
	}

	public List<EmployeeQual> getEmployeeQualByEmplId(Integer id) {
		String hql = "from EmployeeQual i where i.id=?";
		List<EmployeeQual> l = getHibernateTemplate().find(hql, id);
		return l.isEmpty()||l==null? null:l;
	}

	public void saveNewEmployeeImage(EmpImageFile myFile) {
		getHibernateTemplate().saveOrUpdate(myFile);
	}

	public Employee getEmployeeById(Integer id) {
		String hql = "from Employee i where i.Id=?";
		List l = getHibernateTemplate().find(hql, id);
		return l.isEmpty() || l == null ? null : (Employee) l.get(0);
	}

	public List<Employee> getAllEmployeeList() {
		String hql = "from Employee i";
		List<Employee> l = getHibernateTemplate().find(hql);
		return l.isEmpty()||l==null? null:l;
	}

	public List<Employee> getEmployeeListByStatus(int id) {
		String hql = "from Employee i where i.Status.Id=?";
		List<Employee> l = getHibernateTemplate().find(hql,id);
		return l.isEmpty()||l==null? null:l;
	}

}
