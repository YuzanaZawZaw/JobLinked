package com.frame.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.frame.business.entity.Employee;
import com.frame.business.entity.EmployeeSkill;
import com.frame.business.entity.EmployeeSkillPK;
import com.frame.business.entity.SkillType;
/**
*
* @author Yuzana Zaw Zaw
*/
public class EmployeeSkillDaoImpl extends HibernateDaoSupport implements
		EmployeeSkillDao {

	public List<EmployeeSkill> getEmployeeSkillListAll(Employee loginUser) {
		String hql = "from EmployeeSkill i where i.Id.Employee=?";
		List<EmployeeSkill> l = getHibernateTemplate().find(hql,
				loginUser);
		return l.isEmpty() || l == null ? null : l;
	}
	
	public void deleteEmployeeSkill(EmployeeSkillPK empSkill) {
		String hql="delete from EmployeeSkill i where i.Id.Employee.Id=? " +
		"and i.Id.SkillType.Id=?";
		Object[] param = { empSkill.getEmployee().getId(), empSkill.getSkillType().getId() };
		getHibernateTemplate().bulkUpdate(hql, param);
		
	}

	public void saveEmployeeSkill(EmployeeSkill empSkill) {
		getHibernateTemplate().saveOrUpdate(empSkill);
		
	}

	public List<EmployeeSkill> getEmployeeSkillListAll(int skillTypeId) {
		String hql = "from EmployeeSkill i where i.Id.SkillType.Id=?";
		List<EmployeeSkill> l = getHibernateTemplate().find(hql,
				skillTypeId);
		return l.isEmpty() || l == null ? null : l;
	}

}
