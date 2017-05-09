import javax.sound.midi.*;

/**
	Like MiniMusicPlayer1 but learning how to get an Event from using MIDI so I can make something happen
	in a GUI when a note is played.
*/

public class MiniMusicPlayer2 implements ControllerEventListener {	
	
	public static void main(String[] args) {

		/*
			Sequencer
			plays
			Sequence
			which has a 
			Track 
			which holds 
			The actual music info.
		*/

		MiniMusicPlayer2 mmp = new MiniMusicPlayer2();
		mmp.go();
		
	
	}

	public void go() {

		try {

			Sequencer player = MidiSystem.getSequencer();
			player.open(); //defaults to closed, we have to open the player

			int[] eventsIWant = {127};
			player.addControllerEventListener(this, eventsIWant);

			Sequence seq = new Sequence(Sequence.PPQ, 4);

			Track track = seq.createTrack(); //ask sequence for a Track object

			for(int i = 5; i < 61; i+=4) {
				track.add(makeEvent(144, 1, i, 100, i));

				track.add(makeEvent(176, 1, 127, 0, i));
				/*
					176 says event type is a Controller Event, with an argument
					for event number 127
					We can't listen for 144 or 128, but this gives us
					something we can 'listen' to so we can make something happen
					every time a note is playing.
					It happens at the same time as the first event.
				*/

				track.add(makeEvent(128, 1, i, 100, i + 2));
			}

			player.setSequence(seq); //give the sequence we've adapted to the sequencer
			player.setTempoInBPM(220);
			player.start(); // start the sequencer, or, press PLAY!		



		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

	public void controlChange(ShortMessage event) {

		System.out.println("la!");
	}

	public static MidiEvent makeEvent(int command, int channel, int one, int two, int tick) {

		MidiEvent event = null;

		try {
			ShortMessage a = new ShortMessage();
			a.setMessage(command, channel, one, two);
			event = new MidiEvent(a, tick);
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		return event;
	}
}