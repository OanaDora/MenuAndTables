package com.demo.shared;
/**
 * Contains constants shared by client and server.
 * 
 * @author akovacs
 *
 */
public final class Constants {
	//user group constants
	public static final int USER_GROUP_ADMIN = 1;
	public static final int USER_GROUP_PROVISIONING = 2;
	public static final int USER_GROUP_NOC_ADMIN = 3;
	public static final int USER_GROUP_NOC_USER = 4;
	
	//session attributes constants
	public static final String SESSION_ATTRIBUTE_USERNAME = "userName";
	public static final String SESSION_ATTRIBUTE_USER_GROUP_ID = "userGroup";
	//expiration for the cookie 1 day
	public static final long SESSION_COOKIE_EXPIRATION_DURATION = 1000 * 60 * 60 * 24 * 1;
}
