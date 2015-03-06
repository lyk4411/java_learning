package examples100;

//                            _ooOoo_  
//                           o8888888o  
//                           88" . "88  
//                           (| -_- |)  
//                            O\ = /O  
//                        ____/`---'\____  
//                      .   ' \\| |// `.  
//                       / \\||| : |||// \  
//                     / _||||| -:- |||||- \  
//                       | | \\\ - /// | |  
//                     | \_| ''\---/'' | |  
//                      \ .-\__ `-` ___/-. /  
//                   ___`. .' /--.--\ `. . __  
//                ."" '< `.___\_<|>_/___.' >'"".  
//               | | : `- \`.;`\ _ /`;.`/ - ` : | |  
//                 \ \ `-. \_ __\ /__ _/ .-` / /  
//         ======`-.____`-.___\_____/___.-`____.-'======  
//                            `=---='  
//  
//         .............................................  
//                  ���汣��             ����BUG 
//          ��Ի:  
//                  д��¥��д�ּ䣬д�ּ������Ա��  
//                  ������Աд�������ó��򻻾�Ǯ��  
//                  ����ֻ���������������������ߣ�  
//                  ��������ո��գ����������긴�ꡣ  
//                  ��Ը�������Լ䣬��Ը�Ϲ��ϰ�ǰ��  
//                  ���۱������Ȥ���������г���Ա��  
//                  ����Ц��߯��񲣬��Ц�Լ���̫����  
//                  ��������Ư���ã��ĸ���ó���Ա��  


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Title: ��ť��ʾ Description: �ṩһ����ť����ʾ�����ʵ�ְ�ť����һ����ťʧЧ Filename:
 */
public class ButtonDemo extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	protected JButton b1, b2, b3;

	/**
	 * ����˵��������������ʼͼ�ν��湹��
	 */
	public ButtonDemo() {
		ImageIcon leftButtonIcon = createImageIcon("images/right.gif");
		ImageIcon middleButtonIcon = createImageIcon("images/middle.gif");
		ImageIcon rightButtonIcon = createImageIcon("images/left.gif");

		b1 = new JButton("ʧЧ�м䰴ť(D)", leftButtonIcon);
		b1.setVerticalTextPosition(AbstractButton.CENTER);// ˮƽ�м����
		b1.setHorizontalTextPosition(AbstractButton.LEADING);// �൱��LEFT
		b1.setMnemonic(KeyEvent.VK_D);// ��b1�alt+D��
		b1.setActionCommand("disable");

		b2 = new JButton("M�м䰴ť", middleButtonIcon);
		b2.setVerticalTextPosition(AbstractButton.BOTTOM);
		b2.setHorizontalTextPosition(AbstractButton.CENTER);
		b2.setMnemonic(KeyEvent.VK_M);// ��b2�alt+M��

		b3 = new JButton("E�����м䰴ť", rightButtonIcon);
		b3.setMnemonic(KeyEvent.VK_E);// ��b3�alt+E��
		b3.setActionCommand("enable");
		b3.setEnabled(false);

		// ��1��3����¼�����
		b1.addActionListener(this);
		b3.addActionListener(this);
		// ���ð�ť��ʾ�ı�
		b1.setToolTipText("��������ť����ʹ�м�İ�ťʧЧ��");
		b2.setToolTipText("��������ť��û���κε��¼�������");
		b3.setToolTipText("��������ť����ʹ�м�İ�ť��Ч");

		// ����ť��ӵ�JPanel��
		add(b1);
		add(b2);
		add(b3);
	}

	/**
	 * ����˵�����¼�����
	 */
	public void actionPerformed(ActionEvent e) {
		if ("disable".equals(e.getActionCommand())) {
			b2.setEnabled(false);
			b1.setEnabled(false);
			b3.setEnabled(true);
		} else {
			b2.setEnabled(true);
			b1.setEnabled(true);
			b3.setEnabled(false);
		}
	}

	/**
	 * ����˵��������ͼ�꣬ ���������String path ͼ�����ڵ�·�� �������ͣ�ImageIcon ͼ�����
	 */
	protected static ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = ButtonDemo.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	/**
	 * ����˵����������
	 */
	public static void main(String[] args) {
		// ����ʹ���µ�swing����
		JFrame.setDefaultLookAndFeelDecorated(true);

		// ����һ������
		JFrame frame = new JFrame("ButtonDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// ����һ�����
		ButtonDemo newContentPane = new ButtonDemo();
		newContentPane.setOpaque(true);
		frame.setContentPane(newContentPane);

		// ��ʾ����
		frame.pack();
		frame.setVisible(true);
	}
}