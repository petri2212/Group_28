package gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import gui.Controller;
import gui.view.InsertPlayersView;
import myshelfie.GameManager;
import myshelfie.GameState;
import myshelfie.MyShelfie;
import myshelfie.Player;

/**
 * This is the controller for the insert players, it extends Controller because
 * of the MVC and takes its own view as a parameter.
 */
public class InsertPlayersController extends Controller<InsertPlayersView> {

	/**
	 * This is the constructor of the class.
	 * 
	 * @param model super from the controller class
	 * @param view  super from the controller class
	 */
	public InsertPlayersController(GameManager model, InsertPlayersView view) {
		super(model, view);
	}

	/**
	 * This is an override of the listener where there are the actions.
	 */
	protected void initViewListeners() {
		
		view.actionReturnMainPage = new ActionListener() {

			/**
			 * This is an action from the view and it returns to home page.
			 */
			public void actionPerformed(ActionEvent e) {
				model.changeState(GameState.HOME);
			}
		};

		view.actionInitGame = new ActionListener() {

			/**
			 * This is an action from the view check if there is
			 * the minimum number of players.
			 */
			public void actionPerformed(ActionEvent e) {
				ArrayList<Player> players = view.getInseredPlayers();

				if (players.size() < MyShelfie.MIN_PLAYERS) {
					view.showTooFewPlayersWarning();
				} else {
					model.setPlayers(view.getInseredPlayers());
					model.changeState(GameState.INIT_GAME);
				}
			}
		};

		view.actionInsertPlayer = new ActionListener() {

			/**
			 * This is an action from the view try to insert a new player
			 * into he list with all the controls that it needs.
			 */
			public void actionPerformed(ActionEvent e) {
				ArrayList<Player> players = view.getInseredPlayers();
				String input = view.getInput();
				Player player = new Player(input);

				if (input == null || input.isEmpty()) {
					view.showInvalidInputWarning();
					return;
				} else if (players.contains(player)) {
					view.showDoublePlayersWarning();
					return;
				} else if (players.size() == MyShelfie.MAX_PLAYERS) {
					view.showTooManyPlayersWarning();
				} else {
					view.insertPlayers(player);
					view.showInseredPlayer();
				}
			}
		};
	}

}
