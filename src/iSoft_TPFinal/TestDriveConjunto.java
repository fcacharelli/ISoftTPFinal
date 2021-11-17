package iSoft_TPFinal;

public class TestDriveConjunto {

	public static void main (String[] args) {
	        BeatModelInterface beatModel = new BeatModel();
			ControllerInterface controller1 = new BeatController(beatModel);
			DetectorModel detectorModel = new DetectorModel();
	        ControllerInterface controller2 = new DetectorController(detectorModel);
	        ControllerInterface controller3 = new HeartController(HeartModel.getInstance());
	    }
	
}
