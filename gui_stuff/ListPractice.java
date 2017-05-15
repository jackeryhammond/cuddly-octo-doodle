import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ListPractice implements ActionListener {
	
	JList list;
	

	public static void main(String[] args) {

		ListPractice ta = new ListPractice();

		ta.go();
	}

	public void go() {

		//make JFrame
		JFrame frame = new JFrame("Text Area Practice");
		JPanel panel = new JPanel();

		//make list of strings to be put in list
		String[] listEntries = {"America", "Beach Boys", "Chicago", "George Michael", "Peter Cetera"};

		//make list
		list = new JList(listEntries);

		list.setVisibleRowCount(3);

		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		//make scroll pane and set it's constraints
		//add  list to scroll pane
		JScrollPane scroller = new JScrollPane(list);

		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		//add scroll pane to panel
		panel.add(scroller);

		//add panel and button to frame
		frame.getContentPane().add(BorderLayout.CENTER, panel);


		//finishing touches
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(350, 300);
		frame.setVisible(true);

	}

	

	

}