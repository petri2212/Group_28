package gui;

import gui.controller.*;
import gui.view.console.*;

import myshelfie.GameManager;

public class ConsoleUI implements UI {

	/**
	 * Initialize the controller and the view
	 * in the main page for the console.
	 */
	public void showMainPage(GameManager model) {
		MainPageViewConsole view = new MainPageViewConsole();
		MainPageController controller = new MainPageController(model, view);
		controller.start();
	}

	/**
	 * Initialize the controller and the view
	 * in the insert players page for the console.
	 */
	public void showInsertPlayersPage(GameManager model) {
		InsertPlayersViewConsole view = new InsertPlayersViewConsole();
		InsertPlayersController controller = new InsertPlayersController(model, view);
		controller.start();
	}

	/**
	 * Initialize the controller and the view
	 * in the game stage page for the console.
	 */
	public void showGameStagePage(GameManager model) {
		GameStageViewConsole view = new GameStageViewConsole();
		GameStageController controller = new GameStageController(model, view);
		controller.start();
	}

	/**
	 * Initialize the controller and the view
	 * in the points page for the console.
	 */
	public void showPointsPage(GameManager model) {
		PointsPageViewConsole view = new PointsPageViewConsole();
		PointsPageController controller = new PointsPageController(model, view);
		controller.start();
	}

}
