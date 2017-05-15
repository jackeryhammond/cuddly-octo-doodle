import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//just a class to play with some swing components. Mainy JLists, using JButtons/labels/etc to manipulate and change 
//behaviour based on these components.

public class ListPractice implements ActionListener {
	
	JList list;
	JLabel changelabel;	

	public static void main(String[] args) {

		ListPractice ta = new ListPractice();

		ta.go();
	}

	public void go() {

		//make JFrame
		JFrame frame = new JFrame("JList Practice");
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Pick an artist from the list, and click the button to see my opinion");
		changelabel = new JLabel("Opinion will be here.");
		JButton button = new JButton("What do I think?");

		//make list of strings to be put in list
		String[] listEntries = {"America", "Beach Boys", "Chicago", "Justin Bieber", "George Michael", "Peter Cetera"};

		//make list
		list = new JList(listEntries);

		list.setVisibleRowCount(6);

		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		//make button listen for event
		button.addActionListener(this);

		//make scroll pane and set it's constraints
		//add  list to scroll pane
		JScrollPane scroller = new JScrollPane(list);

		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		//change layout manager for panel

		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		//add scroll pane and changing label to panel
		panel.add(scroller);
		panel.add(changelabel);

		//add panel and button to frame
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.getContentPane().add(BorderLayout.NORTH, label);
		frame.getContentPane().add(BorderLayout.SOUTH, button);


		//finishing touches
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 200);
		frame.setVisible(true);

	}

	public void actionPerformed(ActionEvent event) {

		String selection = (String) list.getSelectedValue();
		//System.out.println(selection);

		if(selection == "America") {
			changelabel.setText("Ventura Highway is my jam");
		}
		else if(selection == "Beach Boys") {
			//System.out.println("beach boys");
			changelabel.setText("Wouldn't it be nice if we were older?");
		}
		else if(selection == "Chicago") {
			changelabel.setText("If you leave me now you'll take away the biggest part of me");
		}
		else if(selection == "Justin Bieber") {
			changelabel.setText("Don't even mention that name... although I do like some of his newer stuff");
		}
		else if(selection == "George Michael") {
			changelabel.setText("Best selection! Rest in peace my son");
		}
		else if(selection == "Peter Cetera") {
			changelabel.setText("Still slammin'!");
		}

	}



	

}