package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

// BEGIN main
public class TabPaneDemo {
	protected JTabbedPane tabPane = new JTabbedPane();

	public TabPaneDemo() {
		//tabPane = new JTabbedPane();
		tabPane.add(new JLabel("One", JLabel.CENTER), "First");
		tabPane.add(new JLabel("Two", JLabel.CENTER), "Second");
		tabPane.add(new JLabel("Three", JLabel.CENTER), "Third");
	}

	public static void main(String[] a) {
		JFrame f = new JFrame("Tab Demo");
		f.getContentPane().add(new TabPaneDemo().tabPane);
		f.setSize(300, 200);
		f.setVisible(true);
	}
}
// END main