package gui.view;

import java.awt.event.ActionListener;

import gui.View;
import myshelfie.Board;
import myshelfie.BookshelfObject;
import myshelfie.Tile;
import utils.MatrixCoords;

public abstract class BoardView implements View {
	
	protected Board<Tile> board;
	protected int playersnumber;
	protected BookshelfObject bookshelfObjectToPrint;
		
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
			BookshelfObject tmpTile = tile.getBookshelfObject();
			setTileToPrint(tmpTile);
			return true;
		}
		return false;
	}
	
	public void setTileToPrint(BookshelfObject bookshelfObject) {
		this.bookshelfObjectToPrint = bookshelfObject;
	}
	
}
