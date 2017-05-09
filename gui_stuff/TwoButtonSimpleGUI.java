import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TwoButtonSimpleGUI  {
	
	JFrame frame;
	JLabel label;

	public static void main(String[] args) {

		TwoButtonSimpleGUI gui = new TwoButtonSimpleGUI();

		gui.go();

	}

	public void go() {

		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton colorButton = new JButton();
		JButton labelButton = new JButton();


		
		colorButton.setText("Click to change the colour.");
		colorButton.addActionListener(new ColorListener());

		labelButton.setText("Click to change label.");
		labelButton.addActionListener(new LabelListener());

		label = new JLabel("I'm a label!");
		MyDrawPanel dp = new MyDrawPanel();

		frame.getContentPane().add(BorderLayout.EAST, labelButton);
		frame.getContentPane().add(BorderLayout.WEST, label);
		frame.getContentPane().add(BorderLayout.CENTER, dp);
		frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
		

		frame.setSize(1000,1000);
		frame.setVisible(true);


	}

	class ColorListener implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			frame.repaint();
		}
	}

	class LabelListener implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			label.setText("At least the button works...");
		}
	}



}