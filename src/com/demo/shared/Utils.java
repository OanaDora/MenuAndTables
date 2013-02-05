package com.demo.shared;

import static com.demo.shared.Constants.SESSION_ATTRIBUTE_USERNAME;
import static com.demo.shared.Constants.SESSION_ATTRIBUTE_USER_GROUP_ID;

import javax.servlet.http.HttpSession;

public class Utils {
	
	public static SessionState constructSessionState(HttpSession session, boolean isValidSession){
		
		SessionState sessionState = new SessionState();
		sessionState.setLoginSuccesfull(isValidSession);
		sessionState.setSessionId(session.getId());
		
		if(isValidSession){
			sessionState.setUsername((String)session.getAttribute(SESSION_ATTRIBUTE_USERNAME));
			sessionState.setUserGroupId((Integer)session.getAttribute(SESSION_ATTRIBUTE_USER_GROUP_ID));
		}
		
		return sessionState;
	}

}
