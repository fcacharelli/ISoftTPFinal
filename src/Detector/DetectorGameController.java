package Detector;


public class DetectorGameController implements DetectorControllerInterface {
	DetectorModel model;
	DetectorView view;
	
	public DetectorGameController(DetectorModel model){
		this.model=model;
		this.view=new DetectorView(model, this);
		model.notifyModelObservers();
		model.initialize();
		model.on();
	}
	public void off(){
		model.off();
	}
	public void moveUp(){
		model.setY(-1);
	}
	public void moveDown(){
		model.setY(1);
	}
	public void moveLeft(){
		model.setX(-1);
	}
	public void moveRight(){
		model.setX(1);
	}
	public void dig(){
		model.dig();
	}
}
