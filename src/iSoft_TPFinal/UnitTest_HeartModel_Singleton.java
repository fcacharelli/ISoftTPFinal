package iSoft_TPFinal;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class UnitTest_HeartModel_Singleton {

	@Test
	public void test() {
		HeartModel aux = HeartModel.getInstance();
		assertEquals(aux, HeartModel.getInstance());
		assertEquals(aux, HeartModel.getInstance());
		assertEquals(aux, HeartModel.getInstance());
		assertEquals(aux, HeartModel.getInstance());
	}
}
