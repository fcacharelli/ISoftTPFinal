package Detector;

import javax.sound.midi.*;
import Beat.*;
import java.util.*;

public class DetectorModel implements DetectorModelInterface, MetaEventListener {

	Sequencer sequencer;
	int bpm = 60;
    Sequence sequence;
    Track track;
    
    ArrayList<BeatObserver> beatObservers;
	ArrayList<BPMObserver> bpmObservers;
	ArrayList<ModelObserver> modelObservers;
	int xDetector;
	int yDetector;
	Tesoro tesoro;
	int distancia;
	boolean excavado;
	boolean encontrado;
	
	public DetectorModel(){
		beatObservers = new ArrayList<BeatObserver>();
		bpmObservers = new ArrayList<BPMObserver>();
		distancia = 10;
	}
	
	public DetectorModel(Tesoro tesoro){
		beatObservers = new ArrayList<BeatObserver>();
		bpmObservers = new ArrayList<BPMObserver>();
		modelObservers = new ArrayList<ModelObserver>();
		xDetector = 10;
		yDetector = 10;
		this.tesoro = tesoro;
		distancia = tesoro.calcularDistancia(xDetector, yDetector);
		excavado = false;
		encontrado = false;
	}
    
	public void initialize() {
        setUpMidi();
        buildTrackAndStart();
	}
 
    public void on() {
        sequencer.start();
        if(distancia<=10) setBPM(500-44*distancia);
		else setBPM(60);
    }
    
    public void off() {
  		setBPM(0);
		sequencer.stop();
    }
 
    public void setBPM(int bpm) {
		this.bpm = bpm;
		sequencer.setTempoInBPM(getBPM());
		notifyBPMObservers();
    }
  
	public int getBPM() {
		return bpm;
	}
  
	void beatEvent() {
		notifyBeatObservers();
	}
	
	public void meta(MetaMessage message) {
    	if (message.getType() == 0x2F ) {
			beatEvent();
            sequencer.setTickPosition(0) ; 
            sequencer.start(); 
            setBPM(getBPM());	
        }
    }

	public void setUpMidi() {
		try {
			sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequencer.addMetaEventListener(this);
			sequence = new Sequence(Sequence.PPQ,4);
			track = sequence.createTrack();
			sequencer.setTempoInBPM(getBPM());
		} catch(Exception e) {
				e.printStackTrace();
		}
    } 

     public void buildTrackAndStart() {
        int[] trackList = {67, 0, 0, 0};
    
        sequence.deleteTrack(null);
        track = sequence.createTrack();

      	makeTracks(trackList);
		track.add(makeEvent(192,9,1,0,4));      
	 	try {
			sequencer.setSequence(sequence);                    
		} catch(Exception e) {
			e.printStackTrace();
		}
    } 
            
    public void makeTracks(int[] list) {        
       
       for (int i = 0; i < list.length; i++) {
          int key = list[i];

          if (key != 0) {
             track.add(makeEvent(144,9,key, 100, i));
             track.add(makeEvent(128,9,key, 100, i+1));
          }
       }
    }
        
    public  MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
            
        } catch(Exception e) {
			e.printStackTrace(); 
		}
        return event;
    }
   
	public void registerObserver(BeatObserver o) {
		beatObservers.add(o);
	}
  
	public void notifyBeatObservers() {
		for(int i = 0; i < beatObservers.size(); i++) {
			BeatObserver observer = (BeatObserver)beatObservers.get(i);
			observer.updateBeat();
		}
	}
	
	public void removeObserver(BeatObserver o) {
		int i = beatObservers.indexOf(o);
		if (i >= 0) {
			beatObservers.remove(i);
		}
	}
  
	public void registerObserver(BPMObserver o) {
		bpmObservers.add(o);
	}
  
	public void notifyBPMObservers() {
		for(int i = 0; i < bpmObservers.size(); i++) {
			BPMObserver observer = (BPMObserver)bpmObservers.get(i);
			observer.updateBPM();
		}
	}
	
	public void removeObserver(BPMObserver o) {
		int i = bpmObservers.indexOf(o);
		if (i >= 0) {
			bpmObservers.remove(i);
		}
	}

	public void registerObserver(ModelObserver o) {
		modelObservers.add(o);
	}
  
	public void notifyModelObservers() {
		for(int i = 0; i < modelObservers.size(); i++) {
			ModelObserver observer = (ModelObserver)modelObservers.get(i);
			observer.updatePos(getX(),getY());
			observer.setLevelBoom(getDistancia());
			if(encontrado && excavado) {
				observer.verTesoro();
			} else if (excavado && !encontrado) {
				observer.ouch();
			}
			excavado = false;
		}
	}
  
	public void removeObserver(ModelObserver o) {
		int i = modelObservers.indexOf(o);
		if (i >= 0) {
			modelObservers.remove(i);
		}
	}

	public int getDistancia() {
		return this.distancia;
	}

	public void setDistancia(int distancia) {
		if(distancia>=0){
			this.distancia=distancia;
			if(distancia<=10) setBPM(500-44*distancia);
			else setBPM(60);
		}
	}

	public void setX(int i){
		if(!(xDetector+i>=20 || xDetector+i<0)) this.xDetector+=i;
		setDistancia(tesoro.calcularDistancia(xDetector, yDetector));
		notifyModelObservers();
	}
	
	public void setY(int i){
		if(!(yDetector+i>=20 || yDetector+i<0)) this.yDetector+=i;
		setDistancia(tesoro.calcularDistancia(xDetector, yDetector));
		notifyModelObservers();
	}
	
	public int getX(){
		return xDetector;
	}
	
	public int getY(){
		return yDetector;
	}
	
	public void dig(){
		if(tesoro.dig(xDetector, yDetector)) {
			excavado = true;
			encontrado = true;
			notifyModelObservers();
		} else {
			excavado = true;
			notifyModelObservers();
		}
	}
}
