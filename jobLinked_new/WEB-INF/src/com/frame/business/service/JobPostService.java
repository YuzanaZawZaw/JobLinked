package com.frame.business.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.frame.business.entity.EmpImageFile;
import com.frame.business.entity.JobPost;
import com.frame.business.entity.JobPostApply;
import com.frame.business.entity.JobPostQual;
import com.frame.business.entity.JobPostRequirement;
import com.frame.business.entity.PartyGroup;
import com.frame.business.entity.PartyGroupPosition;
import com.frame.business.entity.QualType;
import com.frame.business.entity.Recruiters;
import com.frame.business.entity.Status;
import com.frame.dao.EmpImageFileDao;
import com.frame.dao.JobPostApplyDao;
import com.frame.dao.JobPostDao;
import com.frame.dao.JobPostQualDao;
import com.frame.dao.JobPostRequirementDao;
import com.frame.dao.PartyGroupDao;
import com.frame.dao.PartyGroupPositionDao;
import com.frame.dao.QualTypeDao;
import com.frame.dao.StatusDao;
import com.frame.presentation.form.EmployeeForm;
import com.frame.presentation.form.JobPostForm;
import com.frame.presentation.form.JobPostListForm;
import com.frame.presentation.form.JobPostQualForm;
import com.frame.presentation.form.JobPostRequirementForm;
import com.frame.presentation.form.RecruiterForm;

/**
 * 
 * @author Yuzana Zaw Zaw
 */
public class JobPostService {
	private JobPostDao myJobPostDao;
	private PartyGroupPositionDao myPartyGroupPositionDao;
	private StatusDao myStatusDao;
	private JobPostRequirementDao myJobPostReqDao;
	private QualTypeDao myQualTypeDao;
	private JobPostQualDao myJobPostQualDao;
	private JobPostApplyDao myJobPostApplyDao;
	private PartyGroupDao myPartyGroupDao;
	private EmpImageFileDao myEmpImageFileDao;
	public EmpImageFileDao getMyEmpImageFileDao() {
		return myEmpImageFileDao;
	}

	public void setMyEmpImageFileDao(EmpImageFileDao myEmpImageFileDao) {
		this.myEmpImageFileDao = myEmpImageFileDao;
	}

	public PartyGroupDao getMyPartyGroupDao() {
		return myPartyGroupDao;
	}

	public void setMyPartyGroupDao(PartyGroupDao myPartyGroupDao) {
		this.myPartyGroupDao = myPartyGroupDao;
	}

	public QualTypeDao getMyQualTypeDao() {
		return myQualTypeDao;
	}

	public void setMyQualTypeDao(QualTypeDao myQualTypeDao) {
		this.myQualTypeDao = myQualTypeDao;
	}

	public JobPostRequirementDao getMyJobPostReqDao() {
		return myJobPostReqDao;
	}

	public void setMyJobPostReqDao(JobPostRequirementDao myJobPostReqDao) {
		this.myJobPostReqDao = myJobPostReqDao;
	}

	public JobPostApplyDao getMyJobPostApplyDao() {
		return myJobPostApplyDao;
	}

	public void setMyJobPostApplyDao(JobPostApplyDao myJobPostApplyDao) {
		this.myJobPostApplyDao = myJobPostApplyDao;
	}

	public JobPostQualDao getMyJobPostQualDao() {
		return myJobPostQualDao;
	}

	public void setMyJobPostQualDao(JobPostQualDao myJobPostQualDao) {
		this.myJobPostQualDao = myJobPostQualDao;
	}

	public StatusDao getMyStatusDao() {
		return myStatusDao;
	}

	public void setMyStatusDao(StatusDao myStatusDao) {
		this.myStatusDao = myStatusDao;
	}

	public PartyGroupPositionDao getMyPartyGroupPositionDao() {
		return myPartyGroupPositionDao;
	}

	public void setMyPartyGroupPositionDao(
			PartyGroupPositionDao myPartyGroupPositionDao) {
		this.myPartyGroupPositionDao = myPartyGroupPositionDao;
	}

