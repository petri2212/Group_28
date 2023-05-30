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

public class InsertPlayersController extends Controller<InsertPlayersView> {

	public InsertPlayersController(GameManager model, InsertPlayersView view) {
		super(model, view);
	}

	@Override
	protected void initViewListeners() {
		view.actionReturnMainPage = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.changeState(GameState.HOME);
			}
		};

		view.actionInitGame = new ActionListener() {

			@Override
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

			@Override
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
