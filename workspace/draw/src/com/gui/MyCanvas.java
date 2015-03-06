package com.gui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class MyCanvas extends Canvas {
	public void paint(Graphics g){
		g.drawOval(50, 50, 300, 200);
		g.setColor(Color.red);
		g.fillArc(100, 100, 100, 100, 45, 90);
	}
}
