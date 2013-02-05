package com.demo.server;

import javax.servlet.http.HttpSession;

import com.demo.client.service.SessionManagementService;
import com.demo.shared.SessionState;
import com.demo.shared.Utils;

import static com.demo.shared.Constants.*;

/**
 * 
 * @author akovacs
 *
 */
public class SessionManagementServiceImpl extends AbstractServiceImpl implements SessionManagementService {


	public void setUserName(String userName) {
		
		 HttpSession httpSession = getSession();  
	     httpSession.setAttribute(SESSION_ATTRIBUTE_USERNAME, userName); 

	}

	public String getUserName() {
		HttpSession session = getSession();  
	    if (session.getAttribute(SESSION_ATTRIBUTE_USERNAME) != null)  
	    {  
	        return (String) session.getAttribute(SESSION_ATTRIBUTE_USERNAME);  
	    }  
	    else   
	    {  
	        return "";  
	    }  
	}
	
	public Integer getUserGroupId(){
		HttpSession session = getSession();  
	    if (session.getAttribute(SESSION_ATTRIBUTE_USER_GROUP_ID) != null)  
	    {  
	        return (Integer) session.getAttribute(SESSION_ATTRIBUTE_USER_GROUP_ID);  
	    }  
	    else   
	    {  
	        return null;  
	    }  
	}
	
	public SessionState isValidSession(){
		HttpSession session = getSession(); 
		SessionState sessionState = null;
		
		if ( session.getAttribute(SESSION_ATTRIBUTE_USERNAME) != null && 
				session.getAttribute(SESSION_ATTRIBUTE_USER_GROUP_ID) != null){
			sessionState =  Utils.constructSessionState(session, true);
		} else {
			sessionState = Utils.constructSessionState(session, false);
		}
		
		return sessionState;
	}
	
	

}
