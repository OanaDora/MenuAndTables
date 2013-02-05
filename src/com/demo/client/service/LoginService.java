package com.demo.client.service;

import com.demo.shared.SessionState;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("loginServ")
public interface LoginService extends RemoteService {

	public SessionState login(String username, String password);
}
