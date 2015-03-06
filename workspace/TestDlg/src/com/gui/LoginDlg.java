package com.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginDlg extends JDialog implements ActionListener{
	private JLabel nameLabel = new JLabel("name:");
	private JLabel passwordLabel = new JLabel("password:");
	private JTextField nameField = new JTextField();
	private JPasswordField passwordField = new JPasswordField();
	private JButton okBtn = new JButton("OK");
	private JButton cancelBtn = new JButton("Cancel");
	
	private boolean ok = false;
	
	public boolean isOK(){
		return ok;
	}
	
	public LoginDlg(Frame owner){
		super(owner,"please login",true);
		initComponents();
		initEvents();
		
	}
	private void initEvents(){
		okBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
	}
	private void initComponents(){
		Container c = this.getContentPane();

		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT,5,0));
		btnPanel.add(okBtn);
		btnPanel.add(cancelBtn);
		
		c.add(btnPanel,BorderLayout.SOUTH);
		
		JPanel cp = new JPanel();
		cp.setLayout(new BorderLayout(5,0));
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		p1.setLayout(new GridLayout(2,1,0,5));
		p2.setLayout(new GridLayout(2,1,0,5));
		
		p1.add(nameLabel);
		p1.add(passwordLabel);
		
		p2.add(nameField);
		p2.add(passwordField);
		
		cp.add(p1,BorderLayout.WEST);
		cp.add(p2,BorderLayout.CENTER);
		
		c.add(cp);
		
		this.setSize(300,140);
		this.setLocationRelativeTo(this.getOwner());
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource() == okBtn){
			ok = true;
		}
		else {
			ok = false;
		}
		this.dispose();
	}
	

}
