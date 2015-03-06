package madjava;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Frame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CardLayoutDemo extends Frame implements ActionListener {
	Button b1 = new Button("Button1");
	Button b2 = new Button("Button2");
	Button b3 = new Button("Button3");
	Button b4 = new Button("Button4");
	Button b5 = new Button("Button5");

	CardLayout card = new CardLayout();

	CardLayoutDemo(String title) {
		super(title);
		super.setSize(500, 400);

		// 将窗口设置为卡片布局
		super.setLayout(card);

		super.add(b1, "b1");
		super.add(b2, "b2");
		super.add(b3, "b3");
		super.add(b4, "b4");
		super.add(b5, "b5");

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		// 翻书
		card.next(this);
	}

	public static void main(String[] args) {
		CardLayoutDemo cardLayoutDemo = new CardLayoutDemo("CardLayout演示");

		cardLayoutDemo.setVisible(true);
	}
}
