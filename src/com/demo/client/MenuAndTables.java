package com.demo.client;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.demo.client.service.OrderService;
import com.demo.client.service.OrderServiceAsync;
import com.demo.client.service.SessionManagementService;
import com.demo.client.service.SessionManagementServiceAsync;
import com.demo.shared.Constants;
import com.demo.shared.Notification;
import com.demo.shared.SessionState;
import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.view.client.ListDataProvider;

public class MenuAndTables implements EntryPoint {

	
	public void onModuleLoad() {
		
		SessionManagementServiceAsync sessionManagementService = (SessionManagementServiceAsync) GWT.create(SessionManagementService.class);
		sessionManagementService.isValidSession(new AsyncCallback<SessionState>() {
			
			public void onSuccess(SessionState sessionState) {
				if(Boolean.TRUE.equals(sessionState.isLoginSuccesfull())){
	        		
					addTabsByRol(sessionState.getUserGroupId());
				} else {
					returnToLoginPage();
				}
				
			}
			
			public void onFailure(Throwable caught) {
				returnToLoginPage();				
			}
		});		
		
	}
	
	private void addTabsByRol(Integer userGroupId){
		
		TabPanel mainPanel = TabMenuBar.panel;
		
		//add tabs
		FlowPanel notificationPagePanel = TabMenuBar.addTab("Notifications");
		constructNotificationPage(notificationPagePanel);
		FlowPanel ordersPagePanel = TabMenuBar.addTab("Orders");
		constructOrdersPage(ordersPagePanel);
		
		if(Constants.USER_GROUP_ADMIN == userGroupId){
			FlowPanel financialPagePanel = TabMenuBar.addTab("financial");
		}
		
		TabMenuBar.initializePanel(900, 550, null);
		
		
	}
	
	private void returnToLoginPage(){
		Window.Location.assign(Window.Location.createUrlBuilder().setPath("MenuAndTablesDemo/index.html").setHash("").buildString());
	}
	
	private void constructNotificationPage(FlowPanel notificationPagePanel){
		
		final CommonCellTable<Notification> table = new CommonCellTable<Notification>();
		
		table.setStyleName("tabel-center", true);
		
		TextColumn<Notification> timeCol = new TextColumn<Notification>() {
			public String getValue(Notification notification) {
		        return notification.getDate().toString();
		      }
		};
		timeCol.setSortable(true);
		
		
		EditableColumn<Notification> nameCol = new EditableColumn<Notification>(new EditTextCell()){
			public String getValue(Notification notification) {
		        return notification.getNotificationName();
		      }
		};
		
		TextColumn<Notification> actionCol = new TextColumn<Notification>() {
			public String getValue(Notification notification) {
		        return notification.getActionName();
		      }
		};
		actionCol.setSortable(true);

		
		table.addColumn(timeCol, "Timestamp");
		table.addColumn(nameCol, "Notification");
		table.addColumn(actionCol, "Action link");
		
		
		notificationPagePanel.add(table);
		
		OrderServiceAsync orderService = (OrderServiceAsync) GWT.create(OrderService.class);
		orderService.getNotification(getSessionIdFromCookie(), new AsyncCallback<List<Notification>>() {

			public void onFailure(Throwable caught) {
				System.out.print("Order service could not be called!");
				
			}

			public void onSuccess(List<Notification> result) {
				setNotificationElements(table, result);
				
			}
		});
	}
	
	private void setNotificationElements(CommonCellTable<Notification> table, List<Notification> notifications){
	/*	List<Notification> notifications = Arrays.asList(
				new Notification(new Timestamp((new Date(113, 0, 12)).getTime()), "New Order Request", "Trunk order"), 
				new Notification(new Timestamp((new Date(113, 0, 20)).getTime()), "New Order Request", "DS3 order"), 
				new Notification(new Timestamp((new Date(113, 0, 24)).getTime()), "Redesign Request", "Trunk order")
				);*/

		ListDataProvider<Notification> dataProvider = new ListDataProvider<Notification>();
		// Connect the table to the data provider.
	    dataProvider.addDataDisplay(table);

		List<Notification> list = dataProvider.getList();
		for(Notification notif :  notifications){
			list.add(notif);
		}
		
		// Add a ColumnSortEvent.ListHandler to connect sorting to the	   
	  /*  ListHandler<Notification> columnSortHandler = new ListHandler<Notification>(list);
	    columnSortHandler.setComparator(table.getColumn(2), Notification.constructComparatorForAction());
	    table.addColumnSortHandler(columnSortHandler);******/

//	    table.addColumnListenerForSorting((Column)table.getColumn(2), list,  Notification.constructComparatorForAction());
	    table.addColumnListenerForSorting((Column)table.getColumn(0), list);
		
	}
	
	private void constructOrdersPage(FlowPanel orderPanel){
		final Grid grid = new Grid(7,3);
		grid.setText(0, 0, "Order type:");
		
		//get order types and put them in a drop down list
		OrderServiceAsync orderService = (OrderServiceAsync) GWT.create(OrderService.class);
		orderService.getOrderTypes(getSessionIdFromCookie(), new AsyncCallback<List<String>>() {

			public void onFailure(Throwable caught) {
				System.out.print("Order service could not be called!");
				
			}

			public void onSuccess(List<String> result) {
				DropDownList orderType = new DropDownList();
				orderType.addToList(result);
				grid.add(orderType);				
			}
		});
		
		orderPanel.add(grid);
	}
	
	private String getSessionIdFromCookie(){
		return Cookies.getCookie("sid");
	}
}
