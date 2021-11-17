package iSoft_TPFinal;


public class DetectorTestDrive {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DetectorModel detectorModel = new DetectorModel();
        ControllerInterface model = new DetectorController(detectorModel);
	}

}
