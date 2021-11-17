/**
 * clase que se encarga de toda la implementación gráfica
 */

package Detector;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DetectorView extends JFrame implements ModelObserver{
	
	private static final long serialVersionUID = 1L;
	JPanel panel;
	private JLabel lblPasto;
    private JLabel lblPala1;
    private JLabel lblPala2;
    private JLabel lblPala3;
    private JLabel lblBoom;
    private ArrayList<ImageIcon> iconosBoom;
    private JLabel lblDetector;
    private JLabel lblTesoro;
    private int posX;
    private int posY;
    private int intentos;
    private DetectorModel detectorModel;
    private DetectorGameController controller;
    private JButton btnCavar;
     
    public DetectorView(DetectorModel detectorModel, final DetectorGameController controller) {
    	this.detectorModel=detectorModel;
    	detectorModel.registerObserver((ModelObserver)this);
    	this.controller=controller;
        posX = 0;
        posY = -50;
        intentos = 0;
        
        setResizable(false);
        this.setTitle("DetectorGame");
        this.setSize(607,629);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        
        panel = new JPanel();
        panel.setBounds(0, 0, 600, 600);
        getContentPane().add(panel);
        panel.setLayout(null);
        
        panel.add(lblPala1 = new JLabel(new ImageIcon(getClass().getResource("Imagenes/pala.png"))));
        lblPala1.setBounds(490,0,100,90);
        panel.add(lblPala2 = new JLabel(new ImageIcon(getClass().getResource("Imagenes/pala.png"))));
        lblPala2.setBounds(490,100,100,90);
        panel.add(lblPala3 = new JLabel(new ImageIcon(getClass().getResource("Imagenes/pala.png"))));
        lblPala3.setBounds(490,200,100,90);
        panel.add(lblBoom = new JLabel(new ImageIcon(getClass().getResource("Imagenes/boom0.png"))));
        lblBoom.setBounds(500,300,100,300);
        
        iconosBoom = new ArrayList<ImageIcon>();
        iconosBoom.add(new ImageIcon(getClass().getResource("Imagenes/boom14.png")));
        iconosBoom.add(new ImageIcon(getClass().getResource("Imagenes/boom13.png")));
        iconosBoom.add(new ImageIcon(getClass().getResource("Imagenes/boom12.png")));
        iconosBoom.add(new ImageIcon(getClass().getResource("Imagenes/boom11.png")));
        iconosBoom.add(new ImageIcon(getClass().getResource("Imagenes/boom10.png")));
        iconosBoom.add(new ImageIcon(getClass().getResource("Imagenes/boom9.png")));
        iconosBoom.add(new ImageIcon(getClass().getResource("Imagenes/boom8.png")));
        iconosBoom.add(new ImageIcon(getClass().getResource("Imagenes/boom7.png")));
        iconosBoom.add(new ImageIcon(getClass().getResource("Imagenes/boom6.png")));
        iconosBoom.add(new ImageIcon(getClass().getResource("Imagenes/boom5.png")));
        iconosBoom.add(new ImageIcon(getClass().getResource("Imagenes/boom4.png")));
        iconosBoom.add(new ImageIcon(getClass().getResource("Imagenes/boom3.png")));
        iconosBoom.add(new ImageIcon(getClass().getResource("Imagenes/boom2.png")));
        iconosBoom.add(new ImageIcon(getClass().getResource("Imagenes/boom1.png")));
        iconosBoom.add(new ImageIcon(getClass().getResource("Imagenes/boom0.png")));
        
        panel.add(lblDetector = new JLabel(new ImageIcon(getClass().getResource("Imagenes/detector.png"))));
        panel.add(lblTesoro = new JLabel(new ImageIcon(getClass().getResource("Imagenes/tesoro.png"))));
		lblTesoro.setVisible(false);
        
        btnCavar = new JButton("CAVAR");
        btnCavar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		controller.dig();
        	}
        });
        btnCavar.setFont(new Font("Arial Narrow", Font.BOLD, 20));
        btnCavar.setBounds(0, 500, 100, 100);
        panel.add(btnCavar);
        
        JButton buttonRight= new JButton();
        buttonRight.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		controller.moveRight();
        	}
        });
        buttonRight.setIcon(new ImageIcon(DetectorView.class.getResource("/Detector/Imagenes/right.png")));
        buttonRight.setBounds(400, 500, 100, 100);
        panel.add(buttonRight);
        
        JButton buttonDown= new JButton();
        buttonDown.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		controller.moveDown();
        	}
        });
        buttonDown.setIcon(new ImageIcon(DetectorView.class.getResource("/Detector/Imagenes/down.png")));
        buttonDown.setBounds(300, 500, 100, 100);
        panel.add(buttonDown);
        
        JButton buttonUp= new JButton();
        buttonUp.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		controller.moveUp();
        	}
        });
        buttonUp.setIcon(new ImageIcon(DetectorView.class.getResource("/Detector/Imagenes/up.png")));
        buttonUp.setBounds(200, 500, 100, 100);
        panel.add(buttonUp);
        
        JButton buttonLeft= new JButton();
        buttonLeft.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		controller.moveLeft();
        	}
        });
        buttonLeft.setIcon(new ImageIcon(DetectorView.class.getResource("/Detector/Imagenes/left.png")));
        buttonLeft.setBounds(100, 500, 100, 100);
        panel.add(buttonLeft);
        
        panel.add(lblPasto = new JLabel(new ImageIcon(getClass().getResource("Imagenes/pasto.png"))));
        lblPasto.setBounds(0,0,600,600);
    }
    
    public void setLevelBoom(int i){
    	lblBoom.setIcon(iconosBoom.get(i));
    }

	public void updatePos(int x, int y) {
    	posX=x*24;
    	posY=-50+y*22;
    	lblDetector.setBounds(posX, posY, 75, 150);
	}
	
	public void usarPala(boolean x){
		if(intentos == 1){
			if(x) lblPala3.setIcon(new ImageIcon(getClass().getResource("Imagenes/win.png")));
			else lblPala3.setIcon(new ImageIcon(getClass().getResource("Imagenes/ouch.png")));
		}
		if(intentos == 2){
			if(x) lblPala2.setIcon(new ImageIcon(getClass().getResource("Imagenes/win.png")));
			else lblPala2.setIcon(new ImageIcon(getClass().getResource("Imagenes/ouch.png")));
		}
		if(intentos == 3){
			if(x) lblPala1.setIcon(new ImageIcon(getClass().getResource("Imagenes/win.png")));
			else {
				lblPala1.setIcon(new ImageIcon(getClass().getResource("Imagenes/gameover.png")));
				controller.off();
			}
		}
	}
	
	public void verTesoro(){
		intentos++;
		usarPala(true);
		lblTesoro.setBounds(posX, posY+50, 75, 75);
		lblTesoro.setVisible(true);
		controller.off();
	}
	
	public void ouch(){
		intentos++;
		usarPala(false);
	}
}
