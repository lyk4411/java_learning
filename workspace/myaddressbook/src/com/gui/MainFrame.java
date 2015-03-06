package com.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.dao.IAddressDAO;
import com.dao.mysql.MySQLAddressDAO;
import com.dao.mysql.MySQLUtil;
import com.domain.Address;

public class MainFrame extends JFrame implements ActionListener{
	private JButton addBtn = new JButton("add new person");
	private JButton removeBtn = new JButton("delete person");
	private JTable addressTable;
	private AddressTableModel addressTableModel = new AddressTableModel();
	
	public MainFrame(){
		super("my address list management system");
		
		initComponents();
		initEvents();
	}
	
	private void initComponents(){
		addressTable = new JTable(addressTableModel);
		
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
		btnPanel.add(addBtn);
		btnPanel.add(removeBtn);
		
		this.getContentPane().add(btnPanel,BorderLayout.NORTH);
		this.getContentPane().add(new JScrollPane(addressTable));
		
		this.setSize(600, 600);
		this.setLocationRelativeTo(null);
		
		try {
			IAddressDAO addressDAO = new MySQLAddressDAO();
			List<Address> addresses = addressDAO.findAll();
			addressTableModel.addAll(addresses);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void initEvents(){
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				try {
					MySQLUtil.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.exit(0);
			}
		});
		
		addBtn.addActionListener(this);
		removeBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == addBtn){
			AddressDlg adlg = new AddressDlg(this);
			adlg.setVisible(true);
			Address address = adlg.getAddress();
			if(address!=null){
				try {
					IAddressDAO addressDAO = new MySQLAddressDAO();
					address = addressDAO.create(address);
					addressTableModel.add(address);
				} catch (Exception ee) {
					// TODO Auto-generated catch block
					ee.printStackTrace();
				}
			}
		}
		else if(e.getSource() == removeBtn) {
			
		}
	}
}