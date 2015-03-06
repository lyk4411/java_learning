package com.app;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import com.gui.MyFrame;
import com.gui.TestFrame;

public class App {
	
	/*private static class ActionProcessor implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ae) {
			// TODO Auto-generated method stub
			System.out.println(Math.random());
		}
		
	}*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Frame mainFrame = new Frame("LYK");
		Button okButton = new Button("OK");
		
		mainFrame.add(okButton);
		mainFrame.setVisible(true);
		mainFrame.setLayout(null);
		
		mainFrame.setLocation(100, 200);
		mainFrame.setSize(100, 100);
		
		okButton.setLocation(30,30);
		okButton.setSize(80, 30);*/
		
		/*Frame  f = new Frame("Test FlowLayout");
		f.setLayout(new FlowLayout(FlowLayout.CENTER,15,15));
		
		Button b1 = new Button("aaaaa");
		Button b2 = new Button("bbbbbbbbbbbbbbbbbbbbbbbbbbb");
		Button b3 = new Button("cccc");
		Button b4 = new Button("dddddddddddddd");
		Button b5 = new Button("eeeeeeeeeeeeeeeeeeeeeeeeee");
		
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.add(b5);
		
		f.setLocation(200, 200);
		f.setSize(300, 240);
		f.setVisible(true);
		*/
		/*
		Frame f = new Frame("Test BorderLayout");
		f.setLayout(new BorderLayout());
		
		Button b1 = new Button("11");
		Button b2 = new Button("22");
		Button b3 = new Button("33");
		Button b4 = new Button("44");
		Button b5 = new Button("55");
		
		f.add(b1,BorderLayout.NORTH);
		f.add(b2,BorderLayout.SOUTH);
		f.add(b3,BorderLayout.WEST);
		f.add(b4,BorderLayout.EAST);
		f.add(b5,BorderLayout.CENTER);
		
		f.setLocation(200, 200);
		f.setSize(300, 240);
		f.setVisible(true);
		*/
		/*
		Frame f = new Frame("Test GridLayout");
		f.setLayout(new GridLayout(2,3,5,5));
		
		Button b1 = new Button("11");
		Button b2 = new Button("22");
		Button b3 = new Button("33");
		Button b4 = new Button("44");
		Button b5 = new Button("55");
		Button b6 = new Button("66");
		Button b7 = new Button("77");

		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.add(b5);
		f.add(b6);
		f.add(b7);

		f.setSize(300, 240);
		f.setLocationRelativeTo(null);
		f.setVisible(true);*/
		
		/*Frame f = new Frame("Test Event");
		Button okBtn = new Button("OK");
		f.setLayout(new FlowLayout());
		f.add(okBtn);
		f.setSize(120, 100);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		
		okBtn.addActionListener(new ActionProcessor());
		*/
		
		TestFrame tf= new TestFrame();
		tf.setVisible(true);
		
		
		
		
		for (int i=0;i<10;i++){
			int num = (int)(Math.random() * 100) + 1;
			System.out.println(num);
		}
		List<String> names = new ArrayList<String>();
		names.add("d");
		names.add("c");
		names.add("b");
		names.add("a");	
		System.out.println(names);
		
		render();
	}
	public static void render(){
		int a = 2;
		int b = 3;
		int res = a + b;
		System.out.println(res);
	}
} 
