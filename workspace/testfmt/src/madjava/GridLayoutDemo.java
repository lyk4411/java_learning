package madjava;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;

public class GridLayoutDemo extends Frame {
	Button[] buttons = new Button[9];

	GridLayoutDemo(String title) {
		super(title);
		super.setSize(500, 400);

		super.setLayout(new GridLayout(3, 3));

		for (int i = 0; i < 9; i++) {
			buttons[i] = new Button("b" + i);
			super.add(buttons[i]);
		}
	}

	public static void main(String[] args) {
		GridLayoutDemo gridLayoutDemo = new GridLayoutDemo("GridLayoutÑÝÊ¾");
		gridLayoutDemo.setVisible(true);
	}
}
