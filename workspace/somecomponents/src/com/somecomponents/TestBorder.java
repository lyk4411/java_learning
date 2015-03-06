package com.somecomponents;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class TestBorder extends JFrame{
	private JPanel btnPanel;
	private JButton okBtn;
	private JButton cancelBtn;
	
	public TestBorder(){
		btnPanel = new JPanel();
		okBtn = new JButton("OK");
		cancelBtn = new JButton("Cancel");
		btnPanel.add(okBtn);
		btnPanel.add(cancelBtn);
		
		btnPanel.setBorder(new TitledBorder("Test Border"));
		
		this.getContentPane().add(btnPanel,BorderLayout.SOUTH);
		pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TestBorder();
	}

}
