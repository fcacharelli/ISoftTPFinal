package iSoft_TPFinal;
  
public class HeartTestDrive {
	//Prueba para hacer el primer commit y ver el versionado y funcionamiento general
    public static void main (String[] args) {
        ControllerInterface model = new HeartController(HeartModel.getInstance());
    }
}
