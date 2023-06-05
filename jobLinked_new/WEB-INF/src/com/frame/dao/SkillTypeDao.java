package com.frame.dao;

import java.util.List;

import com.frame.business.entity.SkillType;
/**
*
* @author Yuzana Zaw Zaw
*/
public interface SkillTypeDao {

	void saveSkillType(SkillType skillType);

	List<SkillType> getLoadSkillTypeList();

	void deleteSkillType(SkillType st);

	SkillType searchSkillTypeById(String skillTypeId);

	SkillType getSkillTypeById(int frmSkillTypeId);

	
}
