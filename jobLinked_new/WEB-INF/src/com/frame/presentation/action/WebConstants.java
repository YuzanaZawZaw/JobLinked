package com.frame.presentation.action;
public class WebConstants {

    // HttpSession 
    /** HttpSession */
    /** user bean key name */

    /** HttpServletRequest */
    public static final String ATTR_MESSAGE = "message";
    public static final String SESSION_SCREENNAME = "screen_name"; 
    //ReserveForm 
    public static final String FORM_PROPERTY_IS_CHANGE = "isChange";
    static final String KEY_MESSAGE_SCREENTRANSERR = "message.error.screentransition";
    static final String SUCCESS = "success";
    static final String SUCCESS_Login = "gotoLogin";
    static final String SUCCESS_Home = "gotoHome";
    
    //For Amazon Web Services
    public static final String END_POINT = "ecs.amazonaws.com";
	public static final String KEY_ID = "AKIAJTEW4WACGT7XJIIQ";
	public static final String SECRET_KEY = "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";
	public static final String OPERATION = "ItemLookup";
	public static final String RESPONSE_GROUP = "Medium";
	public static final String SERVICE = "AWSECommerceService";
	public static final String VERSION = "2009-03-31";
	public static final String PROXY_SET = "true";
	public static final String PROXY_HOST = "192.168.48.6";
	public static final String PROXY_PORT = "8080";

	//For LDAP Services
	public final static String LDAP_PRINCIPAL = "uid=swteacher1, ou=People, dc=ictti, dc=site";
	public final static String LDAP_CREDENTIALS ="ICTTI";// "1ctt1l3ctur3r";
	public final static String INITIAL_CONTEXT_FACTORY="com.sun.jndi.ldap.LdapCtxFactory";
	public final static String LDAP_URL="ldap://ldapserver.ictti.site/";
    
    private WebConstants() {
        // nothing to do.
    }
}
