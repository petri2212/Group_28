package gui.view;

import java.awt.event.ActionListener;

import gui.View;

public abstract class PickObjectsView implements View{
	
	protected String playerName;
	protected String[] downCoords;
	protected int[] rightCoords;
	
	public ActionListener actionPickPlayerName;
	
	public ActionListener actionPutObjects;
	
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
