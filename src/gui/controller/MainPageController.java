package gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.Controller;
import gui.view.MainPageView;

import myshelfie.GameManager;
import myshelfie.GameState;

public class MainPageController extends Controller<MainPageView> {

	public MainPageController(GameManager model, MainPageView view) {
		super(model, view);
	}

	@Override
	public void initViewListeners() {
		view.actionNewGame = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.changeState(GameState.INSERT_PLAYERS);
			}
		};
		
		view.actionExit = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				model.changeState(GameState.EXIT);
			}
		};
	}
}
