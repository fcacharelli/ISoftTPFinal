package iSoft_TPFinal;

public class DetectorController implements ControllerInterface{
	
	DetectorModel model;
	DJView view;
	
	public DetectorController(DetectorModel model){
		this.model=model;
		view = new DJView(this, new DetectorAdapter(model));
        view.createView();
        view.createControls();
		view.disableStopMenuItem();
		view.enableStartMenuItem();
		model.initialize();
	}
	public void start() {
		model.on();
		view.disableStartMenuItem();
		view.enableStopMenuItem();
	}
  
	public void stop() {
		model.off();
		view.disableStopMenuItem();
		view.enableStartMenuItem();
	}
    
	public void increaseBPM() {
        int distancia = model.getDistancia();
        model.setDistancia(distancia + 1);
	}
    
	public void decreaseBPM() {
        int distancia = model.getDistancia();
        model.setDistancia(distancia - 1);
  	}
  
 	public void setBPM(int bpm) {
 		model.setDistancia(bpm);
	}


}
