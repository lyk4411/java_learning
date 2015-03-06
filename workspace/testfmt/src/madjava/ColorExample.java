package madjava;

import java.awt.Color;
import java.awt.Panel;
import java.awt.Frame;
import java.awt.GridLayout;

public class ColorExample extends Frame {
	Panel aPaper = new Panel();

	ColorExample(String title) {
		super(title);
		super.setSize(500, 400);

		aPaper.setBackground(Color.RED);
		super.add(aPaper);
	}

	public static void main(String[] args) {
		ColorExample colorDemo = new ColorExample("Color");

		colorDemo.setVisible(true);
	}
}
