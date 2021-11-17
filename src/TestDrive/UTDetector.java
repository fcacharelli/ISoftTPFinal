package TestDrive;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import Detector.DetectorModel;
import Detector.Tesoro;

public class UTDetector {
	
	Tesoro tesoro = new Tesoro();
	DetectorModel model = new DetectorModel(tesoro);
	
	@Before
	public void inicializar(){
		model.initialize();
		model.on();
	}

	@Test
	public void testBPM() {
		int var=60;
		model.setBPM(var);
		assertEquals(var, model.getBPM());
	}
	
	@Test
	public void testDistanciaNegativa(){
		int positiva = 5;
		int negativa = -5;
		model.setDistancia(positiva);
		model.setDistancia(negativa);
		assertEquals(positiva, model.getDistancia());		
	}
	
	@Test
	public void testBPMEncontrado(){
		int distancia = 0;
		int BPMEncontrado = 500;
		model.setDistancia(distancia);
		assertEquals(BPMEncontrado, model.getBPM());
	}
	
	@Test
	public void testBPMLejos(){
		int lejos = 1500;
		int BPMLejos = 60;
		model.setDistancia(lejos);
		assertEquals(BPMLejos, model.getBPM());
	}
	
	@Test
	public void testSalirX(){
		int maxPos = 19;
		for(int i=0;i<25;i++){
			model.setX(1);
		}
		assertEquals(maxPos, model.getX());		
	}
	
	@Test
	public void testSalirY(){
		int maxPos = 19;
		for(int i=0;i<25;i++){
			model.setY(1);
		}
		assertEquals(maxPos, model.getY());		
	}
	
	@After
	public void finalizar(){
		model.off();
	}
}
