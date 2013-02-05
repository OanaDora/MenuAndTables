package com.demo.client.service;

import com.demo.shared.SessionState;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface SessionManagementServiceAsync {

	public void getUserName(AsyncCallback<String> asyncCallback); 
	public void getUserGroupId(AsyncCallback<Integer> asyncCallback);
	public void isValidSession(AsyncCallback<SessionState> asyncCallback);
}