	public JobPostDao getMyJobPostDao() {
		return myJobPostDao;
	}

	public void setMyJobPostDao(JobPostDao myJobPostDao) {
		this.myJobPostDao = myJobPostDao;
	}

	public void firstLoadPositionList(JobPostForm myForm,
			RecruiterForm loginForm) {
		Recruiters myRec = loginForm.getLoginUser();
		PartyGroup partyGroup = myPartyGroupDao.searchPartyGroupById(myRec
				.getPartyGroupPosition().getPartyGroup().getId());// recruiter
																	// company
		List<PartyGroupPosition> positionList = myPartyGroupPositionDao
				.getLoadPartyGroupPositionList();// get all position list
		List<PartyGroupPosition> newPositionList = new ArrayList<PartyGroupPosition>();
		if (positionList != null) {
			for (PartyGroupPosition position : positionList) {
				// position list that equals the recruiter company and position
				// company
				if (position.getPartyGroup().getGroupNameLocal()
						.equals(partyGroup.getGroupNameLocal())) {
					newPositionList.add(position);
				}
			}
		}

		if (newPositionList != null) {
			myForm.setFrmPositionList(newPositionList);
		}
	}

	public void firstLoadStatusList(JobPostForm myForm, RecruiterForm loginForm) {
		List<Status> myStatus = myStatusDao.getLoadStatusList();
		if (myStatus != null) {
			myForm.setFrmStatusList(myStatus);
		}
	}

	public void createJobPost(JobPostForm myForm, RecruiterForm loginForm) {
		Recruiters recruiter = loginForm.getLoginUser();
		JobPost jobPost = new JobPost();
		PartyGroupPosition position = myPartyGroupPositionDao
				.searchPartyGroupPositionById(Integer.parseInt(myForm
						.getFrmPositionName()));
		Status status = myStatusDao.searchStatusById(Integer.parseInt(myForm
				.getFrmStatusName()));
		jobPost.setId(null);
		jobPost.setRecruiter(recruiter);
		jobPost.setPartyGroupPosition(position);
		jobPost.setStatus(status);
		jobPost.setLocation(myForm.getFrmLocation());
		jobPost.setEmploymentType(myForm.getFrmEmploymentType());
		jobPost.setSalary(myForm.getFrmSalary());

		SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
		Date fromDate;
		Date thruDate;
		try {
			if (myForm.getFrmFromDate() != null) {
				fromDate = myformat.parse(myForm.getFrmFromDate());
				java.sql.Date from_date = new java.sql.Date(fromDate.getTime());
				jobPost.setFromDate(from_date);
			}
			if (myForm.getFrmThruDate() != null) {
				thruDate = myformat.parse(myForm.getFrmThruDate());
				java.sql.Date thru_date = new java.sql.Date(thruDate.getTime());
				jobPost.setThruDate(thru_date);
			}

			myJobPostDao.createJobPost(jobPost);
			myForm.setFrmPositionName("");
			myForm.setFrmStatusName("");
			myForm.setFrmLocation("");
			myForm.setFrmEmploymentType("");
			myForm.setFrmSalary("");
			myForm.setFrmFromDate(null);
			myForm.setFrmThruDate(null);
		} catch (ParseException e) {

			e.printStackTrace();
		}
	}

	public void firstLoadJobPostListTag(JobPostForm myForm,
			Recruiters recruiters) {
		List<JobPost> jobPostList = myJobPostDao
				.getAllJobPostListByLoginUser(recruiters);
		if (jobPostList != null) {
			myForm.setFrmJobPostList(jobPostList);
		}

		myForm.setFrmPositionName("");
		myForm.setFrmStatusName("");
		myForm.setFrmLocation("");
		myForm.setFrmEmploymentType("");
		myForm.setFrmSalary("");
		myForm.setFrmFromDate(null);
		myForm.setFrmThruDate(null);

	}

