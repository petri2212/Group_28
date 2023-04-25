package gui.controller;

import gui.Controller;

import myshelfie.GameManager;
import myshelfie.GameState;

public class MainPageController extends Controller {

	public MainPageController(GameManager model) {
		super(model);
	}

	public void actionNewGame() {
		model.changeState(GameState.NEW_GAME);
	}

}
