package com.demo.client.service;

import com.demo.shared.SessionState;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LoginServiceAsync {
	
	void login(String username, String password, AsyncCallback<SessionState> callback)
			throws IllegalArgumentException;


}
