package iSoft_TPFinal;

public class DetectorAdapter implements BeatModelInterface{

	DetectorModel detector;
	
	public DetectorAdapter(DetectorModel detector){
		this.detector=detector;
	}
	@Override
	public void initialize() {
		this.detector.initialize();
	}

	@Override
	public void on() {
		this.detector.on();		
	}

	@Override
	public void off() {
		this.detector.off();
	}

	@Override
	public void setBPM(int bpm) {
		this.detector.setDistancia(bpm);
	}

	@Override
	public int getBPM() {
		return this.detector.getDistancia();
	}

	@Override
	public void registerObserver(BeatObserver o) {
		this.detector.registerObserver(o);
	}

	@Override
	public void removeObserver(BeatObserver o) {
		this.detector.removeObserver(o);
	}

	@Override
	public void registerObserver(BPMObserver o) {
		this.detector.registerObserver(o);
	}

	@Override
	public void removeObserver(BPMObserver o) {
		this.detector.removeObserver(o);
	}

	
	
}
