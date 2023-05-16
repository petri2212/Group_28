package gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import gui.Controller;
import gui.view.PickObjectsView;
import myshelfie.GameManager;
import myshelfie.GameState;
import myshelfie.Player;

public class PickObjectsController extends Controller<PickObjectsView>{

	public PickObjectsController(GameManager model, PickObjectsView view) {
		super(model, view);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initViewListeners() {
		
		view.actionPickPlayerName = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Player> players = model.getPlayers();
				int playerTurn = model.getPlayerTurn();
				Player player = players.get(playerTurn);
				String playerName = player.getName();
				view.setPlayerName(playerName);
			}
		};
		
		view.actionPutObjects = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				view.setDownCoords(model.getDownCools());
				view.setRightCoords(model.getRightCools());
			}
		};
		
	}

}
