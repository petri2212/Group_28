package gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import gui.Controller;
import gui.view.PointsPageView;
import myshelfie.GameManager;
import myshelfie.GameState;
import myshelfie.Player;
/**
 * This is the controller for the point page, it extends Controller because
 * of the MVC and takes its own view as a parameter.
 */
public class PointsPageController extends Controller<PointsPageView> {

	/**
	 * This is the constructor of the class and it sets the player
	 * in a way where they are from the winner to the last.
	 * @param model super from the controller class
	 * @param view  super from the controller class
	 */
	public PointsPageController(GameManager model, PointsPageView view) {
		super(model, view);

		ArrayList<Player> players = model.getPlayers();

		players.sort((a, b) -> {
			if (a.getPoints() == b.getPoints()) {
				return 0;
			} else if (a.getPoints() > b.getPoints()) {
				return -1;
			} else {
				return 1;
			}
		});

		view.setPlayers(players);
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
	}

}
