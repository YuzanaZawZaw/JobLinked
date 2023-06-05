package com.frame.dao;

import com.frame.business.entity.Admin;
/**
*
* @author Yuzana Zaw Zaw
*/
public interface AdminDao {

	public Admin getAdminByEmailAndPassword(String frmLoginEmail,
			String frmLoginPassword);

	public void saveAdmin(Admin myAdmin);
}
