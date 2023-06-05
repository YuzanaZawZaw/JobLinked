package com.frame.presentation.form;

import java.util.List;

import org.apache.struts.validator.ValidatorForm;

import com.frame.business.entity.Recruiters;

/**
*
* @author Yuzana Zaw Zaw
*/
public class MailForm extends ValidatorForm {
	//send to one mail
	private String frmMailAdd;
	private String frmMailMessage;
	private String frmMailFailMessage;
	private String frmMailName;
	private String frmMailBody;
	private String frmMailSubject;
	private Recruiters loginUser;
	public Recruiters getLoginUser() {
		return loginUser;
	}
	public void setLoginUser(Recruiters loginUser) {
		this.loginUser = loginUser;
	}
	public String getFrmMailSubject() {
		return frmMailSubject;
	}
	public void setFrmMailSubject(String frmMailSubject) {
		this.frmMailSubject = frmMailSubject;
	}
	public String getFrmMailBody() {
		return frmMailBody;
	}
	public void setFrmMailBody(String frmMailBody) {
		this.frmMailBody = frmMailBody;
	}
	public String getFrmMailAdd() {
		return frmMailAdd;
	}
	public void setFrmMailAdd(String frmMailAdd) {
		this.frmMailAdd = frmMailAdd;
	}
	public String getFrmMailMessage() {
		return frmMailMessage;
	}
	public void setFrmMailMessage(String frmMailMessage) {
		this.frmMailMessage = frmMailMessage;
	}
	public String getFrmMailName() {
		return frmMailName;
	}
	public void setFrmMailName(String frmMailName) {
		this.frmMailName = frmMailName;
	}
	public String getFrmMailFailMessage() {
		return frmMailFailMessage;
	}
	public void setFrmMailFailMessage(String frmMailFailMessage) {
		this.frmMailFailMessage = frmMailFailMessage;
	}
	

	

}
