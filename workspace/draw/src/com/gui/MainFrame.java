package com.gui;

import java.awt.Frame;

public class MainFrame extends Frame {
	private MyCanvas canvas;
	
	public MainFrame(){
		canvas = new MyCanvas();
		
		this.add(canvas);
		
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
	}
}
