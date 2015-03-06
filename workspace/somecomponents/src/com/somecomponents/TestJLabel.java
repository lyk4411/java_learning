package com.somecomponents;

import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class TestJLabel extends JFrame {

	private class MyIcon implements Icon {

		@Override
		public int getIconHeight() {
			// TODO Auto-generated method stub
			return 55;
		}

		@Override
		public int getIconWidth() {
			// TODO Auto-generated method stub
			return 45;
		}

		@Override
		public void paintIcon(Component c, Graphics g, int x, int y) {
			// TODO Auto-generated method stub
			g.drawOval(0, 0, x, y);
		}
		
	}
	private JLabel nameLabel;
	
	public TestJLabel(){
		Icon icon = new ImageIcon("D:\\Users\\liu.yongkai\\workspace\\somecomponents\\src\\icon.GIF");
		
		//Icon icon = new MyIcon();
		nameLabel = new JLabel("ÌÚÑ¶",icon,SwingConstants.CENTER);
		Container c = getContentPane();
		
		c.add(nameLabel);
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TestJLabel();
	}

}
