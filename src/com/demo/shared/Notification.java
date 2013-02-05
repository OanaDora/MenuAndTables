package com.demo.shared;

import java.io.Serializable;
//import java.sql.Timestamp;
//import java.util.Comparator;
//import java.util.Date;


public class Notification implements Serializable{

	private static final long serialVersionUID = 1L;
	private String date;
	private String notificationName;
	private String actionName;
	
	public Notification(){}
	
	/*public Notification(String date, String notificationName, String actionName){
		this.date = date;
		this.notificationName = notificationName;
		this.actionName = actionName;
	}*/
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getNotificationName() {
		return notificationName;
	}
	public void setNotificationName(String notificationName) {
		this.notificationName = notificationName;
	}
	public String getActionName() {
		return actionName;
	}
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}
	
	
	/*public boolean equals(Notification obj) {
		if (this == obj){
			return true;
		}
		return false;
	}*/

	/**
	 * Construct a comparator for action column. 
	 * @return a comparator using action attribute
	 */
	/*public static Comparator<Notification> constructComparatorForAction(){
		return new Comparator<Notification>() {
	          public int compare(Notification o1, Notification o2) {
		            if (o1 == o2) {
		              return 0;
		            }

		            if (o1 != null) {
		              return (o2 != null) ? o1.getActionName().compareTo(o2.getActionName()) : 1;
		            }
		            return -1;
		          }
		};
	}*/
}
