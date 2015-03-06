package examples100;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Title: 内部窗体 Description: 生成一个内部窗体，提供InternalFrameDemo类使用 Filename:
 * MyInternalFrame.java
 */
public class MyInternalFrame extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	static int openFrameCount = 0;
	static final int xOffset = 30, yOffset = 30;

	public MyInternalFrame() {
		super("文档 #" + (++openFrameCount), true, // 可变尺寸
				true, // 有关闭按钮
				true, // 有最大化按钮
				true);// 最小化按钮

		// 给内部窗体添加一个文本域
		JTextArea j = new JTextArea(5, 20);
		j.setEditable(true);
		JScrollPane scrollPane = new JScrollPane(j);

		getContentPane().add(scrollPane);
		// 设置内部窗体的大小
		setSize(300, 300);

		// 设置内部窗体的显示位置
		setLocation(xOffset * openFrameCount, yOffset * openFrameCount);
	}
}