package com.frame.business.service;

import com.frame.business.entity.Admin;
import com.frame.business.entity.Recruiters;
import com.frame.dao.AdminDao;
import com.frame.presentation.form.AdminForm;
import com.frame.presentation.form.RecruiterForm;
/**
*
* @author Yuzana Zaw Zaw
*/
public class AdminService {
	private AdminDao myAdminDao;
	
	public AdminDao getMyAdminDao() {
		return myAdminDao;
	}
	
	public void setMyAdminDao(AdminDao myAdminDao) {
		this.myAdminDao = myAdminDao;
	}
	
	public void checkLoginUser(AdminForm myForm) {
		Admin myAdmin = myAdminDao.getAdminByEmailAndPassword(myForm.getFrmLoginEmail(),myForm.getFrmLoginPassword());
		if(myAdmin!=null){
			myForm.setLoginUser(myAdmin);
		}else{
			myForm.setLoginUser(null);
		}
		
	}

	public boolean checkLoginUser(String email, String frmChangeOldPassword) {
		Admin myAdmin = myAdminDao.getAdminByEmailAndPassword(email,frmChangeOldPassword);
		if(myAdmin==null){
			return false;
		}else{
			return true;
		}
	}
	
	public void saveUpdateAdmin(AdminForm myForm) {
		Admin myAdmin=myForm.getLoginUser();
		myAdmin.setPassword(myForm.getFrmChangeConfirmPassword());
		myAdminDao.saveAdmin(myAdmin);
		myForm.setFrmChangeOldPassword("");
		myForm.setFrmChangeNewPassword("");
		myForm.setFrmChangeConfirmPassword("");
	}	
}
