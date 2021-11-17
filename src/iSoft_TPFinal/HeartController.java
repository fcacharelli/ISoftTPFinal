package iSoft_TPFinal;
  
public class HeartController implements ControllerInterface {
	HeartModel model;
	DJView view;
  
	public HeartController(HeartModel model) {
		this.model = model;
		view = new HeartView(this, new HeartAdapter(model));
        view.createView();
        view.createControls();
		view.disableStopMenuItem();
		view.disableStartMenuItem();
	}
  
	public void start() {}
 
	public void stop() {}
    
	public void increaseBPM() {
        model.intentarNuevaInstancia();
	}
    
	public void decreaseBPM() {}
  
 	public void setBPM(int bpm) {}
}



