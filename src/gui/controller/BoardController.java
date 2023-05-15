package gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.Controller;
import gui.view.BoardView;
import myshelfie.Board;
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
		
		view.actionPrintBoard = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Board board = model.getBoard();
				view.setBoard(board); 
			}
		};
	}
	
	

}
