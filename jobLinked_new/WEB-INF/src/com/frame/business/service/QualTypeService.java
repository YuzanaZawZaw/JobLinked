package com.frame.business.service;
import java.util.List;

import com.frame.business.entity.EmployeeQual;
import com.frame.business.entity.JobPostQual;
import com.frame.business.entity.QualType;
import com.frame.dao.EmployeeQualDao;
import com.frame.dao.JobPostQualDao;
import com.frame.dao.QualTypeDao;
import com.frame.presentation.form.JobPostQualForm;
import com.frame.presentation.form.QualTypeForm;
import com.frame.presentation.form.RecruiterForm;

/**
*
* @author Yuzana Zaw Zaw
*/
public class QualTypeService {
	private QualTypeDao myQualTypeDao;
	private EmployeeQualDao myEmployeeQualDao;
	private JobPostQualDao myJobPostQualDao;

	public JobPostQualDao getMyJobPostQualDao() {
		return myJobPostQualDao;
	}


	public void setMyJobPostQualDao(JobPostQualDao myJobPostQualDao) {
		this.myJobPostQualDao = myJobPostQualDao;
	}


	public EmployeeQualDao getMyEmployeeQualDao() {
		return myEmployeeQualDao;
	}


	public void setMyEmployeeQualDao(EmployeeQualDao myEmployeeQualDao) {
		this.myEmployeeQualDao = myEmployeeQualDao;
	}


	public QualTypeDao getMyQualTypeDao() {
		return myQualTypeDao;
	}


	public void setMyQualTypeDao(QualTypeDao myQualTypeDao) {
		this.myQualTypeDao = myQualTypeDao;
	}


	public void createQualType(QualTypeForm myForm) 
	{
		QualType qualType=new QualType();
		qualType.setId(null);
		qualType.setDescription(myForm.getFrmQualTypeName());
		myQualTypeDao.saveQualType(qualType);
		myForm.setFrmQualTypeName("");
	}


	public void firstLoadQualTypeDisplayTag(QualTypeForm myForm) {
		List<QualType> l=myQualTypeDao.getLoadQualTypeList();
		if(l!=null){
			myForm.setFrmQualTypeList(l);
		}
		
	}

	public void deleteQualType(QualTypeForm myForm,int qualTypeId) {
		QualType qualType=myQualTypeDao.getQualTypeById(qualTypeId);
		List<EmployeeQual> empQualList=myEmployeeQualDao.getEmployeeQualListeByQualType(qualType);
		List<JobPostQual> jobPostQualList=myJobPostQualDao.getJobPostQualByQualType(qualType);
		if(empQualList!=null || jobPostQualList!=null){
			myForm.setErrorMsg("You can't delete this qual type "+qualType.getDescription()+" is used in employee qualification or job post qualification!!");
		}else{
			QualType st=new QualType();
			st.setId(myForm.getQualTypeId());
			myQualTypeDao.deleteQualType(st);
			myForm.setSuccessMsg("Successfully deleted!!");
		}
	}

	public void firstLoadQualTypeDisplayTag(JobPostQualForm myForm) {
		List<QualType> l=myQualTypeDao.getLoadQualTypeList();
		if(l!=null){
			myForm.setQualList(l);
		}
	}
	
}
