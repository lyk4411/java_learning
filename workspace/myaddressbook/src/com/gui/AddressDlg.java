package com.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.domain.Address;

public class AddressDlg extends JDialog implements ActionListener {
	private JLabel nameLable = new JLabel("name");
	private JLabel genderLable = new JLabel("gender");
	private JLabel birthdayLable = new JLabel("birthday");
	private JLabel mobileLable = new JLabel("mobile");
	private JLabel phoneLable = new JLabel("phone");
	private JLabel emailLable = new JLabel("email");
	
	private JTextField nameField = new JTextField(26);
	private JTextField genderField = new JTextField(26);
	private JTextField birthdayField = new JTextField(26);
	private JTextField mobileField = new JTextField(26);
	private JTextField phoneField = new JTextField(26);
	private JTextField emailField = new JTextField(26);
	
	private JButton okBtn = new JButton("OK");
	private JButton cancelBtn = new JButton("Cancel");
	
	private Address address = null;
	
	public AddressDlg(JFrame owner){
		super(owner,"create new person",true);
		
		initComponents();
		initEvents();
	}
	private void initComponents(){
		JPanel wp = new JPanel();
		wp.setLayout(new GridLayout(6,1,0,5));
		JPanel cp = new JPanel();
		cp.setLayout(new GridLayout(6,1,0,5));
		JPanel sp = new JPanel();
		sp.setLayout(new FlowLayout(FlowLayout.RIGHT,5,5));
		
		wp.add(nameLable);
		wp.add(genderLable);
		wp.add(birthdayLable);
		wp.add(mobileLable);
		wp.add(phoneLable);
		wp.add(emailLable);
		
		cp.add(nameField);
		cp.add(genderField);
		cp.add(birthdayField);
		cp.add(mobileField);
		cp.add(phoneField);
		cp.add(emailField);
		
		sp.add(okBtn);
		sp.add(cancelBtn);
		
		this.getContentPane().add(wp,BorderLayout.WEST);
		this.getContentPane().add(cp,BorderLayout.CENTER);
		this.getContentPane().add(sp,BorderLayout.SOUTH);
		
		this.pack();
		this.setLocationRelativeTo(this.getOwner());
		
	}
	private void initEvents(){
		okBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == okBtn){
			address = new Address();
			address.setName(nameField.getText());
			address.setGender(genderField.getText().equals("male")?'m':'f');
			address.setBirthday(Date.valueOf(birthdayField.getText()));
			address.setMobile(mobileField.getText());
			address.setPhone(phoneField.getText());
			address.setEmail(emailField.getText());
		}
		else{
			address = null;
		}
		this.dispose();
	}
	
	public Address getAddress(){
		return address;
	}
}
