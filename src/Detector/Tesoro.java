package Detector;

import java.util.Random;

public class Tesoro {
	
	int xTesoro=0;
	int yTesoro=15;
	
	public Tesoro(){
		Random generator = new Random();
    	xTesoro = generator.nextInt(20);
    	yTesoro = generator.nextInt(20);
    	while ((yTesoro == xTesoro) || (yTesoro == 10)){
    		yTesoro = generator.nextInt(20);
    	}
	}
	
	public int calcularDistancia(int x, int y){
		return (int)Math.sqrt(Math.pow(x-xTesoro,2)+Math.pow(y-yTesoro,2));
	}
	
	public boolean dig(int x, int y){
		if((x == xTesoro) && (y == yTesoro)) return true;
		else return false;
	}
}
