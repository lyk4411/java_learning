package game;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BallFrame extends Frame {
	private BallCanvas bc;
	
	public BallFrame(){
		bc = new BallCanvas();
		this.add(bc);
		
		this.setSize(400,450);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		bc.start(10);
		
		this.addWindowListener(new WindowProcessor());
	}
	
	private class WindowProcessor extends WindowAdapter{
		public void windowClosing(WindowEvent e){
			System.exit(0);
		}
	}
	
	public static void main(String args[]){
		new BallFrame();
	}
}
