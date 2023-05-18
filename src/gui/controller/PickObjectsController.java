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
				view.setDownCoords(model.getDownCoords());
				view.setRightCoords(model.getRightCoords());
			}
		};
		
		view.actionVerifyObject = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int downCoordsPosition = 0;
				int rightCoordsPosition = 2;
				int commaPosition = 1;
				String[] input = view.getInput();
				ArrayList<String> downCoordsList = new ArrayList<>();
				ArrayList<Integer> rightCoordsList = new ArrayList<>();
				
				if(input[commaPosition] != ",") {
					System.out.println("You must insert coords with this sintax (A,0)");
					view.setWaiting(true);
				}
				
				for (int i = 0; i < model.getDownCoords().length; i++) {
					downCoordsList.add(model.getDownCoords()[i]);
					rightCoordsList.add(model.getRightCoords()[i]);
				}
				
				if(downCoordsList.contains(input[downCoordsPosition]) && rightCoordsList.contains(input[rightCoordsPosition])) {
					int indexOfDownCoords = downCoordsList.indexOf(input[downCoordsPosition]);
					
				}else {
					System.out.println("Attention you insert coords that are not in the board!!");
					view.setWaiting(true);

				}
				
			}
		};
		
	}

}
