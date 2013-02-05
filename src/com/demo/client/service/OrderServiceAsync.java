package com.demo.client.service;

import java.util.List;

import com.demo.shared.Notification;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface OrderServiceAsync {

	public void getNotification(String sessionId, AsyncCallback<List<Notification>> asyncCallback);
	public void getOrderTypes(String sessionId,  AsyncCallback<List<String>> asyncCallback);
}
