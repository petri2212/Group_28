package gui;

import gui.controller.*;
import gui.view.console.*;

import myshelfie.GameManager;

public class ConsoleUI implements UI {

	@Override
	public void showMainPage(GameManager model) {
		MainPageViewConsole view = new MainPageViewConsole();
		MainPageController controller = new MainPageController(model, view);
		controller.start();
	}

	@Override
	public void showInsertPlayersPage(GameManager model) {
		InsertPlayersViewConsole view = new InsertPlayersViewConsole();
		InsertPlayersController controller = new InsertPlayersController(model, view);
		controller.start();
	}

	@Override
	public void showPickObjectsFromBoardPage(GameManager model) {
		PickObjectsFromBoardViewConsole view = new PickObjectsFromBoardViewConsole();
		PickObjectsFromBoardController controller = new PickObjectsFromBoardController(model, view);
		controller.start();
	}

	@Override
	public void showPutObjectsPage(GameManager model) {
		PutObjectsViewConsole view = new PutObjectsViewConsole();
		PutObjectsController controller = new PutObjectsController(model, view);
		controller.start();
	}

}
