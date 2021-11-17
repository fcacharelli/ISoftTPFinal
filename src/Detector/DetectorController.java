package Detector;

import Beat.*;

/**
 * Esta clase es utilizada como controlador del detector de metales para la actividad numero dos
 * en la que se genero el nuevo modelo de detector de metales y se probo al mismo utilizando
 * la view del BeatModel
 * @author ---DIEGO---
 *
 */

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
	
	public DetectorController(DetectorModel model, DJView view){
		this.model = model;
		this.view = view;
		this.view.disableStopMenuItem();
		this.view.enableStartMenuItem();
		this.model.initialize();
		
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
 	
 	public void setView(DJView view){
 		this.view = view;
 	}
}
