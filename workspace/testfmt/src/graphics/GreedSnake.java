package graphics;

import java.awt.*;
import java.awt.event.*;

public class GreedSnake // 主类
{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyWindow();

	}

}

class MyPanel extends Panel implements KeyListener, Runnable// 自定义面板类，继承了键盘和线程接口
{

	Button snake[]; // 定义蛇按钮
	int shu = 0; // 蛇的节数
	int food[]; // 食物数组
	boolean result = true; // 判定结果是输 还是赢
	Thread thread; // 定义线程
	static int weix, weiy; // 食物位置
	boolean t = true; // 判定游戏是否结束
	int fangxiang = 0; // 蛇移动方向
	int x = 0, y = 0; // 蛇头位置

	MyPanel() {

		setLayout(null);
		snake = new Button[20];
		food = new int[20];
		thread = new Thread(this);

		for (int j = 0; j < 20; j++) {
			food[j] = (int) (Math.random() * 99);// 定义20个随机食物
		}

		weix = (int) (food[0] * 0.1) * 60; // 十位*60为横坐标
		weiy = (int) (food[0] % 10) * 40; // 个位*40为纵坐标
		for (int i = 0; i < 20; i++) {
			snake[i] = new Button();
		}

		add(snake[0]);
		snake[0].setBackground(Color.black);
		snake[0].addKeyListener(this); // 为蛇头添加键盘监视器
		snake[0].setBounds(0, 0, 10, 10);
		setBackground(Color.cyan);
	}

	public void run() // 接收线程
	{

		while (t) {

			if (fangxiang == 0)// 向右
			{
				try {
					x += 10;
					snake[0].setLocation(x, y);// 设置蛇头位置

					if (x == weix && y == weiy) // 吃到食物
					{
						shu++;
						weix = (int) (food[shu] * 0.1) * 60;
						weiy = (int) (food[shu] % 10) * 40;
						repaint(); // 重绘下一个食物
						add(snake[shu]); // 增加蛇节数和位置
						snake[shu].setBounds(snake[shu - 1].getBounds());
					}
					thread.sleep(100); // 睡眠100ms
				} catch (Exception e) {
				}
			} else if (fangxiang == 1)// 向左
			{
				try {
					x -= 10;
					snake[0].setLocation(x, y);
					if (x == weix && y == weiy) {
						shu++;
						weix = (int) (food[shu] * 0.1) * 60;
						weiy = (int) (food[shu] % 10) * 40;
						repaint();
						add(snake[shu]);
						snake[shu].setBounds(snake[shu - 1].getBounds());
					}

					thread.sleep(100);
				} catch (Exception e) {
				}
			} else if (fangxiang == 2)// 向上
			{
				try {
					y -= 10;
					snake[0].setLocation(x, y);
					if (x == weix && y == weiy) {
						shu++;
						weix = (int) (food[shu] * 0.1) * 60;
						weiy = (int) (food[shu] % 10) * 40;
						repaint();
						add(snake[shu]);
						snake[shu].setBounds(snake[shu - 1].getBounds());
					}
					thread.sleep(100);
				} catch (Exception e) {
				}
			} else if (fangxiang == 3)// 向下
			{
				try {
					y += 10;
					snake[0].setLocation(x, y);
					if (x == weix && y == weiy) {
						shu++;
						weix = (int) (food[shu] * 0.1) * 60;
						weiy = (int) (food[shu] % 10) * 40;
						repaint();
						add(snake[shu]);
						snake[shu].setBounds(snake[shu - 1].getBounds());
					}
					thread.sleep(100);
				} catch (Exception e) {
				}
			}
			int num1 = shu;
			while (num1 > 1)// 判断是否咬自己的尾巴
			{
				if (snake[num1].getBounds().x == snake[0].getBounds().x
						&& snake[num1].getBounds().y == snake[0].getBounds().y) {
					t = false;
					result = false;
					repaint();
				}
				num1--;
			}
			if (x < 0 || x >= this.getWidth() || y < 0 || y >= this.getHeight())// 判断是否撞墙
			{
				t = false;
				result = false;
				repaint();
			}
			int num = shu;
			while (num > 0) // 设置蛇节位置
			{
				snake[num].setBounds(snake[num - 1].getBounds());
				num--;
			}

			if (shu == 15) // 如果蛇节数等于15则胜利
			{
				t = false;
				result = true;
				repaint();
			}

		}

	}

	public void keyPressed(KeyEvent e) // 按下键盘方向键
	{
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)// 右键
		{
			if (fangxiang != 1)// 如果先前方向不为左
				fangxiang = 0;

		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (fangxiang != 0)
				fangxiang = 1;

		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			if (fangxiang != 3)
				fangxiang = 2;

		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			if (fangxiang != 2)
				fangxiang = 3;

		}
	}

	public void keyTyped(KeyEvent e) {

	}

	public void keyReleased(KeyEvent e) {

	}

	public void paint(Graphics g) // 在面板上绘图
	{
		int x1 = this.getWidth() - 1;
		int y1 = this.getHeight() - 1;
		g.setColor(Color.red);
		g.fillOval(weix, weiy, 10, 10);// 食物
		g.drawRect(0, 0, x1, y1); // 墙
		if (t == false && result == false)
			g.drawString("GAME OVER!", 250, 200);// 输出游戏失败
		else if (t == false && result == true)
			g.drawString("YOU WIN!", 250, 200);// 输出游戏成功
	}

}

class MyWindow extends Frame implements ActionListener// 自定义窗口类
{
	MyPanel my;
	Button btn;
	Panel panel;

	MyWindow() {
		super("GreedSnake");
		my = new MyPanel();
		btn = new Button("begin");
		panel = new Panel();
		btn.addActionListener(this);
		panel.add(new Label("begin后请按Tab键选定蛇"));
		panel.add(btn);
		panel.add(new Label("按上下左右键控制蛇行动"));
		add(panel, BorderLayout.NORTH);
		add(my, BorderLayout.CENTER);
		setBounds(100, 100, 610, 500);
		setVisible(true);
		validate();
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public void actionPerformed(ActionEvent e)// 按下begin按钮
	{

		if (e.getSource() == btn) {
			try {
				my.thread.start(); // 开始线程
				my.validate();
			} catch (Exception ee) {
			}
		}

	}
}