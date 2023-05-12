package gui;

import javax.management.InstanceAlreadyExistsException;

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
	public void showBoardPage(GameManager model) {
		BoardViewConsole view = new BoardViewConsole();
		BoardController controller = new BoardController(model, view);
		controller.start();
	}

}
