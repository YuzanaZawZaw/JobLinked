package com.frame.business.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.frame.business.entity.PartyGroupPosition;
import com.frame.business.entity.Recruiters;
import com.frame.business.entity.Status;
import com.frame.dao.PartyGroupPositionDao;
import com.frame.dao.RecruitersDao;
import com.frame.dao.StatusDao;
import com.frame.presentation.form.AdminForm;
import com.frame.presentation.form.RecruiterForm;

/**
 * 
 * @author Yuzana Zaw Zaw
 */
public class RecruitersService {
	private RecruitersDao myRecruitersDao;
	private StatusDao myStatusDao;
	private PartyGroupPositionDao myPartyGroupPositionDao;

	public PartyGroupPositionDao getMyPartyGroupPositionDao() {
		return myPartyGroupPositionDao;
	}

	public void setMyPartyGroupPositionDao(
			PartyGroupPositionDao myPartyGroupPositionDao) {
		this.myPartyGroupPositionDao = myPartyGroupPositionDao;
	}

	public StatusDao getMyStatusDao() {
		return myStatusDao;
	}

	public void setMyStatusDao(StatusDao myStatusDao) {
		this.myStatusDao = myStatusDao;
	}

	public RecruitersDao getMyRecruitersDao() {
		return myRecruitersDao;
	}

	public void setMyRecruitersDao(RecruitersDao myRecruitersDao) {
		this.myRecruitersDao = myRecruitersDao;
	}

