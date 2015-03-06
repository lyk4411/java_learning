package com.gui;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame implements ActionListener{
	private Button okBtn;
	
	private class MouseProcessor extends MouseAdapter{
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			if(arg0.getButton() == MouseEvent.BUTTON1){
				MyFrame.this.setBackground(Color.red);
			}
			else if(arg0.getButton() == MouseEvent.BUTTON3){
				MyFrame.this.setBackground(Color.blue);
			}
		}
	}
	private class WindowProcessor extends WindowAdapter{
		public void windowClosing(WindowEvent e){
			System.exit(0);
		}
	}
	/*private class MouseProcessor implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			if(arg0.getButton() == MouseEvent.BUTTON1){
				MyFrame.this.setBackground(Color.red);
			}
			else if(arg0.getButton() == MouseEvent.BUTTON3){
				MyFrame.this.setBackground(Color.blue);
			}
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}*/
	
	public MyFrame(){
		super("My Frame");
		okBtn = new Button("OK");
		
		okBtn.addActionListener(this);
		
		this.addMouseListener(new MouseProcessor());
		
		this.addWindowListener(new WindowProcessor());
		
		this.setLayout(new FlowLayout());
		this.add(okBtn);
		
		this.setSize(120,60);
		this.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println(Math.random());
	}
}
