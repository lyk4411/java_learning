package com.layout;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowEvent;


public class AddressFrame2 extends Frame {
	private Label nameLabel = new Label("姓        名：");
	private Label birthdayLabel = new Label("出生年月：");
	private Label mailLabel = new Label("电子邮件：");
	
	private TextField nameField = new TextField();
	private TextField birthdayField = new TextField();
	private TextField mailField = new TextField();
	
	private Button okBtn = new Button("确定");
	private Button cancelkBtn = new Button("取消");
	
	public AddressFrame2(){
		this.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0;
		c.weighty = 1;
		c.gridheight = 1;
		c.gridwidth = 1;
		
		this.add(nameLabel,c);
		
		c.gridy = 1;
		
		this.add(birthdayLabel,c);
		
		c.gridy = 2;
		
		this.add(mailLabel,c);
		
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.weightx = 1;
		c.weighty = 1;
		this.add(nameField,c);
		
		c.gridy = 1;
		this.add(birthdayField,c);
		
		c.gridy = 2;
		this.add(mailField,c);
		
		c.gridx = 1;
		c.gridy = 3;
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.EAST;
		c.weighty = 0;
		c.gridwidth = 1;
		this.add(okBtn,c);
		
		c.gridx = 2;
		c.weightx = 0;
		c.weighty = 0;
		this.add(cancelkBtn,c);
		
		this.setSize(260,150);
		this.setLocationRelativeTo(null);
		
		WindowProcessor wp = new WindowProcessor();
		this.addWindowListener(wp);
		this.setVisible(true);
	}
	
	private class WindowProcessor extends  WindowAdapter{
		public void windowClosing(WindowEvent e){
			System.exit(0);
		}
	}
	
	public static void main(String args[]){
		new AddressFrame2();
	}
}
