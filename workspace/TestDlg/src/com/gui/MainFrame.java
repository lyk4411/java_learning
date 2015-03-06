package com.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainFrame extends JFrame  implements ActionListener{

	private JButton loginBtn;
	private JButton inputBtn = new JButton("Input Dialog");
	private JButton confirmBtn = new JButton("confirm Dialog");
	private JButton openfileBtn = new JButton("open file Dialog");

	public MainFrame(){
		loginBtn = new JButton("login");
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));
		btnPanel.add(loginBtn);
		btnPanel.add(inputBtn);
		btnPanel.add(confirmBtn);
		btnPanel.add(openfileBtn);
		
		this.getContentPane().add(btnPanel,BorderLayout.NORTH);
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		
		loginBtn.addActionListener(this);
		inputBtn.addActionListener(this);
		confirmBtn.addActionListener(this);
		openfileBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource() == loginBtn){
			LoginDlg dlg  = new LoginDlg(this);
			dlg.setVisible(true);
			
			if(dlg.isOK()){
				System.out.println("login Success");
			}
		}
		else if(ae.getSource() == inputBtn){
			String res = JOptionPane.showInputDialog(this,"your age:","information",JOptionPane.QUESTION_MESSAGE);
			if(res != null){
				JOptionPane.showMessageDialog(this, res);
			}
		}
		else if(ae.getSource() == confirmBtn){
			int res = JOptionPane.showConfirmDialog(this, "Are you sure?","Confirm information",
					JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
			if(res == JOptionPane.YES_OPTION){
				JOptionPane.showMessageDialog(this, "delete successfully");
			}
		}
		else if(ae.getSource() == openfileBtn){
			JFileChooser choose = new JFileChooser();
			int res = choose.showOpenDialog(this);
			if(res == JFileChooser.APPROVE_OPTION){
				File ff = choose.getSelectedFile();
				JOptionPane.showMessageDialog(this, ff.getAbsoluteFile());
			}
		}
	}
}
