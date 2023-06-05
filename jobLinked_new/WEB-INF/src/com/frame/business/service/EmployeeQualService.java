package com.frame.business.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.frame.business.entity.Employee;
import com.frame.business.entity.EmployeeQual;
import com.frame.business.entity.EmployeeQualPK;
import com.frame.business.entity.QualType;
import com.frame.dao.EmployeeDao;
import com.frame.dao.EmployeeQualDao;
import com.frame.dao.QualTypeDao;
import com.frame.presentation.form.EmployeeForm;
import com.frame.presentation.form.EmployeeQualForm;
import com.frame.presentation.form.JobPostQualForm;

/**
*
* @author Yuzana Zaw Zaw
*/
public class EmployeeQualService {
	private EmployeeQualDao myEmployeeQualDao;
	private QualTypeDao myQualTypeDao;
	private EmployeeDao myEmployeeDao;

	public EmployeeDao getMyEmployeeDao() {
		return myEmployeeDao;
	}

	public void setMyEmployeeDao(EmployeeDao myEmployeeDao) {
		this.myEmployeeDao = myEmployeeDao;
	}

	public QualTypeDao getMyQualTypeDao() {
		return myQualTypeDao;
	}

	public void setMyQualTypeDao(QualTypeDao myQualTypeDao) {
		this.myQualTypeDao = myQualTypeDao;
	}

	public EmployeeQualDao getMyEmployeeQualDao() {
		return myEmployeeQualDao;
	}

	public void setMyEmployeeQualDao(EmployeeQualDao myEmployeeQualDao) {
		this.myEmployeeQualDao = myEmployeeQualDao;
	}

	public void firstLoadEmployeeQualDisplayTag(EmployeeQualForm myForm,
			Employee emp) {
		List<EmployeeQual> qualList = myEmployeeQualDao
				.getEmployeeQualListAll(emp);
		if(qualList!=null){
			myForm.setFrmDetailEmpQualList(qualList);
		}else{
			myForm.setFrmDetailEmpQualList(null);
		}
		myForm.setFrmQualTypeName("");
		myForm.setFrmDegree("");
		myForm.setFrmFieldOfActivity("");
		myForm.setFrmFieldOfStudy("");
		myForm.setFrmSchoolName("");
		myForm.setFrmFromDate("");
		myForm.setFrmThruDate("");
	}

	public void detailForEmployeeQualDisplayTag(EmployeeQualForm myForm) {
		EmployeeQual qual = myEmployeeQualDao.getEmployeeQualDetailById(myForm
				.getFrmDetailEmpQualId());
		myForm.setFrmDetailEmpQual(qual);
		myForm.setFrmQualTypeName("");
		myForm.setFrmDegree("");
		myForm.setFrmFieldOfActivity("");
		myForm.setFrmFieldOfStudy("");
		myForm.setFrmSchoolName("");
		myForm.setFrmFromDate("");
		myForm.setFrmThruDate("");

	}

	public void firstLoadQualType(EmployeeQualForm myForm) {
		List<QualType> l = myQualTypeDao.getLoadQualTypeList();
		if(l!=null){
			myForm.setFrmQualTypeList(l);
		}else{
			myForm.setFrmQualTypeList(null);
		}
	}

	public void deleteEmployeeQual(EmployeeQualForm myForm) {
		Employee emp = myEmployeeDao.getEmployeeById(myForm.getFrmEmployeeId());
		QualType qualType = myQualTypeDao.getQualTypeById(myForm
				.getFrmQualTypeId());

		EmployeeQual empQual = new EmployeeQual();
		EmployeeQualPK pk = new EmployeeQualPK();

		pk.setEmployee(emp);
		pk.setQualType(qualType);
		empQual.setId(pk);
		myEmployeeQualDao.deleteEmployeeQual(pk);

	}

	public void createEmployeeQual(EmployeeQualForm myForm,
			EmployeeForm loginForm) {
		Employee employee = loginForm.getLoginUser();
		EmployeeQual empQual = new EmployeeQual();
		QualType qualType = myQualTypeDao.getQualTypeById(Integer
				.parseInt(myForm.getFrmQualTypeName()));
		List<EmployeeQual> empQualList=myEmployeeQualDao.getEmployeeQualListeByQualType(qualType);
		if(empQualList!=null){
			myForm.setErrorMsg("This qualification type is already created!!");
		}else{
			EmployeeQualPK pk = new EmployeeQualPK();
			pk.setEmployee(employee);
			pk.setQualType(qualType);
			empQual.setId(pk);
			empQual.setDegree(myForm.getFrmDegree());
			empQual.setFieldOfActivity(myForm.getFrmFieldOfActivity());
			empQual.setFieldOfStudy(myForm.getFrmFieldOfStudy());
			empQual.setSchoolName(myForm.getFrmSchoolName());
			SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
			Date fromDate;
			Date thruDate;

			try {
				if(myForm.getFrmFromDate()!=null){
					fromDate = myformat.parse(myForm.getFrmFromDate());
					java.sql.Date from_date = new java.sql.Date(fromDate.getTime());
					empQual.setFromDate(from_date);
				}
				if(myForm.getFrmThruDate()!=null){
					thruDate = myformat.parse(myForm.getFrmThruDate());
					java.sql.Date thru_date = new java.sql.Date(thruDate.getTime());
					empQual.setThruDate(thru_date);
				}
				myEmployeeQualDao.saveEmployeeQual(empQual);
				myForm.setSuccessMsg("Successfully created!!");
				myForm.setFrmQualTypeName("");
				myForm.setFrmDegree("");
				myForm.setFrmFieldOfActivity("");
				myForm.setFrmFieldOfStudy("");
				myForm.setFrmSchoolName("");
				myForm.setFrmFromDate("");
				myForm.setFrmThruDate("");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void firstLoadQualType(JobPostQualForm myForm) {
		List<QualType> l = myQualTypeDao.getLoadQualTypeList();
		if(l!=null){
			myForm.setQualList(l);
		}else{
			myForm.setQualList(null);
		}
		
	}

}
