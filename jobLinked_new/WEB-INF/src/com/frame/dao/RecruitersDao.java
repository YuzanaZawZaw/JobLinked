package com.frame.dao;

import java.util.List;

import com.frame.business.entity.PartyGroupPosition;
import com.frame.business.entity.Recruiters;

/**
*
* @author Yuzana Zaw Zaw
*/
public interface RecruitersDao {
	public void saveRecruiters(Recruiters recruiter);

	public Recruiters getRecruitersByEmail(String frmEmail);

	public Recruiters getRecruitersByEmailAndPassword(String frmLoginEmail,
			String frmLoginPassword);

	public Recruiters getRecruitersByEmailAndSecurityQ(
			String frmForgetPassEmail, String frmForgetPassSecurityQuest);

	public List<Recruiters> getAllRecruiterList();

	public List<Recruiters> getRecruiterListByStatus(int id);

	public Recruiters getRecruitersById(int id);

	public List<Recruiters> getRecruiterListByPosition(
			PartyGroupPosition partyGroupPosition);

}
