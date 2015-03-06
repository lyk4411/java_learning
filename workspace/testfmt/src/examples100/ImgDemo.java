package examples100;

import javax.swing.*;
import java.awt.*;

/**
 * Title: 图片的处理， Description: 将图片放大和翻转显示 Filename: ImgDemo.java
 */
class ImgDemo extends JFrame {

	private static final long serialVersionUID = 1L;
	Image image;

	/**
	 * 方法说明：构造器，显示窗体 输入参数： 返回类型：
	 */
	@SuppressWarnings("deprecation")
	ImgDemo(String filename) {
		setTitle("drawImage Example");
		try {
			image = getToolkit().getImage(filename);
			setIconImage(image);
		} catch (Exception e) {
			e.printStackTrace();
		}

		setSize(600, 250);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		show();
	}

	/**
	 * 方法说明：绘制图像 输入参数： 返回类型：
	 */
	public void paint(Graphics g) {
		Insets insets = getInsets();
		int x = insets.left, y = insets.top;
		// 获取图片尺寸
		int w = image.getWidth(this);
		int h = image.getHeight(this);
		// 正常显示图片
		g.drawImage(image, x, y, this);
		// 缩小图形
		g.drawRect(x, y, w / 4 + 1, h / 4 + 1);// 画一个框
		g.drawImage(image, x + 1, y + 1, w / 4, h / 4, this);
		// 水平翻转
		g.drawImage(image, x + w, y, x + 2 * w, y + h, w, 0, 0, h, this);
	}

	/**
	 * 方法说明：主方法，接受参数 输入参数： 返回类型：
	 */
	public static void main(String[] args) {
		if (args.length == 1) {
			new ImgDemo(args[0]);
		} else {
			System.err.println("usage: java ImgDemo images-name ");
		}
	}
}