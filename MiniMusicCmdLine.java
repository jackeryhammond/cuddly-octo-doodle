import javax.sound.midi.*;

public class MiniMusicCmdLine {	
	
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


		MiniMusicCmdLine mini = new MiniMusicCmdLine();

		if(args.length < 2) {
			System.out.println("Don't forget the interument and note args");
		}

		else {
			int instrument = Integer.parseInt(args[0]);
			int note = Integer.parseInt(args[1]);
			mini.play(instrument, note);
		}

	}

	public void play(int instrument, int note) {

		try {

			Sequencer player = MidiSystem.getSequencer();
			player.open(); //defaults to closed, we have to open the player

			Sequence seq = new Sequence(Sequence.PPQ, 4);

			Track track = seq.createTrack(); //ask sequence for a Track object

			//MidiEvent event = null;

			ShortMessage first = new ShortMessage();
			first.setMessage(192, 1, instrument, 0);
			MidiEvent changeInstrument = new MidiEvent(first,1);

			ShortMessage a = new ShortMessage();
			a.setMessage(144, 1, note, 100);
			MidiEvent noteOn = new MidiEvent(a, 1);
			track.add(noteOn);

			//Message
			//Holds the instruction we give to the MidiEvent which then
			//translates into what it should play
			//we give the message to the midi event
			//then we add the midi event to the track.

			//message says what to do, midi event says when to do it.

			//a.setMessage(message type, channel, note to play, velocity);

			ShortMessage b = new ShortMessage();
			b.setMessage(128, 1, note, 100);
			MidiEvent noteOff = new MidiEvent(b, 16);
			track.add(noteOff);

			player.setSequence(seq); //give the sequence we've adapted to the sequencer

			player.start(); // start the sequencer, or, press PLAY!

		} 
		catch(Exception ex) {

			ex.printStackTrace();

		}
	}
}