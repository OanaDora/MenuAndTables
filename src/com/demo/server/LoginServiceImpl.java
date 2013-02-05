package com.demo.server;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpSession;

import com.demo.client.service.LoginService;
import static com.demo.shared.Constants.*;
import com.demo.shared.SessionState;
import com.demo.shared.Utils;
/**
 * 
 * @author akovacs
 *
 */
public class LoginServiceImpl extends AbstractServiceImpl implements LoginService {
	
	
	public SessionState login(String username, String password){
		String passwordDb = null;
		Integer userGroupId = null;
		SessionState sessionState = null;

		try{
		   connect = MySqlConnection.getInstance().getConn();      
	      
		   statement = connect.createStatement();	     
		   resultSet = statement.executeQuery("select * from test1.users");
		  
		  while (resultSet.next()) {
			  
			  if(username.trim().equalsIgnoreCase(resultSet.getString("username"))) {
				  passwordDb = resultSet.getString("password");
				  userGroupId = resultSet.getInt("idusergroup");
			  }
		  }
		  
		  HttpSession httpSession = getThreadLocalRequest().getSession(true);
		  
		  if(passwordDb != null && passwordDb.equals(password)){
			   
			  httpSession.setAttribute(SESSION_ATTRIBUTE_USERNAME, username);
			  httpSession.setAttribute(SESSION_ATTRIBUTE_USER_GROUP_ID, userGroupId);
			  sessionState = Utils.constructSessionState(httpSession, true);
			  
		  } else {
			  sessionState = Utils.constructSessionState(httpSession, false);
		  }
		  
	  } catch(SQLException e) {
		  e.printStackTrace();
	  } catch (Exception e) {
		  e.printStackTrace();
	  } finally{
		 close();
	  } 
		
		return sessionState;
	}
		
	
}
