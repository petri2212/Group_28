package gui.controller;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.util.ArrayList;
import gui.Controller;
import gui.view.GameStageView;
import myshelfie.GameManager;
import myshelfie.GameState;
import myshelfie.Player;
/**
 * This is the controller for the game stage, it extends
 * Controller because of the MVC and takes its own view as a parameter.
 */
public class GameStageController extends Controller<GameStageView> {

	private Player player;
	
/**
 * This is the constructor of the class and it sets all the parameter
 * of the player that is playing.
	 * @param model super from the controller class
	 * @param view  super from the controller class
 */
	public GameStageController(GameManager model, GameStageView view) {
		super(model, view);

		ArrayList<Player> players = model.getPlayers();
		int playerTurn = model.getPlayerTurn();
		
		this.player = players.get(playerTurn);
		if(this.player.getBookshelf().isFull()) {
			for(int i=0; i<players.size();i++) {
				
					model.updatePlayerTurnAndChangeState();
					this.player=players.get(playerTurn = model.getPlayerTurn());
					if(!(this.player.getBookshelf().isFull())) {
						break;
					}
			}
		}
		String playerName = player.getName();

		this.view.setCommonGoals(model.getCommonGoalManager().getCommonGoal1(),
				model.getCommonGoalManager().getCommonGoal2());

		this.view.setBoard(model.getBoard());

		this.view.setPlayerName(playerName);

		this.view.setPersonalGoal(player.getPersonalGoal());

		this.view.setBookshelf(player.getBookshelf());
	}

	/**
	 * This is an override of the listener where
	 * there are the actions.
	 */
	protected void initViewListeners() {

		view.actionEndTurn = new ActionListener() {

			/**
			 * This is an action from the view and it point to the controls.
			 */
			public void actionPerformed(ActionEvent e) {
				model.changeState(GameState.CONTROLS);
			}
		};

		view.actionReturnMainPage = new ActionListener() {

			/**
			 * This is an action from the view and it return to home page.
			 */
			public void actionPerformed(ActionEvent e) {
				model.changeState(GameState.HOME);
			}
		};
	}

}
