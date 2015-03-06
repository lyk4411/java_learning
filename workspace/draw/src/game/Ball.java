package game;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;

public class Ball implements Runnable{
	private int r;
	private Color c;
	private Point pos;
	private int speed;
	private Component owner;
	
	public Ball(int r,Color c,int speed,Component owner){
		this.r = r;
		this.c = c;
		this.speed = speed;
		this.owner = owner;
	}
	public Ball(Component owner){
		this.owner = owner;
		this.r = (int)(Math.random() * 11 + 10);
		this.c = new Color((int)(Math.random() * 256),
							(int)(Math.random() * 256),
							(int)(Math.random() * 256));
		this.pos = new Point(0,0);
		int width = (int) owner.getSize().getWidth();
		pos.x = (int) (r + (width - 2 * r) * Math.random());
		pos.y = (int) owner.getSize().getHeight() - r;
		speed = (int)((Math.random() * 15) + 5);
	}
	public void draw(Graphics g){
		g.setColor(c);
		g.fillOval(pos.x - r, pos.y - r, 2*r, 2*r);
	}
	
	public boolean isPointIn(Point pt){
		return pt.distance(pos) <= r;
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true){
			try{
				Thread.sleep(speed);				
			}
			catch(Exception e){
			}
			
			pos.y -= 1;
			owner.repaint(pos.x-r-1,pos.y-r-1,2*r+2,2*r+4);
			if(pos.y - r <= 0){
				break;
			}
			
		}
	}
	public void start(){
		Thread t = new Thread(this);
		t.start();
	}
}
