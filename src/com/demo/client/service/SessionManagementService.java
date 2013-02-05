package com.demo.client.service;

import com.demo.shared.SessionState;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("session")
public interface SessionManagementService extends RemoteService {
	
	public String getUserName(); 
	public Integer getUserGroupId();
	public SessionState isValidSession();
}
