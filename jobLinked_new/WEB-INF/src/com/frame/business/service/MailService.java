package com.frame.business.service;

import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.swing.JOptionPane;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import com.frame.presentation.form.MailForm;
import com.frame.util.MailConfig;

/**
*
* @author Yuzana Zaw Zaw
*/
public class MailService {

	public void prepareForMail(MailForm myForm) {
		String strFrom = "joblinked.jl@gmail.com";
		String strSubject = myForm.getFrmMailSubject();
		String strContent = new String();
		try {
			VelocityEngine engine = new VelocityEngine();
			Properties properties = new Properties();
			properties.setProperty(VelocityEngine.RESOURCE_LOADER, "classpath");
			properties.setProperty("classpath."
					+ VelocityEngine.RESOURCE_LOADER + ".class",
					ClasspathResourceLoader.class.getName());
			engine.init(properties);
			Template tm = engine.getTemplate("mailTemplate.vm");
			VelocityContext vc = new VelocityContext();
			vc.put("name", myForm.getFrmMailName());
			String today = new SimpleDateFormat("yyyy-MM-dd")
					.format(new Date()).toString();
			vc.put("today", today);
			vc.put("body", myForm.getFrmMailBody());
			vc.put("recName", myForm.getLoginUser().getFirstName()+" "+myForm.getLoginUser().getLastName());
			
			StringWriter sw = new StringWriter();
			tm.merge(vc, sw);
			strContent = sw.toString();
			if (strContent != null) {
				MailConfig smtpMailSender = new MailConfig();
				smtpMailSender.sendToOne(myForm.getFrmMailAdd(), strSubject,
						strContent, strFrom);
				myForm.setFrmMailMessage("Mail can send successfully");
				myForm.setFrmMailAdd(null);
				myForm.setFrmMailName(null);
				myForm.setFrmMailBody(null);
				myForm.setFrmMailSubject(null);
			} else {
				myForm.setFrmMailFailMessage("Mail cannot send because the message is null");
			}

		} catch (Exception e) {
			myForm.setFrmMailFailMessage("Mail Cannot Send");
		}
	}


}
