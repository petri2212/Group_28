package gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import gui.Controller;
import gui.view.PointsPageView;
import myshelfie.GameManager;
import myshelfie.GameState;
import myshelfie.Player;

public class PointsPageController extends Controller<PointsPageView> {

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
