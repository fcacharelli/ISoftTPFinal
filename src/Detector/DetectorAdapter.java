package Detector;

import Beat.BPMObserver;
import Beat.BeatModelInterface;
import Beat.BeatObserver;

public class DetectorAdapter implements BeatModelInterface{

	DetectorModel detector;
	
	public DetectorAdapter(DetectorModel detector){
		this.detector=detector;
	}

	public void initialize() {
		this.detector.initialize();
	}

	public void on() {
		this.detector.on();		
	}

	public void off() {
		this.detector.off();
	}

	public void setBPM(int bpm) {
		this.detector.setDistancia(bpm);
	}

	public int getBPM() {
		return this.detector.getDistancia();
	}

	public void registerObserver(BeatObserver o) {
		this.detector.registerObserver(o);
	}

	public void removeObserver(BeatObserver o) {
		this.detector.removeObserver(o);
	}

	public void registerObserver(BPMObserver o) {
		this.detector.registerObserver(o);
	}

	public void removeObserver(BPMObserver o) {
		this.detector.removeObserver(o);
	}	
}
