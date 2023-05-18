package gui.view;

import java.awt.event.ActionListener;

import gui.View;

public abstract class PickObjectsView implements View{
	
	protected String input;
	protected int inputLenght;
	protected boolean isWaiting;
	protected String playerName;
	protected String[] downCoords;
	protected int[] rightCoords;
	
	public ActionListener actionPickPlayerName;
	
	public ActionListener actionPutObjects;

	public ActionListener actionVerifyObject;
	
	public void setInput(String input) {
		this.input = input;
	}
	
	public String[] getInput() {
		String[] inputToString = this.input.split(null);
		return inputToString;
	}
	
	public void setWaiting(boolean var) {
		isWaiting = var;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	public void setDownCoords(String[] downCoords) {
		this.downCoords = downCoords;
	}
	
	public void setRightCoords(int[] rightCoords) {
		this.rightCoords = rightCoords;
	}

}
