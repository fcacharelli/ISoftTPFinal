package Strategy;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

import Beat.*;
import Heart.*;
import Detector.*;

public class StrategyView extends DJView {

	private final JComboBox comboBox = new JComboBox();    
	private final StrategyView thisView = this;
	private HeartAdapter heartAdapter = new HeartAdapter(HeartModel.getInstance());
	
	public StrategyView(ControllerInterface controller, BeatModelInterface model) {
		super(controller, model);
	}
	
	public StrategyView(){
		super();
	}
	
    public void createView() {
        viewPanel = new JPanel(new GridLayout(1, 2));
        viewFrame = new JFrame("View");
        viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewFrame.setSize(new Dimension(100, 80));
        bpmOutputLabel = new JLabel("offline", SwingConstants.CENTER);
		beatBar = new BeatBar();
		beatBar.setValue(0);
        JPanel bpmPanel = new JPanel(new GridLayout(3, 1));
		bpmPanel.add(beatBar);
        bpmPanel.add(bpmOutputLabel);
        viewPanel.add(bpmPanel);
        viewFrame.getContentPane().add(viewPanel, BorderLayout.CENTER);
        viewFrame.pack();
        viewFrame.setVisible(true);
        
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Heart", "Beat", "Detector"}));
        comboBox.setSelectedIndex(0);
        comboBox.setToolTipText("");
        
        comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED){
					if(comboBox.getSelectedIndex()==1) {
						if(controller!=null) controller.stop();
						HeartController heartController = new HeartController(thisView);
						setController(heartController);
						setModel(heartAdapter);
					}
					if(comboBox.getSelectedIndex()==2) {
						if(controller!=null) controller.stop();
						BeatModel beat = new BeatModel();
						BeatController beatController= new BeatController(beat,thisView);
						setController(beatController);
						setModel(beat);
					}
					if(comboBox.getSelectedIndex()==3) {
						if(controller!=null) controller.stop();
						DetectorModel detector= new DetectorModel();
						DetectorController detectorController = new DetectorController(detector,thisView);
						setController(detectorController);
						setModel((new DetectorAdapter(detector)));
					}
				}
			}
		});
        bpmPanel.add(comboBox);
	}
  
	
	public void setModel(BeatModelInterface model){
		this.model = model;
		model.registerObserver((BeatObserver)this);
		model.registerObserver((BPMObserver)this);
	}
	
	public void setController(ControllerInterface controller){
		this.controller = controller;	
	}
}
