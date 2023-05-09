package gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import gui.Controller;
import gui.view.InsertPlayersView;
import gui.view.console.InsertPlayersViewConsole;
import myshelfie.GameManager;
import myshelfie.GameState;
import myshelfie.Player;

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
				model.changeState(GameState.INIT_GAME);
			}
		};
		
		view.actionInsertPlayer = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Player> players = model.getPlayers();
				int maxplayers = 4;
				String name = "ciao";
				int i = 0;
					if(name == players.get(i).getName()) {
						throw new NullPointerException("Due player non possono avere lo stesso nome");
						model.changeState(GameState.INSERT_PLAYERS);
					}
				}
				
			}
		};
	}
	
	

}
