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

}
