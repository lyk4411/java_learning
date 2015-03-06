package com.gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.domain.Book;

public class BookTableModel extends AbstractTableModel {
	private static final String[] headers = {
		"bookname","price","author"
	};
	private List<Book> books = new ArrayList<Book>();
	
	public void appendBook(Book b){
		books.add(b);
		this.fireTableDataChanged();
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return headers.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return books.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		Book tb = books.get(row);
		switch(col){
		case 0: 
			return "<html>" + tb.getName() + "<br> adsfalkfdalksgha" + "<html/>"; 
		case 1:
			return tb.getPrice();
		case 2:
			return tb.getAuthor();
		}
		return null;
	}
	
	public String getColumnName(int colIndex){
		return headers[colIndex];
	}
	public boolean isCellEditable(int rowIndex, int columnIndex){
		return true;
	}
	public void setValueAt(Object aValue,int rowIndex, int columnIndex){
		Book tb = books.get(rowIndex);
		if(tb != null){
			switch(columnIndex){
				case 0: 
					 tb.setName((String)(aValue));
				case 1:
					 tb.setPrice(Double.valueOf((String)aValue));
					 break;
				case 2:
					 tb.setAuthor((String)aValue);
					 break;
			}
		}
	}
}
