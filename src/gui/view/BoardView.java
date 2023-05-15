package gui.view;

import java.awt.event.ActionListener;

import gui.View;
import myshelfie.Board;

public abstract class BoardView implements View {
	
	protected Board board;
	
	public ActionListener actionReturnMainPage;
	
	public ActionListener actionPrintBoard;
	
	public Board setBoard(Board board) {
		return this.board = board;
	}

}
