package com.frame.dao;

import java.util.List;

import com.frame.business.entity.EmpImageFile;
/**
*
* @author Yuzana Zaw Zaw
*/
public interface EmpImageFileDao {
	public void saveNewEmployeeImage(EmpImageFile myFile);

	public EmpImageFile getEmpImageFileById(Integer id);

	public void deleteEmpImageFile(Integer id);

	public List<EmpImageFile> getAllEmployeeImage();
}
