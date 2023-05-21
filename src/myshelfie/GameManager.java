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
	private Points points;

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
			points = new Points(players.size());
			board = new BoardProxy(players.size());
			changeState(GameState.PICK_OBJECTS_FROM_BOARD);

			break;
			
		case PICK_OBJECTS_FROM_BOARD:
			ui.showPickObjectsFromBoardPage(this);
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
		return this.players;
	}
	/**
	 * this method will be called at the end of the game and will score players who have completed one or two commongoals based on the order of completion of the commongoals
	 * @param playersGoal1Placement first array of players to check
	 * @param playersGoal2Placement second array of players to check
	 */
	public void assignPoints(ArrayList<Player> playersGoal1Placement,ArrayList<Player> playersGoal2Placement){
		 try {
				for (Player player : playersGoal1Placement) {
					player.addPoints(points.getPoint(1));
					
				}
				}
				catch(IllegalStateException e) {
					System.out.println(e);
				}
		 
		 try {
		 		for (Player player : playersGoal2Placement) {
					player.addPoints(points.getPoint(2));
					
				}
				}
				catch(IllegalStateException e) {
					System.out.println(e);
				}
		  }
	
}
