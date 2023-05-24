package gui.view;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import goal.CommonGoal;
import goal.PersonalGoal;
import gui.View;
import myshelfie.Board;
import myshelfie.Bookshelf;
import utils.MatrixCoords;

public abstract class GameStageView implements View {

	protected static final int MAX_PICKED_OBJECTS = 3;

	protected Board board;
	protected String playerName;
	protected ArrayList<MatrixCoords> pickedObjButtoncoords = new ArrayList<>();
	protected PersonalGoal personalGoal;
	protected CommonGoal commonGoal1;
	protected CommonGoal commonGoal2;
	protected Bookshelf bookshelf;
	
	public ActionListener actionEndTurn;

	public ActionListener actionReturnMainPage;

	public void setBoard(Board board) {
		this.board = board;
	}

	public void setBookshelf(Bookshelf bookshelf) {
		this.bookshelf = bookshelf;
	}

	public void setPersonalGoal(PersonalGoal personalGoal) {
		this.personalGoal = personalGoal;
	}

	public void setCommonGoals(CommonGoal commonGoal1, CommonGoal commonGoal2) {
		this.commonGoal1 = commonGoal1;
		this.commonGoal2 = commonGoal2;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

}
