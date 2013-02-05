package com.demo.server;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpSession;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * 
 * @author akovacs
 *
 */
public abstract class AbstractServiceImpl extends RemoteServiceServlet  {

	protected static final long serialVersionUID = 1L;
	
	protected Connection connect = null;
	protected ResultSet resultSet = null;
	protected Statement statement = null;	
	
	protected void close() {
	    try {
	      if (resultSet != null) {
	        resultSet.close();
	      }

	      if (statement != null) {
	        statement.close();
	      }

	      if (connect != null) {
	        connect.close();
	      }
	    } catch (Exception e) {

	    }
	  }

	/**
	 * 
	 * @return the current http session
	 */
	protected HttpSession getSession(){
		return getThreadLocalRequest().getSession(true);
	}
	
	/**
	 * Verifies if the session is valid by comparing the session id sent from client that is load from the cookie and the session id set
	 * on the http session object.
	 * 
	 * @param sessionIdClient identifies the client session id
	 * @return true if the session id sent from the client is the same with session id from the server.
	 */
	protected boolean isSessionIdValid(String sessionIdClient){
		HttpSession session = getSession();
		return session != null && session.getId() != null && session.getId().equals(sessionIdClient);
	}
}
