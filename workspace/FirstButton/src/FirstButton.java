import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.*;

public class FirstButton extends JFrame implements ActionListener{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("SwingApplication");  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
		JButton hi = new JButton("Hi");
		
        frame.getContentPane().add(hi, BorderLayout.CENTER);  
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
		if(cmd.equals("Hi")){
			System.out.println("Hello world");
		}
	}
}
