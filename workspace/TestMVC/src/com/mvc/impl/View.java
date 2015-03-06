package com.mvc.impl;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.mvc.IController;
import com.mvc.IMode;
import com.mvc.IView;

public class View implements IView,ActionListener {
	private Frame frame = new Frame("Test MVC");
	private TextField messageField = new TextField();
	private Button setBtn = new Button("Set Message");
	private IMode model;
	private IController controller;
	
	public View(IMode model){
		this.model = model;
		this.model.addModelListener(this);
		
		frame.add(messageField,BorderLayout.CENTER);
		frame.add(setBtn,BorderLayout.EAST);
		
		messageField.setText(model.getMessage());
		setBtn.addActionListener(this);
		
		frame.setSize(200, 200);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		WindowProcessor wp = new WindowProcessor();
		frame.addWindowListener(wp);
		
	}
	@Override
	public void processMessageChanged(String msg) {
		// TODO Auto-generated method stub
		messageField.setText(msg);

	}

	@Override
	public void showResult(String tip) {
		// TODO Auto-generated method stub
		System.out.println(tip);
		

	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String msg = messageField.getText();
		controller.doChangeMessage(msg);
	}
	@Override
	public void addViewListener(IController c) {
		// TODO Auto-generated method stub
		controller = c;
	}
	private class WindowProcessor extends  WindowAdapter{
		public void windowClosing(WindowEvent e){
			System.exit(0);
		}
	}
}
