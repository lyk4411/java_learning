package examples100;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * Title: ��������ʾ Description: ʹ�û����˿��ƶ�ʱ����������ͼƬ�Ĳ����ٶ� Filename: SliderDemo.java
 */
public class SliderDemo extends JPanel implements ActionListener,
		WindowListener, ChangeListener {

	private static final long serialVersionUID = 1L;
	// ����ͼƬ�Ĳ���
	static final int FPS_MIN = 0; // ������Сֵ
	static final int FPS_MAX = 30; // �������ֵ
	static final int FPS_INIT = 15; // ��ʼ��ֵ
	int frameNumber = 0;
	int NUM_FRAMES = 14;
	ImageIcon[] images = new ImageIcon[NUM_FRAMES];
	int delay;
	Timer timer;
	boolean frozen = false;

	// �����ǩ������ʾ��ֻС��
	JLabel picture;

	public SliderDemo() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		delay = 1000 / FPS_INIT;

		// ��Ϣ��ʾ��ǩ
		JLabel sliderLabel = new JLabel("���������ˣ��ı䲥���ٶȣ�", JLabel.CENTER);
		sliderLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		// ����һ�������ˣ���������Сֵ�����ֵ�Լ���ʼֵ
		JSlider framesPerSecond = new JSlider(JSlider.HORIZONTAL, FPS_MIN,
				FPS_MAX, FPS_INIT);
		framesPerSecond.addChangeListener(this);

		// ���廬���˲���
		framesPerSecond.setMajorTickSpacing(10);// ÿ10�̶ȱ�עһ��
		framesPerSecond.setMinorTickSpacing(1);// ��С�̶�Ϊ1
		framesPerSecond.setPaintTicks(true);// ���ƻ������ϵĿ̶�
		framesPerSecond.setPaintLabels(true);// �ڻ��������л��ƻ�����
		framesPerSecond.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

		// ����һ��������ʾͼƬ�ı�ǩ
		picture = new JLabel();
		picture.setHorizontalAlignment(JLabel.CENTER);
		picture.setAlignmentX(Component.CENTER_ALIGNMENT);
		picture.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLoweredBevelBorder(),
				BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		updatePicture(0); // ��ʾ��һ��ͼ

		// ����Ա��ӵ������
		add(sliderLabel);
		add(framesPerSecond);
		add(picture);
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		// ����һ����ʱ������������¼�
		timer = new Timer(delay, this);
		timer.setInitialDelay(delay * 7); // ��ÿ��ѭ��ͣ��ʱ��
		timer.setCoalesce(true);// �����ظ�ѭ��
	}

	/**
	 * ����˵�������һ��������� ��������� �������ͣ�
	 */
	void addWindowListener(Window w) {
		w.addWindowListener(this);
	}

	public void windowIconified(WindowEvent e) {
		stopAnimation();
	}

	public void windowDeiconified(WindowEvent e) {
		startAnimation();
	}

	public void windowOpened(WindowEvent e) {
	}

	public void windowClosing(WindowEvent e) {
	}

	public void windowClosed(WindowEvent e) {
	}

	public void windowActivated(WindowEvent e) {
	}

	public void windowDeactivated(WindowEvent e) {
	}

	/**
	 * ����˵�����Ի����˽��м��� ���������ChangeEvent e �����˱䶯�¼� �������ͣ�
	 */
	public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider) e.getSource();
		if (!source.getValueIsAdjusting()) {
			int fps = (int) source.getValue();// ��û����˵�ֵ
			if (fps == 0) {
				if (!frozen)
					stopAnimation();
			} else {
				delay = 1000 / fps;
				timer.setDelay(delay);
				timer.setInitialDelay(delay * 10);
				if (frozen)
					startAnimation();
			}
		}
	}

	/**
	 * ����˵������ʼ���� ��������� �������ͣ�
	 */
	public void startAnimation() {
		timer.start();
		frozen = false;
	}

	/**
	 * ����˵����ֹͣ���� ��������� �������ͣ�
	 */
	public void stopAnimation() {
		timer.stop();
		frozen = true;
	}

	/**
	 * ����˵�����¼����� ��������� �������ͣ�
	 */
	public void actionPerformed(ActionEvent e) {
		// �ı�ͼƬ֡
		if (frameNumber == (NUM_FRAMES - 1)) {
			frameNumber = 0;
		} else {
			frameNumber++;
		}

		updatePicture(frameNumber); // ��ʾ����ͼ

		if (frameNumber == (NUM_FRAMES - 1)
				|| frameNumber == (NUM_FRAMES / 2 - 1)) {
			timer.restart();
		}
	}

	/**
	 * ����˵�������Ƶ�ǰ֡ ���������int frameNum ͼƬ֡���� �������ͣ�
	 */
	protected void updatePicture(int frameNum) {
		if (images[frameNumber] == null) {
			images[frameNumber] = createImageIcon("images/doggy/T"
					+ frameNumber + ".gif");
		}

		// ����ͼƬ
		if (images[frameNumber] != null) {
			picture.setIcon(images[frameNumber]);
		} else { // ���û�з���ͼƬ
			picture.setText("image #" + frameNumber + " not found");
		}
	}

	/**
	 * ����˵������ȡͼƬ ���������String path ͼƬ·�� �������ͣ�ImageIcon ͼƬ����
	 */
	protected static ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = SliderDemo.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	/**
	 * ����˵���������� ��������� �������ͣ�
	 */
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);

		// ���崰��
		JFrame frame = new JFrame("SliderDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// ʵ��������
		SliderDemo animator = new SliderDemo();
		animator.setOpaque(true);
		frame.setContentPane(animator);

		// ��ʾ����
		frame.pack();
		frame.setVisible(true);
		animator.startAnimation();
	}
}