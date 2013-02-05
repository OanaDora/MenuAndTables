package com.demo.client;

import java.util.Date;

import com.demo.client.service.LoginService;
import com.demo.client.service.LoginServiceAsync;
import com.demo.shared.Constants;
import com.demo.shared.FieldVerifier;
import com.demo.shared.SessionState;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class LoginEntryPoint implements EntryPoint {
	
	private static final String DEFAULT_USER_NAME = "admin";
	
	FlowPanel panel = new FlowPanel();
	private Label userLabel;
	private Label passwordLabel;
	private TextBox userNameField;
	private PasswordTextBox passwordField;
	private Button signInButton;

	@Override
	public void onModuleLoad() {
		  
		userLabel = new Label("Username");
		userNameField = new TextBox();
		passwordLabel = new Label("Password");
	    passwordField = new PasswordTextBox();
	    signInButton = new Button("Sign in");

	    userNameField.setText(DEFAULT_USER_NAME);

	    panel.add(userLabel);
	    panel.add(userNameField);
	    panel.add(passwordLabel);
	    panel.add(passwordField);
	    panel.add(signInButton);

	    bindCustomUiHandlers(); 
	    
	    RootPanel.get("loginForm").add(panel);
	}

	protected void bindCustomUiHandlers() {

	    signInButton.addClickHandler(new ClickHandler() {
	      public void onClick(ClickEvent event) {

	        if (FieldVerifier.isValidUsername(getUserName()) &&
	           (FieldVerifier.isValidPassword(getPassword()))) {
	          
	        	LoginServiceAsync loginService = (LoginServiceAsync) GWT.create(LoginService.class);
	        	loginService.login(getUserName(), getPassword(),  new AsyncCallback<SessionState>(){
	        		
	        		public void onSuccess(SessionState sessionState){ 
	        			
	        			if (Boolean.FALSE.equals(sessionState.isLoginSuccesfull())){
	    	        		resetAndFocus();
	    	        	} else {
	    	        		String sessionID = sessionState.getSessionId();	    	        		
	    	        		Date expires = new Date(System.currentTimeMillis() + Constants.SESSION_COOKIE_EXPIRATION_DURATION);
	    	        		Cookies.setCookie("sid", sessionID, expires, null, "/", false);
	    	        		
	    	        		Window.Location.assign(Window.Location.createUrlBuilder().setPath("MenuAndTablesDemo/index.html").setHash("").buildString());
	    	        	}
	        		}
	        		
	        		public void onFailure(Throwable caught) {
						System.out.print("Service could not be called");						
					}
	        	});
	        	
	        }
	        else {	          
	          
	          resetAndFocus();
	        }
	      }
	    });
	  }

	  public String getUserName() {
	    return userNameField.getText();
	  }

	  public String getPassword() {
	    return passwordField.getText();
	  }

	  public void resetAndFocus() {
		Window.alert("You must enter a valid User name and Password.");
		
	    userNameField.setFocus(true);
	    userNameField.selectAll();
	  }
}
