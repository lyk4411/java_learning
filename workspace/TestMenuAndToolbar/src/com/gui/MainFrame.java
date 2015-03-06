package com.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JToolBar;

public class MainFrame extends JFrame {
	
	private JPopupMenu popupMenu;
	
	public MainFrame(){
		super("hello menu and toolbar");
		
		initMenu();
		initToolBar();
		initEvents();
		
		this.setSize(500, 400);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	private class MyMouse extends MouseAdapter{
		public void mouseClicked(MouseEvent me){
			if(me.getButton() == MouseEvent.BUTTON3){
				popupMenu.show(getContentPane(),me.getPoint().x,me.getPoint().y);
			}
		}
	}
	
	private void initEvents(){
		popupMenu = new JPopupMenu();
		JMenuItem newItem = new JMenuItem("new");
		JMenuItem saveItem = new JMenuItem("save");
		popupMenu.add(newItem);
		popupMenu.add(saveItem);
		
		Container c = this.getContentPane();
		c.addMouseListener(new MyMouse());
	}
	
	private class MyAction extends AbstractAction{

		public MyAction(String name,Icon icon){
			super(name,icon);
		}
		@Override
		public void actionPerformed(ActionEvent e) {// 20'
			// TODO Auto-generated method stub
			System.out.println("adfafas");
		}
		
	}
	private void initToolBar(){
		JToolBar bar = new JToolBar("quick start");
		bar.add(new MyAction("hello", new ImageIcon("")));
		
		this.getContentPane().add(bar,BorderLayout.NORTH);
		
	}

	
	private void initMenu(){
		JMenuBar bar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("file");
		JMenu editMenu = new JMenu("edit");
		JMenu windowMenu = new JMenu("window");
		
		bar.add(fileMenu);
		bar.add(editMenu);
		bar.add(windowMenu);
		
		JMenuItem newItem = new JMenuItem("new");
		JMenuItem saveItem = new JMenuItem("save");
		JMenuItem exitItem = new JMenuItem("exit");
		
		JCheckBoxMenuItem toolbarItem = new JCheckBoxMenuItem("toolbar");
		windowMenu.add(toolbarItem);
		
		fileMenu.add(newItem);
		fileMenu.add(saveItem);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);
		
		exitItem.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ae) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		this.setJMenuBar(bar);
	}
}
