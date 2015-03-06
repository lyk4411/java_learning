package examples100;

import javax.swing.*;
import java.awt.*;

/**
 * Title: ͼƬ�Ĵ��� Description: ��ͼƬ�Ŵ�ͷ�ת��ʾ Filename: ImgDemo.java
 */
class ImgDemo extends JFrame {

	private static final long serialVersionUID = 1L;
	Image image;

	/**
	 * ����˵��������������ʾ���� ��������� �������ͣ�
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
	 * ����˵��������ͼ�� ��������� �������ͣ�
	 */
	public void paint(Graphics g) {
		Insets insets = getInsets();
		int x = insets.left, y = insets.top;
		// ��ȡͼƬ�ߴ�
		int w = image.getWidth(this);
		int h = image.getHeight(this);
		// ������ʾͼƬ
		g.drawImage(image, x, y, this);
		// ��Сͼ��
		g.drawRect(x, y, w / 4 + 1, h / 4 + 1);// ��һ����
		g.drawImage(image, x + 1, y + 1, w / 4, h / 4, this);
		// ˮƽ��ת
		g.drawImage(image, x + w, y, x + 2 * w, y + h, w, 0, 0, h, this);
	}

	/**
	 * ����˵���������������ܲ��� ��������� �������ͣ�
	 */
	public static void main(String[] args) {
		if (args.length == 1) {
			new ImgDemo(args[0]);
		} else {
			System.err.println("usage: java ImgDemo images-name ");
		}
	}
}