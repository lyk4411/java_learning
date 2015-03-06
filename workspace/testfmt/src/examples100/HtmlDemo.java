package examples100;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Description: ������ʾʹ��html������swing����Ϲ�����ʾ��Ϣ Filename: HtmlDemo.java
 */

public class HtmlDemo extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	JLabel theLabel;
	JTextArea htmlTextArea;

	/**
	 * ����˵���������������������еĳ�Ա ��������� �������ͣ�
	 */
	public HtmlDemo() {
		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

		String initialText = "<html>\n" + "��ɫ���������:\n" + "<ul>\n"
				+ "<li><font color=red>red</font>\n"
				+ "<li><font color=blue>blue</font>\n"
				+ "<li><font color=green>green</font>\n"
				+ "<li><font size=-2>small</font>\n"
				+ "<li><font size=+2>large</font>\n" + "<li><i>italic</i>\n"
				+ "<li><b>bold</b>\n" + "</ul>\n";
		// ����һ���ı���
		htmlTextArea = new JTextArea(10, 20);
		htmlTextArea.setText(initialText);
		JScrollPane scrollPane = new JScrollPane(htmlTextArea);
		// ���尴ť
		JButton changeTheLabel = new JButton("�ı���ʾ");
		changeTheLabel.setMnemonic(KeyEvent.VK_C);
		changeTheLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		changeTheLabel.addActionListener(this);
		// �����ǩ
		theLabel = new JLabel(initialText) {

			private static final long serialVersionUID = 1L;

			public Dimension getPreferredSize() {
				return new Dimension(200, 200);
			}

			public Dimension getMinimumSize() {
				return new Dimension(200, 200);
			}

			public Dimension getMaximumSize() {
				return new Dimension(200, 200);
			}
		};
		// ���ñ�ǩ�Ķ��뷽ʽ
		theLabel.setVerticalAlignment(SwingConstants.CENTER);
		theLabel.setHorizontalAlignment(SwingConstants.CENTER);
		// ����һ�����߿����ߵı༭���
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.PAGE_AXIS));
		leftPanel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("�༭HTML�������ť��ʾ�����"),
				BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		leftPanel.add(scrollPane);
		leftPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		leftPanel.add(changeTheLabel);
		// ����һ�����߿���ұ���ʾ�����
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.PAGE_AXIS));
		rightPanel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("����ʹ�ñ�ǩ��ʾHTML���"),
				BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		rightPanel.add(theLabel);

		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		add(leftPanel);
		add(Box.createRigidArea(new Dimension(10, 0)));
		add(rightPanel);
	}

	/**
	 * ����˵�����¼����������û������ť���� ��������� �������ͣ�
	 */
	public void actionPerformed(ActionEvent e) {
		theLabel.setText(htmlTextArea.getText());
	}

	/**
	 * ����˵���������� ��������� �������ͣ�
	 */
	public static void main(String[] args) {

		JFrame.setDefaultLookAndFeelDecorated(true);

		// ��������
		JFrame frame = new JFrame("HtmlDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// �������
		JComponent newContentPane = new HtmlDemo();
		newContentPane.setOpaque(true);
		frame.setContentPane(newContentPane);

		// ��ʾ����
		frame.pack();
		frame.setVisible(true);
	}
}