package com.layout;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestCardLayout {
	
	private Frame frame;
	private Panel card1;
	private Panel card2;
	private Panel card3;
	private CardLayout cl;
	
	private class MouseAction extends MouseAdapter {
		//public void mouseClicked(MouseEvent me) {
		//	cl.next(frame);
		//}
		//public void mouseMoved(MouseEvent me){
		//	cl.next(frame);
		//}
		//public void mousePressed(MouseEvent me){
		//	cl.next(frame);
		//}
		//public void mouseReleased(MouseEvent me){
		//	cl.next(frame);
		//}
		public void mouseExited(MouseEvent me){
			cl.next(frame);
		}
		//public void mouseEntered(MouseEvent e){
		//	cl.next(frame);
		//}
	}
	
	private class WindowProcessor extends  WindowAdapter{
		public void windowClosing(WindowEvent e){
			System.exit(0);
		}
	}
	
	public TestCardLayout(){
		MouseAction ma = new MouseAction();
		WindowProcessor wp = new WindowProcessor();
		frame = new Frame("Test CardLayout");
		frame.addWindowListener(wp);
		
		card1 = new Panel();
		card1.setBackground(Color.red);
		card1.addMouseListener(ma);
		card2 = new Panel();
		card2.setBackground(Color.green);
		card2.addMouseListener(ma);
		card3 = new Panel();
		card3.setBackground(Color.blue);
		card3.addMouseListener(ma);
		
		cl = new CardLayout();
		frame.setLayout(cl);
		frame.add(card1,"aaaa");
		frame.add(card2,"bbbb");
		frame.add(card3,"cccc");
		
		cl.show(frame, "aaaa");
		
		frame.setSize(400, 300);
		frame.setLocationRelativeTo(null);
		
		
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TestCardLayout();
	}

}