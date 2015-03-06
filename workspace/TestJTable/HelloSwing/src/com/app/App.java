package com.app;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f = new JFrame("Hello Swing");
		Container c = f.getContentPane();
		c.setLayout(new BorderLayout());
		
		JButton okBtn = new JButton("OK");
		JButton cancelBtn = new JButton("Cancel");
		JTextArea ta = new JTextArea();
		f.getContentPane().add(okBtn);
		
		c.add(new JScrollPane(ta),BorderLayout.CENTER);
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		btnPanel.add(okBtn);
		btnPanel.add(cancelBtn);
		
		c.add(btnPanel,BorderLayout.SOUTH);
		
		f.setSize(300, 400);
		f.setLocationRelativeTo(null);
		
		f.setVisible(true);
		
	}
}
