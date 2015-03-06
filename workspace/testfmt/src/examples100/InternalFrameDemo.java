package examples100;

import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

import java.awt.event.*;
import java.awt.*;

/**
 * Title: �ڲ�������ʾ Description: ������ʾһ���ڲ����塣����ѡ�����ĵ����˵���ͣ�������ڲ����塣 Filename:
 */
public class InternalFrameDemo extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	JDesktopPane desktop;

	/**
	 * ����˵��������������Ӵ����Ա ��������� �������ͣ�
	 */
	public InternalFrameDemo() {
		super("InternalFrameDemo");

		// ����������һ���Ƚϴ�Ĵ��壬������ֻ����50px�ı߽�
		int inset = 50;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(inset, inset, screenSize.width - inset * 2, screenSize.height
				- inset * 2);

		// �������
		desktop = new JDesktopPane(); // �������
		createFrame(); // ������һ���ڲ�����
		setContentPane(desktop);// ��������ӵ�����
		setJMenuBar(createMenuBar());

		// ������קģʽ
		desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
	}

	/**
	 * ����˵�����齨�˵� ��������� �������ͣ�
	 */
	protected JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();

		// ����һ���˵�
		JMenu menu = new JMenu("�ļ�");
		menu.setMnemonic(KeyEvent.VK_D);
		menuBar.add(menu);

		// ���塰���ĵ����˵�
		JMenuItem menuItem = new JMenuItem("���ĵ�");
		menuItem.setMnemonic(KeyEvent.VK_N);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
				ActionEvent.ALT_MASK));
		menuItem.setActionCommand("new");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		// ���塰�˳����˵�
		menuItem = new JMenuItem("�˳�");
		menuItem.setMnemonic(KeyEvent.VK_Q);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
				ActionEvent.ALT_MASK));
		menuItem.setActionCommand("quit");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		return menuBar;
	}

	/**
	 * ����˵�����¼���������ѡ��Ĳ˵�������ӳ ���������ActionEvent e �¼� �������ͣ�
	 */
	public void actionPerformed(ActionEvent e) {
		if ("new".equals(e.getActionCommand())) { // ���ĵ�
			createFrame();
		} else if("quit".equals(e.getActionCommand())){ // �˳�
			quit();
		}
	}

	/**
	 * ����˵��������MyInternalFrame�ഴ���µ��ڲ����壬 ��������� �������ͣ�
	 */
	protected void createFrame() {
		MyInternalFrame frame = new MyInternalFrame();

		frame.setVisible(true);
		desktop.add(frame);
		try {
			frame.setSelected(true);
		} catch (java.beans.PropertyVetoException e) {
		}
	}

	/**
	 * ����˵�����˳����� ��������� �������ͣ�
	 */
	protected void quit() {
		System.exit(0);
	}

	/**
	 * ����˵���������� ��������� �������ͣ�
	 */
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);

		// ����һ���ڲ�����
		InternalFrameDemo frame = new InternalFrameDemo();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// ��ʾ����
		frame.setVisible(true);
	}
}