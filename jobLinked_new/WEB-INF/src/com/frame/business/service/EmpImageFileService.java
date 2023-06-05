package com.frame.business.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;

import org.apache.struts.upload.FormFile;
import org.hibernate.Hibernate;

import com.frame.business.entity.EmpImageFile;
import com.frame.business.entity.Employee;
import com.frame.dao.EmpImageFileDao;
import com.frame.dao.EmployeeDao;
import com.frame.presentation.form.EmployeeForm;
import com.frame.presentation.form.EmployeeViewProfileForm;

/**
 * 
 * @author Yuzana Zaw Zaw
 */
public class EmpImageFileService {
	private EmpImageFileDao myEmpImageFileDao;
	private EmployeeDao myEmployeeDao;

	public EmployeeDao getMyEmployeeDao() {
		return myEmployeeDao;
	}

	public void setMyEmployeeDao(EmployeeDao myEmployeeDao) {
		this.myEmployeeDao = myEmployeeDao;
	}

	public EmpImageFileDao getMyEmpImageFileDao() {
		return myEmpImageFileDao;
	}

	public void setMyEmpImageFileDao(EmpImageFileDao myEmpImageFileDao) {
		this.myEmpImageFileDao = myEmpImageFileDao;
	}

	public void saveUploadImage(EmployeeForm myForm, EmployeeForm loginForm) {
		FormFile formFile = myForm.getFrmUploadImage();
		Blob bfile;
		try {

			if (formFile != null) {
				bfile = Hibernate.createBlob(formFile.getInputStream());
				String fst = formFile.getFileName().trim();
				Integer size = formFile.getFileSize();

				EmpImageFile myFile = new EmpImageFile();
				Employee employee = loginForm.getLoginUser();
				myFile.setId(null);
				myFile.setEmployee(employee);
				myFile.setImageName(fst);
				myFile.setImageData(bfile);
				myFile.setImageSize(size);
				myFile.setImageContentType(formFile.getContentType());
				/*if (myFile.getImageSize() > 65536) {
					//myForm.setFrmImageFileSizeError("error");
					System.out.println("Your image size is greater than 65536");
				} else {
					if (myForm.getFrmUploadImage() != null) {
						EmpImageFile imageFile = myEmpImageFileDao
								.getEmpImageFileById(employee.getId());
						if (imageFile != null) {
							myEmpImageFileDao.deleteEmpImageFile(imageFile
									.getEmployee().getId());
						}
						myEmpImageFileDao.saveNewEmployeeImage(myFile);
					}
				}*/
				if (myForm.getFrmUploadImage() != null) {
					EmpImageFile imageFile = myEmpImageFileDao
							.getEmpImageFileById(employee.getId());
					if (imageFile != null) {
						myEmpImageFileDao.deleteEmpImageFile(imageFile
								.getEmployee().getId());
					}
					myEmpImageFileDao.saveNewEmployeeImage(myFile);
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public EmpImageFile retrieveEmployeeImage(EmployeeForm myForm,
			EmployeeForm loginForm) {
		Employee employee = loginForm.getLoginUser();
		EmpImageFile imageFile = myEmpImageFileDao.getEmpImageFileById(employee
				.getId());
		if (imageFile != null) {
			myForm.setImageFile(imageFile);
		} else {
			myForm.setImageFile(null);
		}
		return imageFile;
	}

	public EmpImageFile retrieveEmployeeImage(EmployeeViewProfileForm myForm,
			EmployeeForm loginForm) {
		Employee employee = loginForm.getLoginUser();
		EmpImageFile imageFile = myEmpImageFileDao.getEmpImageFileById(employee
				.getId());
		if (imageFile != null) {
			myForm.setImageFile(imageFile);
		} else {
			myForm.setImageFile(null);
		}

		return imageFile;

	}

	public void retrieveEmployeeImage(EmployeeViewProfileForm myForm,
			int frmEmployeeId) {
		Employee employee = myEmployeeDao.getEmployeeById(frmEmployeeId);
		EmpImageFile imageFile = myEmpImageFileDao.getEmpImageFileById(employee
				.getId());
		if (imageFile != null) {
			myForm.setImageFile(imageFile);
		} else {
			myForm.setImageFile(null);
		}
	}

	public EmpImageFile  retrieveEmployeeImage(EmployeeForm myForm) {
		EmpImageFile imageFile = myEmpImageFileDao.getEmpImageFileById(myForm.getLoginUser().getId());
		if (imageFile != null) {
			myForm.setImageFile(imageFile);
		} else {
			myForm.setImageFile(null);
		}
		return imageFile;
	}

}
