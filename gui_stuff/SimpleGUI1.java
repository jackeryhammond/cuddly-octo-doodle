import javax.swing.*;

public class SimpleGUI1 {

	public static void main (String[] args) {

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
	}
}