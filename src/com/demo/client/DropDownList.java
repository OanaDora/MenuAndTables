package com.demo.client;

import java.util.List;

import com.google.gwt.user.client.ui.ListBox;
/**
 * 
 * @author akovacs
 *
 */
public class DropDownList extends ListBox {
	
	public DropDownList(){
		super();
	}
	/**
	 * Inserts into the <ListBox> all the <String> as items from the list specified as parameter.
	 * @param list specified the items that will be inserted in the <ListBox>
	 */
	public void addToList(List<String> list){
		
		for(String o : list){
			this.addItem(o);
		}		
	}
}
