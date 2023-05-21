package gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;

import gui.Controller;
import gui.view.PickObjectsFromBoardView;
import myshelfie.Board;
import myshelfie.GameManager;
import myshelfie.Player;
import utils.MatrixCoords;

public class PickObjectsFromBoardController extends Controller<PickObjectsFromBoardView> {

	public PickObjectsFromBoardController(GameManager model, PickObjectsFromBoardView view) {
		super(model, view);

		this.view.setCommonGoals(model.getCommonGoalManager().getCommonGoal1(),
				model.getCommonGoalManager().getCommonGoal2());

		this.view.setPlayersNumber(model.getPlayersNumber());
	}

	@Override
	protected void initViewListeners() {
		
		//Board
		
		view.actionPrintBoard = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Board board = model.getBoard();
				view.setPlayersNumber(model.getPlayersNumber());
				view.setBoard(board);
			}
		};
		
		view.actionShowBookshelf = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				view.showBookshelf();
			}
		};

		//PickObjects
		
		view.actionPickPlayerName = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Player> players = model.getPlayers();
				int playerTurn = model.getPlayerTurn();
				Player player = players.get(playerTurn);
				String playerName = player.getName();
				view.setPlayerName(playerName);
				view.setPersonalGoal(player.getPersonalGoal());
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
				int maxCoords = 3;
				char column = 0;
				char row = 0;
				char letterToSubtract = 'A';
				int numberToSubtract = 49;
				int indexOfRow;
				int indexOfColumn;
				char[] input = view.getInputArr();
				ArrayList<Character> downCoordsList = new ArrayList<>();
				ArrayList<Character> rightCoordsList = new ArrayList<>();
				HashSet<MatrixCoords> coords = new HashSet<>();
				
				if(coords.size() == maxCoords) {
					view.showChangeStateWarning();
				}

				if(downCoordsList.isEmpty()) {
					for (int i = 0; i < Board.DOWN_COOORDS.length; i++) {
						downCoordsList.add(Board.DOWN_COOORDS[i]);
						rightCoordsList.add(Board.RIGHT_COORDS[i]);
					}
				}
				
				column = input[downCoordsPosition];
				row = input[rightCoordsPosition];

				if (downCoordsList.contains(column) && rightCoordsList.contains(row)) {
					indexOfColumn = column - letterToSubtract;
					indexOfRow = (int) row - numberToSubtract;
					MatrixCoords tmpCoord = new MatrixCoords(indexOfRow, indexOfColumn);
					view.setVerifier(true);
					if (coords.add(tmpCoord)) {
						view.setVerifier(true);
					}else {
						view.showAlreadySelectedCoordsWarning();
						view.setVerifier(false);
					}
					
				} else {
					view.showCoordsNotInTheBoardWarning();
					view.setVerifier(false);
				}

			}
		};
		
	}

}
