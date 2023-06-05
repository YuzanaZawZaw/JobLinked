package com.frame.presentation.form;

import java.util.List;

import org.apache.struts.validator.ValidatorForm;

import com.frame.business.entity.Employee;
import com.frame.business.entity.JobPost;
import com.frame.business.entity.JobPostApply;
import com.frame.business.entity.JobPostQual;
import com.frame.business.entity.JobPostRequirement;
import com.frame.business.entity.PartyGroupPosition;
import com.frame.business.entity.Recruiters;
/**
*
* @author Yuzana Zaw Zaw
*/
public class JobPostListForm extends ValidatorForm {
	private String frmPositionName;
	private int frmTotalJobPost;
	private String frmJobPostId;
	private List<PartyGroupPosition> frmPositionList;
	private JobPost frmJobPost;
	private Recruiters frmRecruiter;
	private List<JobPostApply> frmJobPostAppliedList;
	private int totalAppliedJobPost;
	public int getTotalAppliedJobPost() {
		return totalAppliedJobPost;
	}

	public void setTotalAppliedJobPost(int totalAppliedJobPost) {
		this.totalAppliedJobPost = totalAppliedJobPost;
	}

	public List<JobPostApply> getFrmJobPostAppliedList() {
		return frmJobPostAppliedList;
	}

	public void setFrmJobPostAppliedList(List<JobPostApply> frmJobPostAppliedList) {
		this.frmJobPostAppliedList = frmJobPostAppliedList;
	}

	public Recruiters getFrmRecruiter() {
		return frmRecruiter;
	}

	public void setFrmRecruiter(Recruiters frmRecruiter) {
		this.frmRecruiter = frmRecruiter;
	}

	private List<JobPostQual> frmJobPostQualList;
	private List<JobPostRequirement> frmJobPostRequirementList;
	public List<JobPostRequirement> getFrmJobPostRequirementList() {
		return frmJobPostRequirementList;
	}

	public void setFrmJobPostRequirementList(
			List<JobPostRequirement> frmJobPostRequirementList) {
		this.frmJobPostRequirementList = frmJobPostRequirementList;
	}

	public List<JobPostQual> getFrmJobPostQualList() {
		return frmJobPostQualList;
	}

	public void setFrmJobPostQualList(List<JobPostQual> frmJobPostQualList) {
		this.frmJobPostQualList = frmJobPostQualList;
	}

	public JobPost getFrmJobPost() {
		return frmJobPost;
	}

	public void setFrmJobPost(JobPost frmJobPost) {
		this.frmJobPost = frmJobPost;
	}

	private String frmLocation;
	public String getFrmLocation() {
		return frmLocation;
	}

	public void setFrmLocation(String frmLocation) {
		this.frmLocation = frmLocation;
	}

	public List<PartyGroupPosition> getFrmPositionList() {
		return frmPositionList;
	}

	public void setFrmPositionList(List<PartyGroupPosition> frmPositionList) {
		this.frmPositionList = frmPositionList;
	}

	public String getFrmJobPostId() {
		return frmJobPostId;
	}

	public void setFrmJobPostId(String frmJobPostId) {
		this.frmJobPostId = frmJobPostId;
	}

	public int getFrmTotalJobPost() {
		return frmTotalJobPost;
	}

	public void setFrmTotalJobPost(int frmTotalJobPost) {
		this.frmTotalJobPost = frmTotalJobPost;
	}

	public String getFrmPositionName() {
		return frmPositionName;
	}

	public void setFrmPositionName(String frmPositionName) {
		this.frmPositionName = frmPositionName;
	}

	private Employee loginUser;

	public Employee getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(Employee loginUser) {
		this.loginUser = loginUser;
	}

	private List<JobPost> frmJobPostList;

	public List<JobPost> getFrmJobPostList() {
		return frmJobPostList;
	}

	public void setFrmJobPostList(List<JobPost> frmJobPostList) {
		this.frmJobPostList = frmJobPostList;
	}

	//success message
	private String successMsg;
	private String errorMsg;
	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getSuccessMsg() {
		return successMsg;
	}

	public void setSuccessMsg(String successMsg) {
		this.successMsg = successMsg;
	}
}
