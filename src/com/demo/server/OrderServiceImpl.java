package com.demo.server;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.client.service.OrderService;
import com.demo.shared.Notification;

public class OrderServiceImpl extends AbstractServiceImpl implements OrderService {

	public List<Notification> getNotification(String sessionId){
		List<Notification> notificationList = new ArrayList<Notification>();

		try{
			if(isSessionIdValid(sessionId)){
			   connect = MySqlConnection.getInstance().getConn();      
		      
			   statement = connect.createStatement();	     
			   resultSet = statement.executeQuery("select o.inserttimestamp as order_date, nt.description as notif_type, ot.description as order_type " + 
					   			"from notification n  " + 
					   			"inner join notification_types nt on nt.id_notification_types=n.id_notification_type  " + 
					   			"inner join orders o on n.id_order=o.id_order  " + 
					   			"inner join order_types ot on o.id_order_type = ot.id_order_type;");			   
			   
			  while (resultSet.next()) {
//				  Notification notif =  new Notification(resultSet.getTimestamp("order_date").toString(), resultSet.getString("notif_type"), resultSet.getString("order_type"));
				  Notification notif =  new Notification();
				  notif.setDate(resultSet.getTimestamp("order_date").toString());
				  notif.setNotificationName(resultSet.getString("notif_type"));
				  notif.setActionName(resultSet.getString("order_type"));
				  
				  notificationList.add(notif);
			  }
			  
			} else {
				//TODO if session is not valid throw an exception or show message
			}
		} catch(SQLException e) {
			  e.printStackTrace();
		} catch (Exception e) {
			  e.printStackTrace();
		} finally{
			 close();
		} 
		
		return notificationList;
	}
	
	public List<String> getOrderTypes(String sessionId){
		List<String> orderTypeList = new ArrayList<String>();
		
		try{
			if(isSessionIdValid(sessionId)){
				   connect = MySqlConnection.getInstance().getConn();      
			      
				   statement = connect.createStatement();	     
				   resultSet = statement.executeQuery("select * from order_types");			   
				   
				  while (resultSet.next()) {
					  orderTypeList.add(resultSet.getString("description"));
				  }
			}
		}catch(SQLException e) {
			  e.printStackTrace();
		} catch (Exception e) {
			  e.printStackTrace();
		} finally{
			 close();
		} 
		
		return orderTypeList;
	}
}
