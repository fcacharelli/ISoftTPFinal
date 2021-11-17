package TestDrive;

import Heart.HeartController;
import Heart.HeartModel;
  
public class HeartTestDrive {
	
    public static void main (String[] args) {
        HeartController controller = new HeartController(HeartModel.getInstance());
    }
}
