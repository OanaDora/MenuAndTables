package com.demo.client.widgets;

import java.util.Date;


import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.CalendarModel;
import com.google.gwt.user.datepicker.client.CalendarView;
import com.google.gwt.user.datepicker.client.DatePicker;
import com.google.gwt.user.datepicker.client.DefaultCalendarView;
import com.google.gwt.user.datepicker.client.DefaultMonthSelector;
import com.google.gwt.user.datepicker.client.MonthSelector;

public class CalendarPicker extends DatePicker {
	
	private TextBox textBox;
	
	public CalendarPicker(){
		super();
	}
	
	public CalendarPicker(MonthSelector monthSelector, CalendarView view, CalendarModel model){
		super (monthSelector, view, model);
	}
	public CalendarPicker(TextBox input){
		super();	
		
		
       
		this.textBox = input;
		this.addValueChangeHandler(new ValueChangeHandler<Date>() {
		      public void onValueChange(ValueChangeEvent<Date> event) {
		        Date date = event.getValue();
		        String dateString = DateTimeFormat.getMediumDateFormat().format(date);
		        textBox.setText(dateString);
		      }
		    });
	}
	
	private void setMonthEvents(){
		DefaultMonthSelector monthSelector = new DefaultMonthSelector();
        CalendarView view = new DefaultCalendarView();
        CalendarModel model = new CalendarModel();
        
        
	}

}
