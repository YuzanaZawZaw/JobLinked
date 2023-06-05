package com.frame.dao;

import java.util.List;

import com.frame.business.entity.QualType;

/**
*
* @author Yuzana Zaw Zaw
*/
public interface QualTypeDao {

	void saveQualType(QualType qualType);

	List<QualType> getLoadQualTypeList();

	void deleteQualType(QualType st);

	QualType searchQualTypeById(String qualTypeId);

	QualType getQualTypeById(int parseInt);

	
}
