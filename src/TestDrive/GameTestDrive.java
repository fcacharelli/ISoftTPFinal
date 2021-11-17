package TestDrive;

import Detector.*;

public class GameTestDrive {

	public static void main(String[] args) {
		Tesoro tesoro = new Tesoro();
        DetectorModel model = new DetectorModel(tesoro);
        DetectorGameController detectorGameController = new DetectorGameController(model);
	}
}