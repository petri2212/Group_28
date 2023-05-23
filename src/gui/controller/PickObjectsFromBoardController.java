package gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import gui.Controller;
import gui.view.PickObjectsFromBoardView;
import myshelfie.GameManager;
import myshelfie.GameState;
import myshelfie.Player;

public class PickObjectsFromBoardController extends Controller<PickObjectsFromBoardView> {

	private Player player;

	public PickObjectsFromBoardController(GameManager model, PickObjectsFromBoardView view) {
		super(model, view);

		ArrayList<Player> players = model.getPlayers();
		int playerTurn = model.getPlayerTurn();
		this.player = players.get(playerTurn);
		String playerName = player.getName();

		this.view.setCommonGoals(model.getCommonGoalManager().getCommonGoal1(),
				model.getCommonGoalManager().getCommonGoal2());

		this.view.setBoard(model.getBoard());

		this.view.setPlayerName(playerName);

		this.view.setPersonalGoal(player.getPersonalGoal());

		this.view.setBookshelf(player.getBookshelf());
	}

	@Override
	protected void initViewListeners() {

		view.actionEndTurn = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (player.getBookshelf().isFull()) {
					model.changeState(GameState.END);
				} else {
					model.changeState(GameState.CONTROLS);
				}
			}
		};

		view.actionReturnMainPage = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.changeState(GameState.HOME);
			}
		};
	}

}
