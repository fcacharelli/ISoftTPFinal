package Heart;

import Strategy.StrategyView;
import Beat.ControllerInterface;
import Beat.DJView;
  
public class HeartController implements ControllerInterface {
	HeartModel model;
	public DJView view;
  
	public HeartController(HeartModel model) {
		this.model = model;
		view = new HeartView(this, new HeartAdapter(model));
        view.createView();
        view.createControls();
		view.disableStopMenuItem();
		view.disableStartMenuItem();
	}
	
	public HeartController(StrategyView view){
		this.model = HeartModel.getInstance();
		this.view = view;
		this.view.disableStopMenuItem();
		this.view.disableStartMenuItem();
	}
  
	public void start() {
		model.on();
	}
 
	public void stop() {
		model.off();
	}
    
	public void increaseBPM() {
        model.intentarNuevaInstancia();
	}
    
	public void decreaseBPM() {}
  
 	public void setBPM(int bpm) {}

 	public void setView(DJView view){
 		this.view = view;
 	}
 	
	public ControllerInterface setController(DJView view) {
		this.setView(view);
		this.view.disableStopMenuItem();
		this.view.disableStartMenuItem();
		return this;
	}
}



