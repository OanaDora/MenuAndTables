package com.demo.client.widgets;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.user.cellview.client.Column;

public abstract class EditableColumn<T> extends Column<T,String>{

	public EditableColumn(EditTextCell cell) {
		super((Cell<String>) cell);
	}

	
	
}
