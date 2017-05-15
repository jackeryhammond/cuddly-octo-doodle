import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextArea1 implements ActionListener {
	
	JTextArea tArea;
	JCheckBox check;
	int buttonPressCount = 0;

	public static void main(String[] args) {

		TextArea1 ta = new TextArea1();

		ta.go();
	}

	public void go() {

		//make JFrame
		JFrame frame = new JFrame("Text Area Practice");

		JPanel panel = new JPanel();

		check = new JCheckBox("Add counter");

		JButton button = new JButton("Click this button, see what happens bud.");

		button.addActionListener(this);

		//make text area
		tArea = new JTextArea(10, 23);
		tArea.setLineWrap(true);

		//make scroll pane
		//add text area to scroll pane
		JScrollPane scroller = new JScrollPane(tArea);

		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		//add scroll pane to panel
		panel.add(scroller);
		panel.add(check);
		//add panel and button to frame
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.getContentPane().add(BorderLayout.SOUTH, button);

		//finishing touches
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(350, 300);
		frame.setVisible(true);
		



	}

	public void actionPerformed(ActionEvent event) {
		
		buttonPressCount++;
		
		tArea.append("Button clicked \n");
		
		//deals with grammar and if check box is selected
		if(check.isSelected())
		{
			if(buttonPressCount > 1) {
				tArea.append("You have pressed the button " + buttonPressCount + " times!\n");
				//System.out.println("times");
			}
			else {
				tArea.append("You have pressed the button " + buttonPressCount + " time!\n");
				//System.out.println("time");

			}	
		}
				
		
	}

}