package gui.view;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import gui.View;
import myshelfie.Board;
import myshelfie.BookshelfObject;
import myshelfie.Tile;
import utils.MatrixCoords;

public abstract class PickObjectsFromBoardView implements View {
	
	//Board
	
	protected Board board;
	protected int playersnumber;
	protected BookshelfObject bookshelfObjectToPrint;
	
	//PickObjects
	
	protected String input;
	protected int inputLenght;
	protected boolean isWaiting;
	protected String playerName;
	protected char[] downCoords;
	protected char[] rightCoords;
	protected ArrayList<String> savedCoords;
	protected String tmpCoords;
	protected boolean verifier;
	
	//Board
		
	public ActionListener actionPrintBoard;
	
	//PickObjects
	
	public ActionListener actionPickPlayerName;

	public ActionListener actionPutObjects;

	public ActionListener actionVerifyObject;
	
	//Board
		
	public void setBoard(Board board) {
		this.board = board;
	}
	
	public void setPlayersNumber(int players) {
		this.playersnumber = players;
	}
	
	public boolean checkTile(int r, int c) {
		Tile tile = board.get(new MatrixCoords(r ,c));
		if(tile != null && tile.isUsable(playersnumber)) {
			BookshelfObject tmpTile = tile.getBookshelfObject();
			setTileToPrint(tmpTile);
			return true;
		}
		return false;
	}
	
	public void setTileToPrint(BookshelfObject bookshelfObject) {
		this.bookshelfObjectToPrint = bookshelfObject;
	}
	
	//PickObjects
	
	public void setVerifier(Boolean verifier) {
		this.verifier = verifier;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public char[] getInput() {
		char[] inputChar = { ' ', ' ', ' ' };
		for (int i = 0; i < input.length(); i++) {
			inputChar[i] = input.charAt(i);
		}
		return inputChar;
	}

	public void setWaiting(boolean var) {
		isWaiting = var;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public void setDownCoords(char[] downCoords) {
		this.downCoords = downCoords;
	}

	public void setRightCoords(char[] rightCoords) {
		this.rightCoords = rightCoords;
	}

}
