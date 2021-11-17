package TestDrive;

import static org.junit.Assert.*;
import org.junit.Test;
import Beat.BeatModel;

public class UTBeat {

	@Test
	public void testBPM() {
		int var=60;
		BeatModel model = new BeatModel();
		model.initialize();
		model.on();
		model.setBPM(var);
		assertEquals(var, model.getBPM());
		model.off();
	}
}
