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
			
		case EXIT:
			System.exit(0);
			break;
 
		case INSERT_PLAYERS:
			ui.showInsertPlayersPage(this);
			break;
			
		case INIT_GAME:
			board = new Board(players.size());
			board.printBoards();
			ui.showBoardPage(this);
			break;
			
		case PICK_OBJECTS:
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

	private void updatePlayerTurn() {
		playerTurn = (playerTurn >= players.size() - 1) ? playerTurn++ : 0;
	}
	
	public void setPlayer(Player player) {
		this.players.add(player);
	}
	
	public ArrayList<Player> getPlayers(){
		if(players == null) {
			throw new NullPointerException("You must first initialize the ArrayList!!");
		}
		return players;
	}
	
	public void printBoard(Board board) {
		board.printBoards();
	}
	
}
