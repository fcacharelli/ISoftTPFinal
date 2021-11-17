package TestDrive;

import Strategy.StrategyView;

public class TestDriveStrategy {

	public static void main(String[] args) {
		StrategyView view = new StrategyView();
		view.createView();
		view.createControls();
	}
}
