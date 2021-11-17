package TestDrive;

import Beat.*;
import Detector.*;
import Heart.*;

public class TestDriveConjunto {

	public static void main (String[] args) {
	        BeatModelInterface beatModel = new BeatModel();
	        DetectorModel detectorModel = new DetectorModel();
	        ControllerInterface controller1 = new BeatController(beatModel);
			ControllerInterface controller2 = new DetectorController(detectorModel);
	        ControllerInterface controller3 = new HeartController(HeartModel.getInstance());
	    }
	
}
