package examples100;

import javax.swing.*;
import java.awt.*;

/**
 * Title: �����Լ��Ĵ��� Description: Filename:mainFrame.java
 */
public class mainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * ����˵������������ͨ�����ݲ�������ɴ���Ļ��ơ� ���������String sTitle ������� ���������int iWidth ����Ŀ��
	 * ���������int iHeight ����ĸ߶� �������ͣ�
	 */
	public mainFrame(String sTitle, int iWidth, int iHeight) {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();// ��ȡ��Ļ�ߴ�
		ImageIcon ii = new ImageIcon("middle.gif");
		setTitle(sTitle);// ���ô������
		setIconImage(ii.getImage());// ���ô����ͼ��
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// ���õ��رմ���ʱ�˳�����
		setSize(iWidth, iHeight);// ���ô����С
		int w = getSize().width;// ��ȡ������
		int h = getSize().height;// ��ȡ����߶�
		System.out.println("�����" + w + " ����ߣ�" + h);
		int x = (dim.width - w) / 2;
		int y = (dim.height - h) / 2;
		setLocation(x, y);// �������Ƶ���Ļ�м�
		setVisible(true);// ��ʾ����
	}

	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);// ʹ�����µ�SWING���
		new mainFrame("main Frame Demo", 400, 300);
	}
}