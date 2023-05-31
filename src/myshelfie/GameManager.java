package myshelfie;

import java.util.ArrayList;

import board.Board;
import board.BoardProxy;
import deck.DeckCommon;
import deck.DeckPersonal;
import goal.CommonGoalManager;
import gui.UI;

public class GameManager {

	private GameState state;
	private UI ui;
	private ArrayList<Player> players;
	private Board board;
	private int playerTurn;
	private Points points;
	private CommonGoalManager commonGoalManager;
	private boolean isLastTurn;

	public GameManager(UI ui) {
		this.ui = ui;
		isLastTurn = false;
	}

	public void start() {
		state = GameState.HOME;
		players = new ArrayList<>();
		playerTurn = 0;
		manageState();
	}

	public void changeState(GameState nextState) {
		state = nextState;
		manageState();
	}

	private void manageState() {
		switch (state) {
		case HOME:
			ui.showMainPage(this);
			break;

		case EXIT:
			System.exit(0);
			break;

		case INSERT_PLAYERS:
			ui.showInsertPlayersPage(this);
			break;

		case INIT_GAME:
			points = new Points(players.size());
			board = new BoardProxy(players.size());

			DeckPersonal deckPersonal = new DeckPersonal();

			for (Player player : players) {
				player.assignPersonalGoal(deckPersonal.extractGoal());
			}

			DeckCommon deckCommon = new DeckCommon();
			commonGoalManager = new CommonGoalManager(players, deckCommon.extractGoal(), deckCommon.extractGoal());

			changeState(GameState.GAME_STAGE);
			break;

		case GAME_STAGE:
			ui.showGameStagePage(this);
			break;

		case CONTROLS:
			if (board.areAllObjectsIsolated()) {
				board.fillLivingRoomWithObjects();
			}
			if(isLastTurn==false){
				if (players.get(playerTurn).getBookshelf().isFull()) {
					players.get(playerTurn).addPoints(1);
					isLastTurn = true;

				}
			}
			commonGoalManager.CheckPlacementPlayer();
			updatePlayerTurnAndChangeState();
			break;

		case END:
			for (Player player : players) {
				player.addPoints(player.getPersonalGoal().check(player.bookshelf));
			}
			assignPoints(commonGoalManager.playersGoal1Placement(), commonGoalManager.playersGoal2Placement());

			ui.showPointsPage(this);
			break;

		default:
			break;
		}
	}

	public Board getBoard() {
		return board;
	}

	public int getPlayersNumber() {
		return this.players.size();
	}

	public int getPlayerTurn() {
		return this.playerTurn;
	}

	public void updatePlayerTurnAndChangeState() {
		if (playerTurn < players.size() - 1) {
			playerTurn++;
			changeState(GameState.GAME_STAGE);
		} else {
			if (isLastTurn) {
				changeState(GameState.END);
			} else {
				playerTurn = 0;
				changeState(GameState.GAME_STAGE);
			}
		}
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	public ArrayList<Player> getPlayers() {
		return this.players;
	}

	/**
	 * this method will be called at the end of the game and will score players who
	 * have completed one or two commongoals based on the order of completion of the
	 * commongoals
	 * 
	 * @param playersGoal1Placement first array of players to check
	 * @param playersGoal2Placement second array of players to check
	 */
	public void assignPoints(ArrayList<Player> playersGoal1Placement, ArrayList<Player> playersGoal2Placement) {
		try {
			for (Player player : playersGoal1Placement) {
				player.addPoints(points.getPoint(1));

			}
		} catch (IllegalStateException e) {
			System.out.println(e);
		}

		try {
			for (Player player : playersGoal2Placement) {
				player.addPoints(points.getPoint(2));

			}
		} catch (IllegalStateException e) {
			System.out.println(e);
		}
	}

	/**
	 * @return the commonGoalManager
	 */
	public CommonGoalManager getCommonGoalManager() {
		return commonGoalManager;
	}

}
