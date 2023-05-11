package gui.view;

import java.awt.event.ActionListener;

import gui.View;

public abstract class InsertPlayersView implements View {
	
	protected String input;
	protected boolean isWaiting;
	
	public void setWaiting(boolean isWaiting) {
		this.isWaiting = isWaiting;
	}

	public ActionListener actionReturnMainPage;
	
	public ActionListener actionInsertPlayer;
	
	public ActionListener actionInitGame;
	
	public void setInput(String input) {
		this.input = input;
	}
	
	public String getInput() {
		return this.input;
	}

}
