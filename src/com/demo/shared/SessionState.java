package com.demo.shared;

import java.io.Serializable;

/**
 * Object containing all related information that are shared by client and server.
 * 
 * @author akovacs
 *
 */
public class SessionState implements Serializable{	
	
	private static final long serialVersionUID = 1L;
	
	public SessionState(){}	
		
	private boolean isLoginSuccesfull = false;
	private String sessionId;
	private int userGroupId;
	private String username;
	
	public boolean isLoginSuccesfull() {
		return isLoginSuccesfull;
	}
	public void setLoginSuccesfull(boolean isLoginSuccesfull) {
		this.isLoginSuccesfull = isLoginSuccesfull;
	}
	public int getUserGroupId() {
		return userGroupId;
	}
	public void setUserGroupId(int userGroupId) {
		this.userGroupId = userGroupId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

}
