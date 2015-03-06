package game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BallCanvas extends Canvas {
	private List<Ball> balls = new ArrayList<Ball>();

	private class MouseAct extends MouseAdapter {
		public void mousePressed(MouseEvent me){
			Point pt = me.getPoint();
			Iterator<Ball> it = balls.iterator();
			while(it.hasNext()){
				Ball tb = it.next();
				if(tb.isPointIn(pt)){
					balls.remove(tb);
					repaint();
					break;
				}
			}
		}
	}
	
	public BallCanvas(){
		addMouseListener(new MouseAct());
	}
	
	public void start(int count){
		balls.clear();
		for(int i=0; i < count; i++){
			Ball tb = new Ball(this);
			balls.add(tb);
			tb.start();
		}
	}
	
	public void update(Graphics g){
		paint(g);
	}
	
	public void paint(Graphics g){
		int width = (int) this.getSize().getWidth();
		int height = (int) this.getSize().getHeight();
		BufferedImage buf = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		Graphics tg = buf.getGraphics();
		tg.setColor(Color.white);
		tg.fillRect(0, 0, width, height);
		
		Iterator<Ball> it = balls.iterator();
		while(it.hasNext()){
			Ball tb = it.next();
			tb.draw(tg);
		}
		g.drawImage(buf, 0, 0,null);
	}
}
