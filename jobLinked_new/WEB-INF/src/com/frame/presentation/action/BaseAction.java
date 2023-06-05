package com.frame.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public abstract class BaseAction extends Action {
	private static final Log LOG = LogFactory.getLog(BaseAction.class);

	public final ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (isCheckScreenTransition(request)) {
			if (!isValidScreenTransition(request)) {
			throw new RuntimeException("screen transition not allowed.");
			}
		}
		// set screen name to the session
		if(request.getParameter(WebConstants.SESSION_SCREENNAME)!=null){
				request.getSession().setAttribute(WebConstants.SESSION_SCREENNAME,request.getParameter(WebConstants.SESSION_SCREENNAME));
		}
		if (request.getMethod().toLowerCase().equals("get")) {
			String strForward = doInit(form, request, response, mapping);
			return mapping.findForward(strForward);
		}
		
         // transfer control to each action
		String name = doExecute(form, request,response, mapping);
		
        // save token to control ilegal screen transition
		saveToken(request);

		// show the jsp returned by each action
		return mapping.findForward(name);
	}

	
	protected String doInit(ActionForm form, HttpServletRequest request,HttpServletResponse response,
			ActionMapping mapping) {
		saveToken(request);
		return "success";
	}

	protected boolean isRequiredLogin(HttpServletRequest request) {
		return true;
	}

	protected boolean isCheckScreenTransition(HttpServletRequest request) {
		return false;
	}

	protected boolean isValidScreenTransition(HttpServletRequest request) {
		return isTokenValid(request);
	}

	protected abstract String doExecute(ActionForm form,
			HttpServletRequest request, HttpServletResponse response,
			ActionMapping mapping) throws Exception;

	protected String getMessage(HttpServletRequest request, String key) {
		return getResources(request).getMessage(key);
	}
}