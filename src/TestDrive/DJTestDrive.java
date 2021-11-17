package TestDrive;

import Beat.BeatController;
import Beat.BeatModel;
import Beat.BeatModelInterface;
import Beat.ControllerInterface;

public class DJTestDrive {

    public static void main (String[] args) {
        BeatModelInterface model = new BeatModel();
		ControllerInterface controller = new BeatController(model);
    }
}
