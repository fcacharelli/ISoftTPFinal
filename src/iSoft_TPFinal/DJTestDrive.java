package iSoft_TPFinal;
  
public class DJTestDrive {
	//Prueba para hacer el primer commit y ver el versionado y funcionamiento general
    public static void main (String[] args) {
        BeatModelInterface model = new BeatModel();
		ControllerInterface controller = new BeatController(model);
    }
}
