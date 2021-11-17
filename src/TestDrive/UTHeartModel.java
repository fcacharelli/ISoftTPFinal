package TestDrive;

import static org.junit.Assert.*;

import org.junit.Test;

import Heart.HeartModel;

public class UTHeartModel {


	@Test
	public void testContador() {
		
		HeartModel heart = HeartModel.getInstance();
		assertNotNull(heart);
		
		int esperado = heart.getHeartRate();
		HeartModel heart2 = HeartModel.getInstance();
		int actual = heart2.getHeartRate();
		assertEquals(esperado, actual-1);
	}

	@Test
	public void testSingleton() {
		HeartModel aux = HeartModel.getInstance();
		assertEquals(aux, HeartModel.getInstance());
		assertEquals(aux, HeartModel.getInstance());
		assertEquals(aux, HeartModel.getInstance());
		assertEquals(aux, HeartModel.getInstance());
	}
	
	
}