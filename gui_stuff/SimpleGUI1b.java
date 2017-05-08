import javax.swing.*;
import java.awt.event.*;

public class SimpleGUI1b implements ActionListener /* 1 */  {

	JButton button;

	public static void main (String[] args) {

		SimpleGUI1b gui = new SimpleGUI1b();
		gui.go();

		/*
		JFrame frame = new JFrame();
		//basically the window
		JButton button = new JButton("click me");
		//button we want to put in the window

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//doesn't default to quitting the program on close, this is what this call does

		frame.getContentPane().add(button);
		//adds the button to the frame's content pane

		frame.setSize(300,300);
		//sets the size of the frame. But why do we not do this before adding the button?

		frame.setVisible(true);
		//not default to actually showing the frame, we have to do this manually.
		*/
	}

	/* 2 */ public void go() {

		JFrame frame = new JFrame();
		button = new JButton("click me");

		button.addActionListener(this);

		frame.getContentPane().add(button);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,300);
		frame.setVisible(true);

	}

	/* 3 */ public void actionPerformed(ActionEvent event) {
		button.setText("I've been clicked!");
	}

	/*
		1) Implement Action Listener Interface
		2) register with the button to tell it you want to listen to it's events
		3) define the event handling method (or, implement the actionPerformed() method
		from the ActionListener interface)
	*/
}