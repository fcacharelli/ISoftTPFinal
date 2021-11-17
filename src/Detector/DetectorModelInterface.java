package Detector;

import Beat.BPMObserver;
import Beat.BeatObserver;

public interface DetectorModelInterface {
		void initialize();
		void on();
		void off();
		int getDistancia();
		void setDistancia(int distancia);
		void registerObserver(BeatObserver o);
		void removeObserver(BeatObserver o);	  
		void registerObserver(BPMObserver o);	  
		void removeObserver(BPMObserver o);
}
