package myshelfie;

import java.util.ArrayList;
import java.util.List;

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
			
		case EXIT:
			System.exit(0);
			break;
 
		case INSERT_PLAYERS:
			ui.showInsertPlayersPage(this);
			break;
			
		case INIT_GAME:
			board = new Board(players.size());
			changeState(GameState.PRINT_BOARD);
			break;
			
		case PRINT_BOARD:
			ui.showBoardPage(this);
			break;
			
		case PICK_OBJECTS:
			ui.showPickObjectsPage(this);
			break;
			
		case PUT_OBJECTS:
			break;

		case CONTROLS:
			updatePlayerTurn();
			break;

		case END:
			break;

		default:
			break;
		}
	}

	public Board getBoard() {
		return board;
	}
	
	public String[] getDownCools() {
		return board.getDownCoord();
	}
	
	public int[] getRightCools() {
		return board.getRightCoord();
	}
	
	public int getPlayersNumber() {
		return this.players.size();
	}
	
	public int getPlayerTurn() {
		return this.playerTurn;
	}

	private void updatePlayerTurn() {
		playerTurn = (playerTurn >= players.size() - 1) ? playerTurn++ : 0;
	}
	
	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	public ArrayList<Player> getPlayers() {
		// TODO Auto-generated method stub
		return this.players;
	}

}
