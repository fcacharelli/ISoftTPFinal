package iSoft_TPFinal;

public class HeartView extends DJView {
	
	public HeartView(ControllerInterface controller, BeatModelInterface model) {	
		super(controller, model);
    }
	
	@Override
	public void updateBPM() {
		if (model != null) {
			if (bpmOutputLabel != null) {
        			bpmOutputLabel.setText("Numero de Instancias: " + model.getBPM());
			}
		}
	}
}
