package com.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import com.domain.Book;

public class CatalogFrame extends JFrame {
	private JTree tree;
	private JLabel label;
	
	private class MySelect implements TreeSelectionListener{

		@Override
		public void valueChanged(TreeSelectionEvent tse) {
			// TODO Auto-generated method stub
			TreePath tp = tse.getNewLeadSelectionPath();
			DefaultMutableTreeNode node = (DefaultMutableTreeNode)tp.getLastPathComponent();
			Book tb = (Book)node.getUserObject();
			System.out.println(tb);
			
			label.setText(tb.getName() + ":" + tb.getPrice());
		}
		
	}
	
	public CatalogFrame(){
		
		DefaultMutableTreeNode root = new  DefaultMutableTreeNode(new Book("root",0));
		DefaultMutableTreeNode computer = new DefaultMutableTreeNode(new Book("computer",0));
		DefaultMutableTreeNode language = new DefaultMutableTreeNode(new Book("language",0));
		
		root.add(computer);
		root.add(language);

		DefaultMutableTreeNode java = new DefaultMutableTreeNode(new Book("Java",100));
		DefaultMutableTreeNode CPP = new DefaultMutableTreeNode(new Book("C++",101));
		
		computer.add(java);
		computer.add(CPP);
		
		DefaultMutableTreeNode english = new DefaultMutableTreeNode(new Book("English",45));
		DefaultMutableTreeNode japanese = new DefaultMutableTreeNode(new Book("Japanese",30));
		
		language.add(english);
		language.add(japanese);
		
		tree = new JTree(root);
		tree.setEditable(true);
		
		TreePath tp = new TreePath(computer.getPath());
		tree.expandPath(tp);
		
		label = new JLabel();
		
		this.getContentPane().add(new JScrollPane(tree),BorderLayout.WEST);
		this.getContentPane().add(label);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		tree.addTreeSelectionListener(new MySelect());
		
	}
}
