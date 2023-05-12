package gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.Controller;
import gui.view.BoardView;
import gui.view.InsertPlayersView;
import myshelfie.GameManager;
import myshelfie.GameState;

public class BoardController extends Controller<BoardView>{
	
	public BoardController(GameManager model, BoardView view) {
		super(model, view);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initViewListeners() {
		
		view.actionReturnMainPage = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.changeState(GameState.HOME);
			}
		};
	}

}
