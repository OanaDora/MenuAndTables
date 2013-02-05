package com.demo.client.widgets;

import java.util.Comparator;
import java.util.List;

import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.cellview.client.IdentityColumn;
import com.google.gwt.user.cellview.client.TextColumn;

/**
 * 
 * @author akovacs
 *
 * @param <T>
 */
public class CommonCellTable<T> extends  CellTable<T>{	
	
	public CommonCellTable(){
		super();
	}
	
	/**
	 * Adds handler for sorting to a column using a custom comparator.
	 * 
	 * @param c identifies the column
	 * @param list contains the data from the table
	 * @param comparator defines the custom comparator
	 * 
	 */
	public void addColumnListenerForSorting(Column c, List<T> list, Comparator<T> comparator){
		// Add a ColumnSortEvent.ListHandler to connect sorting to the
	    // java.util.List.
	    ListHandler<T> columnSortHandler = new ListHandler<T>(list);
	    columnSortHandler.setComparator(c,comparator);
	    this.addColumnSortHandler(columnSortHandler);

	    // We know that the data is sorted alphabetically by default.
	    this.getColumnSortList().push(c);

	}
	
	public void addColumnListenerForSorting(Column c, List<T> list){
		// Add a ColumnSortEvent.ListHandler to connect sorting to the
	    // java.util.List.
	    ListHandler<T> columnSortHandler = new ListHandler<T>(list);
	    columnSortHandler.setComparator(c,new Comparator<T>() {
			
			public int compare(T o1, T o2) {
				if(o1.equals(o2)) {
					return 0 ;
				} else {
					return 1;
				}
			}
		}
	    		);
	    this.addColumnSortHandler(columnSortHandler);

	    // We know that the data is sorted alphabetically by default.
	    this.getColumnSortList().push(c);

	}
	
	
	/*??
	 * 
	 */
	public Column addCustomColumn(int columnType, String header, boolean isSortable){
		Column c = null;
		switch (columnType){
			case 0: 
				c= new TextColumn<T>(){
					public String getValue(T obj) {
						return null;
			      }};
			case 1:
				c=  new EditableColumn<T>(new EditTextCell()){
					public String getValue(T obj) {
						return null;
			      }};
			default:
				c= new TextColumn<T>(){
					public String getValue(T obj) {
						return null;
			      }};
		}
		c.setSortable(isSortable);
		this.addColumn(c, header);
		
		return c;
				
	}	
	
}
