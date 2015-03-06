package madjava;

import java.awt.*;
import java.awt.event.*;

public class ThreeListener implements MouseMotionListener, MouseListener,
		WindowListener {
	// ʵ���������ӿ�
	private Frame f;
	private TextField tf;

	public static void main(String args[]) {
		ThreeListener two = new ThreeListener();
		two.go();
	}

	public void go() {
		f = new Frame("Three listeners example");
		f.add(new Label("Click and drag the mouse"), "North");
		tf = new TextField(30);
		f.add(tf, "South"); // ʹ��ȱʡ�Ĳ��ֹ�����
		f.addMouseMotionListener(this); // ע�������MouseMotionListener
		f.addMouseListener(this); // ע�������MouseListener
		f.addWindowListener(this); // ע�������WindowListener
		f.setSize(300, 200);
		f.setVisible(true);
	}

	public void mouseDragged(MouseEvent e) {// ʵ��mouseDragged����
		String s = "Mouse dragging : X=" + e.getX() + "Y = " + e.getY();
		tf.setText(s);
	}

	public void mouseMoved(MouseEvent e) {
	}

	// ���䲻����Ȥ�ķ������Է�����Ϊ��
	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
		String s = "The mouse entered";
		tf.setText(s);
	}

	public void mouseExited(MouseEvent e) {
		String s = "The mouse has left the building";
		tf.setText(s);
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void windowClosing(WindowEvent e) {
		// Ϊ��ʹ�����������رգ����������˳�����Ҫʵ��windowClosing����
		System.exit(1);
	}

	public void windowOpened(WindowEvent e) {
	}

	// ���䲻����Ȥ�ķ������Է�����Ϊ��
	public void windowIconified(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowClosed(WindowEvent e) {
	}

	public void windowActivated(WindowEvent e) {
	}

	public void windowDeactivated(WindowEvent e) {
	}
}
