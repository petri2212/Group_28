package gui.view;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import gui.View;
import utils.MatrixCoords;

public abstract class PickObjectsView implements View{
	
	protected String input;
	protected int inputLenght;
	protected boolean isWaiting;
	protected String playerName;
	protected char[] downCoords;
	protected char[] rightCoords;
	protected ArrayList<String> savedCoords;
	protected String tmpCoords;
	protected boolean verifier;
	
	public ActionListener actionPickPlayerName;
	
	public ActionListener actionPutObjects;

	public ActionListener actionVerifyObject;
	
	public void setVerifier(Boolean verifier) {
		this.verifier = verifier;
	}
	
	public void setInput(String input) {
		this.input = input;
	}
	
	public char[] getInput() {
		char[] inputChar = {' ', ' ', ' '};
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
