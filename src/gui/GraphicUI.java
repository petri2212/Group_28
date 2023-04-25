package gui;

import javax.swing.JFrame;

import gui.controller.*;
import gui.view.graphic.*;

import myshelfie.GameManager;

public class GraphicUI implements UI {

	private JFrame mainFrame;

	public GraphicUI() {
		mainFrame = new JFrame();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setTitle("My Shelfy");
		//mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		mainFrame.setResizable(true);
		mainFrame.setVisible(true);
	}

	@Override
	public void showMainPage(GameManager model) {
		MainPageController controller = new MainPageController(model);
		MainPageView view = new MainPageView(mainFrame, controller);
		view.show();
	}

}
