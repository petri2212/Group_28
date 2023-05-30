package gui;

import java.awt.Dimension;

import javax.swing.JFrame;

import gui.controller.*;
import gui.view.graphic.*;

import myshelfie.GameManager;
import resource.Images;

public class GraphicUI implements UI {

	private JFrame mainFrame;

	public GraphicUI() {
		mainFrame = new JFrame();
		mainFrame.setMaximumSize(new Dimension(1140, 760));
		mainFrame.setMinimumSize(new Dimension(1140, 760));
		mainFrame.setPreferredSize(new Dimension(1140, 760));
		mainFrame.setSize(new Dimension(1140, 760));
		mainFrame.setIconImage(Images.ICON_MY_SHELFIE.load());
		mainFrame.setTitle("My Shelfie");
		mainFrame.setResizable(false);
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void showMainPage(GameManager model) {
		MainPageViewGraphic view = new MainPageViewGraphic(mainFrame);
		MainPageController controller = new MainPageController(model, view);
		controller.start();
	}

	@Override
	public void showInsertPlayersPage(GameManager model) {
		InsertPlayersViewGraphic view = new InsertPlayersViewGraphic(mainFrame);
		InsertPlayersController controller = new InsertPlayersController(model, view);
		controller.start();

	}

	@Override
	public void showGameStagePage(GameManager model) {
		GameStageViewGraphic view = new GameStageViewGraphic(mainFrame);
		GameStageController controller = new GameStageController(model, view);
		controller.start();
	}

	@Override
	public void showPointsPage(GameManager model) {
		PointsPageViewGraphic view = new PointsPageViewGraphic(mainFrame);
		PointsPageController controller = new PointsPageController(model, view);
		controller.start();
	}

}
