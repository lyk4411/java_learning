package graphics;

import java.awt.*;

import javax.swing.*;

// BEGIN main
public class DrawStringDemo extends JComponent {
	private static final long serialVersionUID = -7199469682507443122L;
	int textX = 10, textY = 20;

	@Override
	public void paintComponent(Graphics g) {
		g.drawString("Hello Java", textX, textY);
	}

	public Dimension getPreferredSize() {
		return new Dimension(100, 100);
	}
	public static void main(final String[] args) {
		final JFrame jf = new JFrame();
		jf.add(new DrawStringDemo());
		jf.setBounds(100, 100, 100, 100);
		jf.setVisible(true);
	}
}
// END main