package myshelfie;

import java.util.ArrayList;

import gui.UI;

public class GameManager {

	private GameState state;
	private UI ui;
	private ArrayList<Player> players;
	private Board board;
	private int playerTurn;

	public GameManager(UI ui) {
		this.ui = ui;
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
		switch(state) {
		case HOME:
			ui.showMainPage(this);
			break;

		case NEW_GAME:
			break;

		case CONTROLS:
			board = new Board(players.size());
			updatePlayerTurn();
			break;

		case END:
			break;

		default:
			break;
		}
	}

	private void updatePlayerTurn() {
		playerTurn = (playerTurn >= players.size() - 1) ? playerTurn++ : 0;
	}

}
