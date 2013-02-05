package com.demo.client.widgets;


import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabPanel;
/**
 * Contains a tab panel and common functionalities like adding a new tab.
 * 
 * @author akovacs
 *
 */
public class TabMenuBar {

	public static final TabPanel panel = new TabPanel();
	
	/**
	 * Initialize the panel by setting its size and style class.
	 */
	public static void initializePanel(int width, int height, String styleClass){
		panel.selectTab(0);

		panel.setSize(width + "px",  height + "px");
		
		if(styleClass != null){
			panel.addStyleName(styleClass);
		}
		
		RootPanel.get().add(panel);
	}
	
	/**
	 * Add a new panel as a tab in the main panel using the label specified as parameter and returns the new panel.
	 * 
	 * @param tabLabel used to name the tab 
	 * @return a new flow panel that is the new tab in the tab panel
	 */
	public static FlowPanel addTab(String tabLabel){
		
		FlowPanel flowpanel = new FlowPanel();		
		panel.add(flowpanel, tabLabel);
		
		return flowpanel;
	}
	
}
