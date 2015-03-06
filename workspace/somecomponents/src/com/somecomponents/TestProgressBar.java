package com.somecomponents;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class TestProgressBar extends JFrame {
	private JProgressBar bar;
	
	public TestProgressBar(){
		bar = new JProgressBar(JProgressBar.HORIZONTAL,0,100);
		
		getContentPane().add(bar);
		pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		new Thread(){
			public void run(){
				for (int i= 1; i<= 100 ; i++){
					bar.setValue(i);
					try{
						Thread.sleep(10);
					}
					catch(Exception e){
						
					}
				}
			}
		}.start();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TestProgressBar();
		
	}

}
