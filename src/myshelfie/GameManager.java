package myshelfie;

import java.util.ArrayList;

import board.Board;
import board.BoardProxy;
import deck.DeckCommon;
import deck.DeckPersonal;
import goal.CommonGoalManager;
import goal.GenericGoal;
import gui.UI;

/**
 * General game manager, it contains the game data and the state machine that
 * regulates the various phases of the program.
 */
public class GameManager {

	private GameState state;
	private UI ui;
	private ArrayList<Player> players;
	private Board board;
	private int playerTurn;
	private Points points;
	private CommonGoalManager commonGoalManager;
	private GenericGoal generic = new GenericGoal();

	private boolean isLastTurn;

	/**
	 * Creates a new game manager specifying the user interface to use.
	 *
	 * @param ui is the user interface to show to the player
	 */
	public GameManager(UI ui) {
		this.ui = ui;
	}

	/**
	 * Start the state machine.
	 */
	public void start() {
		state = GameState.HOME;
		manageState();
	}

	/**
	 * Change the game state and notify the state machine about the change.
	 *
	 * @param nextState is the state to set
	 */
	public void changeState(GameState nextState) {
		state = nextState;
		manageState();
	}

	/**
	 * Main state machine.
	 */
	private void manageState() {
		switch (state) {
		case HOME:
			players = new ArrayList<>();
			playerTurn = 0;
			isLastTurn = false;
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
			if (isLastTurn == false) {
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
				player.addPoints(generic.check(player.bookshelf));
			}
			assignPoints(commonGoalManager.playersGoal1Placement(), commonGoalManager.playersGoal2Placement());

			ui.showPointsPage(this);
			break;

		default:
			break;
		}
	}

	/**
	 * @return the instantiated game board
	 */
	public Board getBoard() {
		return board;
	}

	/**
	 * @return the player turn
	 */
	public int getPlayerTurn() {
		return this.playerTurn;
	}

	/**
	 * Updates the player turn and checks if this is the last turn to be done.
	 */
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

	/**
	 * Set the current players.
	 *
	 * @param players is a list of players
	 */
	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	/**
	 * @return the current playing players
	 */
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
	private void assignPoints(ArrayList<Player> playersGoal1Placement, ArrayList<Player> playersGoal2Placement) {
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
