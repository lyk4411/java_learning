package com.gui;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import com.domain.Book;

public class BookFrame extends JFrame {
	private JTable bookTable;
	private BookTableModel bookTableModel;
	
	public BookFrame(){
		bookTableModel = new BookTableModel();
		bookTable = new JTable(bookTableModel);
		bookTable.setRowHeight(50);
		bookTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		int columnWidths[] = {100,50,60};
		TableColumnModel tcm =  bookTable.getColumnModel();
		for (int i=0; i<tcm.getColumnCount(); i++) {
			TableColumn tc = tcm.getColumn(i);
			tc.setPreferredWidth(columnWidths[i]);
			
			//tc.setMaxWidth(columnWidths[i]);
			//tc.setMinWidth(columnWidths[i]);
		}
		
		bookTableModel.appendBook(new Book("C++ primer","HP",68));
		bookTableModel.appendBook(new Book("C++ primer","HP",69));
		bookTableModel.appendBook(new Book("C++ primer","HP",67));
		bookTableModel.appendBook(new Book("C++ primer","HP",66));
		bookTableModel.appendBook(new Book("C++ primer","HP",65));
		bookTableModel.appendBook(new Book("C++ primer","HP",88));
		bookTableModel.appendBook(new Book("C++ primer","HP",98));
		
		this.getContentPane().add(new JScrollPane(bookTable));
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);//26'44"
		
	}
}
