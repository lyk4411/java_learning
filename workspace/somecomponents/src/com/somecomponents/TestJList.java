package com.somecomponents;

import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class TestJList extends JFrame{
	private JList msgList;
	
	private class MyListModel extends AbstractListModel{
		private String[] contents = {
				"Thinking in java",
				"Master EJB",
				"C++ primer",
				"Struts in action"
		};
		@Override
		public Object getElementAt(int index) {
			// TODO Auto-generated method stub
			return contents[index];
		}

		@Override
		public int getSize() {
			// TODO Auto-generated method stub
			return contents.length;
		}
		
	}
	
	public TestJList(){
		msgList = new JList(new MyListModel());
		this.getContentPane().add(new JScrollPane(msgList));
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TestJList();
	}
}
