package gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;

import gui.Controller;
import gui.view.PickObjectsView;
import myshelfie.Board;
import myshelfie.GameManager;
import myshelfie.GameState;
import myshelfie.Player;
import utils.MatrixCoords;

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
				view.setDownCoords(Board.DOWN_COOORDS);
				view.setRightCoords(Board.RIGHT_COORDS);
			}
		};
		
		view.actionVerifyObject = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int downCoordsPosition = 0;
				int rightCoordsPosition = 2;
				int commaPosition = 1;
				char column = 0;
				char row = 0;
				char letterToSubtract = 'A';
				int numberToSubtract = 49;
				int indexOfColumn;
				int indexOfRow;
				char[] input = view.getInput();
				ArrayList<Character> downCoordsList = new ArrayList<>();
				ArrayList<Character> rightCoordsList = new ArrayList<>();
				HashSet<MatrixCoords> coords = new HashSet<>();
				
<<<<<<< HEAD
				if(input[commaPosition] == ',') {
					try {
						column = input[downCoordsPosition];
						row = input[rightCoordsPosition];
					} catch (Exception e2) {
						view.setWaiting(true);
					}
					
					for (int i = 0; i < model.getDownCoords().length; i++) {
						downCoordsList.add(model.getDownCoords()[i]);
						rightCoordsList.add(model.getRightCoords()[i]);
					}
=======
				if(input[commaPosition] != ",") {
					System.out.println("You must insert coords with this sintax (A,0)");
					view.setWaiting(true);
				}
				
				for (int i = 0; i < Board.DOWN_COOORDS.length; i++) {
					downCoordsList.add(Board.DOWN_COOORDS[i]);
					rightCoordsList.add(Board.RIGHT_COORDS[i]);
				}
				
				if(downCoordsList.contains(input[downCoordsPosition]) && rightCoordsList.contains(input[rightCoordsPosition])) {
					int indexOfDownCoords = downCoordsList.indexOf(input[downCoordsPosition]);
>>>>>>> f0ed29ab417dc3e10dffe39d4f5c057b570dffe5
					
					if(downCoordsList.contains(column) && rightCoordsList.contains(row)) {
						indexOfColumn = column - letterToSubtract;
						indexOfRow = (int) row - numberToSubtract;
						MatrixCoords tmpCoord = new MatrixCoords(indexOfRow, indexOfColumn);
						if(coords.add(tmpCoord)) {
							view.setVerifier(true);
						}else {
							System.out.println("You've already selected this coords!!");
						}
						view.setWaiting(true);
						
					}else {
						System.out.println("Attention you insert coords that are not in the board!!");
						view.setWaiting(true);
					}
				}else {
					System.out.println("You must insert coords with this sintax (A,0)");
					view.setWaiting(true);
				}
				
			}
		};
		
	}

}
