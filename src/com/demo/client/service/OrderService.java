package com.demo.client.service;

import java.util.List;

import com.demo.shared.Notification;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("order")
public interface OrderService extends RemoteService {

	public List<Notification> getNotification(String sessionId);
	public List<String> getOrderTypes(String sessionId);
}
