package TAMVC;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

import Beat.BeatController;
import Beat.BeatModel;
import Beat.BeatModelInterface;
import Beat.ControllerInterface;
import Detector.DetectorController;
import Detector.DetectorGameController;
import Detector.DetectorModel;
import Detector.Tesoro;
import Heart.HeartController;
import Heart.HeartModel;
import Strategy.StrategyView;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class View {

	private JFrame frmTeacherApproachModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View window = new View();
					window.frmTeacherApproachModel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTeacherApproachModel = new JFrame();
		frmTeacherApproachModel.setTitle("Teacher Approach Model View Controller");
		frmTeacherApproachModel.setBounds(100, 100, 450, 300);
		frmTeacherApproachModel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnStrategy = new JButton("All Models with Switch");
		btnStrategy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StrategyView view = new StrategyView();
				view.createView();
				view.createControls();
			}
		});
		
		JButton btnGame = new JButton("GAME");
		btnGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tesoro tesoro = new Tesoro();
		        DetectorModel model = new DetectorModel(tesoro);
		        DetectorGameController detectorGameController = new DetectorGameController(model);
			}
		});
		
		JButton btnDetectorModel = new JButton("Detector Model");
		btnDetectorModel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DetectorModel detectorModel = new DetectorModel();
		        ControllerInterface model = new DetectorController(detectorModel);
			}
		});
		
		JButton btnDjModel = new JButton("Dj Model");
		btnDjModel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BeatModelInterface model = new BeatModel();
				ControllerInterface controller = new BeatController(model);
			}
		});
		
		JButton btnHeartModel = new JButton("Heart Model");
		btnHeartModel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HeartController controller = new HeartController(HeartModel.getInstance());
			}
		});
		
		JButton btnAllModels = new JButton("All Models");
		btnAllModels.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BeatModelInterface beatModel = new BeatModel();
		        DetectorModel detectorModel = new DetectorModel();
		        ControllerInterface controller1 = new BeatController(beatModel);
				ControllerInterface controller2 = new DetectorController(detectorModel);
		        ControllerInterface controller3 = new HeartController(HeartModel.getInstance());
			}
		});
		
		JTextPane txtpnTamvcteacherApproach = new JTextPane();
		txtpnTamvcteacherApproach.setEditable(false);
		txtpnTamvcteacherApproach.setFont(new Font("Tahoma", Font.BOLD, 28));
		txtpnTamvcteacherApproach.setText("TA-MVC");
		GroupLayout groupLayout = new GroupLayout(frmTeacherApproachModel.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnStrategy, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnDetectorModel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnDjModel, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnGame, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
								.addComponent(btnAllModels, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
								.addComponent(btnHeartModel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(158)
							.addComponent(txtpnTamvcteacherApproach, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addComponent(txtpnTamvcteacherApproach, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnDjModel, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnHeartModel, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAllModels, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDetectorModel, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnStrategy, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
						.addComponent(btnGame, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE))
					.addContainerGap())
		);
		frmTeacherApproachModel.getContentPane().setLayout(groupLayout);
	}
}
