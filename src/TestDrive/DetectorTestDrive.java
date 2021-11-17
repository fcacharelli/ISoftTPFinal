package TestDrive;

import Beat.ControllerInterface;
import Detector.DetectorController;
import Detector.DetectorModel;

public class DetectorTestDrive {

	public static void main(String[] args) {
		DetectorModel detectorModel = new DetectorModel();
        ControllerInterface model = new DetectorController(detectorModel);
	}

}
