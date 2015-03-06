package examples100;

import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JPanel;

import java.net.URL;

import java.awt.*;
import java.awt.event.*;

/**
 * Title: ��������ʾ Description: �ṩһ�����������������򿪡��������桱�������������߰�ť Filename:
 * ToolBarDemo.java
 */
public class ToolBarDemo extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	protected JTextArea textArea;
	protected String newline = "\n";
	static final private String OPEN = "OPEN";
	static final private String SAVE = "SAVE";
	static final private String SEARCH = "SEARCH";

	/**
	 * ����˵���������� ��������� �������ͣ�
	 */
	public ToolBarDemo() {
		super(new BorderLayout());

		// ����������
		JToolBar toolBar = new JToolBar();
		addButtons(toolBar);

		// ����һ���ı����������һЩ��Ϣ
		textArea = new JTextArea(15, 30);
		textArea.setEditable(true);
		JScrollPane scrollPane = new JScrollPane(textArea);

		// ���ų�Ա
		setPreferredSize(new Dimension(450, 110));
		add(toolBar, BorderLayout.PAGE_START);
		add(scrollPane, BorderLayout.CENTER);
	}

	/**
	 * ����˵�������������� ���������JToolBar toolBar ������ �������ͣ�
	 */
	protected void addButtons(JToolBar toolBar) {
		JButton button = null;

		// ��һ����ť�����򿪡�
		button = makeNavigationButton("Open16", OPEN, "��һ���ļ���", "��");
		toolBar.add(button);

		// �ڶ�����ť�������桱
		button = makeNavigationButton("Save16", SAVE, "���浱ǰ�ļ���", "����");
		toolBar.add(button);

		// ��������ť����������
		button = makeNavigationButton("Search16", SEARCH, "�����ļ��е��ַ���", "����");
		toolBar.add(button);
	}

	/**
	 * ����˵�������칤�����ϵİ�ť ��������� �������ͣ�
	 */
	protected JButton makeNavigationButton(String imageName,
			String actionCommand, String toolTipText, String altText) {
		// ����ͼƬ
		// String imgLocation = "aaa.gif";

		String imgLocation = "aaa.gif";

		URL imageURL = ToolBarDemo.class.getResource(imgLocation);

		// ��ʼ�����߰�ť
		JButton button = new JButton();
		// ���ð�ť������
		button.setActionCommand(actionCommand);
		// ������ʾ��Ϣ
		button.setToolTipText(toolTipText);
		button.addActionListener(this);

		if (imageURL != null) { // �ҵ�ͼ��
			button.setIcon(new ImageIcon(imageURL));
		} else { // û��ͼ��
			button.setText(altText);
			System.err.println("Resource not found: " + imgLocation);
		}

		return button;
	}

	/**
	 * ����˵�����¼����� ��������� �������ͣ�
	 */
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		String description = null;

		if (OPEN.equals(cmd)) { // �����һ����ť
			description = "��һ���ļ�������";
		} else if (SAVE.equals(cmd)) { // ����ڶ�����ť
			description = "�����ļ�����";
		} else if (SEARCH.equals(cmd)) { // �����������ť
			description = "�����ַ�����";
		}

		displayResult("��������������ĳ����㽫���룺 " + description);
	}

	protected void displayResult(String actionDescription) {
		textArea.append(actionDescription + newline);
	}

	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);

		// ���崰��
		JFrame frame = new JFrame("ToolBarDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// �������
		ToolBarDemo newContentPane = new ToolBarDemo();
		newContentPane.setOpaque(true);
		frame.setContentPane(newContentPane);

		// ��ʾ����
		frame.pack();
		frame.setVisible(true);
	}
}