	public void saveNewRecruiters(RecruiterForm myForm) {
		Recruiters recruiter = new Recruiters();
		recruiter.setId(null);
		recruiter.setFirstName(myForm.getFrmFirstName());
		recruiter.setLastName(myForm.getFrmLastName());
		recruiter.setEmail(myForm.getFrmEmail());
		recruiter.setPassword(myForm.getFrmPassword());
		recruiter.setPhoneNo(myForm.getFrmPhone());
		recruiter.setNrc(myForm.getFrmNrc());
		recruiter.setGender(myForm.getFrmGender());
		recruiter.setAddress(myForm.getFrmAddress());
		recruiter.setSecurityQest(myForm.getFrmSecurityQuest());
		Status status = myStatusDao.searchStatusByStatusName("ACTIVE");
		recruiter.setStatus(status);
		SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
		Date birthDate;
		try {
			if (!myForm.getFrmBirthDate().equals("")
					|| myForm.getFrmBirthDate() != null) {
				birthDate = myformat.parse(myForm.getFrmBirthDate());
				java.sql.Date birth_date = new java.sql.Date(
						birthDate.getTime());
				recruiter.setBirthDate(birth_date);
			}
			myRecruitersDao.saveRecruiters(recruiter);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public void firstLoadRegistration(RecruiterForm myForm) {
		myForm.setFrmFirstName("");
		myForm.setFrmLastName("");
		myForm.setFrmEmail("");
		myForm.setFrmPassword("");
		myForm.setFrmPhone("");
		myForm.setFrmNrc("");
		myForm.setFrmGender("");
		myForm.setFrmAddress("");
		myForm.setFrmSecurityQuest("");
		myForm.setFrmBirthDate(null);
		myForm.setFrmRegFormControl(null);
	}

	public void checkEmail(RecruiterForm myForm) {
		Recruiters myRecruiter = myRecruitersDao.getRecruitersByEmail(myForm
				.getFrmEmail());
		if (myRecruiter != null) {
			myForm.setFrmEmailError("error");
			myForm.setFrmRegFormControl(null);
		} else {
			myForm.setFrmEmailError("data");
			myForm.setFrmRegFormControl("data");
		}
	}

	public void checkLoginUser(RecruiterForm myForm) {
		Recruiters myRecruiter = myRecruitersDao
				.getRecruitersByEmailAndPassword(myForm.getFrmLoginEmail(),
						myForm.getFrmLoginPassword());
		myForm.setLoginUser(myRecruiter);
	}

	public void verifySecurityQuestion(RecruiterForm myForm) {
		Recruiters myRecruiter = myRecruitersDao
				.getRecruitersByEmailAndSecurityQ(
						myForm.getFrmForgetPassEmail(),
						myForm.getFrmForgetPassSecurityQuest());
		myForm.setLoginUser(myRecruiter);

	}

	public boolean checkLoginUser(String email, String frmChangeOldPassword) {
		Recruiters myRecruiter = myRecruitersDao
				.getRecruitersByEmailAndPassword(email, frmChangeOldPassword);
		if (myRecruiter == null) {
			return false;
		} else {
			return true;
		}
	}

	public void saveUpdateRecruiterPass(RecruiterForm myForm) {
		Recruiters myRecruiter = myForm.getLoginUser();
		myRecruiter.setPassword(myForm.getFrmChangeConfirmPassword());
		myRecruitersDao.saveRecruiters(myRecruiter);
		myForm.setFrmChangeOldPassword("");
		myForm.setFrmChangeNewPassword("");
		myForm.setFrmChangeConfirmPassword("");
	}

	public void firstLoadUpdateProfile(RecruiterForm myForm) {
		Recruiters recruiter = myForm.getLoginUser();
		if (recruiter.getPartyGroupPosition() != null) {
			PartyGroupPosition position = myPartyGroupPositionDao
					.searchPartyGroupPositionById(recruiter
							.getPartyGroupPosition().getId());
			if (position != null) {
				//System.out.println("position:::"+position.getPositionName());
				myForm.setFrmPositionName(position.getPositionName());
			}
		}
		List<PartyGroupPosition> positionList = myPartyGroupPositionDao
				.getLoadPartyGroupPositionList();
		if (positionList != null) {
			myForm.setFrmPositionList(positionList);
		}
		myForm.setFrmFirstName(recruiter.getFirstName());
		myForm.setFrmLastName(recruiter.getLastName());
		myForm.setFrmEmail(recruiter.getEmail());
		myForm.setFrmGender(recruiter.getGender());
		myForm.setFrmPhone(recruiter.getPhoneNo());
		myForm.setFrmNrc(recruiter.getNrc());
		myForm.setFrmAddress(recruiter.getAddress());
		if (!recruiter.getBirthDate().equals("")
				|| recruiter.getBirthDate() != null) {
			SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
			String birthDate = myformat.format(recruiter.getBirthDate());
			myForm.setFrmBirthDate(birthDate);
		}
	}

	public void saveUpdateRecruiterProfile(RecruiterForm myForm) {
		Recruiters recruiter = myForm.getLoginUser();
		if (!myForm.getFrmPositionName().equals("")) {
			PartyGroupPosition position = myPartyGroupPositionDao
					.searchPartyGroupPositionById(Integer.parseInt(myForm
							.getFrmPositionName()));
			if (position != null) {
				recruiter.setPartyGroupPosition(position);
			}
		}
		recruiter.setFirstName(myForm.getFrmFirstName());
		recruiter.setLastName(myForm.getFrmLastName());
		recruiter.setPhoneNo(myForm.getFrmPhone());
		recruiter.setGender(myForm.getFrmGender());
		recruiter.setAddress(myForm.getFrmAddress());
		SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
		Date birthDate;

		try {
			if (!myForm.getFrmBirthDate().equals("")
					|| myForm.getFrmBirthDate() != null) {
				birthDate = myformat.parse(myForm.getFrmBirthDate());
				java.sql.Date birth_date = new java.sql.Date(
						birthDate.getTime());
				recruiter.setBirthDate(birth_date);
				myRecruitersDao.saveRecruiters(recruiter);
			}

		} catch (ParseException e) {

			e.printStackTrace();
		}

	}

	public void getFirstLoadRecruiterList(RecruiterForm myForm,
			AdminForm loginForm) {
		List<Recruiters> recList = myRecruitersDao.getAllRecruiterList();
		if (recList != null) {
			myForm.setFrmRecruiterList(recList);
			int totalRec = recList.size();
			myForm.setFrmTotalRecruiter(totalRec);
		}
		List<Status> status = myStatusDao.getLoadStatusList();
		if(status!=null){
			myForm.setFrmStatusList(status);
		}
	}

	public void getLoadRecruiterListByStatus(RecruiterForm myForm,
			AdminForm loginForm) {
		List<Recruiters> recList = myRecruitersDao
				.getRecruiterListByStatus(Integer.parseInt(myForm
						.getFrmStatusName()));
		myForm.setFrmRecruiterList(recList);
		if (recList != null) {
			int totalRec = recList.size();
			myForm.setFrmTotalRecruiter(totalRec);
		}
	}

	public void deActivateRecAccount(RecruiterForm myForm, AdminForm loginForm) {
		Recruiters recruiter = myRecruitersDao.getRecruitersById(Integer
				.parseInt(myForm.getFrmRecruiterId()));
		Status status = myStatusDao.searchStatusByStatusName("INACTIVE");
		if (recruiter != null) {
			recruiter.setStatus(status);
			myRecruitersDao.saveRecruiters(recruiter);
		}
	}

	public void activateRecAccount(RecruiterForm myForm, AdminForm loginForm) {
		Recruiters recruiter = myRecruitersDao.getRecruitersById(Integer
				.parseInt(myForm.getFrmRecruiterId()));
		Status status = myStatusDao.searchStatusByStatusName("ACTIVE");
		if (recruiter != null) {
			recruiter.setStatus(status);
			myRecruitersDao.saveRecruiters(recruiter);
		}
	}
}
