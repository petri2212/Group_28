package gui.view;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import gui.View;
import myshelfie.Player;

public abstract class InsertPlayersView implements View {

	private String input;

	private ArrayList<Player> inseredPlayers = new ArrayList<>();

	public ActionListener actionReturnMainPage;

	public ActionListener actionInsertPlayer;

	public ActionListener actionInitGame;

	public void setInput(String input) {
		this.input = input;
	}

	public String getInput() {
		return this.input;
	}

	public ArrayList<Player> getInseredPlayers() {
		return inseredPlayers;
	}

	public void insertPlayers(Player playerToInsert) {
		inseredPlayers.add(playerToInsert);
	}

	public abstract void showTooFewPlayersWarning();

	public abstract void showTooManyPlayersWarning();

	public abstract void showDoublePlayersWarning();

	public abstract void showInvalidInputWarning();

	public abstract void showInseredPlayer();

}
