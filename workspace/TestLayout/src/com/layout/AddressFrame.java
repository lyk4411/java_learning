package com.layout;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowEvent;


public class AddressFrame extends Frame {
	private Label nameLabel = new Label("姓        名：");
	private Label birthdayLabel = new Label("出生年月：");
	private Label mailLabel = new Label("电子邮件：");
	
	private TextField nameField = new TextField();
	private TextField birthdayField = new TextField();
	private TextField mailField = new TextField();
	
	private Button okBtn = new Button("确定");
	private Button cancelkBtn = new Button("取消");
	
	public AddressFrame(){
		this.setLayout(new GridLayout(4,1,0,5));
		Panel p1 = new Panel();
		Panel p2 = new Panel();
		Panel p3 = new Panel();
		Panel p4 = new Panel();
		
		this.add(p1);
		this.add(p2);
		this.add(p3);
		this.add(p4);
		
		p1.setLayout(new BorderLayout(5,0));
		p2.setLayout(new BorderLayout(5,0));
		p3.setLayout(new BorderLayout(5,0));
		p4.setLayout(new FlowLayout(FlowLayout.RIGHT,5,0));
		
		p1.add(nameLabel,BorderLayout.WEST);
		p2.add(birthdayLabel,BorderLayout.WEST);
		p3.add(mailLabel,BorderLayout.WEST);
		
		p1.add(nameField,BorderLayout.CENTER);
		p2.add(birthdayField,BorderLayout.CENTER);
		p3.add(mailField,BorderLayout.CENTER);
		
		p4.add(okBtn);
		p4.add(cancelkBtn);
		
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
		new AddressFrame();
	}
}
