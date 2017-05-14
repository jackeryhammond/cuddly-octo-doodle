import javax.sound.midi.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;

public class MiniMusicPlayer3 {

	static JFrame frame = new JFrame("My First Terribly Made Music Video");
	static MyDrawPanel ml;

	public static void main(String[] args) {

		MiniMusicPlayer3 mp = new MiniMusicPlayer3();
		mp.go();

	}

	public void setUpGUI() {

		ml = new MyDrawPanel();
		frame.setContentPane(ml);
		frame.setBounds(30,30,300,300);
		frame.setVisible(true);

	}

	public void go() {
		setUpGUI();

		try {

			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequencer.addControllerEventListener(ml, new int[] {127});
			Sequence seq = new Sequence(Sequence.PPQ, 4);
			Track track = seq.createTrack();

			int r = 0;

			for(int i = 0; i < 60; i += 4) {

				r = (int) ((Math.random() * 50) + 1);
				
				track.add(makeEvent(144, 1, r, 100, i));
				track.add(makeEvent(176, 1, 127, 0, i));
				track.add(makeEvent(128, 1, r, 100, i + 2));

			}

			sequencer.setSequence(seq);
			sequencer.start();
			sequencer.setTempoInBPM(120);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
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

	class MyDrawPanel extends JPanel implements ControllerEventListener {

		boolean msg = false;

		public void controlChange(ShortMessage event) {
			msg = true;
			repaint();
		}

		public void paintComponent(Graphics g) {

			if(msg) {

				//make random numbers for colour
				int r = (int) (Math.random() * 250);
				int gr = (int) (Math.random() * 250);
				int b = (int) (Math.random() * 250);


				//set colour

				g.setColor(new Color(r, gr, b));

				//make random numbers for positioning (40 rand plus 10) and size (120 rand plus 10)
				int height = (int) ((Math.random() * 120) + 10);
				int width = (int) ((Math.random() * 120) + 10);

				int x = (int) ((Math.random() * 40) + 10);
				int y = (int) ((Math.random() * 40) + 10);

				//draw rectangle 
				g.fillRect(x, y, height, width);

				msg = false;
				//set msg to false so it doesn't get repainted for anything other than a controller event.
			}
		}
	}
}