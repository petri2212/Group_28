package gui.view;

import java.awt.event.ActionListener;

import gui.View;

public abstract class PickObjectsView implements View{
	
	protected String playerName;
	
	public ActionListener actionPickPlayerName;
	
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

}
