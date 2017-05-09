import javax.sound.midi.*;

public class MiniMusicPlayer1 {	
	
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

		try {

			Sequencer player = MidiSystem.getSequencer();
			player.open(); //defaults to closed, we have to open the player

			Sequence seq = new Sequence(Sequence.PPQ, 4);

			Track track = seq.createTrack(); //ask sequence for a Track object

			for(int i = 5; i < 61; i+=4) {
				track.add(makeEvent(144, 1, i, 100, i));
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