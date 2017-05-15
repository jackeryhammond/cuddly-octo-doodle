import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.sound.midi.*;

public class BeatBox {
	
	//Build a gui that has 256 Check Boxes that start out unchecked
	//16 labels for instrument names
	//4 buttons

	//Register an action listener for each of the four buttons

	//Set up MIDI system, get sequencer, make a sequence, create a track

	//When user hits start the real action begins,
	//the event handling method for the start button calls the build track and start method.
	//in that method we walk through all 256 checkboxes (one row at a time)
	//once track is built, start the sequencer, which keeps playing (with a loop) until
	//the user hits stop

	/**
		This is an attempt at making a BeatBox application from my textbook Head First Java,
		This is my version, with only the instructions above to help
		I will probably commit their version too given there's much difference
		I am going to attempt to build this myself without looking at the book.
	*/

	//How I would do this:
	/*
		In my head, this works like this: given the content pane has 5 regions, whack the ol'
		buttons in the East, Labels for each instrument in the West, the check boxes in the centre
		and set the size of the window to constrain the amount of boxes per row, rather than make
		a JPanel for each row and add that to a Box Layout panel and add the boxes for those.

		It would work logically but it looks like this book isn't going to do that.
	*/

	ArrayList<JCheckBox> checkboxList;
	JPanel mainPanel;
	Sequencer sequencer;
	Sequence sequence;
	Track track;
	JFrame frame;

	String[] instrumentNames = {"Bass Drum", "Closed Hi-Hat", "Open Hi-Hat", "Acoustic Snare", 
	"Crash Cymbal", "Hand Clap", "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga", 
	"Cowbell", "Vibraslap", "Low-mid Tom", "High Agogo", "Open Hi Conga"};

	int[] instruments = {35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58, 47, 67, 63};

	public static void main(String[] args) {
		BeatBox box = new BeatBox();
		box.go();
	}

	public void go() {

		setUpGUI();

	}

	public void setUpGUI() {

		//Initialise frame
		frame = new JFrame("BeatBox");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,600);

		//Set up border layout so there is room on the edges
		BorderLayout layout = new BorderLayout();
		JPanel background = new JPanel(layout);
		background.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

		//initialise checkboxes
		checkboxList = new ArrayList<JCheckBox>();
		Box buttonBox = new Box(BoxLayout.Y_AXIS); //a JComponent that is simple and uses BoxLayout

		//Make buttons
		JButton start = new JButton("Start");
		start.addActionListener(new MyStartListener());
		buttonBox.add(start);

		JButton stop = new JButton("Stop");
		stop.addActionListener(new MyStopListener());
		buttonBox.add(stop);

		JButton upTempo = new JButton("Tempo Up");
		upTempo.addActionListener(new MyUpTempoListener());
		buttonBox.add(upTempo);

		JButton downTempo = new JButton("Tempo Down");
		downTempo.addActionListener(new MyDownTempoListener());
		buttonBox.add(downTempo);

		//Make box object for name labels
		Box nameBox = new Box(BoxLayout.Y_AXIS);
		for(int i = 0; i < 16; i++) {
			nameBox.add(new Label(instrumentNames[i]));
		}

		//add the buttons and labels to the background frame
		background.add(BorderLayout.EAST, buttonBox);
		background.add(BorderLayout.WEST, nameBox);

		frame.getContentPane().add(background);

		//add check boxes now
		GridLayout grid = new GridLayout(16,16);
		grid.setVgap(1);
		grid.setHgap(2);
		mainPanel = new JPanel(grid);
		background.add(BorderLayout.CENTER, mainPanel);

		for(int i = 0; i < 256; i++) {
			JCheckBox c = new JCheckBox();
			c.setSelected(false);
			checkboxList.add(c);
			mainPanel.add(c);
		}

		//Set Up Midi stuff
		setUpMidi();

		frame.setBounds(50,50,300,300);
		frame.pack();
		frame.setVisible(true);

	}

	public void setUpMidi() {
		System.out.println("Setting up midi");
	}

	public void buildTrackAndStart() {

	}

	public void makeTracks(int[] list) {

	}

	public MidiEvent makeEvent(int command, int channel, int one, int two, int tick) {
		MidiEvent event = null;

		try {
			ShortMessage sm = new ShortMessage();
			sm.setMessage(command, channel, one, two);
			event = new MidiEvent(sm, tick);
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		return event;
	}

	//INNER CLASSES
	//*********************************************************

	public class MyStartListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {

		}
	}

	public class MyStopListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
		}
		
	}

	public class MyUpTempoListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
		}
	}

	public class MyDownTempoListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
		}
	}

}