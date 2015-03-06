package gui;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

// BEGIN main
public class JFrameFlowLayout extends JFrame {
	public JFrameFlowLayout() {
		Container cp = getContentPane();
		// Make sure it has a FlowLayout layoutmanager.
		cp.setLayout(new FlowLayout());
		// now add Components to "cp"...
		JButton yes = new JButton("Yes!");
		cp.add(new JLabel("Wonderful?"));
		cp.add(yes);
		
		yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
		pack();
	}

	// We need a main program to instantiate and show.
	public static void main(String[] args) {
		new JFrameFlowLayout().setVisible(true);
	}
}
// END main