	public void firstLoadUpdateProfile(JobPostForm myForm) {

		Recruiters myLoginUser = myForm.getLoginUser();
		JobPost myJobPost = myJobPostDao.getJobPostByLoginUserAndJobPostId(
				Integer.parseInt(myForm.getFrmJobPostId()), myLoginUser);
		myForm.setFrmStatusName(myJobPost.getStatus().getDescription());
		myForm.setFrmLocation(myJobPost.getLocation());
		myForm.setFrmEmploymentType(myJobPost.getEmploymentType());
		myForm.setFrmSalary(myJobPost.getSalary());
		myForm.setFrmPositionName(myJobPost.getPartyGroupPosition()
				.getPositionName());
		List<Status> myStatus = myStatusDao.getLoadStatusList();
		if (myStatus != null) {
			myForm.setFrmStatusList(myStatus);
		}
		SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
		if (myJobPost.getFromDate() != null) {
			String fromDate = myformat.format(myJobPost.getFromDate());
			myForm.setFrmFromDate(fromDate);
		}
		if (myJobPost.getThruDate() != null) {
			String thruDate = myformat.format(myJobPost.getThruDate());
			myForm.setFrmThruDate(thruDate);
		}
	}

	public void saveUpdateJobPost(JobPostForm myForm) {
		JobPost myJobPost = myJobPostDao.getJobPostByLoginUserAndJobPostId(
				Integer.parseInt(myForm.getFrmJobPostId()),
				myForm.getLoginUser());
		Status status = myStatusDao.searchStatusById(Integer.parseInt(myForm
				.getFrmStatusName()));
		PartyGroupPosition position = myPartyGroupPositionDao
				.searchPartyGroupPositionByName(myForm.getFrmPositionName());
		myJobPost.setRecruiter(myForm.getLoginUser());
		myJobPost.setStatus(status);
		myJobPost.setPartyGroupPosition(position);
		myJobPost.setLocation(myForm.getFrmLocation());
		myJobPost.setEmploymentType(myForm.getFrmEmploymentType());
		myJobPost.setSalary(myForm.getFrmSalary());

		SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
		Date fromDate;
		Date thruDate;
		try {
			if (myForm.getFrmFromDate() != null) {
				fromDate = myformat.parse(myForm.getFrmFromDate());
				java.sql.Date from_date = new java.sql.Date(fromDate.getTime());
				myJobPost.setFromDate(from_date);
			}
			if (myForm.getFrmThruDate() != null) {
				thruDate = myformat.parse(myForm.getFrmThruDate());

				java.sql.Date thru_date = new java.sql.Date(thruDate.getTime());

				myJobPost.setThruDate(thru_date);
			}

			myJobPostDao.createJobPost(myJobPost);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void firstLoadJobPostQual(JobPostForm myForm) {
		JobPost myJobPost = myJobPostDao.getJobPostByLoginUserAndJobPostId(
				Integer.parseInt(myForm.getFrmJobPostId()),
				myForm.getLoginUser());
		List<JobPostQual> qualification = myJobPostQualDao
				.getJobPostQualByJobPostId(myJobPost);
		if (qualification != null) {
			myForm.setFrmJobPostQualList(qualification);
		}
	}

	public void firstLoadJobPostRequirement(JobPostForm myForm) {

		JobPost myJobPost = myJobPostDao.getJobPostByLoginUserAndJobPostId(
				Integer.parseInt(myForm.getFrmJobPostId()),
				myForm.getLoginUser());
		List<JobPostRequirement> appliedList = myJobPostReqDao
				.getJobPostRequirementByJobPostId(myJobPost);

		myForm.setJobPostId(myJobPost.getId());
		if (appliedList != null) {
			myForm.setFrmJobPostRequirementList(appliedList);
		}

	}

	public void firstLoadJobPostAppliedEmployee(JobPostForm myForm) {
		JobPost myJobPost = myJobPostDao.getJobPostByLoginUserAndJobPostId(
				Integer.parseInt(myForm.getFrmJobPostId()),
				myForm.getLoginUser());
		List<JobPostApply> appliedList = myJobPostApplyDao
				.getJobPostAppliedListByJobPostId(myJobPost);
		if (appliedList != null) {
			myForm.setFrmJobPostAppliedEmployeeList(appliedList);
		}

	}

	public void deleteUpdateJobPostStatus(JobPostForm myForm) {
		JobPost myJobPost = myJobPostDao.getJobPostByLoginUserAndJobPostId(
				Integer.parseInt(myForm.getFrmJobPostId()),
				myForm.getLoginUser());
		Status status = myStatusDao.searchStatusByStatusName("INACTIVE");
		myJobPost.setStatus(status);
		myJobPostDao.createJobPost(myJobPost);
	}

	public void firstLoadJobPostRequirement(JobPostRequirementForm myForm,
			RecruiterForm loginForm) {
		JobPostForm jobPostForm = new JobPostForm();
		JobPost myJobPost = myJobPostDao.getJobPostByLoginUserAndJobPostId(
				Integer.parseInt(myForm.getFrmJobPostId()),
				loginForm.getLoginUser());
		List<JobPostRequirement> requList = myJobPostReqDao
				.getJobPostRequirementByJobPostId(myJobPost);
		jobPostForm.setJobPostId(myJobPost.getId());
		if (requList != null) {
			jobPostForm.setFrmJobPostRequirementList(requList);
		}
	}

	public void firstLoadJobPostQualTag(JobPostForm myForm,
			RecruiterForm loginForm) {
		JobPost myJobPost = myJobPostDao.getJobPostByLoginUserAndJobPostId(
				myForm.getJobPostId(), loginForm.getLoginUser());
		List<JobPostQual> qualification = myJobPostQualDao
				.getJobPostQualByJobPostId(myJobPost);
		if (qualification != null) {
			myForm.setFrmJobPostQualList(qualification);
		}

		List<QualType> qualType = myQualTypeDao.getLoadQualTypeList();
		if (qualType != null) {
			myForm.setFrmQualTypeList(qualType);
		}
	}

	public void viewJobPostProfile(JobPostForm myForm, RecruiterForm loginForm) {
		JobPost myJobPost = myJobPostDao.getJobPostByLoginUserAndJobPostId(
				Integer.parseInt(myForm.getFrmJobPostId()),
				loginForm.getLoginUser());
		List<QualType> qualTypeList=myQualTypeDao.getLoadQualTypeList();
		if(qualTypeList!=null){
			myForm.setQualList(qualTypeList);
		}
		List<JobPostQual> qualification = myJobPostQualDao
				.getJobPostQualByJobPostId(myJobPost);
		if (qualification != null) {
			myForm.setFrmJobPostQualList(qualification);
		}
		List<JobPostRequirement> requirementList = myJobPostReqDao
				.getJobPostRequirementByJobPostId(myJobPost);
		if (requirementList != null) {
			myForm.setFrmJobPostRequirementList(requirementList);
		}
		List<JobPostApply> appliedList = myJobPostApplyDao
				.getJobPostAppliedListByJobPostId(myJobPost);
		if (appliedList != null) {
			myForm.setFrmJobPostAppliedEmployeeList(appliedList);
		}
		List<EmpImageFile> imageFile=myEmpImageFileDao.getAllEmployeeImage();
		
		if(imageFile!=null){
			myForm.setFrmImageFileList(imageFile);
		}else{
			myForm.setFrmImageFileList(null);
		}
		

		myForm.setFrmPositionName(myJobPost.getPartyGroupPosition()
				.getPositionName());
		myForm.setFrmLocation(myJobPost.getLocation());
		myForm.setFrmEmploymentType(myJobPost.getEmploymentType());
		myForm.setFrmSalary(myJobPost.getSalary());

		SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
		if(myJobPost.getFromDate()!=null){
			String fromDate = myformat.format(myJobPost.getFromDate());
			myForm.setFrmFromDate(fromDate);
		}
		if(myJobPost.getThruDate()!=null){
			String thruDate = myformat.format(myJobPost.getThruDate());
			myForm.setFrmThruDate(thruDate);
		}
		myForm.setFrmStatusName(myJobPost.getStatus().getDescription());
		myForm.setFrmCompanyName(myJobPost.getPartyGroupPosition()
				.getPartyGroup().getGroupNameLocal());
		myForm.setFrmTotalEmployee(myJobPost.getPartyGroupPosition()
				.getPartyGroup().getTotalEmployee());
		myForm.setFrmRecruiterFirstName(myJobPost.getRecruiter().getFirstName());
		myForm.setFrmRecruiterLastName(myJobPost.getRecruiter().getLastName());
		myForm.setFrmRecruiterEmail(myJobPost.getRecruiter().getEmail());
		myForm.setFrmRecruiterPhone(myJobPost.getRecruiter().getPhoneNo());
	}

	public void viewActiveJobPostList(JobPostListForm myForm,
			EmployeeForm loginForm) {
		List<JobPost> jobPostList = myJobPostDao.getActiveJobPostList();
		if (jobPostList != null) {
			myForm.setFrmJobPostList(jobPostList);
			int listSize = jobPostList.size();
			myForm.setFrmTotalJobPost(listSize);
		} else {
			myForm.setFrmTotalJobPost(0);
			myForm.setFrmJobPostList(null);
		}
	}

	public void firstLoadPositionList(JobPostListForm myForm,
			EmployeeForm loginForm) {
		List<PartyGroupPosition> positionList = myPartyGroupPositionDao
				.getLoadPartyGroupPositionList();
		if (positionList != null) {
			myForm.setFrmPositionList(positionList);
		}
	}

	public void searchJobPostListByLocation(JobPostListForm myForm,
			EmployeeForm loginForm) {
		List<JobPost> positionList = myJobPostDao
				.getJobPostListByLocation(myForm.getFrmLocation());
		if (positionList != null) {
			myForm.setFrmJobPostList(positionList);
		} else {
			myForm.setFrmJobPostList(null);
		}
	}

	public void searchJobPostListByPosition(JobPostListForm myForm,
			EmployeeForm loginForm) {
		List<JobPost> positionList = myJobPostDao
				.getJobPostListByPosition(Integer.parseInt(myForm
						.getFrmPositionName()));
		if (positionList != null) {
			myForm.setFrmJobPostList(positionList);
		} else {
			myForm.setFrmJobPostList(null);
		}

	}

	public void searchJobPostListByLocationAndPosition(JobPostListForm myForm,
			EmployeeForm loginForm) {
		List<JobPost> positionList = myJobPostDao
				.getJobPostListByLocationAndPosition(myForm.getFrmLocation(),
						Integer.parseInt(myForm.getFrmPositionName()));
		if (positionList != null) {
			myForm.setFrmJobPostList(positionList);
		} else {
			myForm.setFrmJobPostList(null);
		}
	}

	public void empViewJobPostProfile(JobPostListForm myForm,
			EmployeeForm loginForm) {
		JobPost myJobPost = myJobPostDao.getJobPostById(Integer.parseInt(myForm
				.getFrmJobPostId()));
		Recruiters recruiter = myJobPost.getRecruiter();
		myForm.setFrmRecruiter(recruiter);
		myForm.setFrmJobPost(myJobPost);
		List<JobPostQual> qualification = myJobPostQualDao
				.getJobPostQualByJobPostId(myJobPost);
		if (qualification != null) {
			myForm.setFrmJobPostQualList(qualification);
		}
		List<JobPostRequirement> requirementList = myJobPostReqDao
				.getJobPostRequirementByJobPostId(myJobPost);

		if (requirementList != null) {
			myForm.setFrmJobPostRequirementList(requirementList);
		}

	}

	public void viewAppliedJobPostList(JobPostListForm myForm,
			EmployeeForm loginForm) {
		List<JobPostApply> appliedList = myJobPostApplyDao
				.getJobPostApplyListByLoginUser(loginForm.getLoginUser());
		List<JobPost> jobPostList = new ArrayList<JobPost>();
		if (appliedList != null) {
			for (JobPostApply apply : appliedList) {
				JobPost newJobPost = myJobPostDao.getJobPostById(apply.getId()
						.getJobPost().getId());
				jobPostList.add(newJobPost);
			}
			int totalApplied = appliedList.size();
			myForm.setTotalAppliedJobPost(totalApplied);
			myForm.setFrmJobPostList(jobPostList);
		}
	}

	public void firstLoadPositionList(RecruiterForm myForm) {
		List<PartyGroupPosition> positionList = myPartyGroupPositionDao
				.getLoadPartyGroupPositionList();
		myForm.setFrmPositionList(positionList);
	}

	public void firstLoadJobPostQual(JobPostQualForm myForm,
			RecruiterForm loginForm) {
		JobPostForm jobPostForm = new JobPostForm();
		JobPost myJobPost = myJobPostDao.getJobPostByLoginUserAndJobPostId(
				Integer.parseInt(myForm.getFrmJobPostId()),
				loginForm.getLoginUser());
		List<JobPostQual> jobPostQualList = myJobPostQualDao
				.getJobPostQualByJobPostId(myJobPost);
		jobPostForm.setJobPostId(myJobPost.getId());
		if (jobPostQualList != null) {
			jobPostForm.setFrmJobPostQualList(jobPostQualList);
		}

	}

	public void viewJobPostProfile(JobPostRequirementForm myForm,
			RecruiterForm loginForm) {
		JobPostForm jobPostForm = new JobPostForm();
		JobPost myJobPost = myJobPostDao.getJobPostByLoginUserAndJobPostId(
				Integer.parseInt(myForm.getFrmJobPostId()),
				loginForm.getLoginUser());
		
		List<JobPostQual> qualification = myJobPostQualDao
				.getJobPostQualByJobPostId(myJobPost);
		if (qualification != null) {
			jobPostForm.setFrmJobPostQualList(qualification);
		}
		List<JobPostRequirement> requirementList = myJobPostReqDao
				.getJobPostRequirementByJobPostId(myJobPost);
		if (requirementList != null) {
			jobPostForm.setFrmJobPostRequirementList(requirementList);
			for(JobPostRequirement req:requirementList){
				System.out.println("HELLO REQ:::"+req.getDescription());
			}		
		}
		List<JobPostApply> appliedList = myJobPostApplyDao
				.getJobPostAppliedListByJobPostId(myJobPost);
		if (appliedList != null) {
			jobPostForm.setFrmJobPostAppliedEmployeeList(appliedList);
		}

		jobPostForm.setFrmPositionName(myJobPost.getPartyGroupPosition()
				.getPositionName());
		jobPostForm.setFrmLocation(myJobPost.getLocation());
		jobPostForm.setFrmEmploymentType(myJobPost.getEmploymentType());
		jobPostForm.setFrmSalary(myJobPost.getSalary());

		SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
		if(myJobPost.getFromDate()!=null){
			String fromDate = myformat.format(myJobPost.getFromDate());
			jobPostForm.setFrmFromDate(fromDate);
		}
		if(myJobPost.getThruDate()!=null){
			String thruDate = myformat.format(myJobPost.getThruDate());
			jobPostForm.setFrmThruDate(thruDate);
		}
		
		jobPostForm.setFrmCompanyName(myJobPost.getPartyGroupPosition()
				.getPartyGroup().getGroupNameLocal());
		jobPostForm.setFrmTotalEmployee(myJobPost.getPartyGroupPosition()
				.getPartyGroup().getTotalEmployee());
		jobPostForm.setFrmRecruiterFirstName(myJobPost.getRecruiter().getFirstName());
		jobPostForm.setFrmRecruiterLastName(myJobPost.getRecruiter().getLastName());
		jobPostForm.setFrmRecruiterEmail(myJobPost.getRecruiter().getEmail());
		jobPostForm.setFrmRecruiterPhone(myJobPost.getRecruiter().getPhoneNo());
	}
}
