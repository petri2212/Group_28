package gui.view;

import java.awt.event.ActionListener;

import gui.View;
import myshelfie.Board;
import myshelfie.Tile;
import utils.MatrixCoords;

public abstract class BoardView implements View {
	
	protected Board board;
	protected int playersnumber;
	
	public ActionListener actionReturnMainPage;
	
	public ActionListener actionPrintBoard;
	
	public void setBoard(Board board) {
		this.board = board;
	}
	
	public void setPlayersNumber(int players) {
		this.playersnumber = players;
	}
	
	public boolean checkTile(int r, int c) {
		Tile tile = board.get(new MatrixCoords(r ,c));
		if(tile != null && tile.isUsable(playersnumber)) {
			return true;
		}
		return false;
	}

}
