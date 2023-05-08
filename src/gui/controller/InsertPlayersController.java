package gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.Controller;
import gui.view.InsertPlayersView;

import myshelfie.GameManager;
import myshelfie.GameState;

public class InsertPlayersController extends Controller<InsertPlayersView> {

	public InsertPlayersController(GameManager model, InsertPlayersView view) {
		super(model, view);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void initViewListeners() {
		// TODO Auto-generated method stub
		view.actionReturnMainPage = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.changeState(GameState.HOME);
			}
		};
		
		view.actionInitGame = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				model.changeState(GameState.INIT_GAME);
			}
		};
		
		view.actionInsertPlayer = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				model.changeState(GameState.INIT_GAME);
			}
		};
	}
	
	

}
