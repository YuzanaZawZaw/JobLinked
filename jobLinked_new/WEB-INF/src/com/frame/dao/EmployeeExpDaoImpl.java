package com.frame.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.frame.business.entity.Employee;
import com.frame.business.entity.EmployeePositionFulfillment;
import com.frame.business.entity.EmployeePositionFulfillmentPK;
import com.frame.business.entity.PartyGroupPosition;
/**
*
* @author Yuzana Zaw Zaw
*/
public class EmployeeExpDaoImpl extends HibernateDaoSupport implements
		EmployeeExpDao {

	public List<EmployeePositionFulfillment> getEmployeeExpListAll(Employee emp) {
		String hql = "from EmployeePositionFulfillment i where i.Id.Employee=? order by i.ThruDate";
		List<EmployeePositionFulfillment> l = getHibernateTemplate().find(hql,
				emp);
		return l.isEmpty() || l == null ? null : l;
	}

	public EmployeePositionFulfillment getCurrentPositionByLoginUser(
			Employee loginUser) {
		String hql = "from EmployeePositionFulfillment i where i.Id.Employee=? and i.CurrentRole=?";
		Object[] param = { loginUser, "1" };
		List l = getHibernateTemplate().find(hql, param);
		return l.isEmpty()||l == null ? null : (EmployeePositionFulfillment) l.get(0);
	}

	public void saveEmployeeExperience(EmployeePositionFulfillment empPosition) {
		getHibernateTemplate().saveOrUpdate(empPosition);
	}

	public void deleteEmployeeExperience(EmployeePositionFulfillmentPK pk) {
		String hql="delete from EmployeePositionFulfillment i where i.Id.Employee.Id=? " +
		"and i.Id.PartyGroupPosition.Id=?";
		Object[] param = { pk.getEmployee().getId(), pk.getPartyGroupPosition().getId() };
		getHibernateTemplate().bulkUpdate(hql, param);
		
	}

	public List<EmployeePositionFulfillment> getEmployeeExpListByPosition(
			PartyGroupPosition partyGroupPosition) {
		String hql = "from EmployeePositionFulfillment i where i.Id.PartyGroupPosition=? order by i.ThruDate";
		List<EmployeePositionFulfillment> l = getHibernateTemplate().find(hql,
				partyGroupPosition);
		return l.isEmpty() || l == null ? null : l;
	}

	public List<EmployeePositionFulfillment> getExpListByPositionAndEmploymentType(
			PartyGroupPosition partyGroupPosition, String frmEmploymentType) {
		String hql = "from EmployeePositionFulfillment i where i.Id.PartyGroupPosition=? and i.EmploymentType=? order by i.ThruDate";
		Object[] param = { partyGroupPosition, frmEmploymentType };
		List<EmployeePositionFulfillment> l = getHibernateTemplate().find(hql,
				param);
		return l.isEmpty() || l == null ? null : l;
	}

	public List<EmployeePositionFulfillment> getExpListByPositionAndEmploymentTypeAndStartDate(
			PartyGroupPosition partyGroupPosition, String frmEmploymentType,
			Date frmFromDate) {
		String hql = "from EmployeePositionFulfillment i where i.Id.PartyGroupPosition=? and i.EmploymentType=? " +
				"and i.FromDate=? order by i.ThruDate";
		Object[] param = { partyGroupPosition, frmEmploymentType,frmFromDate };
		List<EmployeePositionFulfillment> l = getHibernateTemplate().find(hql,
				param);
		return l.isEmpty() || l == null ? null : l;
	}

}
