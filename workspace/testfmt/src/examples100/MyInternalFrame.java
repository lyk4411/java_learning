package examples100;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Title: �ڲ����� Description: ����һ���ڲ����壬�ṩInternalFrameDemo��ʹ�� Filename:
 * MyInternalFrame.java
 */
public class MyInternalFrame extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	static int openFrameCount = 0;
	static final int xOffset = 30, yOffset = 30;

	public MyInternalFrame() {
		super("�ĵ� #" + (++openFrameCount), true, // �ɱ�ߴ�
				true, // �йرհ�ť
				true, // ����󻯰�ť
				true);// ��С����ť

		// ���ڲ��������һ���ı���
		JTextArea j = new JTextArea(5, 20);
		j.setEditable(true);
		JScrollPane scrollPane = new JScrollPane(j);

		getContentPane().add(scrollPane);
		// �����ڲ�����Ĵ�С
		setSize(300, 300);

		// �����ڲ��������ʾλ��
		setLocation(xOffset * openFrameCount, yOffset * openFrameCount);
	}
}