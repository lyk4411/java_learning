package com.gui;


import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.domain.Address;

public class AddressTableModel extends AbstractTableModel {
	private List<Address> addresses = new ArrayList<Address>();
	
	private static String[] headers = {
		"name","gender","birthday","mobile","phone","email"
	};
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return headers.length;
	}
	
	public String getColumnName(int colIndex){
		return headers[colIndex];
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return addresses.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Address addr = addresses.get(rowIndex);
		switch(columnIndex){
		case 0:
			return addr.getName();
		case 1:
			return addr.getGender() == 'm'? "male":"female";
		case 2:
			return addr.getBirthday();
		case 3:
			return addr.getMobile();
		case 4:
			return addr.getPhone();
		case 5:
			return addr.getEmail();
		}
		return null;
	}
	public void addAll(List<Address> addresses) {
		this.addresses.addAll(addresses);
		this.fireTableDataChanged();
	}

	public void add(Address address) {
		// TODO Auto-generated method stub
		this.addresses.add(address);
		this.fireTableDataChanged();
	}
}
