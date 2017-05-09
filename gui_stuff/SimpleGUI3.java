import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleGUI3 implements ActionListener {
	
	JFrame frame;

	public static void main(String[] args) {

		SimpleGUI3 gui = new SimpleGUI3();

		gui.go();

	}

	public void go() {

		frame = new JFrame();
		//JPanel panel = new JPanel();
		JButton button = new JButton();
		MyDrawPanel dp = new MyDrawPanel();

		button.addActionListener(this);
		button.setText("Click to change the colour!");

		frame.getContentPane().add(BorderLayout.CENTER, dp);
		frame.getContentPane().add(BorderLayout.SOUTH, button);
		

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,500);
		frame.setVisible(true);


	}

	public void actionPerformed(ActionEvent event) {

		frame.repaint();

	}



}