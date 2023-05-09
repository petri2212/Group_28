package gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

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
	
	private static final int MIN_PLAYERS = 2;
	private static final int MAX_PLAYERS = 4;

	
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
				ArrayList<Player> players = model.getPlayers();

				if(players.size() < MIN_PLAYERS) {
					System.out.println("Attention!!");
					System.out.println("You must insert at least two players!!");
				}else {
					model.changeState(GameState.INIT_GAME);
				}
			}
		};
		
		view.actionInsertPlayer = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Player> players = model.getPlayers();
				String input = view.getInput();
				Player player = new Player(input);

				
				if(players.contains(player)) {
						System.out.println("Non puoi inserire due nomi uguali!!");
					}
				
				if(players.size() == MAX_PLAYERS) {
					System.out.println("\033[H\033[2J");
					System.out.println("Attention!!");
					System.out.println("You reached the maximum number of players, the will start soon!!");
					model.changeState(GameState.INIT_GAME);
				}else {
					model.setPlayer(player);
				}
			}
		};
	}
	
	

}
