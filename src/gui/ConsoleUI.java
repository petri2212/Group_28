package gui;

import gui.controller.*;
import gui.view.console.*;

import myshelfie.GameManager;

public class ConsoleUI implements UI {

	@Override
	public void showMainPage(GameManager model) {
		MainPageController controller = new MainPageController(model);
		MainPageView view = new MainPageView(controller);
		view.show();
	}

}
